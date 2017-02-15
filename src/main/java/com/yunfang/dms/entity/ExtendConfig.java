package com.yunfang.dms.entity;

import java.util.Date;
import com.yunfang.dms.enums.SourceTableEmum;

public class ExtendConfig {
    private Long id;

    private Integer companyId;

    private Integer sourceTable;

    private String columnName;

    private Date createDateTime;

    private String operator;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getSourceTable() {
        return sourceTable;
    }

    public void setSourceTable(Integer sourceTable) {
        this.sourceTable = sourceTable;
    }

//    public void setSourceTable(SourceTableEmum sourceTable) {
//        this.sourceTable = sourceTable.ordinal();
//    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName == null ? null : columnName.trim();
    }

    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }
}