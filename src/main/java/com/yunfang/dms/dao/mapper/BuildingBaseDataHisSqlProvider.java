package com.yunfang.dms.dao.mapper;

import com.yunfang.dms.entity.BuildingBaseDataHis;
import com.yunfang.dms.entity.BuildingBaseDataHisCond.Criteria;
import com.yunfang.dms.entity.BuildingBaseDataHisCond.Criterion;
import com.yunfang.dms.entity.BuildingBaseDataHisCond;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class BuildingBaseDataHisSqlProvider {

    public String countByExample(BuildingBaseDataHisCond example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("buildingbasedata_his");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(BuildingBaseDataHisCond example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("buildingbasedata_his");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(BuildingBaseDataHis record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("buildingbasedata_his");
        
        if (record.getBuildingid() != null) {
            sql.VALUES("BuildingID", "#{buildingid,jdbcType=BIGINT}");
        }
        
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
        
        if (record.getBuildingName() != null) {
            sql.VALUES("BuildingName", "#{buildingName,jdbcType=VARCHAR}");
        }
        
        if (record.getBuildingAlias() != null) {
            sql.VALUES("BuildingAlias", "#{buildingAlias,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            sql.VALUES("Address", "#{address,jdbcType=VARCHAR}");
        }
        
        if (record.getBuildYear() != null) {
            sql.VALUES("BuildYear", "#{buildYear,jdbcType=VARCHAR}");
        }
        
        if (record.getTotalFloor() != null) {
            sql.VALUES("TotalFloor", "#{totalFloor,jdbcType=INTEGER}");
        }
        
        if (record.getTotalHouse() != null) {
            sql.VALUES("TotalHouse", "#{totalHouse,jdbcType=INTEGER}");
        }
        
        if (record.getRemark() != null) {
            sql.VALUES("Remark", "#{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateDateTime() != null) {
            sql.VALUES("CreateDateTime", "#{createDateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getOperator() != null) {
            sql.VALUES("Operator", "#{operator,jdbcType=VARCHAR}");
        }
        
        if (record.getExtendCol() != null) {
            sql.VALUES("ExtendCol", "#{extendCol,jdbcType=LONGVARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExampleWithBLOBs(BuildingBaseDataHisCond example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("ID");
        } else {
            sql.SELECT("ID");
        }
        sql.SELECT("BuildingID");
        sql.SELECT("CityName");
        sql.SELECT("District");
        sql.SELECT("Region");
        sql.SELECT("Community");
        sql.SELECT("BuildingName");
        sql.SELECT("BuildingAlias");
        sql.SELECT("Address");
        sql.SELECT("BuildYear");
        sql.SELECT("TotalFloor");
        sql.SELECT("TotalHouse");
        sql.SELECT("Remark");
        sql.SELECT("CreateDateTime");
        sql.SELECT("Operator");
        sql.SELECT("ExtendCol");
        sql.FROM("buildingbasedata_his");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String selectByExample(BuildingBaseDataHisCond example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("ID");
        } else {
            sql.SELECT("ID");
        }
        sql.SELECT("BuildingID");
        sql.SELECT("CityName");
        sql.SELECT("District");
        sql.SELECT("Region");
        sql.SELECT("Community");
        sql.SELECT("BuildingName");
        sql.SELECT("BuildingAlias");
        sql.SELECT("Address");
        sql.SELECT("BuildYear");
        sql.SELECT("TotalFloor");
        sql.SELECT("TotalHouse");
        sql.SELECT("Remark");
        sql.SELECT("CreateDateTime");
        sql.SELECT("Operator");
        sql.FROM("buildingbasedata_his");
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
        BuildingBaseDataHis record = (BuildingBaseDataHis) parameter.get("record");
        BuildingBaseDataHisCond example = (BuildingBaseDataHisCond) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("buildingbasedata_his");
        
        if (record.getId() != null) {
            sql.SET("ID = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getBuildingid() != null) {
            sql.SET("BuildingID = #{record.buildingid,jdbcType=BIGINT}");
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
        
        if (record.getBuildingName() != null) {
            sql.SET("BuildingName = #{record.buildingName,jdbcType=VARCHAR}");
        }
        
        if (record.getBuildingAlias() != null) {
            sql.SET("BuildingAlias = #{record.buildingAlias,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            sql.SET("Address = #{record.address,jdbcType=VARCHAR}");
        }
        
        if (record.getBuildYear() != null) {
            sql.SET("BuildYear = #{record.buildYear,jdbcType=VARCHAR}");
        }
        
        if (record.getTotalFloor() != null) {
            sql.SET("TotalFloor = #{record.totalFloor,jdbcType=INTEGER}");
        }
        
        if (record.getTotalHouse() != null) {
            sql.SET("TotalHouse = #{record.totalHouse,jdbcType=INTEGER}");
        }
        
        if (record.getRemark() != null) {
            sql.SET("Remark = #{record.remark,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateDateTime() != null) {
            sql.SET("CreateDateTime = #{record.createDateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getOperator() != null) {
            sql.SET("Operator = #{record.operator,jdbcType=VARCHAR}");
        }
        
        if (record.getExtendCol() != null) {
            sql.SET("ExtendCol = #{record.extendCol,jdbcType=LONGVARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("buildingbasedata_his");
        
        sql.SET("ID = #{record.id,jdbcType=BIGINT}");
        sql.SET("BuildingID = #{record.buildingid,jdbcType=BIGINT}");
        sql.SET("CityName = #{record.cityName,jdbcType=VARCHAR}");
        sql.SET("District = #{record.district,jdbcType=VARCHAR}");
        sql.SET("Region = #{record.region,jdbcType=VARCHAR}");
        sql.SET("Community = #{record.community,jdbcType=VARCHAR}");
        sql.SET("BuildingName = #{record.buildingName,jdbcType=VARCHAR}");
        sql.SET("BuildingAlias = #{record.buildingAlias,jdbcType=VARCHAR}");
        sql.SET("Address = #{record.address,jdbcType=VARCHAR}");
        sql.SET("BuildYear = #{record.buildYear,jdbcType=VARCHAR}");
        sql.SET("TotalFloor = #{record.totalFloor,jdbcType=INTEGER}");
        sql.SET("TotalHouse = #{record.totalHouse,jdbcType=INTEGER}");
        sql.SET("Remark = #{record.remark,jdbcType=VARCHAR}");
        sql.SET("CreateDateTime = #{record.createDateTime,jdbcType=TIMESTAMP}");
        sql.SET("Operator = #{record.operator,jdbcType=VARCHAR}");
        sql.SET("ExtendCol = #{record.extendCol,jdbcType=LONGVARCHAR}");
        
        BuildingBaseDataHisCond example = (BuildingBaseDataHisCond) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("buildingbasedata_his");
        
        sql.SET("ID = #{record.id,jdbcType=BIGINT}");
        sql.SET("BuildingID = #{record.buildingid,jdbcType=BIGINT}");
        sql.SET("CityName = #{record.cityName,jdbcType=VARCHAR}");
        sql.SET("District = #{record.district,jdbcType=VARCHAR}");
        sql.SET("Region = #{record.region,jdbcType=VARCHAR}");
        sql.SET("Community = #{record.community,jdbcType=VARCHAR}");
        sql.SET("BuildingName = #{record.buildingName,jdbcType=VARCHAR}");
        sql.SET("BuildingAlias = #{record.buildingAlias,jdbcType=VARCHAR}");
        sql.SET("Address = #{record.address,jdbcType=VARCHAR}");
        sql.SET("BuildYear = #{record.buildYear,jdbcType=VARCHAR}");
        sql.SET("TotalFloor = #{record.totalFloor,jdbcType=INTEGER}");
        sql.SET("TotalHouse = #{record.totalHouse,jdbcType=INTEGER}");
        sql.SET("Remark = #{record.remark,jdbcType=VARCHAR}");
        sql.SET("CreateDateTime = #{record.createDateTime,jdbcType=TIMESTAMP}");
        sql.SET("Operator = #{record.operator,jdbcType=VARCHAR}");
        
        BuildingBaseDataHisCond example = (BuildingBaseDataHisCond) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(BuildingBaseDataHis record) {
        SQL sql = new SQL();
        sql.UPDATE("buildingbasedata_his");
        
        if (record.getBuildingid() != null) {
            sql.SET("BuildingID = #{buildingid,jdbcType=BIGINT}");
        }
        
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
        
        if (record.getBuildingName() != null) {
            sql.SET("BuildingName = #{buildingName,jdbcType=VARCHAR}");
        }
        
        if (record.getBuildingAlias() != null) {
            sql.SET("BuildingAlias = #{buildingAlias,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            sql.SET("Address = #{address,jdbcType=VARCHAR}");
        }
        
        if (record.getBuildYear() != null) {
            sql.SET("BuildYear = #{buildYear,jdbcType=VARCHAR}");
        }
        
        if (record.getTotalFloor() != null) {
            sql.SET("TotalFloor = #{totalFloor,jdbcType=INTEGER}");
        }
        
        if (record.getTotalHouse() != null) {
            sql.SET("TotalHouse = #{totalHouse,jdbcType=INTEGER}");
        }
        
        if (record.getRemark() != null) {
            sql.SET("Remark = #{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateDateTime() != null) {
            sql.SET("CreateDateTime = #{createDateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getOperator() != null) {
            sql.SET("Operator = #{operator,jdbcType=VARCHAR}");
        }
        
        if (record.getExtendCol() != null) {
            sql.SET("ExtendCol = #{extendCol,jdbcType=LONGVARCHAR}");
        }
        
        sql.WHERE("ID = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, BuildingBaseDataHisCond example, boolean includeExamplePhrase) {
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