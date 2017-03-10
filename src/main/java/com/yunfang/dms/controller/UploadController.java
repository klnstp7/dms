package com.yunfang.dms.controller;

import com.github.junrar.Archive;
import com.github.junrar.rarfile.FileHeader;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.yunfang.dms.dto.*;
import com.yunfang.dms.enums.SourceTableEmum;
import com.yunfang.dms.exception.CustomException;
import com.yunfang.dms.service.inter.*;
import com.yunfang.dms.utils.ExcelUtil;
import com.yunfang.dms.utils.JsonUtil;
import com.yunfang.dms.utils.UserInfoUtil;
import com.yunfang.dms.utils.XmlUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.soap.Addressing;
import java.io.*;
import java.util.*;


/**
 * Created by Administrator on 2017/2/14.
 */
@Controller
@RequestMapping("/upload")
public class UploadController extends BaseController {
    private static final int BUFF_SIZE = 1024 * 1024;

    @Autowired
    private IInquiryDataService InquiryDataService;

    @Autowired
    private ITransactionCaseService transactionCaseService;

    @Autowired
    private IOfferCaseService offerCaseService;

    @Autowired
    private IReportCaseService reportCaseService;

    @Autowired
    private IExtendConfigService extendConfigService;

    @Autowired
    private IReportDocumentService reportDocumentService;

    @Autowired
    private ICommunityBaseDataService communityBaseDataService;

    @Autowired
    private IBuildingBaseDataService buildingBaseDataService;

    @Autowired
    private IUnitBaseDataService unitBaseDataService;

    @Autowired
    private IHouseBaseDataService houseBaseDataService;

    // 附件上传
    @RequestMapping("/uploadAttach")
    public void attachUpload(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ResultInfo<UpLoadFileResultDto> result=new ResultInfo<UpLoadFileResultDto>();
        result.setSuccess(true);
        String dataType = request.getParameter("dataType");
        Integer userCompanyId=UserInfoUtil.getCurrentUserCompanyId();
        String currentUser=UserInfoUtil.getCurrentUser().getLoginName();
        String savePath = request.getSession().getServletContext().getRealPath("/") + "upload/"+dataType+"/"+userCompanyId+"/"+currentUser;
        File f1 = new File(savePath);
        if (!f1.exists()) {
            f1.mkdirs();
        }
        DiskFileItemFactory fac = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(fac);
        upload.setHeaderEncoding("utf-8");
        List<FileItem> fileList = null;
        try {
            fileList = upload.parseRequest(request);
        } catch (FileUploadException ex) {
            ex.printStackTrace();
            return;
        }
        Iterator<FileItem> it = fileList.iterator();
        String name = "";
        //存储完毕保存进入数据库
        //Document document = null;
        UpLoadFileResultDto receivedto = new UpLoadFileResultDto();
        while (it.hasNext()) {
            FileItem item = it.next();
            if (!item.isFormField()) {
                name = item.getName();
                long size = item.getSize();
                String type = item.getContentType();
                if (name == null || name.trim().equals("")) {
                    continue;
                }
                //扩展名格式：
                if (name.lastIndexOf(".") >= 0) {
                    name.substring(name.lastIndexOf("."));
                }
                File saveFile = new File(savePath + "/" + name);
                try {
                    item.write(saveFile);
                    String fileName=name.substring(0,name.lastIndexOf("."));
                    if (dataType.equals("doc")) {//报告文档上传
                        String unZipDir=savePath + "/unzip/"+ fileName;
                        if (!saveFile.getName().endsWith(".rar")) {
                            unZipFiles(saveFile, unZipDir);
                        } else {
                            unRarFile(saveFile.getPath(), unZipDir);
                        }
                        //读取文件夹中的文件
                        reportDocumentService.upLoadReportFile(unZipDir,fileName);
                        File file = new File(unZipDir);
                        deleteFile(file);
                    } else {
                        //询价案例
                        if (dataType.equals("xunjia")) {
                            //调用Service层开始导入数据
                            receivedto=InquiryDataService.batchInsertInquiryData(saveFile.getPath(), dataType + "anli");
                        }
                        //成交案例
                        if (dataType.equals("chengjiao")) {
                            receivedto = transactionCaseService.batchInsertTranCaseData(saveFile.getPath(), dataType + "anli");
                        }
                        //报盘案例
                        if(dataType.equals("baopan"))
                        {
                            receivedto=offerCaseService.batchInsertOfferCaseData(saveFile.getPath(), dataType + "anli");
                        }
                        //报告案例
                        if(dataType.equals("baogao"))
                        {
                            receivedto=reportCaseService.batchInsertReportCaseData(saveFile.getPath(), dataType + "anli");
                        }
                        //小区基础数据
                        if(dataType.equals("community"))
                        {
                            receivedto=communityBaseDataService.batchInsertCommunityBase(saveFile.getPath(),dataType+"base");
                        }
                        //楼幢基础数据
                        if(dataType.equals("building"))
                        {
                            receivedto=buildingBaseDataService.batchInsertBuildingBase(saveFile.getPath(),dataType+"base");
                        }
                        //单元基础数据
                        if(dataType.equals("unit"))
                        {
                            receivedto=unitBaseDataService.batchInsertUnitBase(saveFile.getPath(),dataType+"base");
                        }
                        //户基础数据
                        if(dataType.equals("house"))
                        {
                            receivedto=houseBaseDataService.batchInsertHouseBase(saveFile.getPath(),dataType+"base");
                        }
                    }
                }  catch (CustomException ex){
                    result.setSuccess(false);
                    result.setMsg(ex.getMessage());
                } catch (Exception e) {
                    e.printStackTrace();
                    result.setSuccess(false);
                    result.setMsg("导入失败，请检查数据是否符合要求");
                }
                finally {
                    //删除服务器上的excel文件
                    File file = new File(saveFile.getPath());
                    deleteFile(file);
                }
            }
        }
        result.setData(receivedto);
        Gson gs = new Gson();
        String str = gs.toJson(result);
        str = str.replace("\"extendCol\":\"{\\\"", "\"").replace("\\\"}\"", "\"").replace("\\\"", "\"");
        response.setHeader("Content-type", "application/json;charset=UTF-8");
        response.getWriter().print(str);
    }

