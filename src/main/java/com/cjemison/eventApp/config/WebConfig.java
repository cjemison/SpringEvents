package com.cjemison.eventApp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan(basePackages = "com.cjemison.eventApp")
@EnableAsync
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {
}
