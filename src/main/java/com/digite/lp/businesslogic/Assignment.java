package com.digite.lp.businesslogic;//package com.digite.lp.businesslogic;
import com.SE.PageObjectsFactory;
import com.annotation.PageFragment;

import com.digite.actions.commands.Common;
import com.digite.actions.drivercapabilities.WebDriverFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Slf4j
@PageFragment
@Scope("browserscope")
@Component

public class Assignment extends Common{
//    private static final Object WebDriverFactory = ;
//    CommonUtilities commonUtilities = new CommonUtilities(driver);
    Properties discussionRepo= PageObjectsFactory.loadProperties("Discussion.properties");
    Properties assignmentRepo= PageObjectsFactory.loadProperties("Assignment.properties");
    public Assignment(WebDriverFactory webDriverFactory) throws Exception{
        super(webDriverFactory);
    }

    public void addCommentu(String comment){
        log.info("addComment started");
        try {

            super.enterText(retriveLocators(discussionRepo.getProperty("comment_placeholder")), comment);
            super.elementClick(retriveLocators(discussionRepo.getProperty("comment_save_button")));

        } catch (Exception e) {
            super.exceptionLogger(scenario, e);
        }
        log.info("addComment Completed");
    }
//    public void scrollbuttonandclick(String title) throws Exception {
//

//        super.scrollToElement(retriveLocators(assignmentRepo.getProperty("scrollButton")));
//        super.elementClick(retriveLocators(assignmentRepo.getProperty("commentButton")));
//
//    }
    public void logini() throws Exception {
        super.elementClick(retriveLocators(assignmentRepo.getProperty("nimbleCafeButton")));

//        commonUtilities.elementClick(By.xpath("//a[@class='nav_icon icon-cafe']"));
    }

    }


