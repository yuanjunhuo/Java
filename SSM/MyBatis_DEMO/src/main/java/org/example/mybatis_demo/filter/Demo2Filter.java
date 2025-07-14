package org.example.mybatis_demo.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;


//@WebFilter(urlPatterns = "/*")
public class Demo2Filter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("Demo2Filter,放行之前的信息！！！");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("Demo2Filter,放行之后的信息");


    }
}
