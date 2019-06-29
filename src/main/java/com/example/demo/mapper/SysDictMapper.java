package com.example.demo.mapper;

import com.example.demo.model.SysDict;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface SysDictMapper {
    @Delete({
        "delete from sys_dict",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into sys_dict (id, value, ",
        "label, type, description, ",
        "sort, parent_id, ",
        "create_by, create_date, ",
        "update_by, update_date, ",
        "remarks, del_flag)",
        "values (#{id,jdbcType=INTEGER}, #{value,jdbcType=VARCHAR}, ",
        "#{label,jdbcType=VARCHAR}, #{type,jdbcType=VARCHAR}, #{description,jdbcType=VARCHAR}, ",
        "#{sort,jdbcType=DECIMAL}, #{parentId,jdbcType=VARCHAR}, ",
        "#{createBy,jdbcType=VARCHAR}, #{createDate,jdbcType=TIMESTAMP}, ",
        "#{updateBy,jdbcType=VARCHAR}, #{updateDate,jdbcType=TIMESTAMP}, ",
        "#{remarks,jdbcType=VARCHAR}, #{delFlag,jdbcType=CHAR})"
    })
    int insert(SysDict record);

    @InsertProvider(type=SysDictSqlProvider.class, method="insertSelective")
    int insertSelective(SysDict record);

    @Select({
        "select",
        "id, value, label, type, description, sort, parent_id, create_by, create_date, ",
        "update_by, update_date, remarks, del_flag",
        "from sys_dict",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="value", property="value", jdbcType=JdbcType.VARCHAR),
        @Result(column="label", property="label", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="sort", property="sort", jdbcType=JdbcType.DECIMAL),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_by", property="updateBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_date", property="updateDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="remarks", property="remarks", jdbcType=JdbcType.VARCHAR),
        @Result(column="del_flag", property="delFlag", jdbcType=JdbcType.CHAR)
    })
    SysDict selectByPrimaryKey(Integer id);

    @UpdateProvider(type=SysDictSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SysDict record);

    @Update({
        "update sys_dict",
        "set value = #{value,jdbcType=VARCHAR},",
          "label = #{label,jdbcType=VARCHAR},",
          "type = #{type,jdbcType=VARCHAR},",
          "description = #{description,jdbcType=VARCHAR},",
          "sort = #{sort,jdbcType=DECIMAL},",
          "parent_id = #{parentId,jdbcType=VARCHAR},",
          "create_by = #{createBy,jdbcType=VARCHAR},",
          "create_date = #{createDate,jdbcType=TIMESTAMP},",
          "update_by = #{updateBy,jdbcType=VARCHAR},",
          "update_date = #{updateDate,jdbcType=TIMESTAMP},",
          "remarks = #{remarks,jdbcType=VARCHAR},",
          "del_flag = #{delFlag,jdbcType=CHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SysDict record);
}