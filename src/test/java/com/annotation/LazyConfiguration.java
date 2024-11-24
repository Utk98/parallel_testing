package com.annotation;//package main.java.com.annotation;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.lang.annotation.*;

//@Lazy
@Configuration
@Documented
@Scope("prototype")
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface LazyConfiguration {
}
