package com.SE;

import com.annotation.PageFragment;
import com.digite.actions.commands.Common;
import com.digite.actions.drivercapabilities.WebDriverFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

import java.util.Optional;
import java.util.Properties;

@Slf4j
@PageFragment
public class ExecutionBoard extends Common {
    public ExecutionBoard(WebDriverFactory webDriverFactory) {
        super(webDriverFactory);
    }
    Properties executionBoard=PageObjectsFactory.loadProperties("executionBoard.properties");
    /*
                 Author     : Jishnu Nambiar
                 Description: Select the view type in execution Board of  Nimble application
                 Example    : executionBoardView("Timeline")
                 Input      : String viewType
                 OutputType : return null
     */

    public void executionBoardView(String viewType) throws Exception {
        if(!isElementVisible(retriveLocators(multipleDynamicValueXpathGen(executionBoard.getProperty("viewSelection"), viewType)))){
            super.elementClick(retriveLocators(executionBoard.getProperty("moreOption")));
            super.elementClick(retriveLocators(multipleDynamicValueXpathGen(executionBoard.getProperty("viewSelectionList"), viewType)));
        }
        else{
            super.elementClick(retriveLocators(multipleDynamicValueXpathGen(executionBoard.getProperty("viewSelection"), viewType)));
        }
    }
 /*
                 Author     : Jishnu Nambiar
                 Description: Select the Card view type in execution Board of  Nimble application
                 Example    : cardTypeView("User Story")
                 Input      : String cardType
                 OutputType : return null
     */

    public void cardTypeView(String cardType) throws Exception {
        if(!isElementVisible(retriveLocators(multipleDynamicValueXpathGen(executionBoard.getProperty("cardView"), cardType)))){
            super.elementClick(retriveLocators(executionBoard.getProperty("moreOptionCard")));
        }

        super.elementClick(retriveLocators(multipleDynamicValueXpathGen(executionBoard.getProperty("cardView"), cardType)));
    }

    /*
                 Author     : Jishnu Nambiar
                 Description: Change the zoom level in execution Board
                 Example    : zoom("2")
                 Input      : String zoomLevel
                 OutputType : return null
     */
    public void zoom(int zoomLevel) throws Exception {
        String currentZoomLevel=getText(executionBoard.getProperty("zoomLevel"));
        String numericPart = currentZoomLevel.replaceAll("[^0-9]", "");
        int numericZoomValue = Integer.parseInt(numericPart);
        while(numericZoomValue!=zoomLevel){
            if(numericZoomValue<zoomLevel){
                super.elementClick(retriveLocators(executionBoard.getProperty("zoomIn")));
            }
            else {
                super.elementClick(retriveLocators(executionBoard.getProperty("zoomOut")));
            }
            currentZoomLevel=getText(executionBoard.getProperty("zoomLevel"));
            numericPart = currentZoomLevel.replaceAll("[^0-9]", "");
            numericZoomValue = Integer.parseInt(numericPart);
        }
    }
    /*
               Author     : Jishnu Nambiar
               Description: Add Option in Execution Board
               Example    : add("Release")
               Input      : String option
               OutputType : return null
   */
    public void add(String option) throws Exception {
        super.elementClick(retriveLocators(executionBoard.getProperty("AddButton")));
        super.clickUsingAction(retriveLocators(multipleDynamicValueXpathGen(executionBoard.getProperty("addOption"),option)));
    }

