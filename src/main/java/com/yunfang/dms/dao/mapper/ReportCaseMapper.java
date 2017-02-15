package com.yunfang.dms.dao.mapper;

import com.yunfang.dms.entity.ReportCase;
import com.yunfang.dms.entity.ReportCaseCond;
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
public interface ReportCaseMapper {
    @SelectProvider(type=ReportCaseSqlProvider.class, method="countByExample")
    long countByExample(ReportCaseCond example);

    @DeleteProvider(type=ReportCaseSqlProvider.class, method="deleteByExample")
    int deleteByExample(ReportCaseCond example);

    @Delete({
        "delete from reportcase",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into reportcase (CityName, District, ",
        "Region, ReportNo, ",
        "ReportTime, Community, ",
        "Address, BuildingName, ",
        "RoomLayout, HouseName, ",
        "Floor, TotalFloor, ",
        "Toward, BuildYear, ",
        "Area, TotalPrice, ",
        "Purpose, HouseProperty, ",
        "BuildType, Decoration, ",
        "CustomerInfo, RoomProperty, ",
        "Remark, CompanyID, ",
        "CreateDateTime, LastUpdateTime, ",
        "ExtendCol)",
        "values (#{cityName,jdbcType=VARCHAR}, #{district,jdbcType=VARCHAR}, ",
        "#{region,jdbcType=VARCHAR}, #{reportNo,jdbcType=VARCHAR}, ",
        "#{reportTime,jdbcType=TIMESTAMP}, #{community,jdbcType=VARCHAR}, ",
        "#{address,jdbcType=VARCHAR}, #{buildingName,jdbcType=VARCHAR}, ",
        "#{roomLayout,jdbcType=VARCHAR}, #{houseName,jdbcType=VARCHAR}, ",
        "#{floor,jdbcType=INTEGER}, #{totalFloor,jdbcType=INTEGER}, ",
        "#{toward,jdbcType=VARCHAR}, #{buildYear,jdbcType=VARCHAR}, ",
        "#{area,jdbcType=DECIMAL}, #{totalprice,jdbcType=DECIMAL}, ",
        "#{purpose,jdbcType=VARCHAR}, #{houseProperty,jdbcType=VARCHAR}, ",
        "#{buildType,jdbcType=VARCHAR}, #{decoration,jdbcType=VARCHAR}, ",
        "#{customerInfo,jdbcType=VARCHAR}, #{roomProerty,jdbcType=VARCHAR}, ",
        "#{remark,jdbcType=VARCHAR}, #{companyId,jdbcType=INTEGER}, ",
        "#{createDateTime,jdbcType=TIMESTAMP}, #{lastUpdateTime,jdbcType=TIMESTAMP}, ",
        "#{extendCol,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(ReportCase record);

    @InsertProvider(type=ReportCaseSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(ReportCase record);

    @SelectProvider(type=ReportCaseSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="CityName", property="cityName", jdbcType=JdbcType.VARCHAR),
        @Result(column="District", property="district", jdbcType=JdbcType.VARCHAR),
        @Result(column="Region", property="region", jdbcType=JdbcType.VARCHAR),
        @Result(column="ReportNo", property="reportNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="ReportTime", property="reportTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="Community", property="community", jdbcType=JdbcType.VARCHAR),
        @Result(column="Address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="BuildingName", property="buildingName", jdbcType=JdbcType.VARCHAR),
        @Result(column="RoomLayout", property="roomLayout", jdbcType=JdbcType.VARCHAR),
        @Result(column="HouseName", property="houseName", jdbcType=JdbcType.VARCHAR),
        @Result(column="Floor", property="floor", jdbcType=JdbcType.INTEGER),
        @Result(column="TotalFloor", property="totalFloor", jdbcType=JdbcType.INTEGER),
        @Result(column="Toward", property="toward", jdbcType=JdbcType.VARCHAR),
        @Result(column="BuildYear", property="buildYear", jdbcType=JdbcType.VARCHAR),
        @Result(column="Area", property="area", jdbcType=JdbcType.DECIMAL),
        @Result(column="TotalPrice", property="totalprice", jdbcType=JdbcType.DECIMAL),
        @Result(column="Purpose", property="purpose", jdbcType=JdbcType.VARCHAR),
        @Result(column="HouseProperty", property="houseProperty", jdbcType=JdbcType.VARCHAR),
        @Result(column="BuildType", property="buildType", jdbcType=JdbcType.VARCHAR),
        @Result(column="Decoration", property="decoration", jdbcType=JdbcType.VARCHAR),
        @Result(column="CustomerInfo", property="customerInfo", jdbcType=JdbcType.VARCHAR),
        @Result(column="RoomProperty", property="roomProerty", jdbcType=JdbcType.VARCHAR),
        @Result(column="Remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="CompanyID", property="companyId", jdbcType=JdbcType.INTEGER),
        @Result(column="CreateDateTime", property="createDateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="LastUpdateTime", property="lastUpdateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="ExtendCol", property="extendCol", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<ReportCase> selectByExampleWithBLOBs(ReportCaseCond example);

    @SelectProvider(type=ReportCaseSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="CityName", property="cityName", jdbcType=JdbcType.VARCHAR),
        @Result(column="District", property="district", jdbcType=JdbcType.VARCHAR),
        @Result(column="Region", property="region", jdbcType=JdbcType.VARCHAR),
        @Result(column="ReportNo", property="reportNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="ReportTime", property="reportTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="Community", property="community", jdbcType=JdbcType.VARCHAR),
        @Result(column="Address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="BuildingName", property="buildingName", jdbcType=JdbcType.VARCHAR),
        @Result(column="RoomLayout", property="roomLayout", jdbcType=JdbcType.VARCHAR),
        @Result(column="HouseName", property="houseName", jdbcType=JdbcType.VARCHAR),
        @Result(column="Floor", property="floor", jdbcType=JdbcType.INTEGER),
        @Result(column="TotalFloor", property="totalFloor", jdbcType=JdbcType.INTEGER),
        @Result(column="Toward", property="toward", jdbcType=JdbcType.VARCHAR),
        @Result(column="BuildYear", property="buildYear", jdbcType=JdbcType.VARCHAR),
        @Result(column="Area", property="area", jdbcType=JdbcType.DECIMAL),
        @Result(column="TotalPrice", property="totalprice", jdbcType=JdbcType.DECIMAL),
        @Result(column="Purpose", property="purpose", jdbcType=JdbcType.VARCHAR),
        @Result(column="HouseProperty", property="houseProperty", jdbcType=JdbcType.VARCHAR),
        @Result(column="BuildType", property="buildType", jdbcType=JdbcType.VARCHAR),
        @Result(column="Decoration", property="decoration", jdbcType=JdbcType.VARCHAR),
        @Result(column="CustomerInfo", property="customerInfo", jdbcType=JdbcType.VARCHAR),
        @Result(column="RoomProperty", property="roomProerty", jdbcType=JdbcType.VARCHAR),
        @Result(column="Remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="CompanyID", property="companyId", jdbcType=JdbcType.INTEGER),
        @Result(column="CreateDateTime", property="createDateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="LastUpdateTime", property="lastUpdateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ReportCase> selectByExample(ReportCaseCond example);

    @Select({
        "select",
        "ID, CityName, District, Region, ReportNo, ReportTime, Community, Address, BuildingName, ",
        "RoomLayout, HouseName, Floor, TotalFloor, Toward, BuildYear, Area, TotalPrice, ",
        "Purpose, HouseProperty, BuildType, Decoration, CustomerInfo, RoomProperty, Remark, ",
        "CompanyID, CreateDateTime, LastUpdateTime, ExtendCol",
        "from reportcase",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="CityName", property="cityName", jdbcType=JdbcType.VARCHAR),
        @Result(column="District", property="district", jdbcType=JdbcType.VARCHAR),
        @Result(column="Region", property="region", jdbcType=JdbcType.VARCHAR),
        @Result(column="ReportNo", property="reportNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="ReportTime", property="reportTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="Community", property="community", jdbcType=JdbcType.VARCHAR),
        @Result(column="Address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="BuildingName", property="buildingName", jdbcType=JdbcType.VARCHAR),
        @Result(column="RoomLayout", property="roomLayout", jdbcType=JdbcType.VARCHAR),
        @Result(column="HouseName", property="houseName", jdbcType=JdbcType.VARCHAR),
        @Result(column="Floor", property="floor", jdbcType=JdbcType.INTEGER),
        @Result(column="TotalFloor", property="totalFloor", jdbcType=JdbcType.INTEGER),
        @Result(column="Toward", property="toward", jdbcType=JdbcType.VARCHAR),
        @Result(column="BuildYear", property="buildYear", jdbcType=JdbcType.VARCHAR),
        @Result(column="Area", property="area", jdbcType=JdbcType.DECIMAL),
        @Result(column="TotalPrice", property="totalprice", jdbcType=JdbcType.DECIMAL),
        @Result(column="Purpose", property="purpose", jdbcType=JdbcType.VARCHAR),
        @Result(column="HouseProperty", property="houseProperty", jdbcType=JdbcType.VARCHAR),
        @Result(column="BuildType", property="buildType", jdbcType=JdbcType.VARCHAR),
        @Result(column="Decoration", property="decoration", jdbcType=JdbcType.VARCHAR),
        @Result(column="CustomerInfo", property="customerInfo", jdbcType=JdbcType.VARCHAR),
        @Result(column="RoomProperty", property="roomProerty", jdbcType=JdbcType.VARCHAR),
        @Result(column="Remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="CompanyID", property="companyId", jdbcType=JdbcType.INTEGER),
        @Result(column="CreateDateTime", property="createDateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="LastUpdateTime", property="lastUpdateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="ExtendCol", property="extendCol", jdbcType=JdbcType.LONGVARCHAR)
    })
    ReportCase selectByPrimaryKey(Long id);

    @UpdateProvider(type=ReportCaseSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ReportCase record, @Param("example") ReportCaseCond example);

    @UpdateProvider(type=ReportCaseSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") ReportCase record, @Param("example") ReportCaseCond example);

    @UpdateProvider(type=ReportCaseSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ReportCase record, @Param("example") ReportCaseCond example);

    @UpdateProvider(type=ReportCaseSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ReportCase record);

    @Update({
        "update reportcase",
        "set CityName = #{cityName,jdbcType=VARCHAR},",
          "District = #{district,jdbcType=VARCHAR},",
          "Region = #{region,jdbcType=VARCHAR},",
          "ReportNo = #{reportNo,jdbcType=VARCHAR},",
          "ReportTime = #{reportTime,jdbcType=TIMESTAMP},",
          "Community = #{community,jdbcType=VARCHAR},",
          "Address = #{address,jdbcType=VARCHAR},",
          "BuildingName = #{buildingName,jdbcType=VARCHAR},",
          "RoomLayout = #{roomLayout,jdbcType=VARCHAR},",
          "HouseName = #{houseName,jdbcType=VARCHAR},",
          "Floor = #{floor,jdbcType=INTEGER},",
          "TotalFloor = #{totalFloor,jdbcType=INTEGER},",
          "Toward = #{toward,jdbcType=VARCHAR},",
          "BuildYear = #{buildYear,jdbcType=VARCHAR},",
          "Area = #{area,jdbcType=DECIMAL},",
          "TotalPrice = #{totalprice,jdbcType=DECIMAL},",
          "Purpose = #{purpose,jdbcType=VARCHAR},",
          "HouseProperty = #{houseProperty,jdbcType=VARCHAR},",
          "BuildType = #{buildType,jdbcType=VARCHAR},",
          "Decoration = #{decoration,jdbcType=VARCHAR},",
          "CustomerInfo = #{customerInfo,jdbcType=VARCHAR},",
          "RoomProperty = #{roomProerty,jdbcType=VARCHAR},",
          "Remark = #{remark,jdbcType=VARCHAR},",
          "CompanyID = #{companyId,jdbcType=INTEGER},",
          "CreateDateTime = #{createDateTime,jdbcType=TIMESTAMP},",
          "LastUpdateTime = #{lastUpdateTime,jdbcType=TIMESTAMP},",
          "ExtendCol = #{extendCol,jdbcType=LONGVARCHAR}",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(ReportCase record);

    @Update({
        "update reportcase",
        "set CityName = #{cityName,jdbcType=VARCHAR},",
          "District = #{district,jdbcType=VARCHAR},",
          "Region = #{region,jdbcType=VARCHAR},",
          "ReportNo = #{reportNo,jdbcType=VARCHAR},",
          "ReportTime = #{reportTime,jdbcType=TIMESTAMP},",
          "Community = #{community,jdbcType=VARCHAR},",
          "Address = #{address,jdbcType=VARCHAR},",
          "BuildingName = #{buildingName,jdbcType=VARCHAR},",
          "RoomLayout = #{roomLayout,jdbcType=VARCHAR},",
          "HouseName = #{houseName,jdbcType=VARCHAR},",
          "Floor = #{floor,jdbcType=INTEGER},",
          "TotalFloor = #{totalFloor,jdbcType=INTEGER},",
          "Toward = #{toward,jdbcType=VARCHAR},",
          "BuildYear = #{buildYear,jdbcType=VARCHAR},",
          "Area = #{area,jdbcType=DECIMAL},",
          "TotalPrice = #{totalprice,jdbcType=DECIMAL},",
          "Purpose = #{purpose,jdbcType=VARCHAR},",
          "HouseProperty = #{houseProperty,jdbcType=VARCHAR},",
          "BuildType = #{buildType,jdbcType=VARCHAR},",
          "Decoration = #{decoration,jdbcType=VARCHAR},",
          "CustomerInfo = #{customerInfo,jdbcType=VARCHAR},",
          "RoomProperty = #{roomProerty,jdbcType=VARCHAR},",
          "Remark = #{remark,jdbcType=VARCHAR},",
          "CompanyID = #{companyId,jdbcType=INTEGER},",
          "CreateDateTime = #{createDateTime,jdbcType=TIMESTAMP},",
          "LastUpdateTime = #{lastUpdateTime,jdbcType=TIMESTAMP}",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ReportCase record);
}