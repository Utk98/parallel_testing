package com.digite.actions.drivercapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class WebDriverFactory {

    // Thread-safe driver management
    private List<WebDriverFactory> webDriverThreadPool = Collections.synchronizedList(new ArrayList<>());
    private ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    @Value("${aws.env:http://localhost:3000/}")
    private String env;

    @Value("${browser.mode:non-headless}")
    private String browserMode;

    // Constructor
    public WebDriverFactory() {
    }

    // Create FirefoxDriver bean with prototype scope
    @Bean(name = "firefoxDriver")
    @Scope("prototype")
    public WebDriver firefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver firefoxDriver = new FirefoxDriver();
        firefoxDriver.get(env);
        threadLocalDriver.set(firefoxDriver);
        return threadLocalDriver.get();
    }

    // Create ChromeDriver bean with prototype scope
    @Bean(name = "chromeDriver")
    @Scope("browserscope")
    @Primary
    public WebDriver chromeDriver() {
        WebDriverFactory factory = new WebDriverFactory();
        webDriverThreadPool.add(factory);
        WebDriverManager.chromedriver().setup();
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get(env);
        threadLocalDriver.set(chromeDriver);
        return threadLocalDriver.get();
    }

    // Return the driver instance from ThreadLocal
    public WebDriver getDriver() {
        if (threadLocalDriver.get() == null) {
            threadLocalDriver.set(chromeDriver());
        }
        return threadLocalDriver.get();
    }

    // Quit the driver instance and clean up
    public void quitDriver() {
        if (threadLocalDriver.get() != null) {
            threadLocalDriver.get().quit();
            threadLocalDriver.remove();
        }
    }



    // Get the current driver for the test
    public WebDriver getDriverInstance() throws Exception {
        return getDriver();
    }
//
//    // Clear cookies after each test method
//    @AfterMethod(alwaysRun = true)
//    public void clearCookies() throws Exception {
//        getDriverInstance().manage().deleteAllCookies();
//    }
//
//    // Close all driver objects after the test suite completes
//    @AfterSuite(alwaysRun = true)
//    public void closeDriverObjects() {
//        for (WebDriverFactory factory : webDriverThreadPool) {
//            factory.quitDriver();
//        }
//    }
}
