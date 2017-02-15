package com.yunfang.dms.dao.mapper;

import com.yunfang.dms.entity.PriceData;
import com.yunfang.dms.entity.PriceDataCond;
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
public interface PriceDataMapper {
    @SelectProvider(type=PriceDataSqlProvider.class, method="countByExample")
    long countByExample(PriceDataCond example);

    @DeleteProvider(type=PriceDataSqlProvider.class, method="deleteByExample")
    int deleteByExample(PriceDataCond example);

    @Delete({
        "delete from pricedata",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into pricedata (CityName, District, ",
        "Region, PositionName, ",
        "PositionAddress, BuildYear, ",
        "PriceTime, PriceType, ",
        "Remark, CompanyID, ",
        "CreateDateTime, LastUpdateTime, ",
        "ExtendCol)",
        "values (#{cityName,jdbcType=VARCHAR}, #{district,jdbcType=VARCHAR}, ",
        "#{region,jdbcType=VARCHAR}, #{positionName,jdbcType=VARCHAR}, ",
        "#{positionAddress,jdbcType=VARCHAR}, #{buildYear,jdbcType=VARCHAR}, ",
        "#{priceTime,jdbcType=TIMESTAMP}, #{priceType,jdbcType=VARCHAR}, ",
        "#{remark,jdbcType=VARCHAR}, #{companyId,jdbcType=INTEGER}, ",
        "#{createDateTime,jdbcType=TIMESTAMP}, #{lastUpdateTime,jdbcType=TIMESTAMP}, ",
        "#{extendCol,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(PriceData record);

    @InsertProvider(type=PriceDataSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(PriceData record);

    @SelectProvider(type=PriceDataSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="CityName", property="cityName", jdbcType=JdbcType.VARCHAR),
        @Result(column="District", property="district", jdbcType=JdbcType.VARCHAR),
        @Result(column="Region", property="region", jdbcType=JdbcType.VARCHAR),
        @Result(column="PositionName", property="positionName", jdbcType=JdbcType.VARCHAR),
        @Result(column="PositionAddress", property="positionAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="BuildYear", property="buildYear", jdbcType=JdbcType.VARCHAR),
        @Result(column="PriceTime", property="priceTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="PriceType", property="priceType", jdbcType=JdbcType.VARCHAR),
        @Result(column="Remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="CompanyID", property="companyId", jdbcType=JdbcType.INTEGER),
        @Result(column="CreateDateTime", property="createDateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="LastUpdateTime", property="lastUpdateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="ExtendCol", property="extendCol", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<PriceData> selectByExampleWithBLOBs(PriceDataCond example);

    @SelectProvider(type=PriceDataSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="CityName", property="cityName", jdbcType=JdbcType.VARCHAR),
        @Result(column="District", property="district", jdbcType=JdbcType.VARCHAR),
        @Result(column="Region", property="region", jdbcType=JdbcType.VARCHAR),
        @Result(column="PositionName", property="positionName", jdbcType=JdbcType.VARCHAR),
        @Result(column="PositionAddress", property="positionAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="BuildYear", property="buildYear", jdbcType=JdbcType.VARCHAR),
        @Result(column="PriceTime", property="priceTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="PriceType", property="priceType", jdbcType=JdbcType.VARCHAR),
        @Result(column="Remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="CompanyID", property="companyId", jdbcType=JdbcType.INTEGER),
        @Result(column="CreateDateTime", property="createDateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="LastUpdateTime", property="lastUpdateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<PriceData> selectByExample(PriceDataCond example);

    @Select({
        "select",
        "ID, CityName, District, Region, PositionName, PositionAddress, BuildYear, PriceTime, ",
        "PriceType, Remark, CompanyID, CreateDateTime, LastUpdateTime, ExtendCol",
        "from pricedata",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="CityName", property="cityName", jdbcType=JdbcType.VARCHAR),
        @Result(column="District", property="district", jdbcType=JdbcType.VARCHAR),
        @Result(column="Region", property="region", jdbcType=JdbcType.VARCHAR),
        @Result(column="PositionName", property="positionName", jdbcType=JdbcType.VARCHAR),
        @Result(column="PositionAddress", property="positionAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="BuildYear", property="buildYear", jdbcType=JdbcType.VARCHAR),
        @Result(column="PriceTime", property="priceTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="PriceType", property="priceType", jdbcType=JdbcType.VARCHAR),
        @Result(column="Remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="CompanyID", property="companyId", jdbcType=JdbcType.INTEGER),
        @Result(column="CreateDateTime", property="createDateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="LastUpdateTime", property="lastUpdateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="ExtendCol", property="extendCol", jdbcType=JdbcType.LONGVARCHAR)
    })
    PriceData selectByPrimaryKey(Long id);

    @UpdateProvider(type=PriceDataSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") PriceData record, @Param("example") PriceDataCond example);

    @UpdateProvider(type=PriceDataSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") PriceData record, @Param("example") PriceDataCond example);

    @UpdateProvider(type=PriceDataSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") PriceData record, @Param("example") PriceDataCond example);

    @UpdateProvider(type=PriceDataSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PriceData record);

    @Update({
        "update pricedata",
        "set CityName = #{cityName,jdbcType=VARCHAR},",
          "District = #{district,jdbcType=VARCHAR},",
          "Region = #{region,jdbcType=VARCHAR},",
          "PositionName = #{positionName,jdbcType=VARCHAR},",
          "PositionAddress = #{positionAddress,jdbcType=VARCHAR},",
          "BuildYear = #{buildYear,jdbcType=VARCHAR},",
          "PriceTime = #{priceTime,jdbcType=TIMESTAMP},",
          "PriceType = #{priceType,jdbcType=VARCHAR},",
          "Remark = #{remark,jdbcType=VARCHAR},",
          "CompanyID = #{companyId,jdbcType=INTEGER},",
          "CreateDateTime = #{createDateTime,jdbcType=TIMESTAMP},",
          "LastUpdateTime = #{lastUpdateTime,jdbcType=TIMESTAMP},",
          "ExtendCol = #{extendCol,jdbcType=LONGVARCHAR}",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(PriceData record);

    @Update({
        "update pricedata",
        "set CityName = #{cityName,jdbcType=VARCHAR},",
          "District = #{district,jdbcType=VARCHAR},",
          "Region = #{region,jdbcType=VARCHAR},",
          "PositionName = #{positionName,jdbcType=VARCHAR},",
          "PositionAddress = #{positionAddress,jdbcType=VARCHAR},",
          "BuildYear = #{buildYear,jdbcType=VARCHAR},",
          "PriceTime = #{priceTime,jdbcType=TIMESTAMP},",
          "PriceType = #{priceType,jdbcType=VARCHAR},",
          "Remark = #{remark,jdbcType=VARCHAR},",
          "CompanyID = #{companyId,jdbcType=INTEGER},",
          "CreateDateTime = #{createDateTime,jdbcType=TIMESTAMP},",
          "LastUpdateTime = #{lastUpdateTime,jdbcType=TIMESTAMP}",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(PriceData record);
}