package com.yunfang.dms.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/3/1.
 */
public class BuildingBaseDataHisDto {
    private Long id;

    private Long buildingid;

    private String cityName;

    private String district;

    private String region;

    private String community;

    private String buildingName;

    private String buildingAlias;

    private String address;

    private String buildYear;

    private Integer totalFloor;

    private Integer totalHouse;

    private String remark;

    private String createDateTime;

    private String operator;

    private String extendCol;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBuildingid() {
        return buildingid;
    }

    public void setBuildingid(Long buildingid) {
        this.buildingid = buildingid;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district == null ? null : district.trim();
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region == null ? null : region.trim();
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community == null ? null : community.trim();
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName == null ? null : buildingName.trim();
    }

    public String getBuildingAlias() {
        return buildingAlias;
    }

    public void setBuildingAlias(String buildingAlias) {
        this.buildingAlias = buildingAlias == null ? null : buildingAlias.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getBuildYear() {
        return buildYear;
    }

    public void setBuildYear(String buildYear) {
        this.buildYear = buildYear == null ? null : buildYear.trim();
    }

    public Integer getTotalFloor() {
        return totalFloor;
    }

    public void setTotalFloor(Integer totalFloor) {
        this.totalFloor = totalFloor;
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
        this.remark = remark == null ? null : remark.trim();
    }

    public String getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {

        SimpleDateFormat dataFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.createDateTime = dataFormat.format(createDateTime);
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public String getExtendCol() {
        return extendCol;
    }

    public void setExtendCol(String extendCol) {
        this.extendCol = extendCol == null ? null : extendCol.trim();
    }
}
