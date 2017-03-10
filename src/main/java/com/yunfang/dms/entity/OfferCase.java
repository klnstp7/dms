package com.yunfang.dms.entity;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OfferCase {
    private Long id;

    private String cityName;

    private String district;

    private String region;

    private String community;

    private String address;

    private String roomLayout;

    private Integer floor;

    private Integer totalFloor;

    private String toward;

    private String buildYear;

    private BigDecimal area;

    private BigDecimal price;

    private BigDecimal totalPrice;

    private String remark;

    private Date offerTime;

    private String dataSource;

    private Integer companyId;

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

    public String getRoomLayout() {
        return roomLayout;
    }

    public void setRoomLayout(String roomLayout) {
        this.roomLayout = roomLayout == null ? null : roomLayout.trim();
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getOfferTime() {
        return offerTime;
    }

    public void setOfferTime(String offerTime) throws ParseException {
        if(offerTime!=null && !offerTime.trim().equals("")) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            this.offerTime = sdf.parse(offerTime);
        }
        else
        {
            this.offerTime=new Date();
        }
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource == null ? null : dataSource.trim();
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
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