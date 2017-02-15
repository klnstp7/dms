package com.yunfang.dms.dao.mapper;

import com.yunfang.dms.entity.HouseBaseDataHis;
import com.yunfang.dms.entity.HouseBaseDataHisCond;
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
public interface HouseBaseDataHisMapper {
    @SelectProvider(type=HouseBaseDataHisSqlProvider.class, method="countByExample")
    long countByExample(HouseBaseDataHisCond example);

    @DeleteProvider(type=HouseBaseDataHisSqlProvider.class, method="deleteByExample")
    int deleteByExample(HouseBaseDataHisCond example);

    @Delete({
        "delete from housebasedata_his",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into housebasedata_his (HouseID, CityName, ",
        "District, Region, ",
        "Community, BuildingName, ",
        "UnitName, HouseNum, ",
        "HouseName, Address, ",
        "Area, UseArea, Toward, ",
        "HouseType, Floor, ",
        "TotalFloor, RoomLayout, ",
        "Remark, CreateDateTime, ",
        "Operator, ExtendCol)",
        "values (#{houseId,jdbcType=BIGINT}, #{cityName,jdbcType=VARCHAR}, ",
        "#{district,jdbcType=VARCHAR}, #{region,jdbcType=VARCHAR}, ",
        "#{community,jdbcType=VARCHAR}, #{buildingName,jdbcType=VARCHAR}, ",
        "#{unitName,jdbcType=VARCHAR}, #{houseNum,jdbcType=VARCHAR}, ",
        "#{houseName,jdbcType=VARCHAR}, #{address,jdbcType=VARCHAR}, ",
        "#{area,jdbcType=DECIMAL}, #{useArea,jdbcType=DECIMAL}, #{toward,jdbcType=VARCHAR}, ",
        "#{houseType,jdbcType=VARCHAR}, #{floor,jdbcType=INTEGER}, ",
        "#{totalFloor,jdbcType=INTEGER}, #{roomLayout,jdbcType=VARCHAR}, ",
        "#{remark,jdbcType=VARCHAR}, #{createDateTime,jdbcType=TIMESTAMP}, ",
        "#{operator,jdbcType=VARCHAR}, #{extendCol,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(HouseBaseDataHis record);

    @InsertProvider(type=HouseBaseDataHisSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(HouseBaseDataHis record);

    @SelectProvider(type=HouseBaseDataHisSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="HouseID", property="houseId", jdbcType=JdbcType.BIGINT),
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
        @Result(column="Operator", property="operator", jdbcType=JdbcType.VARCHAR),
        @Result(column="ExtendCol", property="extendCol", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<HouseBaseDataHis> selectByExampleWithBLOBs(HouseBaseDataHisCond example);

    @SelectProvider(type=HouseBaseDataHisSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="HouseID", property="houseId", jdbcType=JdbcType.BIGINT),
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
        @Result(column="Operator", property="operator", jdbcType=JdbcType.VARCHAR)
    })
    List<HouseBaseDataHis> selectByExample(HouseBaseDataHisCond example);

    @Select({
        "select",
        "ID, HouseID, CityName, District, Region, Community, BuildingName, UnitName, ",
        "HouseNum, HouseName, Address, Area, UseArea, Toward, HouseType, Floor, TotalFloor, ",
        "RoomLayout, Remark, CreateDateTime, Operator, ExtendCol",
        "from housebasedata_his",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="HouseID", property="houseId", jdbcType=JdbcType.BIGINT),
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
        @Result(column="Operator", property="operator", jdbcType=JdbcType.VARCHAR),
        @Result(column="ExtendCol", property="extendCol", jdbcType=JdbcType.LONGVARCHAR)
    })
    HouseBaseDataHis selectByPrimaryKey(Long id);

    @UpdateProvider(type=HouseBaseDataHisSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") HouseBaseDataHis record, @Param("example") HouseBaseDataHisCond example);

    @UpdateProvider(type=HouseBaseDataHisSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") HouseBaseDataHis record, @Param("example") HouseBaseDataHisCond example);

    @UpdateProvider(type=HouseBaseDataHisSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") HouseBaseDataHis record, @Param("example") HouseBaseDataHisCond example);

    @UpdateProvider(type=HouseBaseDataHisSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(HouseBaseDataHis record);

    @Update({
        "update housebasedata_his",
        "set HouseID = #{houseId,jdbcType=BIGINT},",
          "CityName = #{cityName,jdbcType=VARCHAR},",
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
          "Operator = #{operator,jdbcType=VARCHAR},",
          "ExtendCol = #{extendCol,jdbcType=LONGVARCHAR}",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(HouseBaseDataHis record);

    @Update({
        "update housebasedata_his",
        "set HouseID = #{houseId,jdbcType=BIGINT},",
          "CityName = #{cityName,jdbcType=VARCHAR},",
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
          "Operator = #{operator,jdbcType=VARCHAR}",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(HouseBaseDataHis record);
}