    @RequestMapping("/exportError")
    public void exportErrorData(String dataType, String jsonStr) {
        JSONArray jsonArray = JSONArray.fromObject(jsonStr);
        String filename = "询价案例错误数据";
        int ordinal=0;
        String configExtend="anli";
        if (dataType.equals("chengjiao")) {
            filename = "成交案例错误数据";
            ordinal= SourceTableEmum.TransactionCase.ordinal();
        }
        if (dataType.equals("baopan")){
            filename = "报盘案例错误数据";
            ordinal= SourceTableEmum.OfferCase.ordinal();
        }
        if (dataType.equals("baogao")){
            filename = "报告案例错误数据";
            ordinal= SourceTableEmum.ReportCase.ordinal();
        }
        if(dataType.equals("community"))  {
            filename = "小区基础错误数据";
            configExtend="base";
            ordinal= SourceTableEmum.CommunityBaseData.ordinal();
        }
        if(dataType.equals("building"))  {
            filename = "楼幢基础错误数据";
            configExtend="base";
            ordinal= SourceTableEmum.BuildingBaseData.ordinal();
        }
        if(dataType.equals("unit"))  {
            filename = "单元基础错误数据";
            configExtend="base";
            ordinal= SourceTableEmum.UnitBaseData.ordinal();
        }
        if(dataType.equals("house"))  {
            filename = "户基础错误数据";
            configExtend="base";
            ordinal= SourceTableEmum.HouseBaseData.ordinal();
        }
        List<ExtendConfigDto> configs = extendConfigService.getExtendTitleList(UserInfoUtil.getCurrentUserCompanyId(), ordinal);
        //ExtendConfigDto errorDto=new ExtendConfigDto();
        //errorDto.setColumnName("错误原因");
        //configs.add(errorDto);
        List<String> titles = new ArrayList<String>();
        if (configs != null) {
            for (ExtendConfigDto dto :
                    configs) {
                if (!titles.contains(dto.getColumnName())) {
                    titles.add(dto.getColumnName());
                }
            }
        }
        Map<String, TempLateConfigDto> configColMap = XmlUtil.getConfigForInput(dataType +configExtend,"entityCol");
        for(Iterator s=titles.iterator();s.hasNext();)
        {
            String col=s.next().toString();
            TempLateConfigDto dto=new TempLateConfigDto();
            dto.setTemplateCol(col);
            dto.setEntityCol(col);
            configColMap.put(col,dto);
        }
        TempLateConfigDto dto=new TempLateConfigDto();
        dto.setTemplateCol("错误原因");
        dto.setEntityCol("errorMsg");
        configColMap.put("errorMsg",dto);
        ExcelUtil.exportJsonToExcel(filename,configColMap, jsonArray, response);
    }

