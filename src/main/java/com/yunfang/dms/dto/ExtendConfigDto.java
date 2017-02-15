package com.yunfang.dms.dto;

import java.util.Date;
import com.yunfang.dms.enums.SourceTableEmum;
/**
 * Created by Administrator on 2017/2/13.
 */
public class ExtendConfigDto {
    private Long id;

    private Integer companyId;

    private SourceTableEmum sourceTable;

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

    public SourceTableEmum getSourceTable() {
        return sourceTable;
    }

    public void setSourceTable(SourceTableEmum sourceTable) {
        this.sourceTable = sourceTable;
    }

    public void setSourceTable(Integer sourceTable) {
        switch (sourceTable) {
            case 0:
                this.sourceTable=SourceTableEmum.InquiryData;
                break;
            case 1:
                this.sourceTable= SourceTableEmum.OfferCase;
                break;
            case 2:
                this.sourceTable= SourceTableEmum.TransactionCase;
                break;
            case 3:
                this.sourceTable= SourceTableEmum.ReportCase;
                break;
            default:
                this.sourceTable= SourceTableEmum.InquiryData;
        }
    }

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
