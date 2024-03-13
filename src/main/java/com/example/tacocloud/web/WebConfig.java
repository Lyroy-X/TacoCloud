package com.example.tacocloud.web;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@AutoConfiguration
@ComponentScan("com.example.tacocloud")
public class WebConfig implements WebMvcConfigurer {


}