    public void overflowCardAction(String cardName,String action) throws Exception {
        waitForPageToBeReady();
        switch(action.toLowerCase()){
            case "comments":
                super.elementClick(retriveLocators(multipleDynamicValueXpathGen(executionBoard.getProperty("cardOverflow"),cardName+",showComments")));
                break;
            case "block":
                super.elementClick(retriveLocators(multipleDynamicValueXpathGen(executionBoard.getProperty("cardOverflow"),cardName+",showComments")));
                break;
            case "tags":
                super.performmoveToElement(retriveLocators(multipleDynamicValueXpathGen(executionBoard.getProperty("cardOverflow"),cardName+",showComments")));
                break;
            case "complete":
                super.elementClick(retriveLocators(multipleDynamicValueXpathGen(executionBoard.getProperty("cardOverflow"),cardName)));
                super.elementClick(retriveLocators(executionBoard.getProperty("menuOption")));
                super.elementClick(retriveLocators(multipleDynamicValueXpathGen(executionBoard.getProperty("confirmationPopup"),"MARK AS DONE")));
                break;
            case "deletecard":
                super.elementClick(retriveLocators(multipleDynamicValueXpathGen(executionBoard.getProperty("cardOverflow"),cardName)));
                super.elementClick(retriveLocators(executionBoard.getProperty("menuOption")));
                super.elementClick(retriveLocators(multipleDynamicValueXpathGen(executionBoard.getProperty("confirmationPopup"),"DELETE")));
                break;
            case "copy":
            case "spillover":
                super.elementClick(retriveLocators(multipleDynamicValueXpathGen(executionBoard.getProperty("cardOverflow"),cardName)));
                super.elementClick(retriveLocators(executionBoard.getProperty("menuOption")));
                break;
            default:
                Assert.isTrue(false,"Action passed is not a valid one.Please check the parameter passed.");
                break;
        }
    }
    public void verifyCardPresence(String cardName) {
        try {
            waitForPageToBeReady();
            scroll(retriveLocators(multipleDynamicValueXpathGen(executionBoard.getProperty("cardName"),cardName)));
            if (super.isElementVisible(retriveLocators(multipleDynamicValueXpathGen(executionBoard.getProperty("cardName"),cardName)))) {
                Assert.isTrue(true,"Card: " + cardName + " is present");
            } else {
                Assert.isTrue(false,"Card: " + cardName + " is not  present");
            }
        } catch (Exception e) {
            log.info("Card Name failed");
        }
    }
    public void verifyCardInLane(String card,String lane) throws Exception {
        log.info("moveTo Started");
        try {
            waitForPageToBeReady();
            expandLane(lane);
            scroll(retriveLocators(multipleDynamicValueXpathGen(executionBoard.getProperty("cardName"),card)));
            Assert.isTrue(isElementVisible(retriveLocators(multipleDynamicValueXpathGen(executionBoard.getProperty("verifyLane"),lane+"|"+card))),"Card:"+card+" is not in the lane:"+lane);
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("moveTo completed");
    }
    public void openCardEB(String cardName){
        try {
            waitForPageToBeReady();
            scrollToElement(retriveLocators(multipleDynamicValueXpathGen(executionBoard.getProperty("cardName"),cardName)));
            super.elementClick(retriveLocators(multipleDynamicValueXpathGen(executionBoard.getProperty("cardName"),cardName)));
            waitForPageToBeReady();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void expandLane(String laneName) throws Exception {
        if (!isElementVisible(retriveLocators(multipleDynamicValueXpathGen(executionBoard.getProperty("laneStatus"), laneName)))) {
            scrollToElement(retriveLocators(multipleDynamicValueXpathGen(executionBoard.getProperty("laneStatus"), laneName)));
            elementClick(retriveLocators(multipleDynamicValueXpathGen(executionBoard.getProperty("laneStatus"), laneName)));
        }
    }


    /*
              Author     : Jishnu Nambiar
              Description: Apply Fitler on Execution Board
              Example    : applyFilter("CommonFields,BlockedStatus:Blocked,Unblocked;CommonFields,Blocking Reason:Leave,Task Switching", "Inc_n")
                           applyFilter("CommonFields,BlockedStatus:Blocked,Unblocked;CommonFields,Blocking Reason:Leave,Task Switching", Optional.empty())
              Input      : String Value,Optional<String>  keyValue
                            Optional key is required for parameter which are common across the filter such as Parent Card so we have to find the "category_key" in div element of the option seen
              OutputType : return null
   */
//    value= CommonFields,BlockedStatus:Blocked,Unblocked;CommonFields,Blocking Reason:Leave,Task Switching
    public void applyFilter(String value, Optional<String>  keyValue) {
        log.info("applyFilter, Started");
        try {
            String[] spilt=value.split(";");//CommonFields,BlockedStatus:Blocked,Unblocked
            waitForPageToBeReady();
            clickFilterButton();
            clearFilter();
            for(String filter:spilt){
                String[] splitFilter=filter.split(":");//CommonFields,BlockedStatus   Blocked,Unblocked
                String[] filterCriteria=splitFilter[0].split(",");  //CommonFields   BlockedStatus
                String[] filterValues=splitFilter[1].split(",");   // Blocked   Unblocked
                if(!isElementVisible(retriveLocators(multipleDynamicValueXpathGen(executionBoard.getProperty("filterOpen"),filterCriteria[0])))){
                    elementClick(retriveLocators(multipleDynamicValueXpathGen(executionBoard.getProperty("filterClosed"),filterCriteria[0])));
                }
                elementClick(retriveLocators(multipleDynamicValueXpathGen(executionBoard.getProperty("selectFilterAttribute"), filterCriteria[0] + "|" + filterCriteria[1])));
                for(String filterParmeter:filterValues) {
                    if(isElementVisible(retriveLocators(executionBoard.getProperty("searchTextBox")))){
                        enterText(retriveLocators(executionBoard.getProperty("searchTextBox")), filterParmeter.substring(0, 3));
                        elementClick(retriveLocators(executionBoard.getProperty("searchIcon")));
                    }
                    if(keyValue.isEmpty()){
                        elementClick(retriveLocators(multipleDynamicValueXpathGen(executionBoard.getProperty("selectCheckbox"),filterParmeter )));
                    }
                    else{
                        elementClick(retriveLocators(multipleDynamicValueXpathGen(executionBoard.getProperty("selectCheckbox2"),keyValue+"|"+ filterParmeter)));
                    }

                }
            }
            elementClick(retriveLocators(executionBoard.getProperty("applyFilter")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("applyFilter, Completed");
    }

    public void clickFilterButton() {
        log.info("applyFilter, Started");
        try {
            elementClick(retriveLocators(executionBoard.getProperty("filter")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("applyFilter, Completed");
    }
    public void clearFilter() throws Exception {
        waitForPageToBeReady();
        elementClick(retriveLocators(executionBoard.getProperty("clearFilter")));
    }



}
