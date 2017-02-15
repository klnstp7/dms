package com.yunfang.dms.dao.mapper;

import com.yunfang.dms.entity.PriceDataHis;
import com.yunfang.dms.entity.PriceDataHisCond.Criteria;
import com.yunfang.dms.entity.PriceDataHisCond.Criterion;
import com.yunfang.dms.entity.PriceDataHisCond;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class PriceDataHisSqlProvider {

    public String countByExample(PriceDataHisCond example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("pricedata_his");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(PriceDataHisCond example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("pricedata_his");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(PriceDataHis record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("pricedata_his");
        
        if (record.getPriceDataId() != null) {
            sql.VALUES("PriceDataID", "#{priceDataId,jdbcType=BIGINT}");
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
        
        if (record.getPositionName() != null) {
            sql.VALUES("PositionName", "#{positionName,jdbcType=VARCHAR}");
        }
        
        if (record.getPositionAddress() != null) {
            sql.VALUES("PositionAddress", "#{positionAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getBuildYear() != null) {
            sql.VALUES("BuildYear", "#{buildYear,jdbcType=VARCHAR}");
        }
        
        if (record.getPriceTime() != null) {
            sql.VALUES("PriceTime", "#{priceTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPriceType() != null) {
            sql.VALUES("PriceType", "#{priceType,jdbcType=VARCHAR}");
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

    public String selectByExampleWithBLOBs(PriceDataHisCond example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("ID");
        } else {
            sql.SELECT("ID");
        }
        sql.SELECT("PriceDataID");
        sql.SELECT("CityName");
        sql.SELECT("District");
        sql.SELECT("Region");
        sql.SELECT("PositionName");
        sql.SELECT("PositionAddress");
        sql.SELECT("BuildYear");
        sql.SELECT("PriceTime");
        sql.SELECT("PriceType");
        sql.SELECT("Remark");
        sql.SELECT("CreateDateTime");
        sql.SELECT("Operator");
        sql.SELECT("ExtendCol");
        sql.FROM("pricedata_his");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String selectByExample(PriceDataHisCond example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("ID");
        } else {
            sql.SELECT("ID");
        }
        sql.SELECT("PriceDataID");
        sql.SELECT("CityName");
        sql.SELECT("District");
        sql.SELECT("Region");
        sql.SELECT("PositionName");
        sql.SELECT("PositionAddress");
        sql.SELECT("BuildYear");
        sql.SELECT("PriceTime");
        sql.SELECT("PriceType");
        sql.SELECT("Remark");
        sql.SELECT("CreateDateTime");
        sql.SELECT("Operator");
        sql.FROM("pricedata_his");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        PriceDataHis record = (PriceDataHis) parameter.get("record");
        PriceDataHisCond example = (PriceDataHisCond) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("pricedata_his");
        
        if (record.getId() != null) {
            sql.SET("ID = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getPriceDataId() != null) {
            sql.SET("PriceDataID = #{record.priceDataId,jdbcType=BIGINT}");
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
        
        if (record.getPositionName() != null) {
            sql.SET("PositionName = #{record.positionName,jdbcType=VARCHAR}");
        }
        
        if (record.getPositionAddress() != null) {
            sql.SET("PositionAddress = #{record.positionAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getBuildYear() != null) {
            sql.SET("BuildYear = #{record.buildYear,jdbcType=VARCHAR}");
        }
        
        if (record.getPriceTime() != null) {
            sql.SET("PriceTime = #{record.priceTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPriceType() != null) {
            sql.SET("PriceType = #{record.priceType,jdbcType=VARCHAR}");
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
        sql.UPDATE("pricedata_his");
        
        sql.SET("ID = #{record.id,jdbcType=BIGINT}");
        sql.SET("PriceDataID = #{record.priceDataId,jdbcType=BIGINT}");
        sql.SET("CityName = #{record.cityName,jdbcType=VARCHAR}");
        sql.SET("District = #{record.district,jdbcType=VARCHAR}");
        sql.SET("Region = #{record.region,jdbcType=VARCHAR}");
        sql.SET("PositionName = #{record.positionName,jdbcType=VARCHAR}");
        sql.SET("PositionAddress = #{record.positionAddress,jdbcType=VARCHAR}");
        sql.SET("BuildYear = #{record.buildYear,jdbcType=VARCHAR}");
        sql.SET("PriceTime = #{record.priceTime,jdbcType=TIMESTAMP}");
        sql.SET("PriceType = #{record.priceType,jdbcType=VARCHAR}");
        sql.SET("Remark = #{record.remark,jdbcType=VARCHAR}");
        sql.SET("CreateDateTime = #{record.createDateTime,jdbcType=TIMESTAMP}");
        sql.SET("Operator = #{record.operator,jdbcType=VARCHAR}");
        sql.SET("ExtendCol = #{record.extendCol,jdbcType=LONGVARCHAR}");
        
        PriceDataHisCond example = (PriceDataHisCond) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("pricedata_his");
        
        sql.SET("ID = #{record.id,jdbcType=BIGINT}");
        sql.SET("PriceDataID = #{record.priceDataId,jdbcType=BIGINT}");
        sql.SET("CityName = #{record.cityName,jdbcType=VARCHAR}");
        sql.SET("District = #{record.district,jdbcType=VARCHAR}");
        sql.SET("Region = #{record.region,jdbcType=VARCHAR}");
        sql.SET("PositionName = #{record.positionName,jdbcType=VARCHAR}");
        sql.SET("PositionAddress = #{record.positionAddress,jdbcType=VARCHAR}");
        sql.SET("BuildYear = #{record.buildYear,jdbcType=VARCHAR}");
        sql.SET("PriceTime = #{record.priceTime,jdbcType=TIMESTAMP}");
        sql.SET("PriceType = #{record.priceType,jdbcType=VARCHAR}");
        sql.SET("Remark = #{record.remark,jdbcType=VARCHAR}");
        sql.SET("CreateDateTime = #{record.createDateTime,jdbcType=TIMESTAMP}");
        sql.SET("Operator = #{record.operator,jdbcType=VARCHAR}");
        
        PriceDataHisCond example = (PriceDataHisCond) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(PriceDataHis record) {
        SQL sql = new SQL();
        sql.UPDATE("pricedata_his");
        
        if (record.getPriceDataId() != null) {
            sql.SET("PriceDataID = #{priceDataId,jdbcType=BIGINT}");
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
        
        if (record.getPositionName() != null) {
            sql.SET("PositionName = #{positionName,jdbcType=VARCHAR}");
        }
        
        if (record.getPositionAddress() != null) {
            sql.SET("PositionAddress = #{positionAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getBuildYear() != null) {
            sql.SET("BuildYear = #{buildYear,jdbcType=VARCHAR}");
        }
        
        if (record.getPriceTime() != null) {
            sql.SET("PriceTime = #{priceTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPriceType() != null) {
            sql.SET("PriceType = #{priceType,jdbcType=VARCHAR}");
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

    protected void applyWhere(SQL sql, PriceDataHisCond example, boolean includeExamplePhrase) {
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