package org.example.mybatis_demo.service.impl;

import org.example.mybatis_demo.mapper.DeptMapper;
import org.example.mybatis_demo.mapper.EmpMapper;
import org.example.mybatis_demo.pojo.Dept;
import org.example.mybatis_demo.pojo.LogDept;
import org.example.mybatis_demo.service.DeptService ;
import org.example.mybatis_demo.service.EmpService;
import org.example.mybatis_demo.service.LogDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {


    @Autowired
    private DeptMapper deptMapper;

    @Autowired
    private EmpService empService;

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private LogDeptService logDeptService;

    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }

    @Override
    public void delete(Integer id) {
        deptMapper.delete(id);
    }

    @Override
    public void insert(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insert(dept);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteByDeptId(Integer deptId) throws Exception {
        try {
            deptMapper.delete(deptId);
            empMapper.deleteByDeptId(deptId);
            // 异常！！！
            // 1. 可以回滚的正常异常！！！
            int i = 1/0;
            //empMapper.deleteByDeptId(deptId);
            /*if (true) {
                throw new Exception("出错啦！！！");
            }*/

        }
        finally {
            LogDept logDept = new LogDept();
            logDept.setCreateTime(LocalDateTime.now());
            logDept.setDescription("执行解散操作的是"+ deptId + "号部门");
            logDeptService.insrtLogDept(logDept);
        }
    }
}
