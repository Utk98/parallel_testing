package com.SE;

import com.annotation.PageFragment;
import com.digite.actions.commands.Common;
import com.digite.actions.drivercapabilities.WebDriverFactory;
import org.springframework.util.Assert;

import java.util.Properties;

@PageFragment
public class CardModal extends Common {
    Properties cardModal=PageObjectsFactory.loadProperties("cardModal.properties");
    public CardModal(WebDriverFactory webDriverFactory) {
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
            if (!isElementVisible(retriveLocators(multipleDynamicValueXpathGen(cardModal.getProperty("tabName"),tabName)))) {
                super.performmoveToElement(retriveLocators(cardModal.getProperty("moreOptionButton")));
            }
            super.elementClick(retriveLocators(multipleDynamicValueXpathGen(cardModal.getProperty("tabName"),tabName)));
        } catch (Exception e) {
          e.printStackTrace();
        }

    }
      /*
                Author     : Jishnu Nambiar
                Description: Execute Card Action such as Save,Mark as Done,Reset,Save n Continue etc on card Modal
                Example    : executeCardAction("Save")
                Input      : String cardAction
                             cardAction will be name of the button removing white space in between for e.g Mark as Done should  passed as markasdone in parameter
                OutputType : return null
    */

    public void executeCardAction(String cardAction) {
        try {
            switchFrame("PopupFrame");
           switch (cardAction.toLowerCase()){
               case "save":
                   elementClick(retriveLocators(cardModal.getProperty("saveBtn")));
                   break;
               case "reset":
                   elementClick(retriveLocators(cardModal.getProperty("resetBtn")));
                   break;
               case "markasdone":
                   elementClick(retriveLocators(cardModal.getProperty("doneBtn")));
                   break;
               case "block":
                   elementClick(retriveLocators(cardModal.getProperty("blockBtn")));
                   break;
               case "share":
                   elementClick(retriveLocators(cardModal.getProperty("shareBtn")));
                   break;
               case "delete":
                   elementClick(retriveLocators(cardModal.getProperty("deleteBtn")));
                   break;
               case "unblock":
                   elementClick(retriveLocators(cardModal.getProperty("unblockBtn")));
                   break;
               case "savencontinue":
                   elementClick(retriveLocators(cardModal.getProperty("saveDropDown")));
                   elementClick(retriveLocators(cardModal.getProperty("savenContinueBtn")));
                   break;
                default:
                   Assert.isTrue(false,"Action passed is not a valid one.Please check the parameter passed.");
                   break;
           }
            switchToDefaultFrame();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }





}
