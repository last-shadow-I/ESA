package com.example.lab2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.xslt.XsltView;
import org.springframework.web.servlet.view.xslt.XsltViewResolver;

public class AppConfig implements WebMvcConfigurer {

    @Bean
    public ViewResolver getXSLTViewResolver(){

        XsltViewResolver xsltResolver = new XsltViewResolver();
        xsltResolver.setOrder(1);
        xsltResolver.setSourceKey("xmlSource");

        xsltResolver.setViewClass(XsltView.class);
        xsltResolver.setViewNames("books", "libraryUsers");
        xsltResolver.setPrefix("classpath:/static/xsl/");
        xsltResolver.setSuffix(".xsl");

        return xsltResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
}
