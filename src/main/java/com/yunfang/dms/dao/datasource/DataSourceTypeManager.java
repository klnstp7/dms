package com.yunfang.dms.dao.datasource;

import com.yunfang.dms.enums.DataSource;

/**
 * Created by Administrator on 2017/1/23.
 */
public class DataSourceTypeManager {
    private static final ThreadLocal<DataSource> dataSourceTypes = new ThreadLocal<DataSource>(){
        @Override
        protected DataSource initialValue(){
            return DataSource.BEIJING;
        }
    };

    public static DataSource get(){
        return dataSourceTypes.get();
    }

    public static void set(DataSource dataSourceType){
        dataSourceTypes.set(dataSourceType);
    }

    public static void reset(){
        dataSourceTypes.set(DataSource.BEIJING);
    }
}