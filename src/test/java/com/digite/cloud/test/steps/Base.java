package com.digite.cloud.test.steps;//package test.java.com.digite.cloud.test.steps;


import com.digite.actions.drivercapabilities.WebDriverFactory;
import com.digite.cloud.test.config.Config;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
//import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.support.AnnotationConfigContextLoader;


@SpringJUnitConfig
@CucumberContextConfiguration
@TestPropertySource(locations = "/application.properties")
@ContextConfiguration(classes = WebDriverFactory.class, loader = AnnotationConfigContextLoader.class )
@SpringBootTest(classes = Config.class)
public class Base {
}