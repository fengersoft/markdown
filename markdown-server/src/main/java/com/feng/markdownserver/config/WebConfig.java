package com.feng.markdownserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {


            registry.addMapping("/**")
                    .allowedOriginPatterns("*")
                    .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
                    .allowCredentials(true)
                    .allowedHeaders("*")
                    .maxAge(3600);


    }
}
