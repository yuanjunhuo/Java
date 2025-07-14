package org.example.mybatis_demo.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.example.mybatis_demo.mapper.EmpMapper;
import org.example.mybatis_demo.pojo.Emp;
import org.example.mybatis_demo.pojo.PageBean;
import org.example.mybatis_demo.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {


    @Autowired
    private EmpMapper empMapper;


    @Override
    public PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {

        // pagehelper
        // 设置分页参数
        PageHelper.startPage(page,pageSize);
        List<Emp> emplist = empMapper.list(name, gender, begin, end);
        Page<Emp> p = (Page<Emp>) emplist;
        PageBean pageBean = new PageBean(p.getTotal(),p.getResult());
        /*// 1. 记录数目
        Long count = empMapper.count();
        //2. 分页数目
        Integer start = (page - 1) * pageSize;
        List<Emp> emplist =  empMapper.Page(start, pageSize);
        */
        return pageBean;
    }

    @Override
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);
    }

    @Override
    public void save(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);
    }

    @Override
    public Emp get(Integer id) {
        return empMapper.get(id);
    }

    @Override
    public void update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
    }

    @Override
    public Emp getByUsernameaandPassword(Emp emp) {
        return empMapper.getBynamepassword(emp);
    }

    public static class myTestImpl {

    }
}
