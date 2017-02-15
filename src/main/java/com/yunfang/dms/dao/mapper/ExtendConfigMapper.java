package com.yunfang.dms.dao.mapper;

import com.yunfang.dms.entity.ExtendConfig;
import com.yunfang.dms.entity.ExtendConfigCond;
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
public interface ExtendConfigMapper {
    @SelectProvider(type=ExtendConfigSqlProvider.class, method="countByExample")
    long countByExample(ExtendConfigCond example);

    @DeleteProvider(type=ExtendConfigSqlProvider.class, method="deleteByExample")
    int deleteByExample(ExtendConfigCond example);

    @Delete({
        "delete from extendconfig",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into extendconfig (CompanyID, SourceTable, ",
        "ColumnName, CreateDateTime, ",
        "Operator)",
        "values (#{companyId,jdbcType=INTEGER}, #{sourceTable,jdbcType=INTEGER}, ",
        "#{columnName,jdbcType=VARCHAR}, #{createDateTime,jdbcType=TIMESTAMP}, ",
        "#{operator,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(ExtendConfig record);

    @InsertProvider(type=ExtendConfigSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(ExtendConfig record);

    @SelectProvider(type=ExtendConfigSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="CompanyID", property="companyId", jdbcType=JdbcType.INTEGER),
        @Result(column="SourceTable", property="sourceTable",jdbcType=JdbcType.INTEGER),
        @Result(column="ColumnName", property="columnName", jdbcType=JdbcType.VARCHAR),
        @Result(column="CreateDateTime", property="createDateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="Operator", property="operator", jdbcType=JdbcType.VARCHAR)
    })
    List<ExtendConfig> selectByExample(ExtendConfigCond example);

    @Select({
        "select",
        "ID, CompanyID, SourceTable, ColumnName, CreateDateTime, Operator",
        "from extendconfig",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="CompanyID", property="companyId", jdbcType=JdbcType.INTEGER),
        @Result(column="SourceTable", property="sourceTable" ,jdbcType=JdbcType.INTEGER),
        @Result(column="ColumnName", property="columnName", jdbcType=JdbcType.VARCHAR),
        @Result(column="CreateDateTime", property="createDateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="Operator", property="operator", jdbcType=JdbcType.VARCHAR)
    })
    ExtendConfig selectByPrimaryKey(Long id);

    @UpdateProvider(type=ExtendConfigSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ExtendConfig record, @Param("example") ExtendConfigCond example);

    @UpdateProvider(type=ExtendConfigSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ExtendConfig record, @Param("example") ExtendConfigCond example);

    @UpdateProvider(type=ExtendConfigSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ExtendConfig record);

    @Update({
        "update extendconfig",
        "set CompanyID = #{companyId,jdbcType=INTEGER},",
          "SourceTable = #{sourceTable,jdbcType=INTEGER},",
          "ColumnName = #{columnName,jdbcType=VARCHAR},",
          "CreateDateTime = #{createDateTime,jdbcType=TIMESTAMP},",
          "Operator = #{operator,jdbcType=VARCHAR}",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ExtendConfig record);
}