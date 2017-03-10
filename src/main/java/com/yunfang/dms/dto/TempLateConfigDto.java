package com.yunfang.dms.dto;

/**
 * Created by Administrator on 2017/2/20.
 * 模版与实体中的字段对应配置列
 */
public class TempLateConfigDto {
    private String templateCol;
    private String entityCol;
    private String dataType;
    private boolean isNull;

    public String getTemplateCol() {
        return templateCol;
    }

    public void setTemplateCol(String templateCol) {
        this.templateCol = templateCol;
    }

    public String getEntityCol() {
        return entityCol;
    }

    public void setEntityCol(String entityCol) {
        this.entityCol = entityCol;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public boolean getIsNull() {
        return isNull;
    }

    public void setIsNull(boolean aNull) {
        isNull = aNull;
    }

}
