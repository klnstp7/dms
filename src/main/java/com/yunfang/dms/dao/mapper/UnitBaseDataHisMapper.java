package com.yunfang.dms.dao.mapper;

import com.yunfang.dms.entity.UnitBaseDataHis;
import com.yunfang.dms.entity.UnitBaseDataHisCond;
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
public interface UnitBaseDataHisMapper {
    @SelectProvider(type=UnitBaseDataHisSqlProvider.class, method="countByExample")
    long countByExample(UnitBaseDataHisCond example);

    @DeleteProvider(type=UnitBaseDataHisSqlProvider.class, method="deleteByExample")
    int deleteByExample(UnitBaseDataHisCond example);

    @Delete({
        "delete from unitbasedata_his",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into unitbasedata_his (UnitID, CityName, ",
        "District, Region, ",
        "Community, BuildingName, ",
        "UnitName, BuildYear, ",
        "TotalFloor, TotalHouse, ",
        "Remark, CreateDateTime, ",
        "Operator, ExtendCol)",
        "values (#{unitId,jdbcType=BIGINT}, #{cityName,jdbcType=VARCHAR}, ",
        "#{district,jdbcType=VARCHAR}, #{region,jdbcType=VARCHAR}, ",
        "#{community,jdbcType=VARCHAR}, #{buildingName,jdbcType=VARCHAR}, ",
        "#{unitName,jdbcType=VARCHAR}, #{buildYear,jdbcType=VARCHAR}, ",
        "#{totalFloor,jdbcType=VARCHAR}, #{totalHouse,jdbcType=INTEGER}, ",
        "#{remark,jdbcType=VARCHAR}, #{createDateTime,jdbcType=TIMESTAMP}, ",
        "#{operator,jdbcType=VARCHAR}, #{extendCol,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(UnitBaseDataHis record);

    @InsertProvider(type=UnitBaseDataHisSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(UnitBaseDataHis record);

    @SelectProvider(type=UnitBaseDataHisSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="UnitID", property="unitId", jdbcType=JdbcType.BIGINT),
        @Result(column="CityName", property="cityName", jdbcType=JdbcType.VARCHAR),
        @Result(column="District", property="district", jdbcType=JdbcType.VARCHAR),
        @Result(column="Region", property="region", jdbcType=JdbcType.VARCHAR),
        @Result(column="Community", property="community", jdbcType=JdbcType.VARCHAR),
        @Result(column="BuildingName", property="buildingName", jdbcType=JdbcType.VARCHAR),
        @Result(column="UnitName", property="unitName", jdbcType=JdbcType.VARCHAR),
        @Result(column="BuildYear", property="buildYear", jdbcType=JdbcType.VARCHAR),
        @Result(column="TotalFloor", property="totalFloor", jdbcType=JdbcType.VARCHAR),
        @Result(column="TotalHouse", property="totalHouse", jdbcType=JdbcType.INTEGER),
        @Result(column="Remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="CreateDateTime", property="createDateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="Operator", property="operator", jdbcType=JdbcType.VARCHAR),
        @Result(column="ExtendCol", property="extendCol", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<UnitBaseDataHis> selectByExampleWithBLOBs(UnitBaseDataHisCond example);

    @SelectProvider(type=UnitBaseDataHisSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="UnitID", property="unitId", jdbcType=JdbcType.BIGINT),
        @Result(column="CityName", property="cityName", jdbcType=JdbcType.VARCHAR),
        @Result(column="District", property="district", jdbcType=JdbcType.VARCHAR),
        @Result(column="Region", property="region", jdbcType=JdbcType.VARCHAR),
        @Result(column="Community", property="community", jdbcType=JdbcType.VARCHAR),
        @Result(column="BuildingName", property="buildingName", jdbcType=JdbcType.VARCHAR),
        @Result(column="UnitName", property="unitName", jdbcType=JdbcType.VARCHAR),
        @Result(column="BuildYear", property="buildYear", jdbcType=JdbcType.VARCHAR),
        @Result(column="TotalFloor", property="totalFloor", jdbcType=JdbcType.VARCHAR),
        @Result(column="TotalHouse", property="totalHouse", jdbcType=JdbcType.INTEGER),
        @Result(column="Remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="CreateDateTime", property="createDateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="Operator", property="operator", jdbcType=JdbcType.VARCHAR)
    })
    List<UnitBaseDataHis> selectByExample(UnitBaseDataHisCond example);

    @Select({
        "select",
        "ID, UnitID, CityName, District, Region, Community, BuildingName, UnitName, BuildYear, ",
        "TotalFloor, TotalHouse, Remark, CreateDateTime, Operator, ExtendCol",
        "from unitbasedata_his",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="UnitID", property="unitId", jdbcType=JdbcType.BIGINT),
        @Result(column="CityName", property="cityName", jdbcType=JdbcType.VARCHAR),
        @Result(column="District", property="district", jdbcType=JdbcType.VARCHAR),
        @Result(column="Region", property="region", jdbcType=JdbcType.VARCHAR),
        @Result(column="Community", property="community", jdbcType=JdbcType.VARCHAR),
        @Result(column="BuildingName", property="buildingName", jdbcType=JdbcType.VARCHAR),
        @Result(column="UnitName", property="unitName", jdbcType=JdbcType.VARCHAR),
        @Result(column="BuildYear", property="buildYear", jdbcType=JdbcType.VARCHAR),
        @Result(column="TotalFloor", property="totalFloor", jdbcType=JdbcType.VARCHAR),
        @Result(column="TotalHouse", property="totalHouse", jdbcType=JdbcType.INTEGER),
        @Result(column="Remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="CreateDateTime", property="createDateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="Operator", property="operator", jdbcType=JdbcType.VARCHAR),
        @Result(column="ExtendCol", property="extendCol", jdbcType=JdbcType.LONGVARCHAR)
    })
    UnitBaseDataHis selectByPrimaryKey(Long id);

    @UpdateProvider(type=UnitBaseDataHisSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") UnitBaseDataHis record, @Param("example") UnitBaseDataHisCond example);

    @UpdateProvider(type=UnitBaseDataHisSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") UnitBaseDataHis record, @Param("example") UnitBaseDataHisCond example);

    @UpdateProvider(type=UnitBaseDataHisSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") UnitBaseDataHis record, @Param("example") UnitBaseDataHisCond example);

    @UpdateProvider(type=UnitBaseDataHisSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UnitBaseDataHis record);

    @Update({
        "update unitbasedata_his",
        "set UnitID = #{unitId,jdbcType=BIGINT},",
          "CityName = #{cityName,jdbcType=VARCHAR},",
          "District = #{district,jdbcType=VARCHAR},",
          "Region = #{region,jdbcType=VARCHAR},",
          "Community = #{community,jdbcType=VARCHAR},",
          "BuildingName = #{buildingName,jdbcType=VARCHAR},",
          "UnitName = #{unitName,jdbcType=VARCHAR},",
          "BuildYear = #{buildYear,jdbcType=VARCHAR},",
          "TotalFloor = #{totalFloor,jdbcType=VARCHAR},",
          "TotalHouse = #{totalHouse,jdbcType=INTEGER},",
          "Remark = #{remark,jdbcType=VARCHAR},",
          "CreateDateTime = #{createDateTime,jdbcType=TIMESTAMP},",
          "Operator = #{operator,jdbcType=VARCHAR},",
          "ExtendCol = #{extendCol,jdbcType=LONGVARCHAR}",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(UnitBaseDataHis record);

    @Update({
        "update unitbasedata_his",
        "set UnitID = #{unitId,jdbcType=BIGINT},",
          "CityName = #{cityName,jdbcType=VARCHAR},",
          "District = #{district,jdbcType=VARCHAR},",
          "Region = #{region,jdbcType=VARCHAR},",
          "Community = #{community,jdbcType=VARCHAR},",
          "BuildingName = #{buildingName,jdbcType=VARCHAR},",
          "UnitName = #{unitName,jdbcType=VARCHAR},",
          "BuildYear = #{buildYear,jdbcType=VARCHAR},",
          "TotalFloor = #{totalFloor,jdbcType=VARCHAR},",
          "TotalHouse = #{totalHouse,jdbcType=INTEGER},",
          "Remark = #{remark,jdbcType=VARCHAR},",
          "CreateDateTime = #{createDateTime,jdbcType=TIMESTAMP},",
          "Operator = #{operator,jdbcType=VARCHAR}",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(UnitBaseDataHis record);
}