package com.digite.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.digite.lp.businesslogic","com.digite.actions"})
@ComponentScan(basePackages = "com.digite.config")
public class Config {
}
