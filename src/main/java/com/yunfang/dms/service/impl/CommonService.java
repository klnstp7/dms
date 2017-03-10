package com.yunfang.dms.service.impl;

import com.google.gson.Gson;
import com.yunfang.dms.dto.*;
import com.yunfang.dms.entity.BuildingBaseDataCond;
import com.yunfang.dms.entity.CommunityBaseDataCond;
import com.yunfang.dms.entity.UnitBaseDataCond;
import com.yunfang.dms.enums.SourceTableEmum;
import com.yunfang.dms.exception.CustomException;
import com.yunfang.dms.service.inter.IBuildingBaseDataService;
import com.yunfang.dms.service.inter.ICommunityBaseDataService;
import com.yunfang.dms.service.inter.IExtendConfigService;
import com.yunfang.dms.service.inter.IUnitBaseDataService;
import com.yunfang.dms.utils.*;
import org.apache.poi.ss.formula.functions.T;
import org.apache.tools.ant.taskdefs.Tstamp;
import org.apache.tools.ant.util.regexp.Regexp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/3/1.
 */
@Service
public class CommonService {

    @Autowired
    private IExtendConfigService extendService;
    @Autowired
    private ICommunityBaseDataService communityBaseDataService;
    @Autowired
    private IBuildingBaseDataService buildingBaseDataService;
    @Autowired
    private IUnitBaseDataService unitBaseDataService;
    private HashMap<String, String> cityMap = new HashMap<String, String>() {
        {
            put("北京", "BEIJING");
            put("上海", "SHANGHAI");
            put("广州", "GUANGZHOU");
        }
    };

