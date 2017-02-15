package com.yunfang.dms.dao.mapper;

import com.yunfang.dms.entity.HouseBaseData;
import com.yunfang.dms.entity.HouseBaseDataCond;
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
public interface HouseBaseDataMapper {
    @SelectProvider(type=HouseBaseDataSqlProvider.class, method="countByExample")
    long countByExample(HouseBaseDataCond example);

    @DeleteProvider(type=HouseBaseDataSqlProvider.class, method="deleteByExample")
    int deleteByExample(HouseBaseDataCond example);

    @Delete({
        "delete from housebasedata",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into housebasedata (CityName, District, ",
        "Region, Community, ",
        "BuildingName, UnitName, ",
        "HouseNum, HouseName, ",
        "Address, Area, UseArea, ",
        "Toward, HouseType, ",
        "Floor, TotalFloor, ",
        "RoomLayout, Remark, ",
        "CreateDateTime, LastUpdateTime, ",
        "CompanyID, ExtendCol)",
        "values (#{cityName,jdbcType=VARCHAR}, #{district,jdbcType=VARCHAR}, ",
        "#{region,jdbcType=VARCHAR}, #{community,jdbcType=VARCHAR}, ",
        "#{buildingName,jdbcType=VARCHAR}, #{unitName,jdbcType=VARCHAR}, ",
        "#{houseNum,jdbcType=VARCHAR}, #{houseName,jdbcType=VARCHAR}, ",
        "#{address,jdbcType=VARCHAR}, #{area,jdbcType=DECIMAL}, #{useArea,jdbcType=DECIMAL}, ",
        "#{toward,jdbcType=VARCHAR}, #{houseType,jdbcType=VARCHAR}, ",
        "#{floor,jdbcType=INTEGER}, #{totalFloor,jdbcType=INTEGER}, ",
        "#{roomLayout,jdbcType=VARCHAR}, #{remark,jdbcType=VARCHAR}, ",
        "#{createDateTime,jdbcType=TIMESTAMP}, #{lastUpdateTime,jdbcType=TIMESTAMP}, ",
        "#{companyId,jdbcType=INTEGER}, #{extendCol,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(HouseBaseData record);

    @InsertProvider(type=HouseBaseDataSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(HouseBaseData record);

    @SelectProvider(type=HouseBaseDataSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="CityName", property="cityName", jdbcType=JdbcType.VARCHAR),
        @Result(column="District", property="district", jdbcType=JdbcType.VARCHAR),
        @Result(column="Region", property="region", jdbcType=JdbcType.VARCHAR),
        @Result(column="Community", property="community", jdbcType=JdbcType.VARCHAR),
        @Result(column="BuildingName", property="buildingName", jdbcType=JdbcType.VARCHAR),
        @Result(column="UnitName", property="unitName", jdbcType=JdbcType.VARCHAR),
        @Result(column="HouseNum", property="houseNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="HouseName", property="houseName", jdbcType=JdbcType.VARCHAR),
        @Result(column="Address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="Area", property="area", jdbcType=JdbcType.DECIMAL),
        @Result(column="UseArea", property="useArea", jdbcType=JdbcType.DECIMAL),
        @Result(column="Toward", property="toward", jdbcType=JdbcType.VARCHAR),
        @Result(column="HouseType", property="houseType", jdbcType=JdbcType.VARCHAR),
        @Result(column="Floor", property="floor", jdbcType=JdbcType.INTEGER),
        @Result(column="TotalFloor", property="totalFloor", jdbcType=JdbcType.INTEGER),
        @Result(column="RoomLayout", property="roomLayout", jdbcType=JdbcType.VARCHAR),
        @Result(column="Remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="CreateDateTime", property="createDateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="LastUpdateTime", property="lastUpdateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="CompanyID", property="companyId", jdbcType=JdbcType.INTEGER),
        @Result(column="ExtendCol", property="extendCol", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<HouseBaseData> selectByExampleWithBLOBs(HouseBaseDataCond example);

    @SelectProvider(type=HouseBaseDataSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="CityName", property="cityName", jdbcType=JdbcType.VARCHAR),
        @Result(column="District", property="district", jdbcType=JdbcType.VARCHAR),
        @Result(column="Region", property="region", jdbcType=JdbcType.VARCHAR),
        @Result(column="Community", property="community", jdbcType=JdbcType.VARCHAR),
        @Result(column="BuildingName", property="buildingName", jdbcType=JdbcType.VARCHAR),
        @Result(column="UnitName", property="unitName", jdbcType=JdbcType.VARCHAR),
        @Result(column="HouseNum", property="houseNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="HouseName", property="houseName", jdbcType=JdbcType.VARCHAR),
        @Result(column="Address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="Area", property="area", jdbcType=JdbcType.DECIMAL),
        @Result(column="UseArea", property="useArea", jdbcType=JdbcType.DECIMAL),
        @Result(column="Toward", property="toward", jdbcType=JdbcType.VARCHAR),
        @Result(column="HouseType", property="houseType", jdbcType=JdbcType.VARCHAR),
        @Result(column="Floor", property="floor", jdbcType=JdbcType.INTEGER),
        @Result(column="TotalFloor", property="totalFloor", jdbcType=JdbcType.INTEGER),
        @Result(column="RoomLayout", property="roomLayout", jdbcType=JdbcType.VARCHAR),
        @Result(column="Remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="CreateDateTime", property="createDateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="LastUpdateTime", property="lastUpdateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="CompanyID", property="companyId", jdbcType=JdbcType.INTEGER)
    })
    List<HouseBaseData> selectByExample(HouseBaseDataCond example);

    @Select({
        "select",
        "ID, CityName, District, Region, Community, BuildingName, UnitName, HouseNum, ",
        "HouseName, Address, Area, UseArea, Toward, HouseType, Floor, TotalFloor, RoomLayout, ",
        "Remark, CreateDateTime, LastUpdateTime, CompanyID, ExtendCol",
        "from housebasedata",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="CityName", property="cityName", jdbcType=JdbcType.VARCHAR),
        @Result(column="District", property="district", jdbcType=JdbcType.VARCHAR),
        @Result(column="Region", property="region", jdbcType=JdbcType.VARCHAR),
        @Result(column="Community", property="community", jdbcType=JdbcType.VARCHAR),
        @Result(column="BuildingName", property="buildingName", jdbcType=JdbcType.VARCHAR),
        @Result(column="UnitName", property="unitName", jdbcType=JdbcType.VARCHAR),
        @Result(column="HouseNum", property="houseNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="HouseName", property="houseName", jdbcType=JdbcType.VARCHAR),
        @Result(column="Address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="Area", property="area", jdbcType=JdbcType.DECIMAL),
        @Result(column="UseArea", property="useArea", jdbcType=JdbcType.DECIMAL),
        @Result(column="Toward", property="toward", jdbcType=JdbcType.VARCHAR),
        @Result(column="HouseType", property="houseType", jdbcType=JdbcType.VARCHAR),
        @Result(column="Floor", property="floor", jdbcType=JdbcType.INTEGER),
        @Result(column="TotalFloor", property="totalFloor", jdbcType=JdbcType.INTEGER),
        @Result(column="RoomLayout", property="roomLayout", jdbcType=JdbcType.VARCHAR),
        @Result(column="Remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="CreateDateTime", property="createDateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="LastUpdateTime", property="lastUpdateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="CompanyID", property="companyId", jdbcType=JdbcType.INTEGER),
        @Result(column="ExtendCol", property="extendCol", jdbcType=JdbcType.LONGVARCHAR)
    })
    HouseBaseData selectByPrimaryKey(Long id);

    @UpdateProvider(type=HouseBaseDataSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") HouseBaseData record, @Param("example") HouseBaseDataCond example);

    @UpdateProvider(type=HouseBaseDataSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") HouseBaseData record, @Param("example") HouseBaseDataCond example);

    @UpdateProvider(type=HouseBaseDataSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") HouseBaseData record, @Param("example") HouseBaseDataCond example);

    @UpdateProvider(type=HouseBaseDataSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(HouseBaseData record);

    @Update({
        "update housebasedata",
        "set CityName = #{cityName,jdbcType=VARCHAR},",
          "District = #{district,jdbcType=VARCHAR},",
          "Region = #{region,jdbcType=VARCHAR},",
          "Community = #{community,jdbcType=VARCHAR},",
          "BuildingName = #{buildingName,jdbcType=VARCHAR},",
          "UnitName = #{unitName,jdbcType=VARCHAR},",
          "HouseNum = #{houseNum,jdbcType=VARCHAR},",
          "HouseName = #{houseName,jdbcType=VARCHAR},",
          "Address = #{address,jdbcType=VARCHAR},",
          "Area = #{area,jdbcType=DECIMAL},",
          "UseArea = #{useArea,jdbcType=DECIMAL},",
          "Toward = #{toward,jdbcType=VARCHAR},",
          "HouseType = #{houseType,jdbcType=VARCHAR},",
          "Floor = #{floor,jdbcType=INTEGER},",
          "TotalFloor = #{totalFloor,jdbcType=INTEGER},",
          "RoomLayout = #{roomLayout,jdbcType=VARCHAR},",
          "Remark = #{remark,jdbcType=VARCHAR},",
          "CreateDateTime = #{createDateTime,jdbcType=TIMESTAMP},",
          "LastUpdateTime = #{lastUpdateTime,jdbcType=TIMESTAMP},",
          "CompanyID = #{companyId,jdbcType=INTEGER},",
          "ExtendCol = #{extendCol,jdbcType=LONGVARCHAR}",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(HouseBaseData record);

    @Update({
        "update housebasedata",
        "set CityName = #{cityName,jdbcType=VARCHAR},",
          "District = #{district,jdbcType=VARCHAR},",
          "Region = #{region,jdbcType=VARCHAR},",
          "Community = #{community,jdbcType=VARCHAR},",
          "BuildingName = #{buildingName,jdbcType=VARCHAR},",
          "UnitName = #{unitName,jdbcType=VARCHAR},",
          "HouseNum = #{houseNum,jdbcType=VARCHAR},",
          "HouseName = #{houseName,jdbcType=VARCHAR},",
          "Address = #{address,jdbcType=VARCHAR},",
          "Area = #{area,jdbcType=DECIMAL},",
          "UseArea = #{useArea,jdbcType=DECIMAL},",
          "Toward = #{toward,jdbcType=VARCHAR},",
          "HouseType = #{houseType,jdbcType=VARCHAR},",
          "Floor = #{floor,jdbcType=INTEGER},",
          "TotalFloor = #{totalFloor,jdbcType=INTEGER},",
          "RoomLayout = #{roomLayout,jdbcType=VARCHAR},",
          "Remark = #{remark,jdbcType=VARCHAR},",
          "CreateDateTime = #{createDateTime,jdbcType=TIMESTAMP},",
          "LastUpdateTime = #{lastUpdateTime,jdbcType=TIMESTAMP},",
          "CompanyID = #{companyId,jdbcType=INTEGER}",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(HouseBaseData record);
}