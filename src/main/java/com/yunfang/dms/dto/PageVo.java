package com.yunfang.dms.dto;

/**
 * Created by Administrator on 2017/2/10.
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 分页器
 *
 * @author Herbert
 *
 * @param <T>
 */

public class PageVo<T> {


    public long getDraw() {
        return draw;
    }

    public void setDraw(long draw) {
        if(draw<1)
            draw=1;
        this.draw = draw;
    }

    private long draw;
    public long getRecordsFiltered() {
        return recordsFiltered;
    }

   /* public void setiTotalDisplayRecords(long iTotalDisplayRecords) {
        this.iTotalDisplayRecords = iTotalDisplayRecords;
    }
*/
    /**
     * 页码总数
     */
    private long recordsFiltered;

    public long getRecordsTotal() {
        return recordsTotal;
    }

   /* public void setiTotalRecords(long iTotalRecords) {
        this.iTotalRecords = iTotalRecords;
    }*/

    /**
     * 总数
     */
    private long recordsTotal;

    /**
     * 数据
     */
    private List<T> aaData;



    public PageVo(long total) {
        this.draw = 1;
        this.recordsFiltered=total;
        this.recordsTotal= total;
    }


    public List<T> getAaData() {
        return aaData;
    }

    public void setAaData(List<T> aaData) {
        this.aaData = aaData;
    }


}