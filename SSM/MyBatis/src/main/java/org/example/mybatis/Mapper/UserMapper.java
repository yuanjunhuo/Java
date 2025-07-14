package org.example.mybatis.Mapper;


import org.apache.ibatis.annotations.*;
import org.example.mybatis.pojo.User;

import java.util.List;

@Mapper
public interface UserMapper {


    @Select("select * from User")
    List<User> findAll();



    // 删除操作
    @Delete("delete from User where id = #{id}")
    /*public void delete(int id);*/
    // 有返回值时，返回值是此次操作影响的记录数
    public int delete(int id);


    // 插入数据
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into User(name,age,id,phone) values(#{name},#{age},#{id},#{phone})")
    public int insert(User user);

    // 修改数据
    @Update("update User set name = #{name} where id = #{id}")
    public int update(User user);


    // 查询

    public User findById(int id);







}
