package com.yunfang.dms.dao.mapper;

import com.yunfang.dms.entity.BuildingBaseData;
import com.yunfang.dms.entity.BuildingBaseDataCond;
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
public interface BuildingBaseDataMapper {
    @SelectProvider(type=BuildingBaseDataSqlProvider.class, method="countByExample")
    long countByExample(BuildingBaseDataCond example);

    @DeleteProvider(type=BuildingBaseDataSqlProvider.class, method="deleteByExample")
    int deleteByExample(BuildingBaseDataCond example);

    @Delete({
        "delete from buildingbasedata",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into buildingbasedata (CityName, District, ",
        "Region, Community, ",
        "BuildingName, BuildingAlias, ",
        "Address, BuildYear, ",
        "TotalFloor, TotalHouse, ",
        "Remark, CreateDateTime, ",
        "LastUpdateTime, CompanyID, ",
        "ExtendCol)",
        "values (#{cityName,jdbcType=VARCHAR}, #{district,jdbcType=VARCHAR}, ",
        "#{region,jdbcType=VARCHAR}, #{community,jdbcType=VARCHAR}, ",
        "#{buildingName,jdbcType=VARCHAR}, #{buildingAlias,jdbcType=VARCHAR}, ",
        "#{address,jdbcType=VARCHAR}, #{buildYear,jdbcType=VARCHAR}, ",
        "#{totalFloor,jdbcType=INTEGER}, #{totalHouse,jdbcType=INTEGER}, ",
        "#{remark,jdbcType=VARCHAR}, #{createDateTime,jdbcType=TIMESTAMP}, ",
        "#{lastUpdateTime,jdbcType=TIMESTAMP}, #{companyId,jdbcType=INTEGER}, ",
        "#{extendCol,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(BuildingBaseData record);

    @InsertProvider(type=BuildingBaseDataSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(BuildingBaseData record);

    @SelectProvider(type=BuildingBaseDataSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
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
        @Result(column="LastUpdateTime", property="lastUpdateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="CompanyID", property="companyId", jdbcType=JdbcType.INTEGER),
        @Result(column="ExtendCol", property="extendCol", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<BuildingBaseData> selectByExampleWithBLOBs(BuildingBaseDataCond example);

    @SelectProvider(type=BuildingBaseDataSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
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
        @Result(column="LastUpdateTime", property="lastUpdateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="CompanyID", property="companyId", jdbcType=JdbcType.INTEGER)
    })
    List<BuildingBaseData> selectByExample(BuildingBaseDataCond example);

    @Select({
        "select",
        "ID, CityName, District, Region, Community, BuildingName, BuildingAlias, Address, ",
        "BuildYear, TotalFloor, TotalHouse, Remark, CreateDateTime, LastUpdateTime, CompanyID, ",
        "ExtendCol",
        "from buildingbasedata",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
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
        @Result(column="LastUpdateTime", property="lastUpdateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="CompanyID", property="companyId", jdbcType=JdbcType.INTEGER),
        @Result(column="ExtendCol", property="extendCol", jdbcType=JdbcType.LONGVARCHAR)
    })
    BuildingBaseData selectByPrimaryKey(Long id);

    @UpdateProvider(type=BuildingBaseDataSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") BuildingBaseData record, @Param("example") BuildingBaseDataCond example);

    @UpdateProvider(type=BuildingBaseDataSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") BuildingBaseData record, @Param("example") BuildingBaseDataCond example);

    @UpdateProvider(type=BuildingBaseDataSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") BuildingBaseData record, @Param("example") BuildingBaseDataCond example);

    @UpdateProvider(type=BuildingBaseDataSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(BuildingBaseData record);

    @Update({
        "update buildingbasedata",
        "set CityName = #{cityName,jdbcType=VARCHAR},",
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
          "LastUpdateTime = #{lastUpdateTime,jdbcType=TIMESTAMP},",
          "CompanyID = #{companyId,jdbcType=INTEGER},",
          "ExtendCol = #{extendCol,jdbcType=LONGVARCHAR}",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(BuildingBaseData record);

    @Update({
        "update buildingbasedata",
        "set CityName = #{cityName,jdbcType=VARCHAR},",
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
          "LastUpdateTime = #{lastUpdateTime,jdbcType=TIMESTAMP},",
          "CompanyID = #{companyId,jdbcType=INTEGER}",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(BuildingBaseData record);
}