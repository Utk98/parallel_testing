package com.SE;

import com.annotation.PageFragment;
import com.digite.actions.commands.Common;
import com.digite.actions.drivercapabilities.WebDriverFactory;

import java.util.Properties;

@PageFragment
public class NformCardModal extends Common {
    Properties nformCardModal=PageObjectsFactory.loadProperties("nformCardModal.properties");
    public NformCardModal(WebDriverFactory webDriverFactory) {
        super(webDriverFactory);
    }
    /*
                Author     : Jishnu Nambiar
                Description: navigate tab in Card Modal
                Example    : navigateTab("Linked_Cards")
                Input      : String tabName
                             TabName should be value after KEY_ in name attribute of anchor tag
                OutputType : return null
    */
    public void navigateTab(String tabName) {
        try {
            if (!isElementVisible(retriveLocators(multipleDynamicValueXpathGen(nformCardModal.getProperty("tabName"),tabName)))) {
                super.performmoveToElement(retriveLocators(nformCardModal.getProperty("moreOptionButton")));
                System.out.println("Jishnu in IF ");
            }
            super.elementClick(retriveLocators(multipleDynamicValueXpathGen(nformCardModal.getProperty("tabName"),tabName)));
        } catch (Exception e) {
          e.printStackTrace();
        }

    }
}
