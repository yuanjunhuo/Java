package org.example.mybatis_demo.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;


//@WebFilter("/*")
public class DemoFilter implements Filter {
    @Override  // 初始化方法，调用一次
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化");
    }

    @Override  // 拦截到请求之后调用，调用多次
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("拦截请求");
        // 放行
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("拦截请求之后的逻辑！！！");
    }

    @Override  // 销毁方法，只调用一次
    public void destroy() {
        System.out.println("销毁请求！！！");
        Filter.super.destroy();
    }
}
