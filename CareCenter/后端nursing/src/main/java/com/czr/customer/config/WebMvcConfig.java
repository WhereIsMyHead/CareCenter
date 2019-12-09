package com.czr.customer.config;


import com.czr.customer.controller.DateConverter;
import com.czr.customer.controller.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * WebMvcConfigurer配置类其实是Spring内部的一种配置方式，采用JavaBean的形式来代替传统的xml配置文件形式进行针对框架个性化定制。基于java-based方式的spring mvc配置，需要创建一个配置类并实现WebMvcConfigurer 接口，WebMvcConfigurerAdapter 抽象类是对WebMvcConfigurer接口的简单抽象（增加了一些默认实现）

 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 配置拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册拦截器,拦截所有请求(/**)
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**");
    }

    /**
     * 配置转换器
     * @param registry
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        //注册转换器
        registry.addConverter(new DateConverter());
    }
}
