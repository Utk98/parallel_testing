package com.digite.config;

import com.digite.actions.drivercapabilities.CucumberBrowserScope;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ScopeConfig {

    @Bean
    public static CustomScopeConfigurer customScopeConfigurer() {
        CustomScopeConfigurer configurer = new CustomScopeConfigurer();
        // Registering 'cucumber-glue' scope to use CucumberBrowserScope
        configurer.addScope("cucumber-glue", new CucumberBrowserScope());
        return configurer;
    }
}
