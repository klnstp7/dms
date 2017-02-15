package com.yunfang.dms.dao.mapper;

import com.yunfang.dms.entity.ExtendConfig;
import com.yunfang.dms.entity.ExtendConfigCond.Criteria;
import com.yunfang.dms.entity.ExtendConfigCond.Criterion;
import com.yunfang.dms.entity.ExtendConfigCond;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class ExtendConfigSqlProvider {

    public String countByExample(ExtendConfigCond example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("extendconfig");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(ExtendConfigCond example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("extendconfig");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(ExtendConfig record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("extendconfig");
        
        if (record.getCompanyId() != null) {
            sql.VALUES("CompanyID", "#{companyId,jdbcType=INTEGER}");
        }
        
        if (record.getSourceTable() != null) {
            sql.VALUES("SourceTable", "#{sourceTable,jdbcType=INTEGER}");
        }
        
        if (record.getColumnName() != null) {
            sql.VALUES("ColumnName", "#{columnName,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateDateTime() != null) {
            sql.VALUES("CreateDateTime", "#{createDateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getOperator() != null) {
            sql.VALUES("Operator", "#{operator,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExample(ExtendConfigCond example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("ID");
        } else {
            sql.SELECT("ID");
        }
        sql.SELECT("CompanyID");
        sql.SELECT("SourceTable");
        sql.SELECT("ColumnName");
        sql.SELECT("CreateDateTime");
        sql.SELECT("Operator");
        sql.FROM("extendconfig");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        ExtendConfig record = (ExtendConfig) parameter.get("record");
        ExtendConfigCond example = (ExtendConfigCond) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("extendconfig");
        
        if (record.getId() != null) {
            sql.SET("ID = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getCompanyId() != null) {
            sql.SET("CompanyID = #{record.companyId,jdbcType=INTEGER}");
        }
        
        if (record.getSourceTable() != null) {
            sql.SET("SourceTable = #{record.sourceTable,jdbcType=INTEGER}");
        }
        
        if (record.getColumnName() != null) {
            sql.SET("ColumnName = #{record.columnName,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateDateTime() != null) {
            sql.SET("CreateDateTime = #{record.createDateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getOperator() != null) {
            sql.SET("Operator = #{record.operator,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("extendconfig");
        
        sql.SET("ID = #{record.id,jdbcType=BIGINT}");
        sql.SET("CompanyID = #{record.companyId,jdbcType=INTEGER}");
        sql.SET("SourceTable = #{record.sourceTable,jdbcType=INTEGER}");
        sql.SET("ColumnName = #{record.columnName,jdbcType=VARCHAR}");
        sql.SET("CreateDateTime = #{record.createDateTime,jdbcType=TIMESTAMP}");
        sql.SET("Operator = #{record.operator,jdbcType=VARCHAR}");
        
        ExtendConfigCond example = (ExtendConfigCond) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(ExtendConfig record) {
        SQL sql = new SQL();
        sql.UPDATE("extendconfig");
        
        if (record.getCompanyId() != null) {
            sql.SET("CompanyID = #{companyId,jdbcType=INTEGER}");
        }
        
        if (record.getSourceTable() != null) {
            sql.SET("SourceTable = #{sourceTable,jdbcType=INTEGER}");
        }
        
        if (record.getColumnName() != null) {
            sql.SET("ColumnName = #{columnName,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateDateTime() != null) {
            sql.SET("CreateDateTime = #{createDateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getOperator() != null) {
            sql.SET("Operator = #{operator,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("ID = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, ExtendConfigCond example, boolean includeExamplePhrase) {
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