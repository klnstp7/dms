package com.yunfang.dms.dao.mapper;

import com.yunfang.dms.entity.PriceDataHis;
import com.yunfang.dms.entity.PriceDataHisCond;
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
public interface PriceDataHisMapper {
    @SelectProvider(type=PriceDataHisSqlProvider.class, method="countByExample")
    long countByExample(PriceDataHisCond example);

    @DeleteProvider(type=PriceDataHisSqlProvider.class, method="deleteByExample")
    int deleteByExample(PriceDataHisCond example);

    @Delete({
        "delete from pricedata_his",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into pricedata_his (PriceDataID, CityName, ",
        "District, Region, ",
        "PositionName, PositionAddress, ",
        "BuildYear, PriceTime, ",
        "PriceType, Remark, ",
        "CreateDateTime, Operator, ",
        "ExtendCol)",
        "values (#{priceDataId,jdbcType=BIGINT}, #{cityName,jdbcType=VARCHAR}, ",
        "#{district,jdbcType=VARCHAR}, #{region,jdbcType=VARCHAR}, ",
        "#{positionName,jdbcType=VARCHAR}, #{positionAddress,jdbcType=VARCHAR}, ",
        "#{buildYear,jdbcType=VARCHAR}, #{priceTime,jdbcType=TIMESTAMP}, ",
        "#{priceType,jdbcType=VARCHAR}, #{remark,jdbcType=VARCHAR}, ",
        "#{createDateTime,jdbcType=TIMESTAMP}, #{operator,jdbcType=VARCHAR}, ",
        "#{extendCol,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(PriceDataHis record);

    @InsertProvider(type=PriceDataHisSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(PriceDataHis record);

    @SelectProvider(type=PriceDataHisSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="PriceDataID", property="priceDataId", jdbcType=JdbcType.BIGINT),
        @Result(column="CityName", property="cityName", jdbcType=JdbcType.VARCHAR),
        @Result(column="District", property="district", jdbcType=JdbcType.VARCHAR),
        @Result(column="Region", property="region", jdbcType=JdbcType.VARCHAR),
        @Result(column="PositionName", property="positionName", jdbcType=JdbcType.VARCHAR),
        @Result(column="PositionAddress", property="positionAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="BuildYear", property="buildYear", jdbcType=JdbcType.VARCHAR),
        @Result(column="PriceTime", property="priceTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="PriceType", property="priceType", jdbcType=JdbcType.VARCHAR),
        @Result(column="Remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="CreateDateTime", property="createDateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="Operator", property="operator", jdbcType=JdbcType.VARCHAR),
        @Result(column="ExtendCol", property="extendCol", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<PriceDataHis> selectByExampleWithBLOBs(PriceDataHisCond example);

    @SelectProvider(type=PriceDataHisSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="PriceDataID", property="priceDataId", jdbcType=JdbcType.BIGINT),
        @Result(column="CityName", property="cityName", jdbcType=JdbcType.VARCHAR),
        @Result(column="District", property="district", jdbcType=JdbcType.VARCHAR),
        @Result(column="Region", property="region", jdbcType=JdbcType.VARCHAR),
        @Result(column="PositionName", property="positionName", jdbcType=JdbcType.VARCHAR),
        @Result(column="PositionAddress", property="positionAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="BuildYear", property="buildYear", jdbcType=JdbcType.VARCHAR),
        @Result(column="PriceTime", property="priceTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="PriceType", property="priceType", jdbcType=JdbcType.VARCHAR),
        @Result(column="Remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="CreateDateTime", property="createDateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="Operator", property="operator", jdbcType=JdbcType.VARCHAR)
    })
    List<PriceDataHis> selectByExample(PriceDataHisCond example);

    @Select({
        "select",
        "ID, PriceDataID, CityName, District, Region, PositionName, PositionAddress, ",
        "BuildYear, PriceTime, PriceType, Remark, CreateDateTime, Operator, ExtendCol",
        "from pricedata_his",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="PriceDataID", property="priceDataId", jdbcType=JdbcType.BIGINT),
        @Result(column="CityName", property="cityName", jdbcType=JdbcType.VARCHAR),
        @Result(column="District", property="district", jdbcType=JdbcType.VARCHAR),
        @Result(column="Region", property="region", jdbcType=JdbcType.VARCHAR),
        @Result(column="PositionName", property="positionName", jdbcType=JdbcType.VARCHAR),
        @Result(column="PositionAddress", property="positionAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="BuildYear", property="buildYear", jdbcType=JdbcType.VARCHAR),
        @Result(column="PriceTime", property="priceTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="PriceType", property="priceType", jdbcType=JdbcType.VARCHAR),
        @Result(column="Remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="CreateDateTime", property="createDateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="Operator", property="operator", jdbcType=JdbcType.VARCHAR),
        @Result(column="ExtendCol", property="extendCol", jdbcType=JdbcType.LONGVARCHAR)
    })
    PriceDataHis selectByPrimaryKey(Long id);

    @UpdateProvider(type=PriceDataHisSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") PriceDataHis record, @Param("example") PriceDataHisCond example);

    @UpdateProvider(type=PriceDataHisSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") PriceDataHis record, @Param("example") PriceDataHisCond example);

    @UpdateProvider(type=PriceDataHisSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") PriceDataHis record, @Param("example") PriceDataHisCond example);

    @UpdateProvider(type=PriceDataHisSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PriceDataHis record);

    @Update({
        "update pricedata_his",
        "set PriceDataID = #{priceDataId,jdbcType=BIGINT},",
          "CityName = #{cityName,jdbcType=VARCHAR},",
          "District = #{district,jdbcType=VARCHAR},",
          "Region = #{region,jdbcType=VARCHAR},",
          "PositionName = #{positionName,jdbcType=VARCHAR},",
          "PositionAddress = #{positionAddress,jdbcType=VARCHAR},",
          "BuildYear = #{buildYear,jdbcType=VARCHAR},",
          "PriceTime = #{priceTime,jdbcType=TIMESTAMP},",
          "PriceType = #{priceType,jdbcType=VARCHAR},",
          "Remark = #{remark,jdbcType=VARCHAR},",
          "CreateDateTime = #{createDateTime,jdbcType=TIMESTAMP},",
          "Operator = #{operator,jdbcType=VARCHAR},",
          "ExtendCol = #{extendCol,jdbcType=LONGVARCHAR}",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(PriceDataHis record);

    @Update({
        "update pricedata_his",
        "set PriceDataID = #{priceDataId,jdbcType=BIGINT},",
          "CityName = #{cityName,jdbcType=VARCHAR},",
          "District = #{district,jdbcType=VARCHAR},",
          "Region = #{region,jdbcType=VARCHAR},",
          "PositionName = #{positionName,jdbcType=VARCHAR},",
          "PositionAddress = #{positionAddress,jdbcType=VARCHAR},",
          "BuildYear = #{buildYear,jdbcType=VARCHAR},",
          "PriceTime = #{priceTime,jdbcType=TIMESTAMP},",
          "PriceType = #{priceType,jdbcType=VARCHAR},",
          "Remark = #{remark,jdbcType=VARCHAR},",
          "CreateDateTime = #{createDateTime,jdbcType=TIMESTAMP},",
          "Operator = #{operator,jdbcType=VARCHAR}",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(PriceDataHis record);
}