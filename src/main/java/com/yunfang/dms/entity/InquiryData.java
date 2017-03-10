package com.yunfang.dms.entity;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InquiryData {
    private Long id;

    private String cityName;

    private String district;

    private String region;

    private String community;

    private String address;

    private String buildingName;

    private String houseName;

    private Integer floor;

    private Integer totalFloor;

    private String toward;

    private String buildYear;

    private BigDecimal area;

    private BigDecimal inquiryPrice;

    private BigDecimal shichangPrice;

    private String customerOrg;

    private Date priceTime;

    private String propertyType;

    private Integer companyId;

    private Date inquiryTime;

    private String inquirySource;

    private String remark;

    private Date createDateTime;

    private Date lastUpdateTime;

    private String extendCol;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName == null ? null : buildingName.trim();
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName == null ? null : houseName.trim();
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getTotalFloor() {
        return totalFloor;
    }

    public void setTotalFloor(Integer totalFloor) {
        this.totalFloor = totalFloor;
    }

    public String getToward() {
        return toward;
    }

    public void setToward(String toward) {
        this.toward = toward == null ? null : toward.trim();
    }

    public String getBuildYear() {
        return buildYear;
    }

    public void setBuildYear(String buildYear) {
        this.buildYear = buildYear == null ? null : buildYear.trim();
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public BigDecimal getInquiryPrice() {
        return inquiryPrice;
    }

    public void setInquiryPrice(BigDecimal inquiryPrice) {
        this.inquiryPrice = inquiryPrice;
    }

    public BigDecimal getShichangPrice() {
        return shichangPrice;
    }

    public void setShichangPrice(BigDecimal shichangPrice) {
        this.shichangPrice = shichangPrice;
    }

    public String getCustomerOrg() {
        return customerOrg;
    }

    public void setCustomerOrg(String customerOrg) {
        this.customerOrg = customerOrg == null ? null : customerOrg.trim();
    }

    public Date getPriceTime() {
        return priceTime;
    }

    public void setPriceTime(String priceTime) throws ParseException {
        if(priceTime!=null || !priceTime.trim().equals("")) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            this.priceTime = sdf.parse(priceTime);
        }
        else
        {
            this.priceTime=new Date();
        }
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType == null ? null : propertyType.trim();
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Date getInquiryTime() {
        return inquiryTime;
    }

    public void setInquiryTime(String inquiryTime) throws ParseException {
        if(inquiryTime!=null || !inquiryTime.trim().equals("")) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            this.inquiryTime = sdf.parse(inquiryTime);
        }
        else
        {
            this.inquiryTime =new Date();
        }
    }

    public String getInquirySource() {
        return inquirySource;
    }

    public void setInquirySource(String inquirySource) {
        this.inquirySource = inquirySource == null ? null : inquirySource.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(String createDateTime) throws ParseException {
        if(createDateTime!=null && !createDateTime.trim().equals("")) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            this.createDateTime = sdf.parse(createDateTime);
        }
        else
        {
            this.createDateTime=new Date();
        }
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(String lastUpdateTime) throws ParseException {
        if(lastUpdateTime!=null || !lastUpdateTime.equals("")) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            this.lastUpdateTime = sdf.parse(lastUpdateTime);
        }
        else {
            this.lastUpdateTime=new Date();
        }
    }

    public String getExtendCol() {
        return extendCol;
    }

    public void setExtendCol(String extendCol) {
        this.extendCol = extendCol == null ? null : extendCol.trim();
    }
}