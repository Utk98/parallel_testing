package com.digite.lp.businesslogic;

import com.digite.actions.commands.Common;
import com.digite.actions.drivercapabilities.WebDriverFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@PropertySource("classpath:/objectRepository/commonapi.properties")
public class CommonApis extends Common {

    @Autowired
   private Environment environment;
    public CommonApis(WebDriverFactory webDriverFactory) {
        super(webDriverFactory);
    }

    public void logout()  {
        log.info( "logout in lp" );
        try {
            navigate(environment.getProperty("aws.logout"));
        } catch ( Throwable t ) {
            super.logger(scenario, t);
        }
        log.info( "Successfully logout" );
    }


    public void loginToDigite(String a_userName, String a_Password1)  {
        log.info( "login in Digite" );
        try {
            waitForPageToBeReady();
            navigate(environment.getProperty("aws.env"));
            waitForPageToBeReady();
            super.enterText( retriveLocators(environment.getProperty("usernameOrEmail")),a_userName);
            super.enterText(retriveLocators(environment.getProperty("password")),a_Password1);
            super.elementClick(retriveLocators(environment.getProperty("submit")));
        } catch ( Throwable t ) {
            super.logger(scenario, t);
        }
        log.info( "Successfully LoggedIn" );
    }
}
