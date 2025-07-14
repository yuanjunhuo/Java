package org.example.mybatis_demo.service;

import org.example.mybatis_demo.pojo.Emp;
import org.example.mybatis_demo.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理
 */
public interface EmpService {
    

    PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

    void delete(List<Integer> ids);

    void save(Emp emp);

    Emp get(Integer id);

    void update(Emp emp);

    Emp getByUsernameaandPassword(Emp emp);


}
