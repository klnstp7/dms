package com.yunfang.dms.dao.mapper;

import com.yunfang.dms.entity.CommunityBaseData;
import com.yunfang.dms.entity.CommunityBaseDataCond.Criteria;
import com.yunfang.dms.entity.CommunityBaseDataCond.Criterion;
import com.yunfang.dms.entity.CommunityBaseDataCond;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class CommunityBaseDataSqlProvider {

    public String countByExample(CommunityBaseDataCond example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("communitybasedata");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(CommunityBaseDataCond example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("communitybasedata");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(CommunityBaseData record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("communitybasedata");
        
        if (record.getCityName() != null) {
            sql.VALUES("CityName", "#{cityName,jdbcType=VARCHAR}");
        }
        
        if (record.getDistrict() != null) {
            sql.VALUES("District", "#{district,jdbcType=VARCHAR}");
        }
        
        if (record.getRegion() != null) {
            sql.VALUES("Region", "#{region,jdbcType=VARCHAR}");
        }
        
        if (record.getCommunity() != null) {
            sql.VALUES("Community", "#{community,jdbcType=VARCHAR}");
        }
        
        if (record.getAlias() != null) {
            sql.VALUES("Alias", "#{alias,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            sql.VALUES("Address", "#{address,jdbcType=VARCHAR}");
        }
        
        if (record.getBuildYear() != null) {
            sql.VALUES("BuildYear", "#{buildYear,jdbcType=VARCHAR}");
        }
        
        if (record.getDevelopers() != null) {
            sql.VALUES("Developers", "#{developers,jdbcType=VARCHAR}");
        }
        
        if (record.getArea() != null) {
            sql.VALUES("Area", "#{area,jdbcType=DECIMAL}");
        }
        
        if (record.getTotalBuilding() != null) {
            sql.VALUES("TotalBuilding", "#{totalBuilding,jdbcType=INTEGER}");
        }
        
        if (record.getTotalHouse() != null) {
            sql.VALUES("TotalHouse", "#{totalHouse,jdbcType=INTEGER}");
        }
        
        if (record.getGreenPercent() != null) {
            sql.VALUES("GreenPercent", "#{greenPercent,jdbcType=DECIMAL}");
        }
        
        if (record.getBaseInstallation() != null) {
            sql.VALUES("BaseInstallation", "#{baseInstallation,jdbcType=VARCHAR}");
        }
        
        if (record.getMating() != null) {
            sql.VALUES("Mating", "#{mating,jdbcType=VARCHAR}");
        }
        
        if (record.getTrafficInfo() != null) {
            sql.VALUES("TrafficInfo", "#{trafficInfo,jdbcType=VARCHAR}");
        }
        
        if (record.getFeaTuRemark() != null) {
            sql.VALUES("FeatureMark", "#{feaTuRemark,jdbcType=VARCHAR}");
        }
        
        if (record.getCompanyId() != null) {
            sql.VALUES("CompanyID", "#{companyId,jdbcType=INTEGER}");
        }
        
        if (record.getRemark() != null) {
            sql.VALUES("Remark", "#{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateDateTime() != null) {
            sql.VALUES("CreateDateTime", "#{createDateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLastUpdateTime() != null) {
            sql.VALUES("LastUpdateTime", "#{lastUpdateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getExtendCol() != null) {
            sql.VALUES("ExtendCol", "#{extendCol,jdbcType=LONGVARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExampleWithBLOBs(CommunityBaseDataCond example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("ID");
        } else {
            sql.SELECT("ID");
        }
        sql.SELECT("CityName");
        sql.SELECT("District");
        sql.SELECT("Region");
        sql.SELECT("Community");
        sql.SELECT("Alias");
        sql.SELECT("Address");
        sql.SELECT("BuildYear");
        sql.SELECT("Developers");
        sql.SELECT("Area");
        sql.SELECT("TotalBuilding");
        sql.SELECT("TotalHouse");
        sql.SELECT("GreenPercent");
        sql.SELECT("BaseInstallation");
        sql.SELECT("Mating");
        sql.SELECT("TrafficInfo");
        sql.SELECT("FeatureMark");
        sql.SELECT("CompanyID");
        sql.SELECT("Remark");
        sql.SELECT("CreateDateTime");
        sql.SELECT("LastUpdateTime");
        sql.SELECT("ExtendCol");
        sql.FROM("communitybasedata");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String selectByExample(CommunityBaseDataCond example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("ID");
        } else {
            sql.SELECT("ID");
        }
        sql.SELECT("CityName");
        sql.SELECT("District");
        sql.SELECT("Region");
        sql.SELECT("Community");
        sql.SELECT("Alias");
        sql.SELECT("Address");
        sql.SELECT("BuildYear");
        sql.SELECT("Developers");
        sql.SELECT("Area");
        sql.SELECT("TotalBuilding");
        sql.SELECT("TotalHouse");
        sql.SELECT("GreenPercent");
        sql.SELECT("BaseInstallation");
        sql.SELECT("Mating");
        sql.SELECT("TrafficInfo");
        sql.SELECT("FeatureMark");
        sql.SELECT("CompanyID");
        sql.SELECT("Remark");
        sql.SELECT("CreateDateTime");
        sql.SELECT("LastUpdateTime");
        sql.SELECT("ExtendCol");
        sql.FROM("communitybasedata");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        String sqlStr=sql.toString();
        if(example.getLimit()>0){
            sqlStr+=" limit " + (example.getStart()>0?example.getStart():"0")+","+example.getLimit();
        }
        return sqlStr;
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        CommunityBaseData record = (CommunityBaseData) parameter.get("record");
        CommunityBaseDataCond example = (CommunityBaseDataCond) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("communitybasedata");
        
        if (record.getId() != null) {
            sql.SET("ID = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getCityName() != null) {
            sql.SET("CityName = #{record.cityName,jdbcType=VARCHAR}");
        }
        
        if (record.getDistrict() != null) {
            sql.SET("District = #{record.district,jdbcType=VARCHAR}");
        }
        
        if (record.getRegion() != null) {
            sql.SET("Region = #{record.region,jdbcType=VARCHAR}");
        }
        
        if (record.getCommunity() != null) {
            sql.SET("Community = #{record.community,jdbcType=VARCHAR}");
        }
        
        if (record.getAlias() != null) {
            sql.SET("Alias = #{record.alias,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            sql.SET("Address = #{record.address,jdbcType=VARCHAR}");
        }
        
        if (record.getBuildYear() != null) {
            sql.SET("BuildYear = #{record.buildYear,jdbcType=VARCHAR}");
        }
        
        if (record.getDevelopers() != null) {
            sql.SET("Developers = #{record.developers,jdbcType=VARCHAR}");
        }
        
        if (record.getArea() != null) {
            sql.SET("Area = #{record.area,jdbcType=DECIMAL}");
        }
        
        if (record.getTotalBuilding() != null) {
            sql.SET("TotalBuilding = #{record.totalBuilding,jdbcType=INTEGER}");
        }
        
        if (record.getTotalHouse() != null) {
            sql.SET("TotalHouse = #{record.totalHouse,jdbcType=INTEGER}");
        }
        
        if (record.getGreenPercent() != null) {
            sql.SET("GreenPercent = #{record.greenPercent,jdbcType=DECIMAL}");
        }
        
        if (record.getBaseInstallation() != null) {
            sql.SET("BaseInstallation = #{record.baseInstallation,jdbcType=VARCHAR}");
        }
        
        if (record.getMating() != null) {
            sql.SET("Mating = #{record.mating,jdbcType=VARCHAR}");
        }
        
        if (record.getTrafficInfo() != null) {
            sql.SET("TrafficInfo = #{record.trafficInfo,jdbcType=VARCHAR}");
        }
        
        if (record.getFeaTuRemark() != null) {
            sql.SET("FeatureMark = #{record.feaTuRemark,jdbcType=VARCHAR}");
        }
        
        if (record.getCompanyId() != null) {
            sql.SET("CompanyID = #{record.companyId,jdbcType=INTEGER}");
        }
        
        if (record.getRemark() != null) {
            sql.SET("Remark = #{record.remark,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateDateTime() != null) {
            sql.SET("CreateDateTime = #{record.createDateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLastUpdateTime() != null) {
            sql.SET("LastUpdateTime = #{record.lastUpdateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getExtendCol() != null) {
            sql.SET("ExtendCol = #{record.extendCol,jdbcType=LONGVARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("communitybasedata");
        
        sql.SET("ID = #{record.id,jdbcType=BIGINT}");
        sql.SET("CityName = #{record.cityName,jdbcType=VARCHAR}");
        sql.SET("District = #{record.district,jdbcType=VARCHAR}");
        sql.SET("Region = #{record.region,jdbcType=VARCHAR}");
        sql.SET("Community = #{record.community,jdbcType=VARCHAR}");
        sql.SET("Alias = #{record.alias,jdbcType=VARCHAR}");
        sql.SET("Address = #{record.address,jdbcType=VARCHAR}");
        sql.SET("BuildYear = #{record.buildYear,jdbcType=VARCHAR}");
        sql.SET("Developers = #{record.developers,jdbcType=VARCHAR}");
        sql.SET("Area = #{record.area,jdbcType=DECIMAL}");
        sql.SET("TotalBuilding = #{record.totalBuilding,jdbcType=INTEGER}");
        sql.SET("TotalHouse = #{record.totalHouse,jdbcType=INTEGER}");
        sql.SET("GreenPercent = #{record.greenPercent,jdbcType=DECIMAL}");
        sql.SET("BaseInstallation = #{record.baseInstallation,jdbcType=VARCHAR}");
        sql.SET("Mating = #{record.mating,jdbcType=VARCHAR}");
        sql.SET("TrafficInfo = #{record.trafficInfo,jdbcType=VARCHAR}");
        sql.SET("FeatureMark = #{record.feaTuRemark,jdbcType=VARCHAR}");
        sql.SET("CompanyID = #{record.companyId,jdbcType=INTEGER}");
        sql.SET("Remark = #{record.remark,jdbcType=VARCHAR}");
        sql.SET("CreateDateTime = #{record.createDateTime,jdbcType=TIMESTAMP}");
        sql.SET("LastUpdateTime = #{record.lastUpdateTime,jdbcType=TIMESTAMP}");
        sql.SET("ExtendCol = #{record.extendCol,jdbcType=LONGVARCHAR}");
        
        CommunityBaseDataCond example = (CommunityBaseDataCond) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("communitybasedata");
        
        sql.SET("ID = #{record.id,jdbcType=BIGINT}");
        sql.SET("CityName = #{record.cityName,jdbcType=VARCHAR}");
        sql.SET("District = #{record.district,jdbcType=VARCHAR}");
        sql.SET("Region = #{record.region,jdbcType=VARCHAR}");
        sql.SET("Community = #{record.community,jdbcType=VARCHAR}");
        sql.SET("Alias = #{record.alias,jdbcType=VARCHAR}");
        sql.SET("Address = #{record.address,jdbcType=VARCHAR}");
        sql.SET("BuildYear = #{record.buildYear,jdbcType=VARCHAR}");
        sql.SET("Developers = #{record.developers,jdbcType=VARCHAR}");
        sql.SET("Area = #{record.area,jdbcType=DECIMAL}");
        sql.SET("TotalBuilding = #{record.totalBuilding,jdbcType=INTEGER}");
        sql.SET("TotalHouse = #{record.totalHouse,jdbcType=INTEGER}");
        sql.SET("GreenPercent = #{record.greenPercent,jdbcType=DECIMAL}");
        sql.SET("BaseInstallation = #{record.baseInstallation,jdbcType=VARCHAR}");
        sql.SET("Mating = #{record.mating,jdbcType=VARCHAR}");
        sql.SET("TrafficInfo = #{record.trafficInfo,jdbcType=VARCHAR}");
        sql.SET("FeatureMark = #{record.feaTuRemark,jdbcType=VARCHAR}");
        sql.SET("CompanyID = #{record.companyId,jdbcType=INTEGER}");
        sql.SET("Remark = #{record.remark,jdbcType=VARCHAR}");
        sql.SET("CreateDateTime = #{record.createDateTime,jdbcType=TIMESTAMP}");
        sql.SET("LastUpdateTime = #{record.lastUpdateTime,jdbcType=TIMESTAMP}");
        
        CommunityBaseDataCond example = (CommunityBaseDataCond) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(CommunityBaseData record) {
        SQL sql = new SQL();
        sql.UPDATE("communitybasedata");
        
        if (record.getCityName() != null) {
            sql.SET("CityName = #{cityName,jdbcType=VARCHAR}");
        }
        
        if (record.getDistrict() != null) {
            sql.SET("District = #{district,jdbcType=VARCHAR}");
        }
        
        if (record.getRegion() != null) {
            sql.SET("Region = #{region,jdbcType=VARCHAR}");
        }
        
        if (record.getCommunity() != null) {
            sql.SET("Community = #{community,jdbcType=VARCHAR}");
        }
        
        if (record.getAlias() != null) {
            sql.SET("Alias = #{alias,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            sql.SET("Address = #{address,jdbcType=VARCHAR}");
        }
        
        if (record.getBuildYear() != null) {
            sql.SET("BuildYear = #{buildYear,jdbcType=VARCHAR}");
        }
        
        if (record.getDevelopers() != null) {
            sql.SET("Developers = #{developers,jdbcType=VARCHAR}");
        }
        
        if (record.getArea() != null) {
            sql.SET("Area = #{area,jdbcType=DECIMAL}");
        }
        
        if (record.getTotalBuilding() != null) {
            sql.SET("TotalBuilding = #{totalBuilding,jdbcType=INTEGER}");
        }
        
        if (record.getTotalHouse() != null) {
            sql.SET("TotalHouse = #{totalHouse,jdbcType=INTEGER}");
        }
        
        if (record.getGreenPercent() != null) {
            sql.SET("GreenPercent = #{greenPercent,jdbcType=DECIMAL}");
        }
        
        if (record.getBaseInstallation() != null) {
            sql.SET("BaseInstallation = #{baseInstallation,jdbcType=VARCHAR}");
        }
        
        if (record.getMating() != null) {
            sql.SET("Mating = #{mating,jdbcType=VARCHAR}");
        }
        
        if (record.getTrafficInfo() != null) {
            sql.SET("TrafficInfo = #{trafficInfo,jdbcType=VARCHAR}");
        }
        
        if (record.getFeaTuRemark() != null) {
            sql.SET("FeatureMark = #{feaTuRemark,jdbcType=VARCHAR}");
        }
        
        if (record.getCompanyId() != null) {
            sql.SET("CompanyID = #{companyId,jdbcType=INTEGER}");
        }
        
        if (record.getRemark() != null) {
            sql.SET("Remark = #{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateDateTime() != null) {
            sql.SET("CreateDateTime = #{createDateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLastUpdateTime() != null) {
            sql.SET("LastUpdateTime = #{lastUpdateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getExtendCol() != null) {
            sql.SET("ExtendCol = #{extendCol,jdbcType=LONGVARCHAR}");
        }
        
        sql.WHERE("ID = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, CommunityBaseDataCond example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}