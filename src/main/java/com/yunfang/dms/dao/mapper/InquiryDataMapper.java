package com.yunfang.dms.dao.mapper;

import com.yunfang.dms.entity.InquiryData;
import com.yunfang.dms.entity.InquiryDataCond;
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
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

@Repository
public interface InquiryDataMapper {
    @SelectProvider(type=InquiryDataSqlProvider.class, method="countByExample")
    long countByExample(InquiryDataCond example);

    @DeleteProvider(type=InquiryDataSqlProvider.class, method="deleteByExample")
    int deleteByExample(InquiryDataCond example);

    @Delete({
        "delete from inquirydata",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into inquirydata (CityName, District, ",
        "Region, Community, ",
        "Address, BuildingName, ",
        "HouseName, Floor, ",
        "TotalFloor, Toward, ",
        "BuildYear, Area, ",
        "InquiryPrice, ShiChangPrice, ",
        "CustomerOrg, PriceTime, ",
        "PropertyType, CompanyID, ",
        "InquiryTime, InquirySource, ",
        "Remark, CreateDateTime, ",
        "LastUpdateTime, ExtendCol)",
        "values (#{cityName,jdbcType=VARCHAR}, #{district,jdbcType=VARCHAR}, ",
        "#{region,jdbcType=VARCHAR}, #{community,jdbcType=VARCHAR}, ",
        "#{address,jdbcType=VARCHAR}, #{buildingName,jdbcType=VARCHAR}, ",
        "#{houseName,jdbcType=VARCHAR}, #{floor,jdbcType=INTEGER}, ",
        "#{totalFloor,jdbcType=INTEGER}, #{toward,jdbcType=VARCHAR}, ",
        "#{buildYear,jdbcType=VARCHAR}, #{area,jdbcType=DECIMAL}, ",
        "#{inquiryPrice,jdbcType=DECIMAL}, #{shichangPrice,jdbcType=DECIMAL}, ",
        "#{customerOrg,jdbcType=VARCHAR}, #{priceTime,jdbcType=TIMESTAMP}, ",
        "#{propertyType,jdbcType=VARCHAR}, #{companyId,jdbcType=INTEGER}, ",
        "#{inquiryTime,jdbcType=TIMESTAMP}, #{inquirySource,jdbcType=VARCHAR}, ",
        "#{remark,jdbcType=VARCHAR}, #{createDateTime,jdbcType=TIMESTAMP}, ",
        "#{lastUpdateTime,jdbcType=TIMESTAMP}, #{extendCol,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(InquiryData record);

    @InsertProvider(type=InquiryDataSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(InquiryData record);

    @SelectProvider(type=InquiryDataSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
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
        @Result(column="BuildYear", property="buildYear", jdbcType=JdbcType.VARCHAR),
        @Result(column="Area", property="area", jdbcType=JdbcType.DECIMAL),
        @Result(column="InquiryPrice", property="inquiryPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="ShiChangPrice", property="shichangPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="CustomerOrg", property="customerOrg", jdbcType=JdbcType.VARCHAR),
        @Result(column="PriceTime", property="priceTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="PropertyType", property="propertyType", jdbcType=JdbcType.VARCHAR),
        @Result(column="CompanyID", property="companyId", jdbcType=JdbcType.INTEGER),
        @Result(column="InquiryTime", property="inquiryTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="InquirySource", property="inquirySource", jdbcType=JdbcType.VARCHAR),
        @Result(column="Remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="CreateDateTime", property="createDateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="LastUpdateTime", property="lastUpdateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="ExtendCol", property="extendCol", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<InquiryData> selectByExampleWithBLOBs(InquiryDataCond example);

    @SelectProvider(type=InquiryDataSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
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
        @Result(column="BuildYear", property="buildYear", jdbcType=JdbcType.VARCHAR),
        @Result(column="Area", property="area", jdbcType=JdbcType.DECIMAL),
        @Result(column="InquiryPrice", property="inquiryPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="ShiChangPrice", property="shichangPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="CustomerOrg", property="customerOrg", jdbcType=JdbcType.VARCHAR),
        @Result(column="PriceTime", property="priceTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="PropertyType", property="propertyType", jdbcType=JdbcType.VARCHAR),
        @Result(column="CompanyID", property="companyId", jdbcType=JdbcType.INTEGER),
        @Result(column="InquiryTime", property="inquiryTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="InquirySource", property="inquirySource", jdbcType=JdbcType.VARCHAR),
        @Result(column="Remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="CreateDateTime", property="createDateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="LastUpdateTime", property="lastUpdateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="ExtendCol", property="extendCol", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<InquiryData> selectByExample(InquiryDataCond example);

    @SelectProvider(type=InquiryDataSqlProvider.class, method="selectByPaging")
    @Results({
            @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
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
            @Result(column="BuildYear", property="buildYear", jdbcType=JdbcType.VARCHAR),
            @Result(column="Area", property="area", jdbcType=JdbcType.DECIMAL),
            @Result(column="InquiryPrice", property="inquiryPrice", jdbcType=JdbcType.DECIMAL),
            @Result(column="ShiChangPrice", property="shichangPrice", jdbcType=JdbcType.DECIMAL),
            @Result(column="CustomerOrg", property="customerOrg", jdbcType=JdbcType.VARCHAR),
            @Result(column="PriceTime", property="priceTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="PropertyType", property="propertyType", jdbcType=JdbcType.VARCHAR),
            @Result(column="CompanyID", property="companyId", jdbcType=JdbcType.INTEGER),
            @Result(column="InquiryTime", property="inquiryTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="InquirySource", property="inquirySource", jdbcType=JdbcType.VARCHAR),
            @Result(column="Remark", property="remark", jdbcType=JdbcType.VARCHAR),
            @Result(column="CreateDateTime", property="createDateTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="LastUpdateTime", property="lastUpdateTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="ExtendCol", property="extendCol", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<InquiryData> selectByPaging(InquiryDataCond example);

    @Select({
        "select",
        "ID, CityName, District, Region, Community, Address, BuildingName, HouseName, ",
        "Floor, TotalFloor, Toward, BuildYear, Area, InquiryPrice, ShiChangPrice, CustomerOrg, ",
        "PriceTime, PropertyType, CompanyID, InquiryTime, InquirySource, Remark, CreateDateTime, ",
        "LastUpdateTime, ExtendCol",
        "from inquirydata",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
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
        @Result(column="BuildYear", property="buildYear", jdbcType=JdbcType.VARCHAR),
        @Result(column="Area", property="area", jdbcType=JdbcType.DECIMAL),
        @Result(column="InquiryPrice", property="inquiryPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="ShiChangPrice", property="shichangPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="CustomerOrg", property="customerOrg", jdbcType=JdbcType.VARCHAR),
        @Result(column="PriceTime", property="priceTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="PropertyType", property="propertyType", jdbcType=JdbcType.VARCHAR),
        @Result(column="CompanyID", property="companyId", jdbcType=JdbcType.INTEGER),
        @Result(column="InquiryTime", property="inquiryTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="InquirySource", property="inquirySource", jdbcType=JdbcType.VARCHAR),
        @Result(column="Remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="CreateDateTime", property="createDateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="LastUpdateTime", property="lastUpdateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="ExtendCol", property="extendCol", jdbcType=JdbcType.LONGVARCHAR)
    })
    InquiryData selectByPrimaryKey(Long id);

    @UpdateProvider(type=InquiryDataSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") InquiryData record, @Param("example") InquiryDataCond example);

    @UpdateProvider(type=InquiryDataSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") InquiryData record, @Param("example") InquiryDataCond example);

    @UpdateProvider(type=InquiryDataSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") InquiryData record, @Param("example") InquiryDataCond example);

    @UpdateProvider(type=InquiryDataSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(InquiryData record);

    @Update({
        "update inquirydata",
        "set CityName = #{cityName,jdbcType=VARCHAR},",
          "District = #{district,jdbcType=VARCHAR},",
          "Region = #{region,jdbcType=VARCHAR},",
          "Community = #{community,jdbcType=VARCHAR},",
          "Address = #{address,jdbcType=VARCHAR},",
          "BuildingName = #{buildingName,jdbcType=VARCHAR},",
          "HouseName = #{houseName,jdbcType=VARCHAR},",
          "Floor = #{floor,jdbcType=INTEGER},",
          "TotalFloor = #{totalFloor,jdbcType=INTEGER},",
          "Toward = #{toward,jdbcType=VARCHAR},",
          "BuildYear = #{buildYear,jdbcType=VARCHAR},",
          "Area = #{area,jdbcType=DECIMAL},",
          "InquiryPrice = #{inquiryPrice,jdbcType=DECIMAL},",
          "ShiChangPrice = #{shichangPrice,jdbcType=DECIMAL},",
          "CustomerOrg = #{customerOrg,jdbcType=VARCHAR},",
          "PriceTime = #{priceTime,jdbcType=TIMESTAMP},",
          "PropertyType = #{propertyType,jdbcType=VARCHAR},",
          "CompanyID = #{companyId,jdbcType=INTEGER},",
          "InquiryTime = #{inquiryTime,jdbcType=TIMESTAMP},",
          "InquirySource = #{inquirySource,jdbcType=VARCHAR},",
          "Remark = #{remark,jdbcType=VARCHAR},",
          "CreateDateTime = #{createDateTime,jdbcType=TIMESTAMP},",
          "LastUpdateTime = #{lastUpdateTime,jdbcType=TIMESTAMP},",
          "ExtendCol = #{extendCol,jdbcType=LONGVARCHAR}",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(InquiryData record);

    @Update({
        "update inquirydata",
        "set CityName = #{cityName,jdbcType=VARCHAR},",
          "District = #{district,jdbcType=VARCHAR},",
          "Region = #{region,jdbcType=VARCHAR},",
          "Community = #{community,jdbcType=VARCHAR},",
          "Address = #{address,jdbcType=VARCHAR},",
          "BuildingName = #{buildingName,jdbcType=VARCHAR},",
          "HouseName = #{houseName,jdbcType=VARCHAR},",
          "Floor = #{floor,jdbcType=INTEGER},",
          "TotalFloor = #{totalFloor,jdbcType=INTEGER},",
          "Toward = #{toward,jdbcType=VARCHAR},",
          "BuildYear = #{buildYear,jdbcType=VARCHAR},",
          "Area = #{area,jdbcType=DECIMAL},",
          "InquiryPrice = #{inquiryPrice,jdbcType=DECIMAL},",
          "ShiChangPrice = #{shichangPrice,jdbcType=DECIMAL},",
          "CustomerOrg = #{customerOrg,jdbcType=VARCHAR},",
          "PriceTime = #{priceTime,jdbcType=TIMESTAMP},",
          "PropertyType = #{propertyType,jdbcType=VARCHAR},",
          "CompanyID = #{companyId,jdbcType=INTEGER},",
          "InquiryTime = #{inquiryTime,jdbcType=TIMESTAMP},",
          "InquirySource = #{inquirySource,jdbcType=VARCHAR},",
          "Remark = #{remark,jdbcType=VARCHAR},",
          "CreateDateTime = #{createDateTime,jdbcType=TIMESTAMP},",
          "LastUpdateTime = #{lastUpdateTime,jdbcType=TIMESTAMP}",
          "ExtendCol = #{extendCol,jdbcType=LONGVARCHAR}",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(InquiryData record);

}