    /*
    * 递归删除文件
    * */
    private void deleteFile(File file) {
        if (file.exists()) {//判断文件是否存在
            if (file.isFile()) {//判断是否是文件
                file.delete();//删除文件
            } else if (file.isDirectory()) {//否则如果它是一个目录
                File[] files = file.listFiles();//声明目录下所有的文件 files[];
                for (int i = 0;i < files.length;i ++) {//遍历目录下所有的文件
                    this.deleteFile(files[i]);//把每个文件用这个方法进行迭代
                }
                file.delete();//删除文件夹
            }
        } else {
            System.out.println("所删除的文件不存在");
        }
    }

    /*
    * 解压文件夹
    * */
    @SuppressWarnings("rawtypes")
    public void unZipFiles(File zipFile, String descDir) throws IOException {
        File pathFile = new File(descDir);
        if (!pathFile.exists()) {
            pathFile.mkdirs();
        }
        ZipFile zip = new ZipFile(zipFile);
        for (Enumeration entries = zip.getEntries(); entries.hasMoreElements(); ) {
            ZipEntry entry = (ZipEntry) entries.nextElement();
            String zipEntryName = entry.getName();
            InputStream in = zip.getInputStream(entry);
            String outPath = (descDir + "/" + zipEntryName).replaceAll("\\*", "/");
            ;
            //判断路径是否存在,不存在则创建文件路径
            File file = new File(outPath.substring(0, outPath.lastIndexOf('/')));
            if (!file.exists()) {
                file.mkdirs();
            }
            //判断文件全路径是否为文件夹,如果是上面已经上传,不需要解压
            if (new File(outPath).isDirectory()) {
                continue;
            }
            OutputStream out = new FileOutputStream(outPath);
            byte[] buf1 = new byte[1024];
            int len;
            while ((len = in.read(buf1)) > 0) {
                out.write(buf1, 0, len);
            }
            in.close();
            out.close();
        }
    }

    /**
     * 根据原始rar路径，解压到指定文件夹下.
     *
     * @param srcRarPath       原始rar路径
     * @param dstDirectoryPath 解压到的文件夹
     */
    @SuppressWarnings("rawtypes")
    public static void unRarFile(String srcRarPath, String dstDirectoryPath) {
        if (!srcRarPath.toLowerCase().endsWith(".rar")) {
            return;
        }
        File dstDiretory = new File(dstDirectoryPath);
        if (!dstDiretory.exists()) {// 目标目录不存在时，创建该文件夹
            dstDiretory.mkdirs();
        }
        Archive a = null;
        try {
            a = new Archive(new File(srcRarPath));
            if (a != null) {
                a.getMainHeader().print(); // 打印文件信息.
                FileHeader fh = a.nextFileHeader();
                while (fh != null) {
                    if (fh.isDirectory()) { // 文件夹
                        File fol = new File(dstDirectoryPath + File.separator
                                + fh.getFileNameString());
                        fol.mkdirs();
                    } else { // 文件
                        File out = new File(dstDirectoryPath + File.separator
                                + fh.getFileNameString().trim());
                        //System.out.println(out.getAbsolutePath());
                        try {// 之所以这么写try，是因为万一这里面有了异常，不影响继续解压.
                            if (!out.exists()) {
                                if (!out.getParentFile().exists()) {// 相对路径可能多级，可能需要创建父目录.
                                    out.getParentFile().mkdirs();
                                }
                                out.createNewFile();
                            }
                            FileOutputStream os = new FileOutputStream(out);
                            a.extractFile(fh, os);
                            os.close();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                    fh = a.nextFileHeader();
                }
                a.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
