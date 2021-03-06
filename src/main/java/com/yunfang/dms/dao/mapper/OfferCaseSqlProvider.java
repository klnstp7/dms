package com.yunfang.dms.dao.mapper;

import com.yunfang.dms.entity.OfferCase;
import com.yunfang.dms.entity.OfferCaseCond;
import com.yunfang.dms.entity.OfferCaseCond.Criteria;
import com.yunfang.dms.entity.OfferCaseCond.Criterion;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class OfferCaseSqlProvider {

    public String countByExample(OfferCaseCond example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("offercase");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(OfferCaseCond example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("offercase");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(OfferCase record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("offercase");
        
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
        
        if (record.getAddress() != null) {
            sql.VALUES("Address", "#{address,jdbcType=VARCHAR}");
        }
        
        if (record.getRoomLayout() != null) {
            sql.VALUES("RoomLayout", "#{roomLayout,jdbcType=VARCHAR}");
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
        
        if (record.getPrice() != null) {
            sql.VALUES("Price", "#{price,jdbcType=DECIMAL}");
        }
        
        if (record.getTotalPrice() != null) {
            sql.VALUES("TotalPrice", "#{totalPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getRemark() != null) {
            sql.VALUES("Remark", "#{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getOfferTime() != null) {
            sql.VALUES("OfferTime", "#{offerTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDataSource() != null) {
            sql.VALUES("DataSource", "#{dataSource,jdbcType=VARCHAR}");
        }
        
        if (record.getCompanyId() != null) {
            sql.VALUES("CompanyID", "#{companyId,jdbcType=INTEGER}");
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

    public String selectByExampleWithBLOBs(OfferCaseCond example) {
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
        sql.SELECT("Address");
        sql.SELECT("RoomLayout");
        sql.SELECT("Floor");
        sql.SELECT("TotalFloor");
        sql.SELECT("Toward");
        sql.SELECT("BuildYear");
        sql.SELECT("Area");
        sql.SELECT("Price");
        sql.SELECT("TotalPrice");
        sql.SELECT("Remark");
        sql.SELECT("OfferTime");
        sql.SELECT("DataSource");
        sql.SELECT("CompanyID");
        sql.SELECT("CreateDateTime");
        sql.SELECT("LastUpdateTime");
        sql.SELECT("ExtendCol");
        sql.FROM("offercase");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String selectByExample(OfferCaseCond example) {
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
        sql.SELECT("Address");
        sql.SELECT("RoomLayout");
        sql.SELECT("Floor");
        sql.SELECT("TotalFloor");
        sql.SELECT("Toward");
        sql.SELECT("BuildYear");
        sql.SELECT("Area");
        sql.SELECT("Price");
        sql.SELECT("TotalPrice");
        sql.SELECT("Remark");
        sql.SELECT("OfferTime");
        sql.SELECT("DataSource");
        sql.SELECT("CompanyID");
        sql.SELECT("CreateDateTime");
        sql.SELECT("LastUpdateTime");
        sql.FROM("offercase");
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
        OfferCase record = (OfferCase) parameter.get("record");
        OfferCaseCond example = (OfferCaseCond) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("offercase");
        
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
        
        if (record.getAddress() != null) {
            sql.SET("Address = #{record.address,jdbcType=VARCHAR}");
        }
        
        if (record.getRoomLayout() != null) {
            sql.SET("RoomLayout = #{record.roomLayout,jdbcType=VARCHAR}");
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
        
        if (record.getPrice() != null) {
            sql.SET("Price = #{record.price,jdbcType=DECIMAL}");
        }
        
        if (record.getTotalPrice() != null) {
            sql.SET("TotalPrice = #{record.totalPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getRemark() != null) {
            sql.SET("Remark = #{record.remark,jdbcType=VARCHAR}");
        }
        
        if (record.getOfferTime() != null) {
            sql.SET("OfferTime = #{record.offerTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDataSource() != null) {
            sql.SET("DataSource = #{record.dataSource,jdbcType=VARCHAR}");
        }
        
        if (record.getCompanyId() != null) {
            sql.SET("CompanyID = #{record.companyId,jdbcType=INTEGER}");
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
        sql.UPDATE("offercase");
        
        sql.SET("ID = #{record.id,jdbcType=BIGINT}");
        sql.SET("CityName = #{record.cityName,jdbcType=VARCHAR}");
        sql.SET("District = #{record.district,jdbcType=VARCHAR}");
        sql.SET("Region = #{record.region,jdbcType=VARCHAR}");
        sql.SET("Community = #{record.community,jdbcType=VARCHAR}");
        sql.SET("Address = #{record.address,jdbcType=VARCHAR}");
        sql.SET("RoomLayout = #{record.roomLayout,jdbcType=VARCHAR}");
        sql.SET("Floor = #{record.floor,jdbcType=INTEGER}");
        sql.SET("TotalFloor = #{record.totalFloor,jdbcType=INTEGER}");
        sql.SET("Toward = #{record.toward,jdbcType=VARCHAR}");
        sql.SET("BuildYear = #{record.buildYear,jdbcType=VARCHAR}");
        sql.SET("Area = #{record.area,jdbcType=DECIMAL}");
        sql.SET("Price = #{record.price,jdbcType=DECIMAL}");
        sql.SET("TotalPrice = #{record.totalPrice,jdbcType=DECIMAL}");
        sql.SET("Remark = #{record.remark,jdbcType=VARCHAR}");
        sql.SET("OfferTime = #{record.offerTime,jdbcType=TIMESTAMP}");
        sql.SET("DataSource = #{record.dataSource,jdbcType=VARCHAR}");
        sql.SET("CompanyID = #{record.companyId,jdbcType=INTEGER}");
        sql.SET("CreateDateTime = #{record.createDateTime,jdbcType=TIMESTAMP}");
        sql.SET("LastUpdateTime = #{record.lastUpdateTime,jdbcType=TIMESTAMP}");
        sql.SET("ExtendCol = #{record.extendCol,jdbcType=LONGVARCHAR}");
        
        OfferCaseCond example = (OfferCaseCond) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("offercase");
        
        sql.SET("ID = #{record.id,jdbcType=BIGINT}");
        sql.SET("CityName = #{record.cityName,jdbcType=VARCHAR}");
        sql.SET("District = #{record.district,jdbcType=VARCHAR}");
        sql.SET("Region = #{record.region,jdbcType=VARCHAR}");
        sql.SET("Community = #{record.community,jdbcType=VARCHAR}");
        sql.SET("Address = #{record.address,jdbcType=VARCHAR}");
        sql.SET("RoomLayout = #{record.roomLayout,jdbcType=VARCHAR}");
        sql.SET("Floor = #{record.floor,jdbcType=INTEGER}");
        sql.SET("TotalFloor = #{record.totalFloor,jdbcType=INTEGER}");
        sql.SET("Toward = #{record.toward,jdbcType=VARCHAR}");
        sql.SET("BuildYear = #{record.buildYear,jdbcType=VARCHAR}");
        sql.SET("Area = #{record.area,jdbcType=DECIMAL}");
        sql.SET("Price = #{record.price,jdbcType=DECIMAL}");
        sql.SET("TotalPrice = #{record.totalPrice,jdbcType=DECIMAL}");
        sql.SET("Remark = #{record.remark,jdbcType=VARCHAR}");
        sql.SET("OfferTime = #{record.offerTime,jdbcType=TIMESTAMP}");
        sql.SET("DataSource = #{record.dataSource,jdbcType=VARCHAR}");
        sql.SET("CompanyID = #{record.companyId,jdbcType=INTEGER}");
        sql.SET("CreateDateTime = #{record.createDateTime,jdbcType=TIMESTAMP}");
        sql.SET("LastUpdateTime = #{record.lastUpdateTime,jdbcType=TIMESTAMP}");
        
        OfferCaseCond example = (OfferCaseCond) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(OfferCase record) {
        SQL sql = new SQL();
        sql.UPDATE("offercase");
        
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
        
        if (record.getAddress() != null) {
            sql.SET("Address = #{address,jdbcType=VARCHAR}");
        }
        
        if (record.getRoomLayout() != null) {
            sql.SET("RoomLayout = #{roomLayout,jdbcType=VARCHAR}");
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
        
        if (record.getPrice() != null) {
            sql.SET("Price = #{price,jdbcType=DECIMAL}");
        }
        
        if (record.getTotalPrice() != null) {
            sql.SET("TotalPrice = #{totalPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getRemark() != null) {
            sql.SET("Remark = #{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getOfferTime() != null) {
            sql.SET("OfferTime = #{offerTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDataSource() != null) {
            sql.SET("DataSource = #{dataSource,jdbcType=VARCHAR}");
        }
        
        if (record.getCompanyId() != null) {
            sql.SET("CompanyID = #{companyId,jdbcType=INTEGER}");
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

    protected void applyWhere(SQL sql, OfferCaseCond example, boolean includeExamplePhrase) {
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