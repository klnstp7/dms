package com.yunfang.dms.dao.mapper;

import com.yunfang.dms.entity.ReportDocument;
import com.yunfang.dms.entity.ReportDocumentCond.Criteria;
import com.yunfang.dms.entity.ReportDocumentCond.Criterion;
import com.yunfang.dms.entity.ReportDocumentCond;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class ReportDocumentSqlProvider {

    public String countByExample(ReportDocumentCond example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("reportdocument");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(ReportDocumentCond example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("reportdocument");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(ReportDocument record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("reportdocument");
        
        if (record.getName() != null) {
            sql.VALUES("Name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getReportCaseId() != null) {
            sql.VALUES("ReportCaseID", "#{reportCaseId,jdbcType=BIGINT}");
        }
        
        if (record.getResourceId() != null) {
            sql.VALUES("ResourceID", "#{resourceId,jdbcType=BIGINT}");
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
        
        return sql.toString();
    }

    public String selectByExample(ReportDocumentCond example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("ID");
        } else {
            sql.SELECT("ID");
        }
        sql.SELECT("Name");
        sql.SELECT("ReportCaseID");
        sql.SELECT("ResourceID");
        sql.SELECT("Remark");
        sql.SELECT("CreateDateTime");
        sql.SELECT("Operator");
        sql.FROM("reportdocument");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        ReportDocument record = (ReportDocument) parameter.get("record");
        ReportDocumentCond example = (ReportDocumentCond) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("reportdocument");
        
        if (record.getId() != null) {
            sql.SET("ID = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getName() != null) {
            sql.SET("Name = #{record.name,jdbcType=VARCHAR}");
        }
        
        if (record.getReportCaseId() != null) {
            sql.SET("ReportCaseID = #{record.reportCaseId,jdbcType=BIGINT}");
        }
        
        if (record.getResourceId() != null) {
            sql.SET("ResourceID = #{record.resourceId,jdbcType=BIGINT}");
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
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("reportdocument");
        
        sql.SET("ID = #{record.id,jdbcType=BIGINT}");
        sql.SET("Name = #{record.name,jdbcType=VARCHAR}");
        sql.SET("ReportCaseID = #{record.reportCaseId,jdbcType=BIGINT}");
        sql.SET("ResourceID = #{record.resourceId,jdbcType=BIGINT}");
        sql.SET("Remark = #{record.remark,jdbcType=VARCHAR}");
        sql.SET("CreateDateTime = #{record.createDateTime,jdbcType=TIMESTAMP}");
        sql.SET("Operator = #{record.operator,jdbcType=VARCHAR}");
        
        ReportDocumentCond example = (ReportDocumentCond) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(ReportDocument record) {
        SQL sql = new SQL();
        sql.UPDATE("reportdocument");
        
        if (record.getName() != null) {
            sql.SET("Name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getReportCaseId() != null) {
            sql.SET("ReportCaseID = #{reportCaseId,jdbcType=BIGINT}");
        }
        
        if (record.getResourceId() != null) {
            sql.SET("ResourceID = #{resourceId,jdbcType=BIGINT}");
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
        
        sql.WHERE("ID = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, ReportDocumentCond example, boolean includeExamplePhrase) {
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