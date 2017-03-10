package com.yunfang.dms.dto;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Administrator on 2017/2/8.
 */
public class BuildingBaseDataDto {
    /**
     * 自增ID
     */
    private Long id;

    /**
     *城市名称
     */
    private String cityName;

    /**
     *行政区
     */
    private String district;

    /**
     *区片
     */
    private String region;

    /**
     *小区名称
     */
    private String community;

    /**
     *楼幢名称
     */
    private String buildingName;

    /**
     *楼幢别名
     */
    private String buildingAlias;

    /**
     *楼幢地址
     */
    private String address;

    /**
     *建成年代
     */
    private String buildYear;

    /**
     *总楼层
     */
    private Integer totalFloor;

    /**
     *总户数
     */
    private Integer totalHouse;

    /**
     *备注
     */
    private String remark;

    /**
     *创建时间
     */
    private String createDateTime;

    /**
     *最后更新时间
     */
    private String lastUpdateTime;



    /**
     *扩展字段
     */

    private String extendCol;

    /**
     *公司ID
     */
    private Integer companyId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getBuildingAlias() {
        return buildingAlias;
    }

    public void setBuildingAlias(String buildingAlias) {
        this.buildingAlias = buildingAlias;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBuildYear() {
        return buildYear;
    }

    public void setBuildYear(String buildYear) {
        this.buildYear = buildYear;
    }

    public Integer getTotalFloor() {
        return totalFloor;
    }

    public void setTotalFloor(Integer totalFloor) {
        this.totalFloor = totalFloor;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getTotalHouse() {
        return totalHouse;
    }

    public void setTotalHouse(Integer totalHouse) {
        this.totalHouse = totalHouse;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        SimpleDateFormat dataFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.createDateTime = dataFormat.format(createDateTime);
    }

    public void setCreateDateTime(String createDateTime) {
        this.createDateTime = createDateTime;
    }

    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime){
        SimpleDateFormat dataFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.lastUpdateTime = dataFormat.format(lastUpdateTime);
    }

    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getExtendCol() {
        return extendCol;
    }

    public void setExtendCol(String extendCol) {
        this.extendCol = extendCol;
    }
}
