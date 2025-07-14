package org.example.mybatis_demo.filter;

import com.alibaba.fastjson2.JSONObject;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.example.mybatis_demo.pojo.Result;
import org.example.mybatis_demo.utils.JwtUtils;
import org.springframework.util.StringUtils;

import java.io.IOException;
@Slf4j
//@WebFilter("/*")
public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        // 获取url地址
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String url = request.getRequestURI();

        // 如果是login
        if(url.contains("login")){
            log.info("登录请求，直接放行！！！");
            filterChain.doFilter(request, response);
            // 直接结束，没有过滤器的后续操作
            return;
        }

        // 获取请求头中的令牌（token）
        String jwtToken = request.getHeader("token");

        // 判断是否存在，如果不存在，返回错误结果
        if(!StringUtils.hasLength(jwtToken)){
            log.info("请求头中token为空，未登录！！！");

            Result error = Result.error("NOT_LOGIN");

            // 手动转换对象，并且把他响应给浏览器

            String notLogin = JSONObject.toJSONString(error);
            response.getWriter().write(notLogin);
            return;
        }

        //  解析token, 解析失败，返回错误的结果！！！！
        try{
            JwtUtils.parseJWT(jwtToken);
        }catch (Exception e){

            log.info("解析令牌失败，返回未登录错误信息");
            Result error = Result.error("NOT_LOGIN");
            String notLogin = JSONObject.toJSONString(error);
            response.getWriter().write(notLogin);
            return;
        }

        // 放行
        log.info("令牌合法，放行！！！");
        filterChain.doFilter(request, response);


    }
}
