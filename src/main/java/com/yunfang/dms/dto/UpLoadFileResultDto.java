package com.yunfang.dms.dto;

/**
 * Created by Administrator on 2017/2/20.
 */
public class UpLoadFileResultDto {
    private int successCount;
    private int totalCount;
    private int errorCount;

    public int getUpdateCount() {
        return updateCount;
    }

    public void setUpdateCount(int updateCount) {
        this.updateCount = updateCount;
    }

    private int updateCount;
    private PageVo<Object> data;

    public int getSuccessCount() {
        return successCount;
    }

    public void setSuccessCount(int successCount) {
        this.successCount = successCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getErrorCount() {
        return errorCount;
    }

    public void setErrorCount(int errorCount) {
        this.errorCount = errorCount;
    }

    public PageVo<Object> getData() {
        return data;
    }

    public void setData(PageVo<Object> data) {
        this.data = data;
    }
}
