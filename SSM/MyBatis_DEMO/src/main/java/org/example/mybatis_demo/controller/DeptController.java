package org.example.mybatis_demo.controller;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.example.mybatis_demo.pojo.Dept;
import org.example.mybatis_demo.pojo.Result;
import org.example.mybatis_demo.service.DeptService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

/**
 * 部门管理Controller
 */
@Slf4j
@RestController
public class DeptController {

    //private static Logger  log = (Logger) LoggerFactory.getLogger(DeptController.class);
    @Autowired
    private DeptService deptService;

    //@RequestMapping(value = "/depts",method = RequestMethod.GET)
    @GetMapping("/depts")
    public Result list(){
        //System.out.println("查询所有的部门数据");
        log.info("查询所有的部门数据");
        List<Dept> deptlist =  deptService.list();
        return Result.success(deptlist);
    }

    // 删除部门信息
    @DeleteMapping("/depts/{id}")
    public Result delete(@PathVariable Integer id){
        deptService.delete(id);
        log.info("删除部门信息：{}",id);
        return Result.success();
    }

    // 增加部门信息
    @PostMapping("/depts")
    public Result insert(@RequestBody Dept dept){

        log.info("新增部门！！！");
        deptService.insert(dept);

        return Result.success();
    }

    // s删除部门以及员工
    @DeleteMapping("/depts/delete/{deptId}")
    public  Result  deleteById(@PathVariable Integer deptId){
        log.info("删除部门以及员工！！！！！！");
        try {
            deptService.deleteByDeptId(deptId);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return Result.success();
    }











}
