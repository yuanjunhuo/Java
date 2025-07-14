package org.example.mybatis_demo.service.impl;

import org.example.mybatis_demo.mapper.LogDeptMapper;
import org.example.mybatis_demo.pojo.LogDept;
import org.example.mybatis_demo.service.LogDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LogDeptServiceImpl implements LogDeptService {

    @Autowired
    private LogDeptMapper logDeptMapper;


    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void insrtLogDept(LogDept logDept) {
        logDeptMapper.insertLog(logDept);
    }
}
