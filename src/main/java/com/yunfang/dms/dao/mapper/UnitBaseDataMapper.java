package com.yunfang.dms.dao.mapper;

import com.yunfang.dms.entity.UnitBaseData;
import com.yunfang.dms.entity.UnitBaseDataCond;

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
public interface UnitBaseDataMapper {
    @SelectProvider(type = UnitBaseDataSqlProvider.class, method = "countByExample")
    long countByExample(UnitBaseDataCond example);

    @DeleteProvider(type = UnitBaseDataSqlProvider.class, method = "deleteByExample")
    int deleteByExample(UnitBaseDataCond example);

    @Delete({
            "delete from unitbasedata",
            "where ID = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
            "insert into unitbasedata (CityName, District, ",
            "Region, Community, ",
            "BuildingName, UnitName, ",
            "BuildYear, TotalFloor, ",
            "TotalHouse, Remark, ",
            "CreateDateTime, LastUpdateTime, ",
            "CompanyID, ExtendCol)",
            "values (#{cityName,jdbcType=VARCHAR}, #{district,jdbcType=VARCHAR}, ",
            "#{region,jdbcType=VARCHAR}, #{community,jdbcType=VARCHAR}, ",
            "#{buildingName,jdbcType=VARCHAR}, #{unitName,jdbcType=VARCHAR}, ",
            "#{buildYear,jdbcType=VARCHAR}, #{totalFloor,jdbcType=VARCHAR}, ",
            "#{totalHouse,jdbcType=INTEGER}, #{remark,jdbcType=VARCHAR}, ",
            "#{createDateTime,jdbcType=TIMESTAMP}, #{lastUpdateTime,jdbcType=TIMESTAMP}, ",
            "#{companyId,jdbcType=INTEGER}, #{extendCol,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Long.class)
    int insert(UnitBaseData record);

    @InsertProvider(type = UnitBaseDataSqlProvider.class, method = "insertSelective")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Long.class)
    int insertSelective(UnitBaseData record);

    @SelectProvider(type = UnitBaseDataSqlProvider.class, method = "selectByExampleWithBLOBs")
    @Results({
            @Result(column = "ID", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "CityName", property = "cityName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "District", property = "district", jdbcType = JdbcType.VARCHAR),
            @Result(column = "Region", property = "region", jdbcType = JdbcType.VARCHAR),
            @Result(column = "Community", property = "community", jdbcType = JdbcType.VARCHAR),
            @Result(column = "BuildingName", property = "buildingName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "UnitName", property = "unitName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "BuildYear", property = "buildYear", jdbcType = JdbcType.VARCHAR),
            @Result(column = "TotalFloor", property = "totalFloor", jdbcType = JdbcType.VARCHAR),
            @Result(column = "TotalHouse", property = "totalHouse", jdbcType = JdbcType.INTEGER),
            @Result(column = "Remark", property = "remark", jdbcType = JdbcType.VARCHAR),
            @Result(column = "CreateDateTime", property = "createDateTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "LastUpdateTime", property = "lastUpdateTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "CompanyID", property = "companyId", jdbcType = JdbcType.INTEGER),
            @Result(column = "ExtendCol", property = "extendCol", jdbcType = JdbcType.LONGVARCHAR)
    })
    List<UnitBaseData> selectByExampleWithBLOBs(UnitBaseDataCond example);

    @SelectProvider(type = UnitBaseDataSqlProvider.class, method = "selectByExample")
    @Results({
            @Result(column = "ID", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "CityName", property = "cityName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "District", property = "district", jdbcType = JdbcType.VARCHAR),
            @Result(column = "Region", property = "region", jdbcType = JdbcType.VARCHAR),
            @Result(column = "Community", property = "community", jdbcType = JdbcType.VARCHAR),
            @Result(column = "BuildingName", property = "buildingName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "UnitName", property = "unitName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "BuildYear", property = "buildYear", jdbcType = JdbcType.VARCHAR),
            @Result(column = "TotalFloor", property = "totalFloor", jdbcType = JdbcType.VARCHAR),
            @Result(column = "TotalHouse", property = "totalHouse", jdbcType = JdbcType.INTEGER),
            @Result(column = "Remark", property = "remark", jdbcType = JdbcType.VARCHAR),
            @Result(column = "CreateDateTime", property = "createDateTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "LastUpdateTime", property = "lastUpdateTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "CompanyID", property = "companyId", jdbcType = JdbcType.INTEGER),
            @Result(column = "ExtendCol", property = "extendCol", jdbcType = JdbcType.LONGVARCHAR)
    })
    List<UnitBaseData> selectByExample(UnitBaseDataCond example);

    @Select({
            "select",
            "ID, CityName, District, Region, Community, BuildingName, UnitName, BuildYear, ",
            "TotalFloor, TotalHouse, Remark, CreateDateTime, LastUpdateTime, CompanyID, ExtendCol",
            "from unitbasedata",
            "where ID = #{id,jdbcType=BIGINT}"
    })
    @Results({
            @Result(column = "ID", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "CityName", property = "cityName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "District", property = "district", jdbcType = JdbcType.VARCHAR),
            @Result(column = "Region", property = "region", jdbcType = JdbcType.VARCHAR),
            @Result(column = "Community", property = "community", jdbcType = JdbcType.VARCHAR),
            @Result(column = "BuildingName", property = "buildingName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "UnitName", property = "unitName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "BuildYear", property = "buildYear", jdbcType = JdbcType.VARCHAR),
            @Result(column = "TotalFloor", property = "totalFloor", jdbcType = JdbcType.VARCHAR),
            @Result(column = "TotalHouse", property = "totalHouse", jdbcType = JdbcType.INTEGER),
            @Result(column = "Remark", property = "remark", jdbcType = JdbcType.VARCHAR),
            @Result(column = "CreateDateTime", property = "createDateTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "LastUpdateTime", property = "lastUpdateTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "CompanyID", property = "companyId", jdbcType = JdbcType.INTEGER),
            @Result(column = "ExtendCol", property = "extendCol", jdbcType = JdbcType.LONGVARCHAR)
    })
    UnitBaseData selectByPrimaryKey(Long id);

    @UpdateProvider(type = UnitBaseDataSqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") UnitBaseData record, @Param("example") UnitBaseDataCond example);

    @UpdateProvider(type = UnitBaseDataSqlProvider.class, method = "updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") UnitBaseData record, @Param("example") UnitBaseDataCond example);

    @UpdateProvider(type = UnitBaseDataSqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") UnitBaseData record, @Param("example") UnitBaseDataCond example);

    @UpdateProvider(type = UnitBaseDataSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UnitBaseData record);

    @Update({
            "update unitbasedata",
            "set CityName = #{cityName,jdbcType=VARCHAR},",
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
            "LastUpdateTime = #{lastUpdateTime,jdbcType=TIMESTAMP},",
            "CompanyID = #{companyId,jdbcType=INTEGER},",
            "ExtendCol = #{extendCol,jdbcType=LONGVARCHAR}",
            "where ID = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(UnitBaseData record);

    @Update({
            "update unitbasedata",
            "set CityName = #{cityName,jdbcType=VARCHAR},",
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
            "LastUpdateTime = #{lastUpdateTime,jdbcType=TIMESTAMP},",
            "CompanyID = #{companyId,jdbcType=INTEGER},",
            "ExtendCol = #{extendCol,jdbcType=LONGVARCHAR}",
            "where ID = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(UnitBaseData record);
}