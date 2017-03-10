package com.yunfang.dms.dao.mapper;

import com.yunfang.dms.entity.OfferCaseHis;
import com.yunfang.dms.entity.OfferCaseHisCond;
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
public interface OfferCaseHisMapper {
    @SelectProvider(type=OfferCaseHisSqlProvider.class, method="countByExample")
    long countByExample(OfferCaseHisCond example);

    @DeleteProvider(type=OfferCaseHisSqlProvider.class, method="deleteByExample")
    int deleteByExample(OfferCaseHisCond example);

    @Delete({
        "delete from offercase_his",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into offercase_his (OfferCaseID, CityName, ",
        "District, Region, ",
        "Community, Address, ",
        "RoomLayout, Floor, ",
        "TotalFloor, Toward, ",
        "BuildYear, Area, ",
        "Price, TotalPrice, ",
        "Remark, OfferTime, ",
        "DataSource, CreateDateTime, ",
        "Operator, ExtendCol)",
        "values (#{offerCaseId,jdbcType=BIGINT}, #{cityName,jdbcType=VARCHAR}, ",
        "#{district,jdbcType=VARCHAR}, #{region,jdbcType=VARCHAR}, ",
        "#{community,jdbcType=VARCHAR}, #{address,jdbcType=VARCHAR}, ",
        "#{roomLayout,jdbcType=VARCHAR}, #{floor,jdbcType=INTEGER}, ",
        "#{totalFloor,jdbcType=INTEGER}, #{toward,jdbcType=VARCHAR}, ",
        "#{buildYear,jdbcType=VARCHAR}, #{area,jdbcType=DECIMAL}, ",
        "#{price,jdbcType=DECIMAL}, #{totalPrice,jdbcType=DECIMAL}, ",
        "#{remark,jdbcType=VARCHAR}, #{offerTime,jdbcType=TIMESTAMP}, ",
        "#{dataSource,jdbcType=VARCHAR}, #{createDateTime,jdbcType=TIMESTAMP}, ",
        "#{operator,jdbcType=VARCHAR}, #{extendCol,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(OfferCaseHis record);

    @InsertProvider(type=OfferCaseHisSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(OfferCaseHis record);

    @SelectProvider(type=OfferCaseHisSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="OfferCaseID", property="offerCaseId", jdbcType=JdbcType.BIGINT),
        @Result(column="CityName", property="cityName", jdbcType=JdbcType.VARCHAR),
        @Result(column="District", property="district", jdbcType=JdbcType.VARCHAR),
        @Result(column="Region", property="region", jdbcType=JdbcType.VARCHAR),
        @Result(column="Community", property="community", jdbcType=JdbcType.VARCHAR),
        @Result(column="Address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="RoomLayout", property="roomLayout", jdbcType=JdbcType.VARCHAR),
        @Result(column="Floor", property="floor", jdbcType=JdbcType.INTEGER),
        @Result(column="TotalFloor", property="totalFloor", jdbcType=JdbcType.INTEGER),
        @Result(column="Toward", property="toward", jdbcType=JdbcType.VARCHAR),
        @Result(column="BuildYear", property="buildYear", jdbcType=JdbcType.VARCHAR),
        @Result(column="Area", property="area", jdbcType=JdbcType.DECIMAL),
        @Result(column="Price", property="price", jdbcType=JdbcType.DECIMAL),
        @Result(column="TotalPrice", property="totalPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="Remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="OfferTime", property="offerTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="DataSource", property="dataSource", jdbcType=JdbcType.VARCHAR),
        @Result(column="CreateDateTime", property="createDateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="Operator", property="operator", jdbcType=JdbcType.VARCHAR),
        @Result(column="ExtendCol", property="extendCol", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<OfferCaseHis> selectByExampleWithBLOBs(OfferCaseHisCond example);

    @SelectProvider(type=OfferCaseHisSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="OfferCaseID", property="offerCaseId", jdbcType=JdbcType.BIGINT),
        @Result(column="CityName", property="cityName", jdbcType=JdbcType.VARCHAR),
        @Result(column="District", property="district", jdbcType=JdbcType.VARCHAR),
        @Result(column="Region", property="region", jdbcType=JdbcType.VARCHAR),
        @Result(column="Community", property="community", jdbcType=JdbcType.VARCHAR),
        @Result(column="Address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="RoomLayout", property="roomLayout", jdbcType=JdbcType.VARCHAR),
        @Result(column="Floor", property="floor", jdbcType=JdbcType.INTEGER),
        @Result(column="TotalFloor", property="totalFloor", jdbcType=JdbcType.INTEGER),
        @Result(column="Toward", property="toward", jdbcType=JdbcType.VARCHAR),
        @Result(column="BuildYear", property="buildYear", jdbcType=JdbcType.VARCHAR),
        @Result(column="Area", property="area", jdbcType=JdbcType.DECIMAL),
        @Result(column="Price", property="price", jdbcType=JdbcType.DECIMAL),
        @Result(column="TotalPrice", property="totalPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="Remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="OfferTime", property="offerTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="DataSource", property="dataSource", jdbcType=JdbcType.VARCHAR),
        @Result(column="CreateDateTime", property="createDateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="Operator", property="operator", jdbcType=JdbcType.VARCHAR)
    })
    List<OfferCaseHis> selectByExample(OfferCaseHisCond example);

    @Select({
        "select",
        "ID, OfferCaseID, CityName, District, Region, Community, Address, RoomLayout, ",
        "Floor, TotalFloor, Toward, BuildYear, Area, Price, TotalPrice, Remark, OfferTime, ",
        "DataSource, CreateDateTime, Operator, ExtendCol",
        "from offercase_his",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="OfferCaseID", property="offerCaseId", jdbcType=JdbcType.BIGINT),
        @Result(column="CityName", property="cityName", jdbcType=JdbcType.VARCHAR),
        @Result(column="District", property="district", jdbcType=JdbcType.VARCHAR),
        @Result(column="Region", property="region", jdbcType=JdbcType.VARCHAR),
        @Result(column="Community", property="community", jdbcType=JdbcType.VARCHAR),
        @Result(column="Address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="RoomLayout", property="roomLayout", jdbcType=JdbcType.VARCHAR),
        @Result(column="Floor", property="floor", jdbcType=JdbcType.INTEGER),
        @Result(column="TotalFloor", property="totalFloor", jdbcType=JdbcType.INTEGER),
        @Result(column="Toward", property="toward", jdbcType=JdbcType.VARCHAR),
        @Result(column="BuildYear", property="buildYear", jdbcType=JdbcType.VARCHAR),
        @Result(column="Area", property="area", jdbcType=JdbcType.DECIMAL),
        @Result(column="Price", property="price", jdbcType=JdbcType.DECIMAL),
        @Result(column="TotalPrice", property="totalPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="Remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="OfferTime", property="offerTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="DataSource", property="dataSource", jdbcType=JdbcType.VARCHAR),
        @Result(column="CreateDateTime", property="createDateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="Operator", property="operator", jdbcType=JdbcType.VARCHAR),
        @Result(column="ExtendCol", property="extendCol", jdbcType=JdbcType.LONGVARCHAR)
    })
    OfferCaseHis selectByPrimaryKey(Long id);

    @UpdateProvider(type=OfferCaseHisSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OfferCaseHis record, @Param("example") OfferCaseHisCond example);

    @UpdateProvider(type=OfferCaseHisSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") OfferCaseHis record, @Param("example") OfferCaseHisCond example);

    @UpdateProvider(type=OfferCaseHisSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OfferCaseHis record, @Param("example") OfferCaseHisCond example);

    @UpdateProvider(type=OfferCaseHisSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OfferCaseHis record);

    @Update({
        "update offercase_his",
        "set OfferCaseID = #{offerCaseId,jdbcType=BIGINT},",
          "CityName = #{cityName,jdbcType=VARCHAR},",
          "District = #{district,jdbcType=VARCHAR},",
          "Region = #{region,jdbcType=VARCHAR},",
          "Community = #{community,jdbcType=VARCHAR},",
          "Address = #{address,jdbcType=VARCHAR},",
          "RoomLayout = #{roomLayout,jdbcType=VARCHAR},",
          "Floor = #{floor,jdbcType=INTEGER},",
          "TotalFloor = #{totalFloor,jdbcType=INTEGER},",
          "Toward = #{toward,jdbcType=VARCHAR},",
          "BuildYear = #{buildYear,jdbcType=VARCHAR},",
          "Area = #{area,jdbcType=DECIMAL},",
          "Price = #{price,jdbcType=DECIMAL},",
          "TotalPrice = #{totalPrice,jdbcType=DECIMAL},",
          "Remark = #{remark,jdbcType=VARCHAR},",
          "OfferTime = #{offerTime,jdbcType=TIMESTAMP},",
          "DataSource = #{dataSource,jdbcType=VARCHAR},",
          "CreateDateTime = #{createDateTime,jdbcType=TIMESTAMP},",
          "Operator = #{operator,jdbcType=VARCHAR},",
          "ExtendCol = #{extendCol,jdbcType=LONGVARCHAR}",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(OfferCaseHis record);

    @Update({
        "update offercase_his",
        "set OfferCaseID = #{offerCaseId,jdbcType=BIGINT},",
          "CityName = #{cityName,jdbcType=VARCHAR},",
          "District = #{district,jdbcType=VARCHAR},",
          "Region = #{region,jdbcType=VARCHAR},",
          "Community = #{community,jdbcType=VARCHAR},",
          "Address = #{address,jdbcType=VARCHAR},",
          "RoomLayout = #{roomLayout,jdbcType=VARCHAR},",
          "Floor = #{floor,jdbcType=INTEGER},",
          "TotalFloor = #{totalFloor,jdbcType=INTEGER},",
          "Toward = #{toward,jdbcType=VARCHAR},",
          "BuildYear = #{buildYear,jdbcType=VARCHAR},",
          "Area = #{area,jdbcType=DECIMAL},",
          "Price = #{price,jdbcType=DECIMAL},",
          "TotalPrice = #{totalPrice,jdbcType=DECIMAL},",
          "Remark = #{remark,jdbcType=VARCHAR},",
          "OfferTime = #{offerTime,jdbcType=TIMESTAMP},",
          "DataSource = #{dataSource,jdbcType=VARCHAR},",
          "CreateDateTime = #{createDateTime,jdbcType=TIMESTAMP},",
          "Operator = #{operator,jdbcType=VARCHAR}",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(OfferCaseHis record);
}