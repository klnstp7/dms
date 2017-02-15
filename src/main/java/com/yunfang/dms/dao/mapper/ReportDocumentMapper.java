package com.yunfang.dms.dao.mapper;

import com.yunfang.dms.entity.ReportDocument;
import com.yunfang.dms.entity.ReportDocumentCond;
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
public interface ReportDocumentMapper {
    @SelectProvider(type=ReportDocumentSqlProvider.class, method="countByExample")
    long countByExample(ReportDocumentCond example);

    @DeleteProvider(type=ReportDocumentSqlProvider.class, method="deleteByExample")
    int deleteByExample(ReportDocumentCond example);

    @Delete({
        "delete from reportdocument",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into reportdocument (Name, ReportCaseID, ",
        "ResourceID, Remark, ",
        "CreateDateTime, Operator)",
        "values (#{name,jdbcType=VARCHAR}, #{reportCaseId,jdbcType=BIGINT}, ",
        "#{resourceId,jdbcType=BIGINT}, #{remark,jdbcType=VARCHAR}, ",
        "#{createDateTime,jdbcType=TIMESTAMP}, #{operator,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(ReportDocument record);

    @InsertProvider(type=ReportDocumentSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(ReportDocument record);

    @SelectProvider(type=ReportDocumentSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="Name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="ReportCaseID", property="reportCaseId", jdbcType=JdbcType.BIGINT),
        @Result(column="ResourceID", property="resourceId", jdbcType=JdbcType.BIGINT),
        @Result(column="Remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="CreateDateTime", property="createDateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="Operator", property="operator", jdbcType=JdbcType.VARCHAR)
    })
    List<ReportDocument> selectByExample(ReportDocumentCond example);

    @Select({
        "select",
        "ID, Name, ReportCaseID, ResourceID, Remark, CreateDateTime, Operator",
        "from reportdocument",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="Name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="ReportCaseID", property="reportCaseId", jdbcType=JdbcType.BIGINT),
        @Result(column="ResourceID", property="resourceId", jdbcType=JdbcType.BIGINT),
        @Result(column="Remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="CreateDateTime", property="createDateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="Operator", property="operator", jdbcType=JdbcType.VARCHAR)
    })
    ReportDocument selectByPrimaryKey(Long id);

    @UpdateProvider(type=ReportDocumentSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ReportDocument record, @Param("example") ReportDocumentCond example);

    @UpdateProvider(type=ReportDocumentSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ReportDocument record, @Param("example") ReportDocumentCond example);

    @UpdateProvider(type=ReportDocumentSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ReportDocument record);

    @Update({
        "update reportdocument",
        "set Name = #{name,jdbcType=VARCHAR},",
          "ReportCaseID = #{reportCaseId,jdbcType=BIGINT},",
          "ResourceID = #{resourceId,jdbcType=BIGINT},",
          "Remark = #{remark,jdbcType=VARCHAR},",
          "CreateDateTime = #{createDateTime,jdbcType=TIMESTAMP},",
          "Operator = #{operator,jdbcType=VARCHAR}",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ReportDocument record);
}