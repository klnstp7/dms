package com.yunfang.dms.dao.mapper;

import com.yunfang.dms.entity.OfferCase;
import com.yunfang.dms.entity.OfferCaseCond;
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
public interface OfferCaseMapper {
    @SelectProvider(type=OfferCaseSqlProvider.class, method="countByExample")
    long countByExample(OfferCaseCond example);

    @DeleteProvider(type=OfferCaseSqlProvider.class, method="deleteByExample")
    int deleteByExample(OfferCaseCond example);

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
        "BuildYear2, Area, ",
        "Price, TotalPrice, ",
        "Remark, OfferTime, ",
        "DataSource, CreateDateTime, ",
        "Operator, ExtendCol)",
        "values (#{offerCaseId,jdbcType=BIGINT}, #{cityName,jdbcType=VARCHAR}, ",
        "#{district,jdbcType=VARCHAR}, #{region,jdbcType=VARCHAR}, ",
        "#{community,jdbcType=VARCHAR}, #{address,jdbcType=VARCHAR}, ",
        "#{roomLayout,jdbcType=VARCHAR}, #{floor,jdbcType=INTEGER}, ",
        "#{totalFloor,jdbcType=INTEGER}, #{toward,jdbcType=VARCHAR}, ",
        "#{buildyear2,jdbcType=VARCHAR}, #{area,jdbcType=DECIMAL}, ",
        "#{price,jdbcType=DECIMAL}, #{totalPrice,jdbcType=DECIMAL}, ",
        "#{remark,jdbcType=VARCHAR}, #{offerTime,jdbcType=TIMESTAMP}, ",
        "#{dataSource,jdbcType=VARCHAR}, #{createDateTime,jdbcType=TIMESTAMP}, ",
        "#{operator,jdbcType=VARCHAR}, #{extendCol,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(OfferCase record);

    @InsertProvider(type=OfferCaseSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(OfferCase record);

    @SelectProvider(type=OfferCaseSqlProvider.class, method="selectByExampleWithBLOBs")
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
        @Result(column="BuildYear2", property="buildyear2", jdbcType=JdbcType.VARCHAR),
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
    List<OfferCase> selectByExampleWithBLOBs(OfferCaseCond example);

    @SelectProvider(type=OfferCaseSqlProvider.class, method="selectByExample")
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
        @Result(column="BuildYear2", property="buildyear2", jdbcType=JdbcType.VARCHAR),
        @Result(column="Area", property="area", jdbcType=JdbcType.DECIMAL),
        @Result(column="Price", property="price", jdbcType=JdbcType.DECIMAL),
        @Result(column="TotalPrice", property="totalPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="Remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="OfferTime", property="offerTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="DataSource", property="dataSource", jdbcType=JdbcType.VARCHAR),
        @Result(column="CreateDateTime", property="createDateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="Operator", property="operator", jdbcType=JdbcType.VARCHAR)
    })
    List<OfferCase> selectByExample(OfferCaseCond example);

    @Select({
        "select",
        "ID, OfferCaseID, CityName, District, Region, Community, Address, RoomLayout, ",
        "Floor, TotalFloor, Toward, BuildYear2, Area, Price, TotalPrice, Remark, OfferTime, ",
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
        @Result(column="BuildYear2", property="buildyear2", jdbcType=JdbcType.VARCHAR),
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
    OfferCase selectByPrimaryKey(Long id);

    @UpdateProvider(type=OfferCaseSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OfferCase record, @Param("example") OfferCaseCond example);

    @UpdateProvider(type=OfferCaseSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") OfferCase record, @Param("example") OfferCaseCond example);

    @UpdateProvider(type=OfferCaseSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OfferCase record, @Param("example") OfferCaseCond example);

    @UpdateProvider(type=OfferCaseSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OfferCase record);

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
          "BuildYear2 = #{buildyear2,jdbcType=VARCHAR},",
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
    int updateByPrimaryKeyWithBLOBs(OfferCase record);

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
          "BuildYear2 = #{buildyear2,jdbcType=VARCHAR},",
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
    int updateByPrimaryKey(OfferCase record);
}