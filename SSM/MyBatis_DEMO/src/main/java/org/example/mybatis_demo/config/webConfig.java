package org.example.mybatis_demo.config;


import org.example.mybatis_demo.intercepter.LoginCheckIntercepter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/*@Configuration   // &#x914D;&#x7F6E;&#x7C7B;
public class webConfig implements WebMvcConfigurer {
    @Autowired
    private LoginCheckIntercepter loginCheckIntercepter;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginCheckIntercepter).addPathPatterns("/**").excludePathPatterns("/login"); // &#x62E6;&#x622A;&#x6240;&#x6709;&#x7684;&#x8D44;&#x6E90;
    }




}*/
