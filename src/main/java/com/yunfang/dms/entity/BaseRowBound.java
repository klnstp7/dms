package com.yunfang.dms.entity;

/**
 * Created by Administrator on 2017/2/13.
 */
public class BaseRowBound {

    protected long limit;

    protected long start;

    public long getLimit() {
        return limit;
    }

    public void setLimit(long limit) {
        this.limit = limit;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }


}
