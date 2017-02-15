package com.yunfang.dms.dao.mapper;

import com.yunfang.dms.entity.InquiryDataHis;
import com.yunfang.dms.entity.InquiryDataHisCond;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

@Repository
public interface InquiryDataHisMapper {
    @SelectProvider(type=InquiryDataHisSqlProvider.class, method="countByExample")
    long countByExample(InquiryDataHisCond example);

    @DeleteProvider(type=InquiryDataHisSqlProvider.class, method="deleteByExample")
    int deleteByExample(InquiryDataHisCond example);

    @Delete({
        "delete from inquirydata_his",
        "where ID = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into inquirydata_his (InquiryDataID, CityName, ",
        "District, Region, ",
        "Community, Address, ",
        "BuildingName, HouseName, ",
        "Floor, TotalFloor, ",
        "Toward, BuildYear, ",
        "Area, InquiryPrice, ",
        "ShiChangPrice, CustomerOrg, ",
        "PriceTime, PropertyType, ",
        "InquiryTime, InquirySource, ",
        "Remark, CreateDateTime, ",
        "Operator, ExtendCol)",
        "values (#{inquiryDataId,jdbcType=BIGINT}, #{cityName,jdbcType=VARCHAR}, ",
        "#{district,jdbcType=VARCHAR}, #{region,jdbcType=VARCHAR}, ",
        "#{community,jdbcType=VARCHAR}, #{address,jdbcType=VARCHAR}, ",
        "#{buildingName,jdbcType=VARCHAR}, #{houseName,jdbcType=VARCHAR}, ",
        "#{floor,jdbcType=INTEGER}, #{totalFloor,jdbcType=INTEGER}, ",
        "#{toward,jdbcType=VARCHAR}, #{buildYear,jdbcType=INTEGER}, ",
        "#{area,jdbcType=DECIMAL}, #{inquiryPrice,jdbcType=DECIMAL}, ",
        "#{shichangPrice,jdbcType=DECIMAL}, #{customerOrg,jdbcType=VARCHAR}, ",
        "#{priceTime,jdbcType=TIMESTAMP}, #{propertyType,jdbcType=VARCHAR}, ",
        "#{inquiryTime,jdbcType=TIMESTAMP}, #{inquirySource,jdbcType=VARCHAR}, ",
        "#{remark,jdbcType=VARCHAR}, #{createDateTime,jdbcType=TIMESTAMP}, ",
        "#{operator,jdbcType=VARCHAR}, #{extendCol,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(InquiryDataHis record);

    @InsertProvider(type=InquiryDataHisSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(InquiryDataHis record);

    @SelectProvider(type=InquiryDataHisSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="InquiryDataID", property="inquiryDataId", jdbcType=JdbcType.BIGINT),
        @Result(column="CityName", property="cityName", jdbcType=JdbcType.VARCHAR),
        @Result(column="District", property="district", jdbcType=JdbcType.VARCHAR),
        @Result(column="Region", property="region", jdbcType=JdbcType.VARCHAR),
        @Result(column="Community", property="community", jdbcType=JdbcType.VARCHAR),
        @Result(column="Address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="BuildingName", property="buildingName", jdbcType=JdbcType.VARCHAR),
        @Result(column="HouseName", property="houseName", jdbcType=JdbcType.VARCHAR),
        @Result(column="Floor", property="floor", jdbcType=JdbcType.INTEGER),
        @Result(column="TotalFloor", property="totalFloor", jdbcType=JdbcType.INTEGER),
        @Result(column="Toward", property="toward", jdbcType=JdbcType.VARCHAR),
        @Result(column="BuildYear", property="buildYear", jdbcType=JdbcType.INTEGER),
        @Result(column="Area", property="area", jdbcType=JdbcType.DECIMAL),
        @Result(column="InquiryPrice", property="inquiryPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="ShiChangPrice", property="shichangPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="CustomerOrg", property="customerOrg", jdbcType=JdbcType.VARCHAR),
        @Result(column="PriceTime", property="priceTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="PropertyType", property="propertyType", jdbcType=JdbcType.VARCHAR),
        @Result(column="InquiryTime", property="inquiryTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="InquirySource", property="inquirySource", jdbcType=JdbcType.VARCHAR),
        @Result(column="Remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="CreateDateTime", property="createDateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="Operator", property="operator", jdbcType=JdbcType.VARCHAR),
        @Result(column="ExtendCol", property="extendCol", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<InquiryDataHis> selectByExampleWithBLOBs(InquiryDataHisCond example);

    @SelectProvider(type=InquiryDataHisSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="InquiryDataID", property="inquiryDataId", jdbcType=JdbcType.BIGINT),
        @Result(column="CityName", property="cityName", jdbcType=JdbcType.VARCHAR),
        @Result(column="District", property="district", jdbcType=JdbcType.VARCHAR),
        @Result(column="Region", property="region", jdbcType=JdbcType.VARCHAR),
        @Result(column="Community", property="community", jdbcType=JdbcType.VARCHAR),
        @Result(column="Address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="BuildingName", property="buildingName", jdbcType=JdbcType.VARCHAR),
        @Result(column="HouseName", property="houseName", jdbcType=JdbcType.VARCHAR),
        @Result(column="Floor", property="floor", jdbcType=JdbcType.INTEGER),
        @Result(column="TotalFloor", property="totalFloor", jdbcType=JdbcType.INTEGER),
        @Result(column="Toward", property="toward", jdbcType=JdbcType.VARCHAR),
        @Result(column="BuildYear", property="buildYear", jdbcType=JdbcType.INTEGER),
        @Result(column="Area", property="area", jdbcType=JdbcType.DECIMAL),
        @Result(column="InquiryPrice", property="inquiryPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="ShiChangPrice", property="shichangPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="CustomerOrg", property="customerOrg", jdbcType=JdbcType.VARCHAR),
        @Result(column="PriceTime", property="priceTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="PropertyType", property="propertyType", jdbcType=JdbcType.VARCHAR),
        @Result(column="InquiryTime", property="inquiryTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="InquirySource", property="inquirySource", jdbcType=JdbcType.VARCHAR),
        @Result(column="Remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="CreateDateTime", property="createDateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="Operator", property="operator", jdbcType=JdbcType.VARCHAR)
    })
    List<InquiryDataHis> selectByExample(InquiryDataHisCond example);

    @Select({
        "select",
        "ID, InquiryDataID, CityName, District, Region, Community, Address, BuildingName, ",
        "HouseName, Floor, TotalFloor, Toward, BuildYear, Area, InquiryPrice, ShiChangPrice, ",
        "CustomerOrg, PriceTime, PropertyType, InquiryTime, InquirySource, Remark, CreateDateTime, ",
        "Operator, ExtendCol",
        "from inquirydata_his",
        "where ID = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="InquiryDataID", property="inquiryDataId", jdbcType=JdbcType.BIGINT),
        @Result(column="CityName", property="cityName", jdbcType=JdbcType.VARCHAR),
        @Result(column="District", property="district", jdbcType=JdbcType.VARCHAR),
        @Result(column="Region", property="region", jdbcType=JdbcType.VARCHAR),
        @Result(column="Community", property="community", jdbcType=JdbcType.VARCHAR),
        @Result(column="Address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="BuildingName", property="buildingName", jdbcType=JdbcType.VARCHAR),
        @Result(column="HouseName", property="houseName", jdbcType=JdbcType.VARCHAR),
        @Result(column="Floor", property="floor", jdbcType=JdbcType.INTEGER),
        @Result(column="TotalFloor", property="totalFloor", jdbcType=JdbcType.INTEGER),
        @Result(column="Toward", property="toward", jdbcType=JdbcType.VARCHAR),
        @Result(column="BuildYear", property="buildYear", jdbcType=JdbcType.INTEGER),
        @Result(column="Area", property="area", jdbcType=JdbcType.DECIMAL),
        @Result(column="InquiryPrice", property="inquiryPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="ShiChangPrice", property="shichangPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="CustomerOrg", property="customerOrg", jdbcType=JdbcType.VARCHAR),
        @Result(column="PriceTime", property="priceTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="PropertyType", property="propertyType", jdbcType=JdbcType.VARCHAR),
        @Result(column="InquiryTime", property="inquiryTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="InquirySource", property="inquirySource", jdbcType=JdbcType.VARCHAR),
        @Result(column="Remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="CreateDateTime", property="createDateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="Operator", property="operator", jdbcType=JdbcType.VARCHAR),
        @Result(column="ExtendCol", property="extendCol", jdbcType=JdbcType.LONGVARCHAR)
    })
    InquiryDataHis selectByPrimaryKey(Integer id);

    @UpdateProvider(type=InquiryDataHisSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") InquiryDataHis record, @Param("example") InquiryDataHisCond example);

    @UpdateProvider(type=InquiryDataHisSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") InquiryDataHis record, @Param("example") InquiryDataHisCond example);

    @UpdateProvider(type=InquiryDataHisSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") InquiryDataHis record, @Param("example") InquiryDataHisCond example);

    @UpdateProvider(type=InquiryDataHisSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(InquiryDataHis record);

    @Update({
        "update inquirydata_his",
        "set InquiryDataID = #{inquiryDataId,jdbcType=BIGINT},",
          "CityName = #{cityName,jdbcType=VARCHAR},",
          "District = #{district,jdbcType=VARCHAR},",
          "Region = #{region,jdbcType=VARCHAR},",
          "Community = #{community,jdbcType=VARCHAR},",
          "Address = #{address,jdbcType=VARCHAR},",
          "BuildingName = #{buildingName,jdbcType=VARCHAR},",
          "HouseName = #{houseName,jdbcType=VARCHAR},",
          "Floor = #{floor,jdbcType=INTEGER},",
          "TotalFloor = #{totalFloor,jdbcType=INTEGER},",
          "Toward = #{toward,jdbcType=VARCHAR},",
          "BuildYear = #{buildYear,jdbcType=INTEGER},",
          "Area = #{area,jdbcType=DECIMAL},",
          "InquiryPrice = #{inquiryPrice,jdbcType=DECIMAL},",
          "ShiChangPrice = #{shichangPrice,jdbcType=DECIMAL},",
          "CustomerOrg = #{customerOrg,jdbcType=VARCHAR},",
          "PriceTime = #{priceTime,jdbcType=TIMESTAMP},",
          "PropertyType = #{propertyType,jdbcType=VARCHAR},",
          "InquiryTime = #{inquiryTime,jdbcType=TIMESTAMP},",
          "InquirySource = #{inquirySource,jdbcType=VARCHAR},",
          "Remark = #{remark,jdbcType=VARCHAR},",
          "CreateDateTime = #{createDateTime,jdbcType=TIMESTAMP},",
          "Operator = #{operator,jdbcType=VARCHAR},",
          "ExtendCol = #{extendCol,jdbcType=LONGVARCHAR}",
        "where ID = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(InquiryDataHis record);

    @Update({
        "update inquirydata_his",
        "set InquiryDataID = #{inquiryDataId,jdbcType=BIGINT},",
          "CityName = #{cityName,jdbcType=VARCHAR},",
          "District = #{district,jdbcType=VARCHAR},",
          "Region = #{region,jdbcType=VARCHAR},",
          "Community = #{community,jdbcType=VARCHAR},",
          "Address = #{address,jdbcType=VARCHAR},",
          "BuildingName = #{buildingName,jdbcType=VARCHAR},",
          "HouseName = #{houseName,jdbcType=VARCHAR},",
          "Floor = #{floor,jdbcType=INTEGER},",
          "TotalFloor = #{totalFloor,jdbcType=INTEGER},",
          "Toward = #{toward,jdbcType=VARCHAR},",
          "BuildYear = #{buildYear,jdbcType=INTEGER},",
          "Area = #{area,jdbcType=DECIMAL},",
          "InquiryPrice = #{inquiryPrice,jdbcType=DECIMAL},",
          "ShiChangPrice = #{shichangPrice,jdbcType=DECIMAL},",
          "CustomerOrg = #{customerOrg,jdbcType=VARCHAR},",
          "PriceTime = #{priceTime,jdbcType=TIMESTAMP},",
          "PropertyType = #{propertyType,jdbcType=VARCHAR},",
          "InquiryTime = #{inquiryTime,jdbcType=TIMESTAMP},",
          "InquirySource = #{inquirySource,jdbcType=VARCHAR},",
          "Remark = #{remark,jdbcType=VARCHAR},",
          "CreateDateTime = #{createDateTime,jdbcType=TIMESTAMP},",
          "Operator = #{operator,jdbcType=VARCHAR}",
        "where ID = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(InquiryDataHis record);
}