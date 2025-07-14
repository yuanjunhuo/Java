package org.example.mybatis_demo.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.mybatis_demo.pojo.Emp;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理
 */
@Mapper
public interface EmpMapper {

   /* @Select("select count(*) from emp")
    public Long count();
    @Select("select * from emp limit #{start},#{pageSize}")
    public List<Emp> Page(Integer start, Integer pageSize);
*/

    // 使用pagehelper 进行分页查询
    //@Select("select * from emp")
    List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);


    void delete(List<Integer> ids);
    @Insert("insert into emp(username,name,gender,image,job,entrydate,dept_id,create_time,update_time)" +
            "values(#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emp);

    @Select("select * from emp where id = #{id}")
    Emp get(Integer id);

    void update(Emp emp);
    @Select("select * from emp where username=#{username} and password=#{password}")
    Emp getBynamepassword(Emp emp);


    // 根据部门id，删除员工
    @Delete("delete from emp where dept_id=#{deptId}")
    void deleteByDeptId(Integer deptId);










}
