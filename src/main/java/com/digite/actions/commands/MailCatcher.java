package com.digite.actions.commands;

import com.annotation.PageFragment;
import com.digite.actions.drivercapabilities.WebDriverFactory;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;


@Slf4j
@PageFragment
public class MailCatcher extends Common{
    public MailCatcher(WebDriverFactory webDriverFactory) {
        super(webDriverFactory);
    }
    public void launchMail(String mailcatcherUrl)throws Exception{
        // Open mail catcher in new window
            navigate(mailcatcherUrl);
    }

    public void openMail(String emailId)throws Exception{
            super.waitForTheElement(By.xpath("//*[@id='messages']//*[contains(text(), '<"+emailId+">')]"),VISIBILITY_OF_ELEMENT_LOCATED);
            super.elementClick(By.xpath("//*[@id='messages']//*[contains(text(), '<"+emailId+">')]"));
    }

    public boolean verifyEmail(String email)throws Exception{
            super.waitForTheElement(By.xpath("//*[@id='messages']//*[contains(text(), '<"+email+">')]"),VISIBILITY_OF_ELEMENT_LOCATED);
            return super.isElementVisible(By.xpath("//*[@id='messages']//*[contains(text(), '<"+email+">')]"));
    }

    public void acceptInvite(By locator) throws Exception {
        super.waitForPageToBeReady();
        customWaitForElement(By.tagName("iframe"), FRAME_TO_BE_AVAILABLE_AND_SWITCH_TO_IT, 120);
        super.waitForTheElement(locator,VISIBILITY_OF_ELEMENT_LOCATED);
        super.clickUsingAction(locator);
    }

}
