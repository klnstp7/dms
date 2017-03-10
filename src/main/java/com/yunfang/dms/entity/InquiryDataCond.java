package com.yunfang.dms.entity;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InquiryDataCond extends BaseRowBound {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InquiryDataCond() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }



    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }


    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCityNameIsNull() {
            addCriterion("CityName is null");
            return (Criteria) this;
        }

        public Criteria andCityNameIsNotNull() {
            addCriterion("CityName is not null");
            return (Criteria) this;
        }

        public Criteria andCityNameEqualTo(String value) {
            addCriterion("CityName =", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameNotEqualTo(String value) {
            addCriterion("CityName <>", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameGreaterThan(String value) {
            addCriterion("CityName >", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameGreaterThanOrEqualTo(String value) {
            addCriterion("CityName >=", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameLessThan(String value) {
            addCriterion("CityName <", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameLessThanOrEqualTo(String value) {
            addCriterion("CityName <=", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameLike(String value) {
            addCriterion("CityName like", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameNotLike(String value) {
            addCriterion("CityName not like", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameIn(List<String> values) {
            addCriterion("CityName in", values, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameNotIn(List<String> values) {
            addCriterion("CityName not in", values, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameBetween(String value1, String value2) {
            addCriterion("CityName between", value1, value2, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameNotBetween(String value1, String value2) {
            addCriterion("CityName not between", value1, value2, "cityName");
            return (Criteria) this;
        }

        public Criteria andDistrictIsNull() {
            addCriterion("District is null");
            return (Criteria) this;
        }

        public Criteria andDistrictIsNotNull() {
            addCriterion("District is not null");
            return (Criteria) this;
        }

        public Criteria andDistrictEqualTo(String value) {
            addCriterion("District =", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictNotEqualTo(String value) {
            addCriterion("District <>", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictGreaterThan(String value) {
            addCriterion("District >", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictGreaterThanOrEqualTo(String value) {
            addCriterion("District >=", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictLessThan(String value) {
            addCriterion("District <", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictLessThanOrEqualTo(String value) {
            addCriterion("District <=", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictLike(String value) {
            addCriterion("District like", "%"+value+"%", "district");
            return (Criteria) this;
        }

        public Criteria andDistrictNotLike(String value) {
            addCriterion("District not like", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictIn(List<String> values) {
            addCriterion("District in", values, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictNotIn(List<String> values) {
            addCriterion("District not in", values, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictBetween(String value1, String value2) {
            addCriterion("District between", value1, value2, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictNotBetween(String value1, String value2) {
            addCriterion("District not between", value1, value2, "district");
            return (Criteria) this;
        }

        public Criteria andRegionIsNull() {
            addCriterion("Region is null");
            return (Criteria) this;
        }

        public Criteria andRegionIsNotNull() {
            addCriterion("Region is not null");
            return (Criteria) this;
        }

        public Criteria andRegionEqualTo(String value) {
            addCriterion("Region =", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotEqualTo(String value) {
            addCriterion("Region <>", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionGreaterThan(String value) {
            addCriterion("Region >", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionGreaterThanOrEqualTo(String value) {
            addCriterion("Region >=", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionLessThan(String value) {
            addCriterion("Region <", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionLessThanOrEqualTo(String value) {
            addCriterion("Region <=", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionLike(String value) {
            addCriterion("Region like", "%"+value+"%", "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotLike(String value) {
            addCriterion("Region not like", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionIn(List<String> values) {
            addCriterion("Region in", values, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotIn(List<String> values) {
            addCriterion("Region not in", values, "region");
            return (Criteria) this;
        }

        public Criteria andRegionBetween(String value1, String value2) {
            addCriterion("Region between", value1, value2, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotBetween(String value1, String value2) {
            addCriterion("Region not between", value1, value2, "region");
            return (Criteria) this;
        }

        public Criteria andCommunityIsNull() {
            addCriterion("Community is null");
            return (Criteria) this;
        }

        public Criteria andCommunityIsNotNull() {
            addCriterion("Community is not null");
            return (Criteria) this;
        }

        public Criteria andCommunityEqualTo(String value) {
            addCriterion("Community =", value, "community");
            return (Criteria) this;
        }

        public Criteria andCommunityNotEqualTo(String value) {
            addCriterion("Community <>", value, "community");
            return (Criteria) this;
        }

        public Criteria andCommunityGreaterThan(String value) {
            addCriterion("Community >", value, "community");
            return (Criteria) this;
        }

        public Criteria andCommunityGreaterThanOrEqualTo(String value) {
            addCriterion("Community >=", value, "community");
            return (Criteria) this;
        }

        public Criteria andCommunityLessThan(String value) {
            addCriterion("Community <", value, "community");
            return (Criteria) this;
        }

        public Criteria andCommunityLessThanOrEqualTo(String value) {
            addCriterion("Community <=", value, "community");
            return (Criteria) this;
        }

        public Criteria andCommunityLike(String value) {
            addCriterion("Community like", "%"+value+"%", "community");
            return (Criteria) this;
        }

        public Criteria andCommunityNotLike(String value) {
            addCriterion("Community not like", value, "community");
            return (Criteria) this;
        }

        public Criteria andCommunityIn(List<String> values) {
            addCriterion("Community in", values, "community");
            return (Criteria) this;
        }

        public Criteria andCommunityNotIn(List<String> values) {
            addCriterion("Community not in", values, "community");
            return (Criteria) this;
        }

        public Criteria andCommunityBetween(String value1, String value2) {
            addCriterion("Community between", value1, value2, "community");
            return (Criteria) this;
        }

        public Criteria andCommunityNotBetween(String value1, String value2) {
            addCriterion("Community not between", value1, value2, "community");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("Address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("Address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("Address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("Address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("Address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("Address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("Address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("Address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("Address like", "%"+value+"%", "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("Address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("Address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("Address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("Address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("Address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andBuildingNameIsNull() {
            addCriterion("BuildingName is null");
            return (Criteria) this;
        }

        public Criteria andBuildingNameIsNotNull() {
            addCriterion("BuildingName is not null");
            return (Criteria) this;
        }

        public Criteria andBuildingNameEqualTo(String value) {
            addCriterion("BuildingName =", value, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameNotEqualTo(String value) {
            addCriterion("BuildingName <>", value, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameGreaterThan(String value) {
            addCriterion("BuildingName >", value, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameGreaterThanOrEqualTo(String value) {
            addCriterion("BuildingName >=", value, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameLessThan(String value) {
            addCriterion("BuildingName <", value, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameLessThanOrEqualTo(String value) {
            addCriterion("BuildingName <=", value, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameLike(String value) {
            addCriterion("BuildingName like", value, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameNotLike(String value) {
            addCriterion("BuildingName not like", value, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameIn(List<String> values) {
            addCriterion("BuildingName in", values, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameNotIn(List<String> values) {
            addCriterion("BuildingName not in", values, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameBetween(String value1, String value2) {
            addCriterion("BuildingName between", value1, value2, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameNotBetween(String value1, String value2) {
            addCriterion("BuildingName not between", value1, value2, "buildingName");
            return (Criteria) this;
        }

        public Criteria andHouseNameIsNull() {
            addCriterion("HouseName is null");
            return (Criteria) this;
        }

        public Criteria andHouseNameIsNotNull() {
            addCriterion("HouseName is not null");
            return (Criteria) this;
        }

        public Criteria andHouseNameEqualTo(String value) {
            addCriterion("HouseName =", value, "houseName");
            return (Criteria) this;
        }

        public Criteria andHouseNameNotEqualTo(String value) {
            addCriterion("HouseName <>", value, "houseName");
            return (Criteria) this;
        }

        public Criteria andHouseNameGreaterThan(String value) {
            addCriterion("HouseName >", value, "houseName");
            return (Criteria) this;
        }

        public Criteria andHouseNameGreaterThanOrEqualTo(String value) {
            addCriterion("HouseName >=", value, "houseName");
            return (Criteria) this;
        }

        public Criteria andHouseNameLessThan(String value) {
            addCriterion("HouseName <", value, "houseName");
            return (Criteria) this;
        }

        public Criteria andHouseNameLessThanOrEqualTo(String value) {
            addCriterion("HouseName <=", value, "houseName");
            return (Criteria) this;
        }

        public Criteria andHouseNameLike(String value) {
            addCriterion("HouseName like", value, "houseName");
            return (Criteria) this;
        }

        public Criteria andHouseNameNotLike(String value) {
            addCriterion("HouseName not like", value, "houseName");
            return (Criteria) this;
        }

        public Criteria andHouseNameIn(List<String> values) {
            addCriterion("HouseName in", values, "houseName");
            return (Criteria) this;
        }

        public Criteria andHouseNameNotIn(List<String> values) {
            addCriterion("HouseName not in", values, "houseName");
            return (Criteria) this;
        }

        public Criteria andHouseNameBetween(String value1, String value2) {
            addCriterion("HouseName between", value1, value2, "houseName");
            return (Criteria) this;
        }

        public Criteria andHouseNameNotBetween(String value1, String value2) {
            addCriterion("HouseName not between", value1, value2, "houseName");
            return (Criteria) this;
        }

        public Criteria andFloorIsNull() {
            addCriterion("Floor is null");
            return (Criteria) this;
        }

        public Criteria andFloorIsNotNull() {
            addCriterion("Floor is not null");
            return (Criteria) this;
        }

        public Criteria andFloorEqualTo(Integer value) {
            addCriterion("Floor =", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorNotEqualTo(Integer value) {
            addCriterion("Floor <>", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorGreaterThan(Integer value) {
            addCriterion("Floor >", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorGreaterThanOrEqualTo(Integer value) {
            addCriterion("Floor >=", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorLessThan(Integer value) {
            addCriterion("Floor <", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorLessThanOrEqualTo(Integer value) {
            addCriterion("Floor <=", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorIn(List<Integer> values) {
            addCriterion("Floor in", values, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorNotIn(List<Integer> values) {
            addCriterion("Floor not in", values, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorBetween(Integer value1, Integer value2) {
            addCriterion("Floor between", value1, value2, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorNotBetween(Integer value1, Integer value2) {
            addCriterion("Floor not between", value1, value2, "floor");
            return (Criteria) this;
        }

        public Criteria andTotalFloorIsNull() {
            addCriterion("TotalFloor is null");
            return (Criteria) this;
        }

        public Criteria andTotalFloorIsNotNull() {
            addCriterion("TotalFloor is not null");
            return (Criteria) this;
        }

        public Criteria andTotalFloorEqualTo(Integer value) {
            addCriterion("TotalFloor =", value, "totalFloor");
            return (Criteria) this;
        }

        public Criteria andTotalFloorNotEqualTo(Integer value) {
            addCriterion("TotalFloor <>", value, "totalFloor");
            return (Criteria) this;
        }

        public Criteria andTotalFloorGreaterThan(Integer value) {
            addCriterion("TotalFloor >", value, "totalFloor");
            return (Criteria) this;
        }

        public Criteria andTotalFloorGreaterThanOrEqualTo(Integer value) {
            addCriterion("TotalFloor >=", value, "totalFloor");
            return (Criteria) this;
        }

        public Criteria andTotalFloorLessThan(Integer value) {
            addCriterion("TotalFloor <", value, "totalFloor");
            return (Criteria) this;
        }

        public Criteria andTotalFloorLessThanOrEqualTo(Integer value) {
            addCriterion("TotalFloor <=", value, "totalFloor");
            return (Criteria) this;
        }

        public Criteria andTotalFloorIn(List<Integer> values) {
            addCriterion("TotalFloor in", values, "totalFloor");
            return (Criteria) this;
        }

        public Criteria andTotalFloorNotIn(List<Integer> values) {
            addCriterion("TotalFloor not in", values, "totalFloor");
            return (Criteria) this;
        }

        public Criteria andTotalFloorBetween(Integer value1, Integer value2) {
            addCriterion("TotalFloor between", value1, value2, "totalFloor");
            return (Criteria) this;
        }

        public Criteria andTotalFloorNotBetween(Integer value1, Integer value2) {
            addCriterion("TotalFloor not between", value1, value2, "totalFloor");
            return (Criteria) this;
        }

        public Criteria andTowardIsNull() {
            addCriterion("Toward is null");
            return (Criteria) this;
        }

        public Criteria andTowardIsNotNull() {
            addCriterion("Toward is not null");
            return (Criteria) this;
        }

        public Criteria andTowardEqualTo(String value) {
            addCriterion("Toward =", value, "toward");
            return (Criteria) this;
        }

        public Criteria andTowardNotEqualTo(String value) {
            addCriterion("Toward <>", value, "toward");
            return (Criteria) this;
        }

        public Criteria andTowardGreaterThan(String value) {
            addCriterion("Toward >", value, "toward");
            return (Criteria) this;
        }

        public Criteria andTowardGreaterThanOrEqualTo(String value) {
            addCriterion("Toward >=", value, "toward");
            return (Criteria) this;
        }

        public Criteria andTowardLessThan(String value) {
            addCriterion("Toward <", value, "toward");
            return (Criteria) this;
        }

        public Criteria andTowardLessThanOrEqualTo(String value) {
            addCriterion("Toward <=", value, "toward");
            return (Criteria) this;
        }

        public Criteria andTowardLike(String value) {
            addCriterion("Toward like", value, "toward");
            return (Criteria) this;
        }

        public Criteria andTowardNotLike(String value) {
            addCriterion("Toward not like", value, "toward");
            return (Criteria) this;
        }

        public Criteria andTowardIn(List<String> values) {
            addCriterion("Toward in", values, "toward");
            return (Criteria) this;
        }

        public Criteria andTowardNotIn(List<String> values) {
            addCriterion("Toward not in", values, "toward");
            return (Criteria) this;
        }

        public Criteria andTowardBetween(String value1, String value2) {
            addCriterion("Toward between", value1, value2, "toward");
            return (Criteria) this;
        }

        public Criteria andTowardNotBetween(String value1, String value2) {
            addCriterion("Toward not between", value1, value2, "toward");
            return (Criteria) this;
        }

        public Criteria andBuildYearIsNull() {
            addCriterion("BuildYear is null");
            return (Criteria) this;
        }

        public Criteria andBuildYearIsNotNull() {
            addCriterion("BuildYear is not null");
            return (Criteria) this;
        }

        public Criteria andBuildYearEqualTo(String value) {
            addCriterion("BuildYear =", value, "buildYear");
            return (Criteria) this;
        }

        public Criteria andBuildYearNotEqualTo(String value) {
            addCriterion("BuildYear <>", value, "buildYear");
            return (Criteria) this;
        }

        public Criteria andBuildYearGreaterThan(String value) {
            addCriterion("BuildYear >", value, "buildYear");
            return (Criteria) this;
        }

        public Criteria andBuildYearGreaterThanOrEqualTo(String value) {
            addCriterion("BuildYear >=", value, "buildYear");
            return (Criteria) this;
        }

        public Criteria andBuildYearLessThan(String value) {
            addCriterion("BuildYear <", value, "buildYear");
            return (Criteria) this;
        }

        public Criteria andBuildYearLessThanOrEqualTo(String value) {
            addCriterion("BuildYear <=", value, "buildYear");
            return (Criteria) this;
        }

        public Criteria andBuildYearLike(String value) {
            addCriterion("BuildYear like", value, "buildYear");
            return (Criteria) this;
        }

        public Criteria andBuildYearNotLike(String value) {
            addCriterion("BuildYear not like", value, "buildYear");
            return (Criteria) this;
        }

        public Criteria andBuildYearIn(List<String> values) {
            addCriterion("BuildYear in", values, "buildYear");
            return (Criteria) this;
        }

        public Criteria andBuildYearNotIn(List<String> values) {
            addCriterion("BuildYear not in", values, "buildYear");
            return (Criteria) this;
        }

        public Criteria andBuildYearBetween(String value1, String value2) {
            addCriterion("BuildYear between", value1, value2, "buildYear");
            return (Criteria) this;
        }

        public Criteria andBuildYearNotBetween(String value1, String value2) {
            addCriterion("BuildYear not between", value1, value2, "buildYear");
            return (Criteria) this;
        }

        public Criteria andAreaIsNull() {
            addCriterion("Area is null");
            return (Criteria) this;
        }

        public Criteria andAreaIsNotNull() {
            addCriterion("Area is not null");
            return (Criteria) this;
        }

        public Criteria andAreaEqualTo(BigDecimal value) {
            addCriterion("Area =", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotEqualTo(BigDecimal value) {
            addCriterion("Area <>", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThan(BigDecimal value) {
            addCriterion("Area >", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("Area >=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThan(BigDecimal value) {
            addCriterion("Area <", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThanOrEqualTo(BigDecimal value) {
            addCriterion("Area <=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaIn(List<BigDecimal> values) {
            addCriterion("Area in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotIn(List<BigDecimal> values) {
            addCriterion("Area not in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Area between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Area not between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andInquiryPriceIsNull() {
            addCriterion("InquiryPrice is null");
            return (Criteria) this;
        }

        public Criteria andInquiryPriceIsNotNull() {
            addCriterion("InquiryPrice is not null");
            return (Criteria) this;
        }

        public Criteria andInquiryPriceEqualTo(BigDecimal value) {
            addCriterion("InquiryPrice =", value, "inquiryPrice");
            return (Criteria) this;
        }

        public Criteria andInquiryPriceNotEqualTo(BigDecimal value) {
            addCriterion("InquiryPrice <>", value, "inquiryPrice");
            return (Criteria) this;
        }

        public Criteria andInquiryPriceGreaterThan(BigDecimal value) {
            addCriterion("InquiryPrice >", value, "inquiryPrice");
            return (Criteria) this;
        }

        public Criteria andInquiryPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("InquiryPrice >=", value, "inquiryPrice");
            return (Criteria) this;
        }

        public Criteria andInquiryPriceLessThan(BigDecimal value) {
            addCriterion("InquiryPrice <", value, "inquiryPrice");
            return (Criteria) this;
        }

        public Criteria andInquiryPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("InquiryPrice <=", value, "inquiryPrice");
            return (Criteria) this;
        }

        public Criteria andInquiryPriceIn(List<BigDecimal> values) {
            addCriterion("InquiryPrice in", values, "inquiryPrice");
            return (Criteria) this;
        }

        public Criteria andInquiryPriceNotIn(List<BigDecimal> values) {
            addCriterion("InquiryPrice not in", values, "inquiryPrice");
            return (Criteria) this;
        }

        public Criteria andInquiryPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("InquiryPrice between", value1, value2, "inquiryPrice");
            return (Criteria) this;
        }

        public Criteria andInquiryPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("InquiryPrice not between", value1, value2, "inquiryPrice");
            return (Criteria) this;
        }

        public Criteria andShichangPriceIsNull() {
            addCriterion("ShiChangPrice is null");
            return (Criteria) this;
        }

        public Criteria andShichangPriceIsNotNull() {
            addCriterion("ShiChangPrice is not null");
            return (Criteria) this;
        }

        public Criteria andShichangPriceEqualTo(BigDecimal value) {
            addCriterion("ShiChangPrice =", value, "shichangPrice");
            return (Criteria) this;
        }

        public Criteria andShichangPriceNotEqualTo(BigDecimal value) {
            addCriterion("ShiChangPrice <>", value, "shichangPrice");
            return (Criteria) this;
        }

        public Criteria andShichangPriceGreaterThan(BigDecimal value) {
            addCriterion("ShiChangPrice >", value, "shichangPrice");
            return (Criteria) this;
        }

        public Criteria andShichangPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ShiChangPrice >=", value, "shichangPrice");
            return (Criteria) this;
        }

        public Criteria andShichangPriceLessThan(BigDecimal value) {
            addCriterion("ShiChangPrice <", value, "shichangPrice");
            return (Criteria) this;
        }

        public Criteria andShichangPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ShiChangPrice <=", value, "shichangPrice");
            return (Criteria) this;
        }

        public Criteria andShichangPriceIn(List<BigDecimal> values) {
            addCriterion("ShiChangPrice in", values, "shichangPrice");
            return (Criteria) this;
        }

        public Criteria andShichangPriceNotIn(List<BigDecimal> values) {
            addCriterion("ShiChangPrice not in", values, "shichangPrice");
            return (Criteria) this;
        }

        public Criteria andShichangPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ShiChangPrice between", value1, value2, "shichangPrice");
            return (Criteria) this;
        }

        public Criteria andShichangPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ShiChangPrice not between", value1, value2, "shichangPrice");
            return (Criteria) this;
        }

        public Criteria andCustomerOrgIsNull() {
            addCriterion("CustomerOrg is null");
            return (Criteria) this;
        }

        public Criteria andCustomerOrgIsNotNull() {
            addCriterion("CustomerOrg is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerOrgEqualTo(String value) {
            addCriterion("CustomerOrg =", value, "customerOrg");
            return (Criteria) this;
        }

        public Criteria andCustomerOrgNotEqualTo(String value) {
            addCriterion("CustomerOrg <>", value, "customerOrg");
            return (Criteria) this;
        }

        public Criteria andCustomerOrgGreaterThan(String value) {
            addCriterion("CustomerOrg >", value, "customerOrg");
            return (Criteria) this;
        }

        public Criteria andCustomerOrgGreaterThanOrEqualTo(String value) {
            addCriterion("CustomerOrg >=", value, "customerOrg");
            return (Criteria) this;
        }

        public Criteria andCustomerOrgLessThan(String value) {
            addCriterion("CustomerOrg <", value, "customerOrg");
            return (Criteria) this;
        }

        public Criteria andCustomerOrgLessThanOrEqualTo(String value) {
            addCriterion("CustomerOrg <=", value, "customerOrg");
            return (Criteria) this;
        }

        public Criteria andCustomerOrgLike(String value) {
            addCriterion("CustomerOrg like", value, "customerOrg");
            return (Criteria) this;
        }

        public Criteria andCustomerOrgNotLike(String value) {
            addCriterion("CustomerOrg not like", value, "customerOrg");
            return (Criteria) this;
        }

        public Criteria andCustomerOrgIn(List<String> values) {
            addCriterion("CustomerOrg in", values, "customerOrg");
            return (Criteria) this;
        }

        public Criteria andCustomerOrgNotIn(List<String> values) {
            addCriterion("CustomerOrg not in", values, "customerOrg");
            return (Criteria) this;
        }

        public Criteria andCustomerOrgBetween(String value1, String value2) {
            addCriterion("CustomerOrg between", value1, value2, "customerOrg");
            return (Criteria) this;
        }

        public Criteria andCustomerOrgNotBetween(String value1, String value2) {
            addCriterion("CustomerOrg not between", value1, value2, "customerOrg");
            return (Criteria) this;
        }

        public Criteria andPriceTimeIsNull() {
            addCriterion("PriceTime is null");
            return (Criteria) this;
        }

        public Criteria andPriceTimeIsNotNull() {
            addCriterion("PriceTime is not null");
            return (Criteria) this;
        }

        public Criteria andPriceTimeEqualTo(Date value) {
            addCriterion("PriceTime =", value, "priceTime");
            return (Criteria) this;
        }

        public Criteria andPriceTimeNotEqualTo(Date value) {
            addCriterion("PriceTime <>", value, "priceTime");
            return (Criteria) this;
        }

        public Criteria andPriceTimeGreaterThan(Date value) {
            addCriterion("PriceTime >", value, "priceTime");
            return (Criteria) this;
        }

        public Criteria andPriceTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("PriceTime >=", value, "priceTime");
            return (Criteria) this;
        }

        public Criteria andPriceTimeLessThan(Date value) {
            addCriterion("PriceTime <", value, "priceTime");
            return (Criteria) this;
        }

        public Criteria andPriceTimeLessThanOrEqualTo(Date value) {
            addCriterion("PriceTime <=", value, "priceTime");
            return (Criteria) this;
        }

        public Criteria andPriceTimeIn(List<Date> values) {
            addCriterion("PriceTime in", values, "priceTime");
            return (Criteria) this;
        }

        public Criteria andPriceTimeNotIn(List<Date> values) {
            addCriterion("PriceTime not in", values, "priceTime");
            return (Criteria) this;
        }

        public Criteria andPriceTimeBetween(Date value1, Date value2) {
            addCriterion("PriceTime between", value1, value2, "priceTime");
            return (Criteria) this;
        }

        public Criteria andPriceTimeNotBetween(Date value1, Date value2) {
            addCriterion("PriceTime not between", value1, value2, "priceTime");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeIsNull() {
            addCriterion("PropertyType is null");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeIsNotNull() {
            addCriterion("PropertyType is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeEqualTo(String value) {
            addCriterion("PropertyType =", value, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeNotEqualTo(String value) {
            addCriterion("PropertyType <>", value, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeGreaterThan(String value) {
            addCriterion("PropertyType >", value, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeGreaterThanOrEqualTo(String value) {
            addCriterion("PropertyType >=", value, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeLessThan(String value) {
            addCriterion("PropertyType <", value, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeLessThanOrEqualTo(String value) {
            addCriterion("PropertyType <=", value, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeLike(String value) {
            addCriterion("PropertyType like", value, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeNotLike(String value) {
            addCriterion("PropertyType not like", value, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeIn(List<String> values) {
            addCriterion("PropertyType in", values, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeNotIn(List<String> values) {
            addCriterion("PropertyType not in", values, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeBetween(String value1, String value2) {
            addCriterion("PropertyType between", value1, value2, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeNotBetween(String value1, String value2) {
            addCriterion("PropertyType not between", value1, value2, "propertyType");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNull() {
            addCriterion("CompanyID is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNotNull() {
            addCriterion("CompanyID is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdEqualTo(Integer value) {
            addCriterion("CompanyID =", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotEqualTo(Integer value) {
            addCriterion("CompanyID <>", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThan(Integer value) {
            addCriterion("CompanyID >", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("CompanyID >=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThan(Integer value) {
            addCriterion("CompanyID <", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThanOrEqualTo(Integer value) {
            addCriterion("CompanyID <=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIn(List<Integer> values) {
            addCriterion("CompanyID in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotIn(List<Integer> values) {
            addCriterion("CompanyID not in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdBetween(Integer value1, Integer value2) {
            addCriterion("CompanyID between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("CompanyID not between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andInquiryTimeIsNull() {
            addCriterion("InquiryTime is null");
            return (Criteria) this;
        }

        public Criteria andInquiryTimeIsNotNull() {
            addCriterion("InquiryTime is not null");
            return (Criteria) this;
        }

        public Criteria andInquiryTimeEqualTo(Date value) {
            addCriterion("InquiryTime =", value, "inquiryTime");
            return (Criteria) this;
        }

        public Criteria andInquiryTimeNotEqualTo(Date value) {
            addCriterion("InquiryTime <>", value, "inquiryTime");
            return (Criteria) this;
        }

        public Criteria andInquiryTimeGreaterThan(Date value) {
            addCriterion("InquiryTime >", value, "inquiryTime");
            return (Criteria) this;
        }

        public Criteria andInquiryTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("InquiryTime >=", value, "inquiryTime");
            return (Criteria) this;
        }

        public Criteria andInquiryTimeLessThan(Date value) {
            addCriterion("InquiryTime <", value, "inquiryTime");
            return (Criteria) this;
        }

        public Criteria andInquiryTimeLessThanOrEqualTo(Date value) {
            addCriterion("InquiryTime <=", value, "inquiryTime");
            return (Criteria) this;
        }

        public Criteria andInquiryTimeIn(List<Date> values) {
            addCriterion("InquiryTime in", values, "inquiryTime");
            return (Criteria) this;
        }

        public Criteria andInquiryTimeNotIn(List<Date> values) {
            addCriterion("InquiryTime not in", values, "inquiryTime");
            return (Criteria) this;
        }

        public Criteria andInquiryTimeBetween(Date value1, Date value2) {
            addCriterion("InquiryTime between", value1, value2, "inquiryTime");
            return (Criteria) this;
        }

        public Criteria andInquiryTimeNotBetween(Date value1, Date value2) {
            addCriterion("InquiryTime not between", value1, value2, "inquiryTime");
            return (Criteria) this;
        }

        public Criteria andInquirySourceIsNull() {
            addCriterion("InquirySource is null");
            return (Criteria) this;
        }

        public Criteria andInquirySourceIsNotNull() {
            addCriterion("InquirySource is not null");
            return (Criteria) this;
        }

        public Criteria andInquirySourceEqualTo(String value) {
            addCriterion("InquirySource =", value, "inquirySource");
            return (Criteria) this;
        }

        public Criteria andInquirySourceNotEqualTo(String value) {
            addCriterion("InquirySource <>", value, "inquirySource");
            return (Criteria) this;
        }

        public Criteria andInquirySourceGreaterThan(String value) {
            addCriterion("InquirySource >", value, "inquirySource");
            return (Criteria) this;
        }

        public Criteria andInquirySourceGreaterThanOrEqualTo(String value) {
            addCriterion("InquirySource >=", value, "inquirySource");
            return (Criteria) this;
        }

        public Criteria andInquirySourceLessThan(String value) {
            addCriterion("InquirySource <", value, "inquirySource");
            return (Criteria) this;
        }

        public Criteria andInquirySourceLessThanOrEqualTo(String value) {
            addCriterion("InquirySource <=", value, "inquirySource");
            return (Criteria) this;
        }

        public Criteria andInquirySourceLike(String value) {
            addCriterion("InquirySource like", value, "inquirySource");
            return (Criteria) this;
        }

        public Criteria andInquirySourceNotLike(String value) {
            addCriterion("InquirySource not like", value, "inquirySource");
            return (Criteria) this;
        }

        public Criteria andInquirySourceIn(List<String> values) {
            addCriterion("InquirySource in", values, "inquirySource");
            return (Criteria) this;
        }

        public Criteria andInquirySourceNotIn(List<String> values) {
            addCriterion("InquirySource not in", values, "inquirySource");
            return (Criteria) this;
        }

        public Criteria andInquirySourceBetween(String value1, String value2) {
            addCriterion("InquirySource between", value1, value2, "inquirySource");
            return (Criteria) this;
        }

        public Criteria andInquirySourceNotBetween(String value1, String value2) {
            addCriterion("InquirySource not between", value1, value2, "inquirySource");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("Remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("Remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("Remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("Remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("Remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("Remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("Remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("Remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("Remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("Remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("Remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("Remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("Remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("Remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeIsNull() {
            addCriterion("CreateDateTime is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeIsNotNull() {
            addCriterion("CreateDateTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeEqualTo(Date value) {
            addCriterion("CreateDateTime =", value, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeNotEqualTo(Date value) {
            addCriterion("CreateDateTime <>", value, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeGreaterThan(Date value) {
            addCriterion("CreateDateTime >", value, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CreateDateTime >=", value, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeLessThan(Date value) {
            addCriterion("CreateDateTime <", value, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CreateDateTime <=", value, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeIn(List<Date> values) {
            addCriterion("CreateDateTime in", values, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeNotIn(List<Date> values) {
            addCriterion("CreateDateTime not in", values, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeBetween(Date value1, Date value2) {
            addCriterion("CreateDateTime between", value1, value2, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CreateDateTime not between", value1, value2, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIsNull() {
            addCriterion("LastUpdateTime is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIsNotNull() {
            addCriterion("LastUpdateTime is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeEqualTo(Date value) {
            addCriterion("LastUpdateTime =", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotEqualTo(Date value) {
            addCriterion("LastUpdateTime <>", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeGreaterThan(Date value) {
            addCriterion("LastUpdateTime >", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("LastUpdateTime >=", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeLessThan(Date value) {
            addCriterion("LastUpdateTime <", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("LastUpdateTime <=", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIn(List<Date> values) {
            addCriterion("LastUpdateTime in", values, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotIn(List<Date> values) {
            addCriterion("LastUpdateTime not in", values, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("LastUpdateTime between", value1, value2, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("LastUpdateTime not between", value1, value2, "lastUpdateTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}