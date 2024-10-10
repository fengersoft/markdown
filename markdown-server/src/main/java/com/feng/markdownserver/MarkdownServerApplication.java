package com.feng.markdownserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.feng.markdownserver.mapper")
public class MarkdownServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MarkdownServerApplication.class, args);
    }

}
