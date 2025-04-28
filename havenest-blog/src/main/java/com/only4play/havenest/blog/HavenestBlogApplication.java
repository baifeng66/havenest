package com.only4play.havenest.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/***
 *@title HavenestBlogApplication
 *@description This is the main class of the Havenest Blog application
 *@author macbookair
 *@version 1.0.0
 *@create 2025/4/27 22:57
 **/
@SpringBootApplication
@MapperScan("com.only4play.havenest.*.mapper")
@ComponentScan("com.only4play.havenest.*")
public class HavenestBlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(HavenestBlogApplication.class, args);
    }
}
