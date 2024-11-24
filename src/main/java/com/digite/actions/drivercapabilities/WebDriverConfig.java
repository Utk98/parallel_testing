package com.digite.actions.drivercapabilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class WebDriverConfig {

    @Bean
    @Scope("browserscope")  // Use the custom scope here
    public WebDriver webDriver() {
        return new ChromeDriver(); // Replace with your WebDriver setup
    }
}
