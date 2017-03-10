package com.yunfang.dms.dto;

import java.awt.peer.PanelPeer;

/**城市信息DTO
 * Created by Administrator on 2017/3/7.
 */
public class CityInfoDto {
    /**
     * 城市名称
     */
    private String cityName;

    /**
     * 是否使用城市（如果否，拦截器将会使用COOKIES城市名称作为数据源）
     */
    private Boolean isUseCity;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Boolean getUseCity() {
        return isUseCity;
    }

    public void setUseCity(Boolean useCity) {
        isUseCity = useCity;
    }
}
