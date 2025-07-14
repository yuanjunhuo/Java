package org.example.mybatis_demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.example.mybatis_demo.pojo.Emp;
import org.example.mybatis_demo.pojo.PageBean;
import org.example.mybatis_demo.pojo.Result;
import org.example.mybatis_demo.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理Controller
 */
@Slf4j
@RestController
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping("/emps")
    // 分页查询
    public Result page(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Short gender, @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,  @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {

        log.info("分页查询！！！");

        PageBean pageBean = empService.page(page, pageSize, name, gender, begin, end);

        return Result.success(pageBean);
    }

    @DeleteMapping("emps/{ids}")
    public Result delete(@PathVariable("ids") List<Integer> ids) {

        log.info("删除数据！！！");
        empService.delete(ids);
        return Result.success();
    }

    @PostMapping("emps")
    public Result save(@RequestBody Emp emp) {
        log.info("新增员工数据！！！");

        empService.save(emp);

        return Result.success();
    }


    @GetMapping("emps/{id}")
    public Result get(@PathVariable Integer id) {
        log.info("根据id查询员工信息！！！！！");
        Emp emp = empService.get(id);

        return Result.success(emp);
    }


    // 员工信息更新
    @PutMapping("emps")
    public Result update(@RequestBody Emp emp) {

        log.info("更新信息！！！");
        empService.update(emp);

        return Result.success();
    }









}
