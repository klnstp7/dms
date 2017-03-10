package com.yunfang.dms.dto;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/3/1.
 */
public class CommunityBaseDataHisDto {
    private Long id;

    private Long communityid;

    private String cityName;

    private String district;

    private String region;

    private String community;

    private String alias;

    private String address;

    private String buildYear;

    private String developers;

    private BigDecimal area;

    private Integer totalBuilding;

    private Integer totalHouse;

    private BigDecimal greenPercent;

    private String baseInstallation;

    private String mating;

    private String trafficInfo;

    private String feaTuRemark;

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

    public Long getCommunityid() {
        return communityid;
    }

    public void setCommunityid(Long communityid) {
        this.communityid = communityid;
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

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias == null ? null : alias.trim();
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

    public String getDevelopers() {
        return developers;
    }

    public void setDevelopers(String developers) {
        this.developers = developers == null ? null : developers.trim();
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public Integer getTotalBuilding() {
        return totalBuilding;
    }

    public void setTotalBuilding(Integer totalBuilding) {
        this.totalBuilding = totalBuilding;
    }

    public Integer getTotalHouse() {
        return totalHouse;
    }

    public void setTotalHouse(Integer totalHouse) {
        this.totalHouse = totalHouse;
    }

    public BigDecimal getGreenPercent() {
        return greenPercent;
    }

    public void setGreenPercent(BigDecimal greenPercent) {
        this.greenPercent = greenPercent;
    }

    public String getBaseInstallation() {
        return baseInstallation;
    }

    public void setBaseInstallation(String baseInstallation) {
        this.baseInstallation = baseInstallation == null ? null : baseInstallation.trim();
    }

    public String getMating() {
        return mating;
    }

    public void setMating(String mating) {
        this.mating = mating == null ? null : mating.trim();
    }

    public String getTrafficInfo() {
        return trafficInfo;
    }

    public void setTrafficInfo(String trafficInfo) {
        this.trafficInfo = trafficInfo == null ? null : trafficInfo.trim();
    }

    public String getFeaTuRemark() {
        return feaTuRemark;
    }

    public void setFeaTuRemark(String feaTuRemark) {
        this.feaTuRemark = feaTuRemark == null ? null : feaTuRemark.trim();
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
