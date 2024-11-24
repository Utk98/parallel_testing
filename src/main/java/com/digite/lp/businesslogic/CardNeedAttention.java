package com.digite.lp.businesslogic;//package com.digite.lp.businesslogic;
//
//import com.digite.actions.commands.Common;
//import io.cucumber.datatable.DataTable;
//import io.cucumber.java.Before;
//import io.cucumber.java.Scenario;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.Assertions;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.env.Environment;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.Map;
//
//@Slf4j
//@Component
//@PropertySource("classpath:/objectRepository/CardNeedsAttention.properties")
//public class CardNeedAttention extends Common {
//
//
//    @Autowired
//    private Environment cardNeedRepo;
//    static Scenario scenario;
//
//    //Jishnu_Remove Before tag implemetnation
//
//    public CardNeedAttention(WebDriver driver) {
//        super(driver);
//    }
//
//
//    /*
//    Author     : Sumit Kumar
//    Description: This api will verify that NO data message
//    Example    : noDataMessage(actualMessage)
//    Input      : (actual message "No data message")
//    OutputType : return boolean
//*/
//    public void noDataMessage(String actualMessage) {
//        log.info("No data message Started");
//        try {
//            //waiting till page load and element visible
//            waitForTheElement(retriveLocators(multipleDynamicValueXpathGen(cardNeedRepo.getProperty("noDataMessage"), actualMessage)),VISIBILITY_OF_ELEMENT_LOCATED);
//            scroll(retriveLocators(multipleDynamicValueXpathGen(cardNeedRepo.getProperty("noDataMessage"), actualMessage)));
//            Assertions.assertTrue(isElementVisible(retriveLocators(multipleDynamicValueXpathGen(cardNeedRepo.getProperty("noDataMessage"), actualMessage))));
//        } catch (Throwable t) {
//            //check what is used in PPM is applicable to all places in the repo
//            super.logger(scenario, t);
//        }
//        log.info("No data message Completed");
//    }
//
//    public void viewCardOnCNA(String name, String cardData) {
//        log.info("viewCardOnCNA Started");
//        try {
//            waitForPageToBeReady();
//            Assertions.assertTrue(isElementVisible(retriveLocators(multipleDynamicValueXpathGen(cardNeedRepo.getProperty("metricView"), cardData + "," + name))));
//
//        } catch (Throwable t) {
//            super.logger(scenario, t);
//        }
//        log.info("viewCardOnCNA Completed");
//
//
//    }
//
//    /*
//    Author     : Sumit Kumar
//    Description: This api will verify that NO data message
//    Example    : viewAccessCard(cardData,testName)
//    Input      : (actual message "No data message")
//    OutputType : return boolean
//*/
//
//    public void viewAccessCard(String cardData, String testName) {
//        log.info("The Ability to access card view of the priority started");
//        try {
//            super.elementClick(retriveLocators(cardNeedRepo.getProperty("expandButton")));
//            super.waitForTheElement(super.retriveLocators(cardNeedRepo.getProperty("popupScreen")), super.VISIBILITY_OF_ELEMENT_LOCATED);
//            Assertions.assertTrue(super.isElementVisible(retriveLocators(multipleDynamicValueXpathGen(cardNeedRepo.getProperty("cardValue"), cardData + "|" + testName))));
//            super.elementClick(retriveLocators(cardNeedRepo.getProperty("popupScreen")));
//        } catch (Throwable t) {
//            super.logger(scenario, t);
//        }
//        log.info("The Ability to access card view of the priority finish");
//    }
//
//    /*
//    Author     : Sumit Kumar
//    Description: This api will verify the metric view of Cards Needing Attention
//    Example    : viewCNAMetricView(dataTable)
//    Input      : (datatable)
//    OutputType : return void
//*/
//
//    public void viewCNAMetricView(DataTable dataTable) {
//        log.info("the metric view of Cards Needing Attention started");
//        try {
//            waitForPageToBeReady();
//            List<Map<String, String>> requests = dataTable.asMaps(String.class, String.class);
//            for (Map<String, String> eachCard : requests) {
//              //Jishnu-Assertion you have to added bcz this methdo returns boolean
//                super.isElementVisible(retriveLocators(multipleDynamicValueXpathGen(cardNeedRepo.getProperty("metricView"), eachCard.get("Values") + "," + eachCard.get("Status"))));
//            }
//        } catch (Throwable t) {
//            super.logger(scenario, t);
//        }
//        log.info("the metric view of Cards Needing Attention finish");
//    }
//
//    public void verifyDefaultZoomLevel(String zoomLevel) {
//        log.info("defaultZoomLevel started");
//        try {
//            waitForPageToBeReady();
//            super.elementClick(retriveLocators(cardNeedRepo.getProperty("expandButton")));
//            Assertions.assertTrue(isElementVisible(retriveLocators(multipleDynamicValueXpathGen(cardNeedRepo.getProperty("cna.zoomLevel"), zoomLevel))));
//            super.elementClick(retriveLocators(cardNeedRepo.getProperty("popupScreen")));
//        } catch (Throwable t) {
//            super.logger(scenario, t);
//        }
//        log.info("defaultZoomLevel finish");
//    }
//
//    //The below method implementation can take reference from Selenium jar EB class
//    public void setZoomLevel(String zoomLevel) {
//        log.info("setZoomLevel started");
//        try {
//            waitForPageToBeReady();
//            super.elementClick(retriveLocators(cardNeedRepo.getProperty("expandButton")));
//            if (zoomLevel.equals("1x")) {
//                waitForPageToBeReady();
//                super.elementDoubleClick(retriveLocators(cardNeedRepo.getProperty("zoomLevelPointer")));
//            } else if (zoomLevel.equals("2x")) {
//                waitForPageToBeReady();
//                super.elementClick(retriveLocators(cardNeedRepo.getProperty("zoomLevelPointer")));
//            } else if (zoomLevel.equals("3x")) {
//                Assertions.assertTrue(true);
//            } else {
//                Assertions.assertFalse(isElementVisible(retriveLocators(multipleDynamicValueXpathGen(cardNeedRepo.getProperty("zoomLevel"), zoomLevel))));
//            }
//
//        } catch (Throwable t) {
//            super.logger(scenario, t);
//        }
//        log.info("setZoomLevel finish");
//    }
//
//    public void verifyZoomLevelData(String data, String zoomLevel) {
//        log.info("verifyZoomLevelData started");
//        try {
//            //Jishnu- if condition not reuired direct u can write assertion -Check what is logic before change
//            waitForPageToBeReady();
//            if (zoomLevel.equals("1x")) {
//                waitForPageToBeReady();
//                if (!isElementVisible(retriveLocators(multipleDynamicValueXpathGen(cardNeedRepo.getProperty("cardNameOnCNA"), data)))) {
//                    Assertions.assertTrue(true);
//                }
//            } else if (zoomLevel.equals("2x")) {
//                waitForPageToBeReady();
//                String[] data1 = data.split(",");
//                for (String details : data1) {
//                    if (isElementVisible(super.retriveLocators(multipleDynamicValueXpathGen(cardNeedRepo.getProperty("cardDetails"), details))))
//                        Assertions.assertTrue(true);
//                    else {
//                        Assertions.assertFalse(isElementVisible(super.retriveLocators(multipleDynamicValueXpathGen(cardNeedRepo.getProperty("cardDetails"), details))));
//                    }
//                }
//            } else if (zoomLevel.equals("3x")) {
//                waitForPageToBeReady();
//                String[] data1 = data.split(",");
//                for (String details : data1) {
//                    if (isElementVisible(super.retriveLocators(multipleDynamicValueXpathGen(cardNeedRepo.getProperty("cardDetails"), details))))
//                        Assertions.assertTrue(true);
//                    else {
//                        Assertions.assertFalse(isElementVisible(super.retriveLocators(multipleDynamicValueXpathGen(cardNeedRepo.getProperty("cardDetails"), details))));
//                    }
//                }
//            }
//        } catch (Throwable t) {
//            super.logger(scenario, t);
//        }
//        log.info("verifyZoomLevelData finish");
//    }
//
//    public void openSettings() {
//        log.info("openSettings Started");
//        try {
//            waitForPageToBeReady();
//            super.elementClick(retriveLocators(cardNeedRepo.getProperty("settingButton")));
//        } catch (Throwable t) {
//            super.logger(scenario, t);
//        }
//        log.info("openSettings Completed");
//    }
//
//    public void setDependentCardsDue(String value) {
//        log.info("setDependentCardsDue Started");
//        try {
//            waitForPageToBeReady();
//            super.elementClick(retriveLocators(cardNeedRepo.getProperty("dependentCardsDue")));
//            super.enterChordKeys(retriveLocators(cardNeedRepo.getProperty("dependentCardsDue")), Keys.CONTROL, Keys.chord("a"));
//            super.enterKeys(retriveLocators(cardNeedRepo.getProperty("dependentCardsDue")), Keys.BACK_SPACE);
//            super.enterText(retriveLocators(cardNeedRepo.getProperty("dependentCardsDue")), value);
//            waitForPageToBeReady();
//        } catch (Throwable t) {
//            super.logger(scenario, t);
//        }
//        log.info("setDependentCardsDue Completed");
//    }
//
//    public void toggleCard(String value) {
//        log.info("toggleCard Started");
//        try {
//            waitForPageToBeReady();
//            super.elementClick(retriveLocators(multipleDynamicValueXpathGen(cardNeedRepo.getProperty("Card"), value)));
//            waitForPageToBeReady();
//        } catch (Throwable t) {
//            super.logger(scenario, t);
//        }
//        log.info("toggleCard Completed");
//
//
//    }
//
//    public void saveSettings() {
//        log.info("saveSettings Started");
//        try {
//            waitForPageToBeReady();
//            super.elementClick(retriveLocators(cardNeedRepo.getProperty("saveButton")));
//        } catch (Throwable t) {
//            super.logger(scenario, t);
//        }
//        log.info("saveSettings Completed");
//    }
//}