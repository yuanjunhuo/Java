package org.example.mybatis_demo.service;

import org.example.mybatis_demo.mapper.DeptMapper;
import org.example.mybatis_demo.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 部门管理
 */
public interface DeptService {
    // 查询所有部门信息
    List<Dept> list();
    // 删除部门
    void delete(Integer id);
    // 插入部门信息
    void insert(Dept dept);
    void deleteByDeptId(Integer deptId) throws Exception;
}