    /*
    * 读取Excel内容到List通用方法,
    * filename 文件名
    * configNodeName  导入配置的节点
    * tableEnm  表枚举，用于扩展字段
    * */
    public <T> List<T> readExcelToList(String filename, Class<T> classType, String configNodeName, SourceTableEmum tableEnm, List<Object> errorList) throws CustomException {
        //读取Excel内容
        Map<Integer, Map<Integer, String>> excelData = ExcelUtil.readExcel(filename);
        //配置文件中 配置的列头对应数据库字段关系
        Map<String, TempLateConfigDto> configColMap = XmlUtil.getConfigForInput(configNodeName, "tempLate");
        Map<Integer, String> colRefIndexMap = null;//保存列名对应的索引
        Map<String, String> colValMap;
        //扩展字段中的值
        Map<String, String> extendColVal;
        //记录一个Excel的城市信息，用于判断一个Excel中是否有多个城市
        List<String> cityNames = new ArrayList<String>();
        //获取用户自定自定义的列
        List<ExtendConfigDto> userExtendConfig = extendService.getExtendTitleList(UserInfoUtil.getCurrentUserCompanyId(), tableEnm.ordinal());
        List<String> userExtendCol = new ArrayList<String>();
        for (ExtendConfigDto dto :
                userExtendConfig) {
            if (!userExtendCol.contains(dto.getColumnName())) {
                userExtendCol.add(dto.getColumnName());
            }
        }
        //返回的List
        List<T> returnList = new ArrayList<T>();
        // Cookie中的城市名称
        String chooseCityName = null;
        try {
            chooseCityName = URLDecoder.decode(CookiesUtil.getCookieByName("CityName").getValue(),"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //循环行
        for (Map.Entry<Integer, Map<Integer, String>> entry : excelData.entrySet()) {
            colValMap = new HashMap<String, String>();
            extendColVal = new HashMap<String, String>();
            //第一行为列头，需要读取列头与数据库字段的关系
            if (entry.getKey() < 1) {
                colRefIndexMap = new HashMap<Integer, String>();
            }
            boolean isValid = true;
            //记录错误描述
            String dataValidMsg = "";
            //循环列
            for (Map.Entry<Integer, String> valueEn : entry.getValue().entrySet()) {
                //第一行时，读取列头，并保存对应关系
                if (entry.getKey() < 1) {
                    colRefIndexMap.put(valueEn.getKey(), valueEn.getValue());
                } else {//将值set进对应的列中
                    //找到模版列头对应数据库字段的关系
                    TempLateConfigDto configDto = configColMap.get(colRefIndexMap.get(valueEn.getKey()));
                    if (configDto != null) {
                        //判断字段类型，以及值是否符合规定,以及特殊字符
                        String returnMsg = validDataFormat(configDto, valueEn.getValue());
                        if (returnMsg != null) {
                            isValid = false;
                            dataValidMsg += returnMsg;
                        }
                        colValMap.put(configDto.getEntityCol(), replaceIllegaChar(valueEn.getValue()));
                        //判断一个Excel中是否包含多个城市
                        if (configDto.getEntityCol().toLowerCase().equals("cityname")) {
                            //String mapCityName = cityMap.get(StringUtil.subStrStart(valueEn.getValue(), valueEn.getValue().indexOf("市")));
                            //判断选择的城市和Excel中的城市是否一致
                            if (!valueEn.getValue().equals(chooseCityName)) {
                                throw new CustomException("选择的城市与导入文件中的城市不一致，请检查文件");
                            }
                            if (cityNames.size() < 1) {
                                cityNames.add(valueEn.getValue());
                            } else if (cityNames.size() > 0 && !cityNames.contains(valueEn.getValue())) {
                                throw new CustomException(filename.substring(filename.lastIndexOf('\\') + 1) + ",同一个文件中仅允许导入一个城市的数据，不允许多个城市同时导入！！");
                            }
                        }
                    } else {
                        if (colRefIndexMap.get(valueEn.getKey()) != null) {
                            //验证扩展字段中的特殊字符
                            TempLateConfigDto extendConfigDto = new TempLateConfigDto();
                            extendConfigDto.setTemplateCol(colRefIndexMap.get(valueEn.getKey()));
                            extendConfigDto.setDataType("String");
                            extendConfigDto.setEntityCol(colRefIndexMap.get(valueEn.getKey()));
                            extendConfigDto.setIsNull(true);
                            String returnMsg = validDataFormat(extendConfigDto, valueEn.getValue());
                            if (returnMsg != null) {
                                isValid = false;
                                dataValidMsg += returnMsg;
                            }
                            //将不存在的配置文件中的列，保存到扩展字段中
                            extendColVal.put(colRefIndexMap.get(valueEn.getKey()), replaceIllegaChar(valueEn.getValue()));
                        }
                    }
                }
            }
            if (entry.getKey() > 0) {
                Gson gs = new Gson();
                if (entry.getKey().equals(1)) {//第一行判断，扩展字段是否已配置
                    List<String> errList = compareExtendCol(extendColVal, userExtendCol);
                    if (errList != null && errList.size() > 0) {
                        throw new CustomException(filename.substring(filename.lastIndexOf('\\') + 1) + ",配置错误，自定义的列不存在：" + gs.toJson(errList).replace("\"", ""));
                    }
                }
                try {
                    if (!isValid) {
                        extendColVal.put("errorMsg", dataValidMsg);
                    }
                    //使用反射动态实例化
                    Class<?> cls = Class.forName(classType.getName());
                    T object = (T) cls.newInstance();
                    //不管成功失败都要给Dto赋值，保证错误列表有数据
                    ClassRefUtil.setFieldValue(object, colValMap);
                    if (extendColVal != null && extendColVal.size() > 0) {
                        //扩展字段中替换英文状态下的单双引号
                        ClassRefUtil.setFieldValue(object, "extendCol", gs.toJson(extendColVal));
                    }
                    if (isValid) {
                        returnList.add(object);
                    } else {
                        errorList.add(object);
                    }
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        return returnList;
    }

    //返回界面需要的数据
    public UpLoadFileResultDto getUpLoadFileResultDto(List<Object> errorList, List<?> list, int updateCount, int noExistsCount) {
        UpLoadFileResultDto resultDto = new UpLoadFileResultDto();
        int total = list.size() + errorList.size() - noExistsCount;
        PageVo<Object> pageVo = new PageVo<Object>(errorList.size());
        pageVo.setAaData(errorList);
        resultDto.setData(pageVo);
        resultDto.setErrorCount(errorList.size());
        resultDto.setUpdateCount(updateCount);
        resultDto.setTotalCount(total);
        resultDto.setSuccessCount(list.size() - updateCount - noExistsCount);
        return resultDto;
    }

    /*
    * 判断小区是否存在
    * */
    public boolean communityIsExists(String region, String cityName, String communityName) {
        Integer companyId = UserInfoUtil.getCurrentUserCompanyId();
        CommunityBaseDataCond communityBaseDataCond = new CommunityBaseDataCond();
        CommunityBaseDataCond.Criteria condition = communityBaseDataCond.createCriteria().andCompanyIdEqualTo(companyId).andCommunityEqualTo(communityName).andCityNameEqualTo(cityName).andRegionEqualTo(region);
        List<CommunityBaseDataDto> dbDtos = communityBaseDataService.selectByCond(communityBaseDataCond);
        return (dbDtos != null && dbDtos.size() > 0);
    }

    /*
    * 判断楼栋是否存在
    * */
    public boolean buildingIsExists(String region, String cityName, String communityName, String building) {
        Integer companyId = UserInfoUtil.getCurrentUserCompanyId();
        BuildingBaseDataCond buildingBaseDataCond = new BuildingBaseDataCond();
        buildingBaseDataCond.createCriteria().andCompanyIdEqualTo(companyId).andCommunityEqualTo(communityName).andCityNameEqualTo(cityName).andRegionEqualTo(region).andBuildingNameEqualTo(building);
        List<BuildingBaseDataDto> dbDtos = buildingBaseDataService.selectByCond(buildingBaseDataCond);
        return (dbDtos != null && dbDtos.size() > 0);
    }

    /*
  * 判断单元是否存在
  * */
    public boolean unitIsExists(String region, String cityName, String communityName, String building, String unitName) {
        Integer companyId = UserInfoUtil.getCurrentUserCompanyId();
        UnitBaseDataCond unitBaseDataCond = new UnitBaseDataCond();
        unitBaseDataCond.createCriteria().andCompanyIdEqualTo(companyId).andCommunityEqualTo(communityName).andCityNameEqualTo(cityName).andRegionEqualTo(region).andBuildingNameEqualTo(building);
        List<UnitBaseDataDto> dbDtos = unitBaseDataService.selectByCond(unitBaseDataCond);
        return (dbDtos != null && dbDtos.size() > 0);
    }

    /*
    * 比较两个集合
    * */
    private List<String> compareExtendCol(Map<String, String> excelExtendCols, List<String> userCols) {
        List<String> returnList = new ArrayList<String>();
        for (Map.Entry<String, String> col : excelExtendCols.entrySet()) {
            boolean bl = userCols.contains(col.getKey());
            if (!bl)
                returnList.add(col.getKey());
        }
        return returnList;
    }

    /*
    * 验证每个单元格的数据，是否符合规定格式
    * 返回：数据符合格式：null,不符合返回错误详细｛列名：错误原因｝
    * */
    private static String validDataFormat(TempLateConfigDto configDto, String colValue) {
        if (configDto.getIsNull() && (colValue == null || colValue.equals("")))
            return null;
        if (!configDto.getIsNull() && (colValue == null || colValue.equals("")))
            return configDto.getTemplateCol() + "(不能为空)；";
        if (configDto.getDataType().equals("String") && colValue != null && !colValue.equals("")) {
            String reg = "['\"<>]";
            Pattern pattern = Pattern.compile(reg, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(colValue);
            if (matcher.find()) {
                return configDto.getTemplateCol() + "(不能包含特殊英文状态下的：单/双引号、书名号,回车)；";
            }
        }
        if (configDto.getDataType().equals("Date"))
            return StringUtil.parseDate(colValue) == null ? configDto.getTemplateCol() + "(必须为日期格式)；" : null;
        if (configDto.getDataType().equals("Integer") || configDto.getDataType().equals("Double") || configDto.getDataType().equals("Long") || configDto.getDataType().equals("BigDecimal"))
            return !StringUtil.isNumeric(colValue) ? configDto.getTemplateCol() + "(必须为数字)；" : null;
        return null;
    }

    /*
    * 替换非法字符
    * */
    private static String replaceIllegaChar(String value) {
        String reg = "['\"<>\n]";
        Pattern pattern = Pattern.compile(reg, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(value);
        return matcher.replaceAll("");
    }
}
