package com.yunfang.dms.dao.mapper;

import com.yunfang.dms.entity.BuildingBaseDataHis;
import com.yunfang.dms.entity.BuildingBaseDataHisCond;
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
public interface BuildingBaseDataHisMapper {
    @SelectProvider(type=BuildingBaseDataHisSqlProvider.class, method="countByExample")
    long countByExample(BuildingBaseDataHisCond example);

    @DeleteProvider(type=BuildingBaseDataHisSqlProvider.class, method="deleteByExample")
    int deleteByExample(BuildingBaseDataHisCond example);

    @Delete({
        "delete from buildingbasedata_his",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into buildingbasedata_his (BuildingID, CityName, ",
        "District, Region, ",
        "Community, BuildingName, ",
        "BuildingAlias, Address, ",
        "BuildYear, TotalFloor, ",
        "TotalHouse, Remark, ",
        "CreateDateTime, Operator, ",
        "ExtendCol)",
        "values (#{buildingid,jdbcType=BIGINT}, #{cityName,jdbcType=VARCHAR}, ",
        "#{district,jdbcType=VARCHAR}, #{region,jdbcType=VARCHAR}, ",
        "#{community,jdbcType=VARCHAR}, #{buildingName,jdbcType=VARCHAR}, ",
        "#{buildingAlias,jdbcType=VARCHAR}, #{address,jdbcType=VARCHAR}, ",
        "#{buildYear,jdbcType=VARCHAR}, #{totalFloor,jdbcType=INTEGER}, ",
        "#{totalHouse,jdbcType=INTEGER}, #{remark,jdbcType=VARCHAR}, ",
        "#{createDateTime,jdbcType=TIMESTAMP}, #{operator,jdbcType=VARCHAR}, ",
        "#{extendCol,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(BuildingBaseDataHis record);

    @InsertProvider(type=BuildingBaseDataHisSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(BuildingBaseDataHis record);

    @SelectProvider(type=BuildingBaseDataHisSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="BuildingID", property="buildingid", jdbcType=JdbcType.BIGINT),
        @Result(column="CityName", property="cityName", jdbcType=JdbcType.VARCHAR),
        @Result(column="District", property="district", jdbcType=JdbcType.VARCHAR),
        @Result(column="Region", property="region", jdbcType=JdbcType.VARCHAR),
        @Result(column="Community", property="community", jdbcType=JdbcType.VARCHAR),
        @Result(column="BuildingName", property="buildingName", jdbcType=JdbcType.VARCHAR),
        @Result(column="BuildingAlias", property="buildingAlias", jdbcType=JdbcType.VARCHAR),
        @Result(column="Address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="BuildYear", property="buildYear", jdbcType=JdbcType.VARCHAR),
        @Result(column="TotalFloor", property="totalFloor", jdbcType=JdbcType.INTEGER),
        @Result(column="TotalHouse", property="totalHouse", jdbcType=JdbcType.INTEGER),
        @Result(column="Remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="CreateDateTime", property="createDateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="Operator", property="operator", jdbcType=JdbcType.VARCHAR),
        @Result(column="ExtendCol", property="extendCol", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<BuildingBaseDataHis> selectByExampleWithBLOBs(BuildingBaseDataHisCond example);

    @SelectProvider(type=BuildingBaseDataHisSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="BuildingID", property="buildingid", jdbcType=JdbcType.BIGINT),
        @Result(column="CityName", property="cityName", jdbcType=JdbcType.VARCHAR),
        @Result(column="District", property="district", jdbcType=JdbcType.VARCHAR),
        @Result(column="Region", property="region", jdbcType=JdbcType.VARCHAR),
        @Result(column="Community", property="community", jdbcType=JdbcType.VARCHAR),
        @Result(column="BuildingName", property="buildingName", jdbcType=JdbcType.VARCHAR),
        @Result(column="BuildingAlias", property="buildingAlias", jdbcType=JdbcType.VARCHAR),
        @Result(column="Address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="BuildYear", property="buildYear", jdbcType=JdbcType.VARCHAR),
        @Result(column="TotalFloor", property="totalFloor", jdbcType=JdbcType.INTEGER),
        @Result(column="TotalHouse", property="totalHouse", jdbcType=JdbcType.INTEGER),
        @Result(column="Remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="CreateDateTime", property="createDateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="Operator", property="operator", jdbcType=JdbcType.VARCHAR)
    })
    List<BuildingBaseDataHis> selectByExample(BuildingBaseDataHisCond example);

    @Select({
        "select",
        "ID, BuildingID, CityName, District, Region, Community, BuildingName, BuildingAlias, ",
        "Address, BuildYear, TotalFloor, TotalHouse, Remark, CreateDateTime, Operator, ",
        "ExtendCol",
        "from buildingbasedata_his",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="BuildingID", property="buildingid", jdbcType=JdbcType.BIGINT),
        @Result(column="CityName", property="cityName", jdbcType=JdbcType.VARCHAR),
        @Result(column="District", property="district", jdbcType=JdbcType.VARCHAR),
        @Result(column="Region", property="region", jdbcType=JdbcType.VARCHAR),
        @Result(column="Community", property="community", jdbcType=JdbcType.VARCHAR),
        @Result(column="BuildingName", property="buildingName", jdbcType=JdbcType.VARCHAR),
        @Result(column="BuildingAlias", property="buildingAlias", jdbcType=JdbcType.VARCHAR),
        @Result(column="Address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="BuildYear", property="buildYear", jdbcType=JdbcType.VARCHAR),
        @Result(column="TotalFloor", property="totalFloor", jdbcType=JdbcType.INTEGER),
        @Result(column="TotalHouse", property="totalHouse", jdbcType=JdbcType.INTEGER),
        @Result(column="Remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="CreateDateTime", property="createDateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="Operator", property="operator", jdbcType=JdbcType.VARCHAR),
        @Result(column="ExtendCol", property="extendCol", jdbcType=JdbcType.LONGVARCHAR)
    })
    BuildingBaseDataHis selectByPrimaryKey(Long id);

    @UpdateProvider(type=BuildingBaseDataHisSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") BuildingBaseDataHis record, @Param("example") BuildingBaseDataHisCond example);

    @UpdateProvider(type=BuildingBaseDataHisSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") BuildingBaseDataHis record, @Param("example") BuildingBaseDataHisCond example);

    @UpdateProvider(type=BuildingBaseDataHisSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") BuildingBaseDataHis record, @Param("example") BuildingBaseDataHisCond example);

    @UpdateProvider(type=BuildingBaseDataHisSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(BuildingBaseDataHis record);

    @Update({
        "update buildingbasedata_his",
        "set BuildingID = #{buildingid,jdbcType=BIGINT},",
          "CityName = #{cityName,jdbcType=VARCHAR},",
          "District = #{district,jdbcType=VARCHAR},",
          "Region = #{region,jdbcType=VARCHAR},",
          "Community = #{community,jdbcType=VARCHAR},",
          "BuildingName = #{buildingName,jdbcType=VARCHAR},",
          "BuildingAlias = #{buildingAlias,jdbcType=VARCHAR},",
          "Address = #{address,jdbcType=VARCHAR},",
          "BuildYear = #{buildYear,jdbcType=VARCHAR},",
          "TotalFloor = #{totalFloor,jdbcType=INTEGER},",
          "TotalHouse = #{totalHouse,jdbcType=INTEGER},",
          "Remark = #{remark,jdbcType=VARCHAR},",
          "CreateDateTime = #{createDateTime,jdbcType=TIMESTAMP},",
          "Operator = #{operator,jdbcType=VARCHAR},",
          "ExtendCol = #{extendCol,jdbcType=LONGVARCHAR}",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(BuildingBaseDataHis record);

    @Update({
        "update buildingbasedata_his",
        "set BuildingID = #{buildingid,jdbcType=BIGINT},",
          "CityName = #{cityName,jdbcType=VARCHAR},",
          "District = #{district,jdbcType=VARCHAR},",
          "Region = #{region,jdbcType=VARCHAR},",
          "Community = #{community,jdbcType=VARCHAR},",
          "BuildingName = #{buildingName,jdbcType=VARCHAR},",
          "BuildingAlias = #{buildingAlias,jdbcType=VARCHAR},",
          "Address = #{address,jdbcType=VARCHAR},",
          "BuildYear = #{buildYear,jdbcType=VARCHAR},",
          "TotalFloor = #{totalFloor,jdbcType=INTEGER},",
          "TotalHouse = #{totalHouse,jdbcType=INTEGER},",
          "Remark = #{remark,jdbcType=VARCHAR},",
          "CreateDateTime = #{createDateTime,jdbcType=TIMESTAMP},",
          "Operator = #{operator,jdbcType=VARCHAR}",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(BuildingBaseDataHis record);
}