package com.yunfang.dms.dao.mapper;

import com.yunfang.dms.entity.TransactionCase;
import com.yunfang.dms.entity.TransactionCaseCond;
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
public interface TransactionCaseMapper {
    @SelectProvider(type=TransactionCaseSqlProvider.class, method="countByExample")
    long countByExample(TransactionCaseCond example);

    @DeleteProvider(type=TransactionCaseSqlProvider.class, method="deleteByExample")
    int deleteByExample(TransactionCaseCond example);

    @Delete({
        "delete from transactioncase",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into transactioncase (CityName, District, ",
        "Region, Community, ",
        "Address, BuildingName, ",
        "RoomLayout, HouseName, ",
        "Floor, TotalFloor, ",
        "Toward, BuildYear, ",
        "Area, Price, TotalPrice, ",
        "ProjectAddress, Remark, ",
        "CompanyID, PriceTime, ",
        "CreateDateTime, LastUpdateTime, ",
        "ExtendCol)",
        "values (#{cityName,jdbcType=VARCHAR}, #{district,jdbcType=VARCHAR}, ",
        "#{region,jdbcType=VARCHAR}, #{community,jdbcType=VARCHAR}, ",
        "#{address,jdbcType=VARCHAR}, #{buildingName,jdbcType=VARCHAR}, ",
        "#{roomLayout,jdbcType=VARCHAR}, #{houseName,jdbcType=VARCHAR}, ",
        "#{floor,jdbcType=INTEGER}, #{totalFloor,jdbcType=INTEGER}, ",
        "#{toward,jdbcType=VARCHAR}, #{buildYear,jdbcType=INTEGER}, ",
        "#{area,jdbcType=DECIMAL}, #{price,jdbcType=DECIMAL}, #{totalPrice,jdbcType=DECIMAL}, ",
        "#{projectAddress,jdbcType=VARCHAR}, #{remark,jdbcType=VARCHAR}, ",
        "#{companyId,jdbcType=INTEGER}, #{pricetime,jdbcType=TIMESTAMP}, ",
        "#{createDateTime,jdbcType=TIMESTAMP}, #{lastUpdateTime,jdbcType=TIMESTAMP}, ",
        "#{extendCol,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(TransactionCase record);

    @InsertProvider(type=TransactionCaseSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(TransactionCase record);

    @SelectProvider(type=TransactionCaseSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="CityName", property="cityName", jdbcType=JdbcType.VARCHAR),
        @Result(column="District", property="district", jdbcType=JdbcType.VARCHAR),
        @Result(column="Region", property="region", jdbcType=JdbcType.VARCHAR),
        @Result(column="Community", property="community", jdbcType=JdbcType.VARCHAR),
        @Result(column="Address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="BuildingName", property="buildingName", jdbcType=JdbcType.VARCHAR),
        @Result(column="RoomLayout", property="roomLayout", jdbcType=JdbcType.VARCHAR),
        @Result(column="HouseName", property="houseName", jdbcType=JdbcType.VARCHAR),
        @Result(column="Floor", property="floor", jdbcType=JdbcType.INTEGER),
        @Result(column="TotalFloor", property="totalFloor", jdbcType=JdbcType.INTEGER),
        @Result(column="Toward", property="toward", jdbcType=JdbcType.VARCHAR),
        @Result(column="BuildYear", property="buildYear", jdbcType=JdbcType.INTEGER),
        @Result(column="Area", property="area", jdbcType=JdbcType.DECIMAL),
        @Result(column="Price", property="price", jdbcType=JdbcType.DECIMAL),
        @Result(column="TotalPrice", property="totalPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="ProjectAddress", property="projectAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="Remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="CompanyID", property="companyId", jdbcType=JdbcType.INTEGER),
        @Result(column="PriceTime", property="pricetime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="CreateDateTime", property="createDateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="LastUpdateTime", property="lastUpdateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="ExtendCol", property="extendCol", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<TransactionCase> selectByExampleWithBLOBs(TransactionCaseCond example);

    @SelectProvider(type=TransactionCaseSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="CityName", property="cityName", jdbcType=JdbcType.VARCHAR),
        @Result(column="District", property="district", jdbcType=JdbcType.VARCHAR),
        @Result(column="Region", property="region", jdbcType=JdbcType.VARCHAR),
        @Result(column="Community", property="community", jdbcType=JdbcType.VARCHAR),
        @Result(column="Address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="BuildingName", property="buildingName", jdbcType=JdbcType.VARCHAR),
        @Result(column="RoomLayout", property="roomLayout", jdbcType=JdbcType.VARCHAR),
        @Result(column="HouseName", property="houseName", jdbcType=JdbcType.VARCHAR),
        @Result(column="Floor", property="floor", jdbcType=JdbcType.INTEGER),
        @Result(column="TotalFloor", property="totalFloor", jdbcType=JdbcType.INTEGER),
        @Result(column="Toward", property="toward", jdbcType=JdbcType.VARCHAR),
        @Result(column="BuildYear", property="buildYear", jdbcType=JdbcType.INTEGER),
        @Result(column="Area", property="area", jdbcType=JdbcType.DECIMAL),
        @Result(column="Price", property="price", jdbcType=JdbcType.DECIMAL),
        @Result(column="TotalPrice", property="totalPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="ProjectAddress", property="projectAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="Remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="CompanyID", property="companyId", jdbcType=JdbcType.INTEGER),
        @Result(column="PriceTime", property="pricetime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="CreateDateTime", property="createDateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="LastUpdateTime", property="lastUpdateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<TransactionCase> selectByExample(TransactionCaseCond example);

    @Select({
        "select",
        "ID, CityName, District, Region, Community, Address, BuildingName, RoomLayout, ",
        "HouseName, Floor, TotalFloor, Toward, BuildYear, Area, Price, TotalPrice, ProjectAddress, ",
        "Remark, CompanyID, PriceTime, CreateDateTime, LastUpdateTime, ExtendCol",
        "from transactioncase",
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
        @Result(column="RoomLayout", property="roomLayout", jdbcType=JdbcType.VARCHAR),
        @Result(column="HouseName", property="houseName", jdbcType=JdbcType.VARCHAR),
        @Result(column="Floor", property="floor", jdbcType=JdbcType.INTEGER),
        @Result(column="TotalFloor", property="totalFloor", jdbcType=JdbcType.INTEGER),
        @Result(column="Toward", property="toward", jdbcType=JdbcType.VARCHAR),
        @Result(column="BuildYear", property="buildYear", jdbcType=JdbcType.INTEGER),
        @Result(column="Area", property="area", jdbcType=JdbcType.DECIMAL),
        @Result(column="Price", property="price", jdbcType=JdbcType.DECIMAL),
        @Result(column="TotalPrice", property="totalPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="ProjectAddress", property="projectAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="Remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="CompanyID", property="companyId", jdbcType=JdbcType.INTEGER),
        @Result(column="PriceTime", property="pricetime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="CreateDateTime", property="createDateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="LastUpdateTime", property="lastUpdateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="ExtendCol", property="extendCol", jdbcType=JdbcType.LONGVARCHAR)
    })
    TransactionCase selectByPrimaryKey(Long id);

    @UpdateProvider(type=TransactionCaseSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TransactionCase record, @Param("example") TransactionCaseCond example);

    @UpdateProvider(type=TransactionCaseSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") TransactionCase record, @Param("example") TransactionCaseCond example);

    @UpdateProvider(type=TransactionCaseSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TransactionCase record, @Param("example") TransactionCaseCond example);

    @UpdateProvider(type=TransactionCaseSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TransactionCase record);

    @Update({
        "update transactioncase",
        "set CityName = #{cityName,jdbcType=VARCHAR},",
          "District = #{district,jdbcType=VARCHAR},",
          "Region = #{region,jdbcType=VARCHAR},",
          "Community = #{community,jdbcType=VARCHAR},",
          "Address = #{address,jdbcType=VARCHAR},",
          "BuildingName = #{buildingName,jdbcType=VARCHAR},",
          "RoomLayout = #{roomLayout,jdbcType=VARCHAR},",
          "HouseName = #{houseName,jdbcType=VARCHAR},",
          "Floor = #{floor,jdbcType=INTEGER},",
          "TotalFloor = #{totalFloor,jdbcType=INTEGER},",
          "Toward = #{toward,jdbcType=VARCHAR},",
          "BuildYear = #{buildYear,jdbcType=INTEGER},",
          "Area = #{area,jdbcType=DECIMAL},",
          "Price = #{price,jdbcType=DECIMAL},",
          "TotalPrice = #{totalPrice,jdbcType=DECIMAL},",
          "ProjectAddress = #{projectAddress,jdbcType=VARCHAR},",
          "Remark = #{remark,jdbcType=VARCHAR},",
          "CompanyID = #{companyId,jdbcType=INTEGER},",
          "PriceTime = #{pricetime,jdbcType=TIMESTAMP},",
          "CreateDateTime = #{createDateTime,jdbcType=TIMESTAMP},",
          "LastUpdateTime = #{lastUpdateTime,jdbcType=TIMESTAMP},",
          "ExtendCol = #{extendCol,jdbcType=LONGVARCHAR}",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(TransactionCase record);

    @Update({
        "update transactioncase",
        "set CityName = #{cityName,jdbcType=VARCHAR},",
          "District = #{district,jdbcType=VARCHAR},",
          "Region = #{region,jdbcType=VARCHAR},",
          "Community = #{community,jdbcType=VARCHAR},",
          "Address = #{address,jdbcType=VARCHAR},",
          "BuildingName = #{buildingName,jdbcType=VARCHAR},",
          "RoomLayout = #{roomLayout,jdbcType=VARCHAR},",
          "HouseName = #{houseName,jdbcType=VARCHAR},",
          "Floor = #{floor,jdbcType=INTEGER},",
          "TotalFloor = #{totalFloor,jdbcType=INTEGER},",
          "Toward = #{toward,jdbcType=VARCHAR},",
          "BuildYear = #{buildYear,jdbcType=INTEGER},",
          "Area = #{area,jdbcType=DECIMAL},",
          "Price = #{price,jdbcType=DECIMAL},",
          "TotalPrice = #{totalPrice,jdbcType=DECIMAL},",
          "ProjectAddress = #{projectAddress,jdbcType=VARCHAR},",
          "Remark = #{remark,jdbcType=VARCHAR},",
          "CompanyID = #{companyId,jdbcType=INTEGER},",
          "PriceTime = #{pricetime,jdbcType=TIMESTAMP},",
          "CreateDateTime = #{createDateTime,jdbcType=TIMESTAMP},",
          "LastUpdateTime = #{lastUpdateTime,jdbcType=TIMESTAMP}",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(TransactionCase record);
}