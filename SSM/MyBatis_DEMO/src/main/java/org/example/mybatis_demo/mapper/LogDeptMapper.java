package org.example.mybatis_demo.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.example.mybatis_demo.pojo.LogDept;

@Mapper
public interface LogDeptMapper {


    @Insert("insert into dept_log(create_time, description) values  (#{createTime},#{description})")
    void insertLog(LogDept logDept);

}
