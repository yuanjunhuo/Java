package org.example.mybatis_demo.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.mybatis_demo.pojo.Dept;

import java.util.List;

/**
 * 部门管理
 */
@Mapper
public interface DeptMapper {


    // 查询所有部门数据
    @Select("select * from dept")
    List<Dept> list();


    // 根据id， 删除部门！！！
    @Delete("delete from dept where id = #{id}")
    void delete(Integer id);


    // 新增部门信息
    @Insert("insert into dept(name,create_time,update_time) values(#{name},#{createTime},#{updateTime})")
    void insert(Dept dept);
}
