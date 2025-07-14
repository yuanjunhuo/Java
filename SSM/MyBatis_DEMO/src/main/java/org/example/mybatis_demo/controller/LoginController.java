package org.example.mybatis_demo.controller;


import lombok.extern.slf4j.Slf4j;
import org.example.mybatis_demo.pojo.Emp;
import org.example.mybatis_demo.pojo.Result;
import org.example.mybatis_demo.service.EmpService;
import org.example.mybatis_demo.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController

public class LoginController {

    @Autowired
    private EmpService empService;

    @PostMapping("/login")
    // json 格式的参数通过对象来接收！！！
    public Result login(@RequestBody Emp emp) {


        log.info("登录！！！");
        Emp e = empService.getByUsernameaandPassword(emp);

        if (e != null) {

            // 生成令牌并下发令牌！！！

            Map<String, Object> claims = new HashMap<>();
            claims.put("id", e.getId());
            claims.put("username", e.getUsername());
            claims.put("password", e.getPassword());
            String jwt  = JwtUtils.generateJwt(claims);
            return Result.success(jwt);
        }
        else{
            return Result.success("用户名出错或代码出错！！！");
        }

    }
}
