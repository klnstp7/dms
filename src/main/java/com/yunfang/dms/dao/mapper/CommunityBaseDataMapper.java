package com.yunfang.dms.dao.mapper;

import com.yunfang.dms.entity.CommunityBaseData;
import com.yunfang.dms.entity.CommunityBaseDataCond;
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
public interface CommunityBaseDataMapper {
    @SelectProvider(type=CommunityBaseDataSqlProvider.class, method="countByExample")
    long countByExample(CommunityBaseDataCond example);

    @DeleteProvider(type=CommunityBaseDataSqlProvider.class, method="deleteByExample")
    int deleteByExample(CommunityBaseDataCond example);

    @Delete({
        "delete from communitybasedata",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into communitybasedata (CityName, District, ",
        "Region, Community, ",
        "Alias, Address, ",
        "BuildYear, Developers, ",
        "Area, TotalBuilding, ",
        "TotalHouse, GreenPercent, ",
        "BaseInstallation, Mating, ",
        "TrafficInfo, FeatureMark, ",
        "CompanyID, Remark, ",
        "CreateDateTime, LastUpdateTime, ",
        "ExtendCol)",
        "values (#{cityName,jdbcType=VARCHAR}, #{district,jdbcType=VARCHAR}, ",
        "#{region,jdbcType=VARCHAR}, #{community,jdbcType=VARCHAR}, ",
        "#{alias,jdbcType=VARCHAR}, #{address,jdbcType=VARCHAR}, ",
        "#{buildYear,jdbcType=VARCHAR}, #{developers,jdbcType=VARCHAR}, ",
        "#{area,jdbcType=DECIMAL}, #{totalBuilding,jdbcType=INTEGER}, ",
        "#{totalHouse,jdbcType=INTEGER}, #{greenPercent,jdbcType=DECIMAL}, ",
        "#{baseInstallation,jdbcType=VARCHAR}, #{mating,jdbcType=VARCHAR}, ",
        "#{trafficInfo,jdbcType=VARCHAR}, #{feaTuRemark,jdbcType=VARCHAR}, ",
        "#{companyId,jdbcType=INTEGER}, #{remark,jdbcType=VARCHAR}, ",
        "#{createDateTime,jdbcType=TIMESTAMP}, #{lastUpdateTime,jdbcType=TIMESTAMP}, ",
        "#{extendCol,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(CommunityBaseData record);

    @InsertProvider(type=CommunityBaseDataSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(CommunityBaseData record);

    @SelectProvider(type=CommunityBaseDataSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="CityName", property="cityName", jdbcType=JdbcType.VARCHAR),
        @Result(column="District", property="district", jdbcType=JdbcType.VARCHAR),
        @Result(column="Region", property="region", jdbcType=JdbcType.VARCHAR),
        @Result(column="Community", property="community", jdbcType=JdbcType.VARCHAR),
        @Result(column="Alias", property="alias", jdbcType=JdbcType.VARCHAR),
        @Result(column="Address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="BuildYear", property="buildYear", jdbcType=JdbcType.VARCHAR),
        @Result(column="Developers", property="developers", jdbcType=JdbcType.VARCHAR),
        @Result(column="Area", property="area", jdbcType=JdbcType.DECIMAL),
        @Result(column="TotalBuilding", property="totalBuilding", jdbcType=JdbcType.INTEGER),
        @Result(column="TotalHouse", property="totalHouse", jdbcType=JdbcType.INTEGER),
        @Result(column="GreenPercent", property="greenPercent", jdbcType=JdbcType.DECIMAL),
        @Result(column="BaseInstallation", property="baseInstallation", jdbcType=JdbcType.VARCHAR),
        @Result(column="Mating", property="mating", jdbcType=JdbcType.VARCHAR),
        @Result(column="TrafficInfo", property="trafficInfo", jdbcType=JdbcType.VARCHAR),
        @Result(column="FeatureMark", property="feaTuRemark", jdbcType=JdbcType.VARCHAR),
        @Result(column="CompanyID", property="companyId", jdbcType=JdbcType.INTEGER),
        @Result(column="Remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="CreateDateTime", property="createDateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="LastUpdateTime", property="lastUpdateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="ExtendCol", property="extendCol", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<CommunityBaseData> selectByExampleWithBLOBs(CommunityBaseDataCond example);

    @SelectProvider(type=CommunityBaseDataSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="CityName", property="cityName", jdbcType=JdbcType.VARCHAR),
        @Result(column="District", property="district", jdbcType=JdbcType.VARCHAR),
        @Result(column="Region", property="region", jdbcType=JdbcType.VARCHAR),
        @Result(column="Community", property="community", jdbcType=JdbcType.VARCHAR),
        @Result(column="Alias", property="alias", jdbcType=JdbcType.VARCHAR),
        @Result(column="Address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="BuildYear", property="buildYear", jdbcType=JdbcType.VARCHAR),
        @Result(column="Developers", property="developers", jdbcType=JdbcType.VARCHAR),
        @Result(column="Area", property="area", jdbcType=JdbcType.DECIMAL),
        @Result(column="TotalBuilding", property="totalBuilding", jdbcType=JdbcType.INTEGER),
        @Result(column="TotalHouse", property="totalHouse", jdbcType=JdbcType.INTEGER),
        @Result(column="GreenPercent", property="greenPercent", jdbcType=JdbcType.DECIMAL),
        @Result(column="BaseInstallation", property="baseInstallation", jdbcType=JdbcType.VARCHAR),
        @Result(column="Mating", property="mating", jdbcType=JdbcType.VARCHAR),
        @Result(column="TrafficInfo", property="trafficInfo", jdbcType=JdbcType.VARCHAR),
        @Result(column="FeatureMark", property="feaTuRemark", jdbcType=JdbcType.VARCHAR),
        @Result(column="CompanyID", property="companyId", jdbcType=JdbcType.INTEGER),
        @Result(column="Remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="CreateDateTime", property="createDateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="LastUpdateTime", property="lastUpdateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<CommunityBaseData> selectByExample(CommunityBaseDataCond example);

    @Select({
        "select",
        "ID, CityName, District, Region, Community, Alias, Address, BuildYear, Developers, ",
        "Area, TotalBuilding, TotalHouse, GreenPercent, BaseInstallation, Mating, TrafficInfo, ",
        "FeatureMark, CompanyID, Remark, CreateDateTime, LastUpdateTime, ExtendCol",
        "from communitybasedata",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="CityName", property="cityName", jdbcType=JdbcType.VARCHAR),
        @Result(column="District", property="district", jdbcType=JdbcType.VARCHAR),
        @Result(column="Region", property="region", jdbcType=JdbcType.VARCHAR),
        @Result(column="Community", property="community", jdbcType=JdbcType.VARCHAR),
        @Result(column="Alias", property="alias", jdbcType=JdbcType.VARCHAR),
        @Result(column="Address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="BuildYear", property="buildYear", jdbcType=JdbcType.VARCHAR),
        @Result(column="Developers", property="developers", jdbcType=JdbcType.VARCHAR),
        @Result(column="Area", property="area", jdbcType=JdbcType.DECIMAL),
        @Result(column="TotalBuilding", property="totalBuilding", jdbcType=JdbcType.INTEGER),
        @Result(column="TotalHouse", property="totalHouse", jdbcType=JdbcType.INTEGER),
        @Result(column="GreenPercent", property="greenPercent", jdbcType=JdbcType.DECIMAL),
        @Result(column="BaseInstallation", property="baseInstallation", jdbcType=JdbcType.VARCHAR),
        @Result(column="Mating", property="mating", jdbcType=JdbcType.VARCHAR),
        @Result(column="TrafficInfo", property="trafficInfo", jdbcType=JdbcType.VARCHAR),
        @Result(column="FeatureMark", property="feaTuRemark", jdbcType=JdbcType.VARCHAR),
        @Result(column="CompanyID", property="companyId", jdbcType=JdbcType.INTEGER),
        @Result(column="Remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="CreateDateTime", property="createDateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="LastUpdateTime", property="lastUpdateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="ExtendCol", property="extendCol", jdbcType=JdbcType.LONGVARCHAR)
    })
    CommunityBaseData selectByPrimaryKey(Long id);

    @UpdateProvider(type=CommunityBaseDataSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CommunityBaseData record, @Param("example") CommunityBaseDataCond example);

    @UpdateProvider(type=CommunityBaseDataSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") CommunityBaseData record, @Param("example") CommunityBaseDataCond example);

    @UpdateProvider(type=CommunityBaseDataSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CommunityBaseData record, @Param("example") CommunityBaseDataCond example);

    @UpdateProvider(type=CommunityBaseDataSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CommunityBaseData record);

    @Update({
        "update communitybasedata",
        "set CityName = #{cityName,jdbcType=VARCHAR},",
          "District = #{district,jdbcType=VARCHAR},",
          "Region = #{region,jdbcType=VARCHAR},",
          "Community = #{community,jdbcType=VARCHAR},",
          "Alias = #{alias,jdbcType=VARCHAR},",
          "Address = #{address,jdbcType=VARCHAR},",
          "BuildYear = #{buildYear,jdbcType=VARCHAR},",
          "Developers = #{developers,jdbcType=VARCHAR},",
          "Area = #{area,jdbcType=DECIMAL},",
          "TotalBuilding = #{totalBuilding,jdbcType=INTEGER},",
          "TotalHouse = #{totalHouse,jdbcType=INTEGER},",
          "GreenPercent = #{greenPercent,jdbcType=DECIMAL},",
          "BaseInstallation = #{baseInstallation,jdbcType=VARCHAR},",
          "Mating = #{mating,jdbcType=VARCHAR},",
          "TrafficInfo = #{trafficInfo,jdbcType=VARCHAR},",
          "FeatureMark = #{feaTuRemark,jdbcType=VARCHAR},",
          "CompanyID = #{companyId,jdbcType=INTEGER},",
          "Remark = #{remark,jdbcType=VARCHAR},",
          "CreateDateTime = #{createDateTime,jdbcType=TIMESTAMP},",
          "LastUpdateTime = #{lastUpdateTime,jdbcType=TIMESTAMP},",
          "ExtendCol = #{extendCol,jdbcType=LONGVARCHAR}",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(CommunityBaseData record);

    @Update({
        "update communitybasedata",
        "set CityName = #{cityName,jdbcType=VARCHAR},",
          "District = #{district,jdbcType=VARCHAR},",
          "Region = #{region,jdbcType=VARCHAR},",
          "Community = #{community,jdbcType=VARCHAR},",
          "Alias = #{alias,jdbcType=VARCHAR},",
          "Address = #{address,jdbcType=VARCHAR},",
          "BuildYear = #{buildYear,jdbcType=VARCHAR},",
          "Developers = #{developers,jdbcType=VARCHAR},",
          "Area = #{area,jdbcType=DECIMAL},",
          "TotalBuilding = #{totalBuilding,jdbcType=INTEGER},",
          "TotalHouse = #{totalHouse,jdbcType=INTEGER},",
          "GreenPercent = #{greenPercent,jdbcType=DECIMAL},",
          "BaseInstallation = #{baseInstallation,jdbcType=VARCHAR},",
          "Mating = #{mating,jdbcType=VARCHAR},",
          "TrafficInfo = #{trafficInfo,jdbcType=VARCHAR},",
          "FeatureMark = #{feaTuRemark,jdbcType=VARCHAR},",
          "CompanyID = #{companyId,jdbcType=INTEGER},",
          "Remark = #{remark,jdbcType=VARCHAR},",
          "CreateDateTime = #{createDateTime,jdbcType=TIMESTAMP},",
          "LastUpdateTime = #{lastUpdateTime,jdbcType=TIMESTAMP}",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(CommunityBaseData record);
}