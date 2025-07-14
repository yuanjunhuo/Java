package org.example.mybatis_demo.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.example.mybatis_demo.pojo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SessionController {



    @GetMapping("/c1")
    public Result setcookie(HttpServletResponse response){
        response.addCookie(new Cookie("login_name", "baimo"));
        return Result.success();
    }
    @GetMapping("/c2")
    public Result getcookie(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("login_name")) {
                System.out.println(cookie.getValue());
            }
        }
        return Result.success();
    }


    @GetMapping("s1")
    public Result setsession(HttpSession session){
        log.info("Http_session_s1:{}", session.hashCode());
        session.setAttribute("login_name", "baimo");
        return Result.success();
    }

    @GetMapping("s2")
    public Result getsession(HttpServletRequest request){

        HttpSession session = request.getSession();
        log.info("Http_session_s2:{}", session.hashCode());
        Object obj = session.getAttribute("login_name");
        return Result.success(obj);
    }





}
