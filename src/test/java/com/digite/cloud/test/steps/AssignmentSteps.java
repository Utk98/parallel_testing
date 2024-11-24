package com.digite.cloud.test.steps;

import com.digite.actions.drivercapabilities.WebDriverFactory;

import com.digite.lp.businesslogic.Assignment;
import com.digite.lp.businesslogic.CommonApis;
import io.cucumber.java8.En;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

@Slf4j

//@PageFragment
@Scope("prototype")
public class AssignmentSteps implements En {

    @Autowired
    private Assignment assignment;

//    @Autowired
//    private Discussion discussion;

    @Autowired
    private CommonApis commonApis;

    @Autowired
    private WebDriverFactory webDriverFactory;

    private WebDriver driver;

    public AssignmentSteps( ) {
        Before(() -> {
            driver = webDriverFactory.getDriver();
        });

        Given("user logs in with email {string} and password {string}", (String email, String password) -> {
            log.info("Logging in with email: {}", email);
            commonApis.loginToDigite(email, password);
            Thread.sleep(5000); // Consider using WebDriver wait instead of Thread.sleep
            assignment.logini();  // Navigate to the necessary page
        });

    }
    }


