package com.yunfang.dms.dao.mapper;

import com.yunfang.dms.entity.ReportCaseHis;
import com.yunfang.dms.entity.ReportCaseHisCond.Criteria;
import com.yunfang.dms.entity.ReportCaseHisCond.Criterion;
import com.yunfang.dms.entity.ReportCaseHisCond;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class ReportCaseHisSqlProvider {

    public String countByExample(ReportCaseHisCond example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("reportcase_his");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(ReportCaseHisCond example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("reportcase_his");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(ReportCaseHis record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("reportcase_his");
        
        if (record.getReportCaseId() != null) {
            sql.VALUES("ReportCaseID", "#{reportCaseId,jdbcType=BIGINT}");
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
        
        if (record.getReportNo() != null) {
            sql.VALUES("ReportNo", "#{reportNo,jdbcType=VARCHAR}");
        }
        
        if (record.getReportTime() != null) {
            sql.VALUES("ReportTime", "#{reportTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCommunity() != null) {
            sql.VALUES("Community", "#{community,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            sql.VALUES("Address", "#{address,jdbcType=VARCHAR}");
        }
        
        if (record.getBuildingName() != null) {
            sql.VALUES("BuildingName", "#{buildingName,jdbcType=VARCHAR}");
        }
        
        if (record.getRoomLayout() != null) {
            sql.VALUES("RoomLayout", "#{roomLayout,jdbcType=VARCHAR}");
        }
        
        if (record.getHouseName() != null) {
            sql.VALUES("HouseName", "#{houseName,jdbcType=VARCHAR}");
        }
        
        if (record.getFloor() != null) {
            sql.VALUES("Floor", "#{floor,jdbcType=INTEGER}");
        }
        
        if (record.getTotalFloor() != null) {
            sql.VALUES("TotalFloor", "#{totalFloor,jdbcType=INTEGER}");
        }
        
        if (record.getToward() != null) {
            sql.VALUES("Toward", "#{toward,jdbcType=VARCHAR}");
        }
        
        if (record.getBuildYear() != null) {
            sql.VALUES("BuildYear", "#{buildYear,jdbcType=VARCHAR}");
        }
        
        if (record.getArea() != null) {
            sql.VALUES("Area", "#{area,jdbcType=DECIMAL}");
        }
        
        if (record.getTotalprice() != null) {
            sql.VALUES("TotalPrice", "#{totalPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getPurpose() != null) {
            sql.VALUES("Purpose", "#{purpose,jdbcType=VARCHAR}");
        }
        
        if (record.getHouseProperty() != null) {
            sql.VALUES("HouseProperty", "#{houseProperty,jdbcType=VARCHAR}");
        }
        
        if (record.getBuildType() != null) {
            sql.VALUES("BuildType", "#{buildType,jdbcType=VARCHAR}");
        }
        
        if (record.getDecoration() != null) {
            sql.VALUES("Decoration", "#{decoration,jdbcType=VARCHAR}");
        }
        
        if (record.getCustomerInfo() != null) {
            sql.VALUES("CustomerInfo", "#{customerInfo,jdbcType=VARCHAR}");
        }
        
        if (record.getRoomProperty() != null) {
            sql.VALUES("RoomProperty", "#{roomProperty,jdbcType=VARCHAR}");
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

    public String selectByExampleWithBLOBs(ReportCaseHisCond example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("ID");
        } else {
            sql.SELECT("ID");
        }
        sql.SELECT("ReportCaseID");
        sql.SELECT("CityName");
        sql.SELECT("District");
        sql.SELECT("Region");
        sql.SELECT("ReportNo");
        sql.SELECT("ReportTime");
        sql.SELECT("Community");
        sql.SELECT("Address");
        sql.SELECT("BuildingName");
        sql.SELECT("RoomLayout");
        sql.SELECT("HouseName");
        sql.SELECT("Floor");
        sql.SELECT("TotalFloor");
        sql.SELECT("Toward");
        sql.SELECT("BuildYear");
        sql.SELECT("Area");
        sql.SELECT("TotalPrice");
        sql.SELECT("Purpose");
        sql.SELECT("HouseProperty");
        sql.SELECT("BuildType");
        sql.SELECT("Decoration");
        sql.SELECT("CustomerInfo");
        sql.SELECT("RoomProperty");
        sql.SELECT("Remark");
        sql.SELECT("CreateDateTime");
        sql.SELECT("Operator");
        sql.SELECT("ExtendCol");
        sql.FROM("reportcase_his");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String selectByExample(ReportCaseHisCond example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("ID");
        } else {
            sql.SELECT("ID");
        }
        sql.SELECT("ReportCaseID");
        sql.SELECT("CityName");
        sql.SELECT("District");
        sql.SELECT("Region");
        sql.SELECT("ReportNo");
        sql.SELECT("ReportTime");
        sql.SELECT("Community");
        sql.SELECT("Address");
        sql.SELECT("BuildingName");
        sql.SELECT("RoomLayout");
        sql.SELECT("HouseName");
        sql.SELECT("Floor");
        sql.SELECT("TotalFloor");
        sql.SELECT("Toward");
        sql.SELECT("BuildYear");
        sql.SELECT("Area");
        sql.SELECT("TotalPrice");
        sql.SELECT("Purpose");
        sql.SELECT("HouseProperty");
        sql.SELECT("BuildType");
        sql.SELECT("Decoration");
        sql.SELECT("CustomerInfo");
        sql.SELECT("RoomProperty");
        sql.SELECT("Remark");
        sql.SELECT("CreateDateTime");
        sql.SELECT("Operator");
        sql.FROM("reportcase_his");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        ReportCaseHis record = (ReportCaseHis) parameter.get("record");
        ReportCaseHisCond example = (ReportCaseHisCond) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("reportcase_his");
        
        if (record.getId() != null) {
            sql.SET("ID = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getReportCaseId() != null) {
            sql.SET("ReportCaseID = #{record.reportCaseId,jdbcType=BIGINT}");
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
        
        if (record.getReportNo() != null) {
            sql.SET("ReportNo = #{record.reportNo,jdbcType=VARCHAR}");
        }
        
        if (record.getReportTime() != null) {
            sql.SET("ReportTime = #{record.reportTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCommunity() != null) {
            sql.SET("Community = #{record.community,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            sql.SET("Address = #{record.address,jdbcType=VARCHAR}");
        }
        
        if (record.getBuildingName() != null) {
            sql.SET("BuildingName = #{record.buildingName,jdbcType=VARCHAR}");
        }
        
        if (record.getRoomLayout() != null) {
            sql.SET("RoomLayout = #{record.roomLayout,jdbcType=VARCHAR}");
        }
        
        if (record.getHouseName() != null) {
            sql.SET("HouseName = #{record.houseName,jdbcType=VARCHAR}");
        }
        
        if (record.getFloor() != null) {
            sql.SET("Floor = #{record.floor,jdbcType=INTEGER}");
        }
        
        if (record.getTotalFloor() != null) {
            sql.SET("TotalFloor = #{record.totalFloor,jdbcType=INTEGER}");
        }
        
        if (record.getToward() != null) {
            sql.SET("Toward = #{record.toward,jdbcType=VARCHAR}");
        }
        
        if (record.getBuildYear() != null) {
            sql.SET("BuildYear = #{record.buildYear,jdbcType=VARCHAR}");
        }
        
        if (record.getArea() != null) {
            sql.SET("Area = #{record.area,jdbcType=DECIMAL}");
        }
        
        if (record.getTotalprice() != null) {
            sql.SET("TotalPrice = #{record.totalPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getPurpose() != null) {
            sql.SET("Purpose = #{record.purpose,jdbcType=VARCHAR}");
        }
        
        if (record.getHouseProperty() != null) {
            sql.SET("HouseProperty = #{record.houseProperty,jdbcType=VARCHAR}");
        }
        
        if (record.getBuildType() != null) {
            sql.SET("BuildType = #{record.buildType,jdbcType=VARCHAR}");
        }
        
        if (record.getDecoration() != null) {
            sql.SET("Decoration = #{record.decoration,jdbcType=VARCHAR}");
        }
        
        if (record.getCustomerInfo() != null) {
            sql.SET("CustomerInfo = #{record.customerInfo,jdbcType=VARCHAR}");
        }
        
        if (record.getRoomProperty() != null) {
            sql.SET("RoomProperty = #{record.roomProperty,jdbcType=VARCHAR}");
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
        sql.UPDATE("reportcase_his");
        
        sql.SET("ID = #{record.id,jdbcType=BIGINT}");
        sql.SET("ReportCaseID = #{record.reportCaseId,jdbcType=BIGINT}");
        sql.SET("CityName = #{record.cityName,jdbcType=VARCHAR}");
        sql.SET("District = #{record.district,jdbcType=VARCHAR}");
        sql.SET("Region = #{record.region,jdbcType=VARCHAR}");
        sql.SET("ReportNo = #{record.reportNo,jdbcType=VARCHAR}");
        sql.SET("ReportTime = #{record.reportTime,jdbcType=TIMESTAMP}");
        sql.SET("Community = #{record.community,jdbcType=VARCHAR}");
        sql.SET("Address = #{record.address,jdbcType=VARCHAR}");
        sql.SET("BuildingName = #{record.buildingName,jdbcType=VARCHAR}");
        sql.SET("RoomLayout = #{record.roomLayout,jdbcType=VARCHAR}");
        sql.SET("HouseName = #{record.houseName,jdbcType=VARCHAR}");
        sql.SET("Floor = #{record.floor,jdbcType=INTEGER}");
        sql.SET("TotalFloor = #{record.totalFloor,jdbcType=INTEGER}");
        sql.SET("Toward = #{record.toward,jdbcType=VARCHAR}");
        sql.SET("BuildYear = #{record.buildYear,jdbcType=VARCHAR}");
        sql.SET("Area = #{record.area,jdbcType=DECIMAL}");
        sql.SET("TotalPrice = #{record.totalPrice,jdbcType=DECIMAL}");
        sql.SET("Purpose = #{record.purpose,jdbcType=VARCHAR}");
        sql.SET("HouseProperty = #{record.houseProperty,jdbcType=VARCHAR}");
        sql.SET("BuildType = #{record.buildType,jdbcType=VARCHAR}");
        sql.SET("Decoration = #{record.decoration,jdbcType=VARCHAR}");
        sql.SET("CustomerInfo = #{record.customerInfo,jdbcType=VARCHAR}");
        sql.SET("RoomProperty = #{record.roomProperty,jdbcType=VARCHAR}");
        sql.SET("Remark = #{record.remark,jdbcType=VARCHAR}");
        sql.SET("CreateDateTime = #{record.createDateTime,jdbcType=TIMESTAMP}");
        sql.SET("Operator = #{record.operator,jdbcType=VARCHAR}");
        sql.SET("ExtendCol = #{record.extendCol,jdbcType=LONGVARCHAR}");
        
        ReportCaseHisCond example = (ReportCaseHisCond) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("reportcase_his");
        
        sql.SET("ID = #{record.id,jdbcType=BIGINT}");
        sql.SET("ReportCaseID = #{record.reportCaseId,jdbcType=BIGINT}");
        sql.SET("CityName = #{record.cityName,jdbcType=VARCHAR}");
        sql.SET("District = #{record.district,jdbcType=VARCHAR}");
        sql.SET("Region = #{record.region,jdbcType=VARCHAR}");
        sql.SET("ReportNo = #{record.reportNo,jdbcType=VARCHAR}");
        sql.SET("ReportTime = #{record.reportTime,jdbcType=TIMESTAMP}");
        sql.SET("Community = #{record.community,jdbcType=VARCHAR}");
        sql.SET("Address = #{record.address,jdbcType=VARCHAR}");
        sql.SET("BuildingName = #{record.buildingName,jdbcType=VARCHAR}");
        sql.SET("RoomLayout = #{record.roomLayout,jdbcType=VARCHAR}");
        sql.SET("HouseName = #{record.houseName,jdbcType=VARCHAR}");
        sql.SET("Floor = #{record.floor,jdbcType=INTEGER}");
        sql.SET("TotalFloor = #{record.totalFloor,jdbcType=INTEGER}");
        sql.SET("Toward = #{record.toward,jdbcType=VARCHAR}");
        sql.SET("BuildYear = #{record.buildYear,jdbcType=VARCHAR}");
        sql.SET("Area = #{record.area,jdbcType=DECIMAL}");
        sql.SET("TotalPrice = #{record.totalPrice,jdbcType=DECIMAL}");
        sql.SET("Purpose = #{record.purpose,jdbcType=VARCHAR}");
        sql.SET("HouseProperty = #{record.houseProperty,jdbcType=VARCHAR}");
        sql.SET("BuildType = #{record.buildType,jdbcType=VARCHAR}");
        sql.SET("Decoration = #{record.decoration,jdbcType=VARCHAR}");
        sql.SET("CustomerInfo = #{record.customerInfo,jdbcType=VARCHAR}");
        sql.SET("RoomProperty = #{record.roomProperty,jdbcType=VARCHAR}");
        sql.SET("Remark = #{record.remark,jdbcType=VARCHAR}");
        sql.SET("CreateDateTime = #{record.createDateTime,jdbcType=TIMESTAMP}");
        sql.SET("Operator = #{record.operator,jdbcType=VARCHAR}");
        
        ReportCaseHisCond example = (ReportCaseHisCond) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(ReportCaseHis record) {
        SQL sql = new SQL();
        sql.UPDATE("reportcase_his");
        
        if (record.getReportCaseId() != null) {
            sql.SET("ReportCaseID = #{reportCaseId,jdbcType=BIGINT}");
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
        
        if (record.getReportNo() != null) {
            sql.SET("ReportNo = #{reportNo,jdbcType=VARCHAR}");
        }
        
        if (record.getReportTime() != null) {
            sql.SET("ReportTime = #{reportTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCommunity() != null) {
            sql.SET("Community = #{community,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            sql.SET("Address = #{address,jdbcType=VARCHAR}");
        }
        
        if (record.getBuildingName() != null) {
            sql.SET("BuildingName = #{buildingName,jdbcType=VARCHAR}");
        }
        
        if (record.getRoomLayout() != null) {
            sql.SET("RoomLayout = #{roomLayout,jdbcType=VARCHAR}");
        }
        
        if (record.getHouseName() != null) {
            sql.SET("HouseName = #{houseName,jdbcType=VARCHAR}");
        }
        
        if (record.getFloor() != null) {
            sql.SET("Floor = #{floor,jdbcType=INTEGER}");
        }
        
        if (record.getTotalFloor() != null) {
            sql.SET("TotalFloor = #{totalFloor,jdbcType=INTEGER}");
        }
        
        if (record.getToward() != null) {
            sql.SET("Toward = #{toward,jdbcType=VARCHAR}");
        }
        
        if (record.getBuildYear() != null) {
            sql.SET("BuildYear = #{buildYear,jdbcType=VARCHAR}");
        }
        
        if (record.getArea() != null) {
            sql.SET("Area = #{area,jdbcType=DECIMAL}");
        }
        
        if (record.getTotalprice() != null) {
            sql.SET("TotalPrice = #{totalPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getPurpose() != null) {
            sql.SET("Purpose = #{purpose,jdbcType=VARCHAR}");
        }
        
        if (record.getHouseProperty() != null) {
            sql.SET("HouseProperty = #{houseProperty,jdbcType=VARCHAR}");
        }
        
        if (record.getBuildType() != null) {
            sql.SET("BuildType = #{buildType,jdbcType=VARCHAR}");
        }
        
        if (record.getDecoration() != null) {
            sql.SET("Decoration = #{decoration,jdbcType=VARCHAR}");
        }
        
        if (record.getCustomerInfo() != null) {
            sql.SET("CustomerInfo = #{customerInfo,jdbcType=VARCHAR}");
        }
        
        if (record.getRoomProperty() != null) {
            sql.SET("RoomProperty = #{roomProperty,jdbcType=VARCHAR}");
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

    protected void applyWhere(SQL sql, ReportCaseHisCond example, boolean includeExamplePhrase) {
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