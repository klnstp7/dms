package com.yunfang.dms.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommunityBaseDataCond extends BaseRowBound {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommunityBaseDataCond() {
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

        public Criteria andAliasIsNull() {
            addCriterion("Alias is null");
            return (Criteria) this;
        }

        public Criteria andAliasIsNotNull() {
            addCriterion("Alias is not null");
            return (Criteria) this;
        }

        public Criteria andAliasEqualTo(String value) {
            addCriterion("Alias =", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasNotEqualTo(String value) {
            addCriterion("Alias <>", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasGreaterThan(String value) {
            addCriterion("Alias >", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasGreaterThanOrEqualTo(String value) {
            addCriterion("Alias >=", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasLessThan(String value) {
            addCriterion("Alias <", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasLessThanOrEqualTo(String value) {
            addCriterion("Alias <=", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasLike(String value) {
            addCriterion("Alias like", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasNotLike(String value) {
            addCriterion("Alias not like", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasIn(List<String> values) {
            addCriterion("Alias in", values, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasNotIn(List<String> values) {
            addCriterion("Alias not in", values, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasBetween(String value1, String value2) {
            addCriterion("Alias between", value1, value2, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasNotBetween(String value1, String value2) {
            addCriterion("Alias not between", value1, value2, "alias");
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

        public Criteria andDevelopersIsNull() {
            addCriterion("Developers is null");
            return (Criteria) this;
        }

        public Criteria andDevelopersIsNotNull() {
            addCriterion("Developers is not null");
            return (Criteria) this;
        }

        public Criteria andDevelopersEqualTo(String value) {
            addCriterion("Developers =", value, "developers");
            return (Criteria) this;
        }

        public Criteria andDevelopersNotEqualTo(String value) {
            addCriterion("Developers <>", value, "developers");
            return (Criteria) this;
        }

        public Criteria andDevelopersGreaterThan(String value) {
            addCriterion("Developers >", value, "developers");
            return (Criteria) this;
        }

        public Criteria andDevelopersGreaterThanOrEqualTo(String value) {
            addCriterion("Developers >=", value, "developers");
            return (Criteria) this;
        }

        public Criteria andDevelopersLessThan(String value) {
            addCriterion("Developers <", value, "developers");
            return (Criteria) this;
        }

        public Criteria andDevelopersLessThanOrEqualTo(String value) {
            addCriterion("Developers <=", value, "developers");
            return (Criteria) this;
        }

        public Criteria andDevelopersLike(String value) {
            addCriterion("Developers like", value, "developers");
            return (Criteria) this;
        }

        public Criteria andDevelopersNotLike(String value) {
            addCriterion("Developers not like", value, "developers");
            return (Criteria) this;
        }

        public Criteria andDevelopersIn(List<String> values) {
            addCriterion("Developers in", values, "developers");
            return (Criteria) this;
        }

        public Criteria andDevelopersNotIn(List<String> values) {
            addCriterion("Developers not in", values, "developers");
            return (Criteria) this;
        }

        public Criteria andDevelopersBetween(String value1, String value2) {
            addCriterion("Developers between", value1, value2, "developers");
            return (Criteria) this;
        }

        public Criteria andDevelopersNotBetween(String value1, String value2) {
            addCriterion("Developers not between", value1, value2, "developers");
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

        public Criteria andTotalBuildingIsNull() {
            addCriterion("TotalBuilding is null");
            return (Criteria) this;
        }

        public Criteria andTotalBuildingIsNotNull() {
            addCriterion("TotalBuilding is not null");
            return (Criteria) this;
        }

        public Criteria andTotalBuildingEqualTo(Integer value) {
            addCriterion("TotalBuilding =", value, "totalBuilding");
            return (Criteria) this;
        }

        public Criteria andTotalBuildingNotEqualTo(Integer value) {
            addCriterion("TotalBuilding <>", value, "totalBuilding");
            return (Criteria) this;
        }

        public Criteria andTotalBuildingGreaterThan(Integer value) {
            addCriterion("TotalBuilding >", value, "totalBuilding");
            return (Criteria) this;
        }

        public Criteria andTotalBuildingGreaterThanOrEqualTo(Integer value) {
            addCriterion("TotalBuilding >=", value, "totalBuilding");
            return (Criteria) this;
        }

        public Criteria andTotalBuildingLessThan(Integer value) {
            addCriterion("TotalBuilding <", value, "totalBuilding");
            return (Criteria) this;
        }

        public Criteria andTotalBuildingLessThanOrEqualTo(Integer value) {
            addCriterion("TotalBuilding <=", value, "totalBuilding");
            return (Criteria) this;
        }

        public Criteria andTotalBuildingIn(List<Integer> values) {
            addCriterion("TotalBuilding in", values, "totalBuilding");
            return (Criteria) this;
        }

        public Criteria andTotalBuildingNotIn(List<Integer> values) {
            addCriterion("TotalBuilding not in", values, "totalBuilding");
            return (Criteria) this;
        }

        public Criteria andTotalBuildingBetween(Integer value1, Integer value2) {
            addCriterion("TotalBuilding between", value1, value2, "totalBuilding");
            return (Criteria) this;
        }

        public Criteria andTotalBuildingNotBetween(Integer value1, Integer value2) {
            addCriterion("TotalBuilding not between", value1, value2, "totalBuilding");
            return (Criteria) this;
        }

        public Criteria andTotalHouseIsNull() {
            addCriterion("TotalHouse is null");
            return (Criteria) this;
        }

        public Criteria andTotalHouseIsNotNull() {
            addCriterion("TotalHouse is not null");
            return (Criteria) this;
        }

        public Criteria andTotalHouseEqualTo(Integer value) {
            addCriterion("TotalHouse =", value, "totalHouse");
            return (Criteria) this;
        }

        public Criteria andTotalHouseNotEqualTo(Integer value) {
            addCriterion("TotalHouse <>", value, "totalHouse");
            return (Criteria) this;
        }

        public Criteria andTotalHouseGreaterThan(Integer value) {
            addCriterion("TotalHouse >", value, "totalHouse");
            return (Criteria) this;
        }

        public Criteria andTotalHouseGreaterThanOrEqualTo(Integer value) {
            addCriterion("TotalHouse >=", value, "totalHouse");
            return (Criteria) this;
        }

        public Criteria andTotalHouseLessThan(Integer value) {
            addCriterion("TotalHouse <", value, "totalHouse");
            return (Criteria) this;
        }

        public Criteria andTotalHouseLessThanOrEqualTo(Integer value) {
            addCriterion("TotalHouse <=", value, "totalHouse");
            return (Criteria) this;
        }

        public Criteria andTotalHouseIn(List<Integer> values) {
            addCriterion("TotalHouse in", values, "totalHouse");
            return (Criteria) this;
        }

        public Criteria andTotalHouseNotIn(List<Integer> values) {
            addCriterion("TotalHouse not in", values, "totalHouse");
            return (Criteria) this;
        }

        public Criteria andTotalHouseBetween(Integer value1, Integer value2) {
            addCriterion("TotalHouse between", value1, value2, "totalHouse");
            return (Criteria) this;
        }

        public Criteria andTotalHouseNotBetween(Integer value1, Integer value2) {
            addCriterion("TotalHouse not between", value1, value2, "totalHouse");
            return (Criteria) this;
        }

        public Criteria andGreenPercentIsNull() {
            addCriterion("GreenPercent is null");
            return (Criteria) this;
        }

        public Criteria andGreenPercentIsNotNull() {
            addCriterion("GreenPercent is not null");
            return (Criteria) this;
        }

        public Criteria andGreenPercentEqualTo(BigDecimal value) {
            addCriterion("GreenPercent =", value, "greenPercent");
            return (Criteria) this;
        }

        public Criteria andGreenPercentNotEqualTo(BigDecimal value) {
            addCriterion("GreenPercent <>", value, "greenPercent");
            return (Criteria) this;
        }

        public Criteria andGreenPercentGreaterThan(BigDecimal value) {
            addCriterion("GreenPercent >", value, "greenPercent");
            return (Criteria) this;
        }

        public Criteria andGreenPercentGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("GreenPercent >=", value, "greenPercent");
            return (Criteria) this;
        }

        public Criteria andGreenPercentLessThan(BigDecimal value) {
            addCriterion("GreenPercent <", value, "greenPercent");
            return (Criteria) this;
        }

        public Criteria andGreenPercentLessThanOrEqualTo(BigDecimal value) {
            addCriterion("GreenPercent <=", value, "greenPercent");
            return (Criteria) this;
        }

        public Criteria andGreenPercentIn(List<BigDecimal> values) {
            addCriterion("GreenPercent in", values, "greenPercent");
            return (Criteria) this;
        }

        public Criteria andGreenPercentNotIn(List<BigDecimal> values) {
            addCriterion("GreenPercent not in", values, "greenPercent");
            return (Criteria) this;
        }

        public Criteria andGreenPercentBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("GreenPercent between", value1, value2, "greenPercent");
            return (Criteria) this;
        }

        public Criteria andGreenPercentNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("GreenPercent not between", value1, value2, "greenPercent");
            return (Criteria) this;
        }

        public Criteria andBaseInstallationIsNull() {
            addCriterion("BaseInstallation is null");
            return (Criteria) this;
        }

        public Criteria andBaseInstallationIsNotNull() {
            addCriterion("BaseInstallation is not null");
            return (Criteria) this;
        }

        public Criteria andBaseInstallationEqualTo(String value) {
            addCriterion("BaseInstallation =", value, "baseInstallation");
            return (Criteria) this;
        }

        public Criteria andBaseInstallationNotEqualTo(String value) {
            addCriterion("BaseInstallation <>", value, "baseInstallation");
            return (Criteria) this;
        }

        public Criteria andBaseInstallationGreaterThan(String value) {
            addCriterion("BaseInstallation >", value, "baseInstallation");
            return (Criteria) this;
        }

        public Criteria andBaseInstallationGreaterThanOrEqualTo(String value) {
            addCriterion("BaseInstallation >=", value, "baseInstallation");
            return (Criteria) this;
        }

        public Criteria andBaseInstallationLessThan(String value) {
            addCriterion("BaseInstallation <", value, "baseInstallation");
            return (Criteria) this;
        }

        public Criteria andBaseInstallationLessThanOrEqualTo(String value) {
            addCriterion("BaseInstallation <=", value, "baseInstallation");
            return (Criteria) this;
        }

        public Criteria andBaseInstallationLike(String value) {
            addCriterion("BaseInstallation like", value, "baseInstallation");
            return (Criteria) this;
        }

        public Criteria andBaseInstallationNotLike(String value) {
            addCriterion("BaseInstallation not like", value, "baseInstallation");
            return (Criteria) this;
        }

        public Criteria andBaseInstallationIn(List<String> values) {
            addCriterion("BaseInstallation in", values, "baseInstallation");
            return (Criteria) this;
        }

        public Criteria andBaseInstallationNotIn(List<String> values) {
            addCriterion("BaseInstallation not in", values, "baseInstallation");
            return (Criteria) this;
        }

        public Criteria andBaseInstallationBetween(String value1, String value2) {
            addCriterion("BaseInstallation between", value1, value2, "baseInstallation");
            return (Criteria) this;
        }

        public Criteria andBaseInstallationNotBetween(String value1, String value2) {
            addCriterion("BaseInstallation not between", value1, value2, "baseInstallation");
            return (Criteria) this;
        }

        public Criteria andMatingIsNull() {
            addCriterion("Mating is null");
            return (Criteria) this;
        }

        public Criteria andMatingIsNotNull() {
            addCriterion("Mating is not null");
            return (Criteria) this;
        }

        public Criteria andMatingEqualTo(String value) {
            addCriterion("Mating =", value, "mating");
            return (Criteria) this;
        }

        public Criteria andMatingNotEqualTo(String value) {
            addCriterion("Mating <>", value, "mating");
            return (Criteria) this;
        }

        public Criteria andMatingGreaterThan(String value) {
            addCriterion("Mating >", value, "mating");
            return (Criteria) this;
        }

        public Criteria andMatingGreaterThanOrEqualTo(String value) {
            addCriterion("Mating >=", value, "mating");
            return (Criteria) this;
        }

        public Criteria andMatingLessThan(String value) {
            addCriterion("Mating <", value, "mating");
            return (Criteria) this;
        }

        public Criteria andMatingLessThanOrEqualTo(String value) {
            addCriterion("Mating <=", value, "mating");
            return (Criteria) this;
        }

        public Criteria andMatingLike(String value) {
            addCriterion("Mating like", value, "mating");
            return (Criteria) this;
        }

        public Criteria andMatingNotLike(String value) {
            addCriterion("Mating not like", value, "mating");
            return (Criteria) this;
        }

        public Criteria andMatingIn(List<String> values) {
            addCriterion("Mating in", values, "mating");
            return (Criteria) this;
        }

        public Criteria andMatingNotIn(List<String> values) {
            addCriterion("Mating not in", values, "mating");
            return (Criteria) this;
        }

        public Criteria andMatingBetween(String value1, String value2) {
            addCriterion("Mating between", value1, value2, "mating");
            return (Criteria) this;
        }

        public Criteria andMatingNotBetween(String value1, String value2) {
            addCriterion("Mating not between", value1, value2, "mating");
            return (Criteria) this;
        }

        public Criteria andTrafficInfoIsNull() {
            addCriterion("TrafficInfo is null");
            return (Criteria) this;
        }

        public Criteria andTrafficInfoIsNotNull() {
            addCriterion("TrafficInfo is not null");
            return (Criteria) this;
        }

        public Criteria andTrafficInfoEqualTo(String value) {
            addCriterion("TrafficInfo =", value, "trafficInfo");
            return (Criteria) this;
        }

        public Criteria andTrafficInfoNotEqualTo(String value) {
            addCriterion("TrafficInfo <>", value, "trafficInfo");
            return (Criteria) this;
        }

        public Criteria andTrafficInfoGreaterThan(String value) {
            addCriterion("TrafficInfo >", value, "trafficInfo");
            return (Criteria) this;
        }

        public Criteria andTrafficInfoGreaterThanOrEqualTo(String value) {
            addCriterion("TrafficInfo >=", value, "trafficInfo");
            return (Criteria) this;
        }

        public Criteria andTrafficInfoLessThan(String value) {
            addCriterion("TrafficInfo <", value, "trafficInfo");
            return (Criteria) this;
        }

        public Criteria andTrafficInfoLessThanOrEqualTo(String value) {
            addCriterion("TrafficInfo <=", value, "trafficInfo");
            return (Criteria) this;
        }

        public Criteria andTrafficInfoLike(String value) {
            addCriterion("TrafficInfo like", value, "trafficInfo");
            return (Criteria) this;
        }

        public Criteria andTrafficInfoNotLike(String value) {
            addCriterion("TrafficInfo not like", value, "trafficInfo");
            return (Criteria) this;
        }

        public Criteria andTrafficInfoIn(List<String> values) {
            addCriterion("TrafficInfo in", values, "trafficInfo");
            return (Criteria) this;
        }

        public Criteria andTrafficInfoNotIn(List<String> values) {
            addCriterion("TrafficInfo not in", values, "trafficInfo");
            return (Criteria) this;
        }

        public Criteria andTrafficInfoBetween(String value1, String value2) {
            addCriterion("TrafficInfo between", value1, value2, "trafficInfo");
            return (Criteria) this;
        }

        public Criteria andTrafficInfoNotBetween(String value1, String value2) {
            addCriterion("TrafficInfo not between", value1, value2, "trafficInfo");
            return (Criteria) this;
        }

        public Criteria andFeaTuRemarkIsNull() {
            addCriterion("FeatureMark is null");
            return (Criteria) this;
        }

        public Criteria andFeaTuRemarkIsNotNull() {
            addCriterion("FeatureMark is not null");
            return (Criteria) this;
        }

        public Criteria andFeaTuRemarkEqualTo(String value) {
            addCriterion("FeatureMark =", value, "feaTuRemark");
            return (Criteria) this;
        }

        public Criteria andFeaTuRemarkNotEqualTo(String value) {
            addCriterion("FeatureMark <>", value, "feaTuRemark");
            return (Criteria) this;
        }

        public Criteria andFeaTuRemarkGreaterThan(String value) {
            addCriterion("FeatureMark >", value, "feaTuRemark");
            return (Criteria) this;
        }

        public Criteria andFeaTuRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("FeatureMark >=", value, "feaTuRemark");
            return (Criteria) this;
        }

        public Criteria andFeaTuRemarkLessThan(String value) {
            addCriterion("FeatureMark <", value, "feaTuRemark");
            return (Criteria) this;
        }

        public Criteria andFeaTuRemarkLessThanOrEqualTo(String value) {
            addCriterion("FeatureMark <=", value, "feaTuRemark");
            return (Criteria) this;
        }

        public Criteria andFeaTuRemarkLike(String value) {
            addCriterion("FeatureMark like", value, "feaTuRemark");
            return (Criteria) this;
        }

        public Criteria andFeaTuRemarkNotLike(String value) {
            addCriterion("FeatureMark not like", value, "feaTuRemark");
            return (Criteria) this;
        }

        public Criteria andFeaTuRemarkIn(List<String> values) {
            addCriterion("FeatureMark in", values, "feaTuRemark");
            return (Criteria) this;
        }

        public Criteria andFeaTuRemarkNotIn(List<String> values) {
            addCriterion("FeatureMark not in", values, "feaTuRemark");
            return (Criteria) this;
        }

        public Criteria andFeaTuRemarkBetween(String value1, String value2) {
            addCriterion("FeatureMark between", value1, value2, "feaTuRemark");
            return (Criteria) this;
        }

        public Criteria andFeaTuRemarkNotBetween(String value1, String value2) {
            addCriterion("FeatureMark not between", value1, value2, "feaTuRemark");
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