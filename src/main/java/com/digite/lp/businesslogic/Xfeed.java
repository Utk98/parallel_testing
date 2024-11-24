package com.digite.lp.businesslogic;//package com.digite.lp.businesslogic;
//
//import com.digite.actions.commands.Common;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.Assertions;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.env.Environment;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@Component
//@Slf4j
//@PropertySource("classpath:/objectRepository/xfeed.properties")
//public class Xfeed extends Common {
//
//    @Autowired
//    Environment xfeed;
//
//    public Xfeed(WebDriver driver) {
//        super(driver);
//    }
//
//
//    /*
//           Author     : Raies
//           Description: verifying Tweet Counts
//           Example    : verifyXfeedCount(Integer count)
//           Input      : Integer count
//           OutputType : return null
//       */
//    public void verifyXfeedCount(Integer count){
//        log.info("verifyXfeedCount Started");
//        try {
//            scroll(retriveLocators(xfeed.getProperty("feed.xFeedCount")));
//            List<WebElement> listOfElements = getListOfElements(xfeed.getProperty("feed.xFeedCount"));
//            customWaitForElement(retriveLocators(xfeed.getProperty("feed.xFeedCount")),VISIBILITY_OF_ELEMENT_LOCATED,25);
//            Assertions.assertTrue(count.equals(listOfElements.size()));
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//       log.info("verifyXfeedCount Completed");
//    }
//
//    /*
//        Author     : Raies
//        Description: Feed's Setting
//        Example    : xfeedSetting()
//        Input      : return null
//        OutputType : return null
//    */
//    public void xfeedSetting(){
//        log.info("xfeedSetting Started");
//        try {
//           elementClick(retriveLocators(xfeed.getProperty("feed.xfeedSettings")));
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    log.info("xfeedSetting Completed");
//    }
//
//    /*
//      Author     : Raies
//      Description: Selecting How many Feed's need to visible in cafe
//      Example    :  SelectFeeds(String number)
//      Input      : String number
//      OutputType : return null
//  */
//    public void selectFeeds(String number){
//        log.info("feed Started");
//        try {
//           elementClick(retriveLocators(xfeed.getProperty("feed.xFeedLabel")));
//           elementClick(retriveLocators(multipleDynamicValueXpathGen(xfeed.getProperty("feed.noOfXfeed"),String.valueOf(number))));
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        log.info("feeds Completed");
//    }
//
//    /*
//     Author     : Raies
//     Description: Adding Tags
//     Example    :  areaOfInterest(String genre)
//     Input      : String genre
//     OutputType : return null
// */
//    public void areaOfInterest(String genre){
//        log.info("areaOfInterest Started");
//        try {
//            elementClick(retriveLocators(xfeed.getProperty("feed.areaOfInterest")));
//            //enter text method is not supporting in areaOfIntrest Input field
//            driver.findElement(retriveLocators(xfeed.getProperty("feed.areaOfInterest"))).sendKeys(genre+ Keys.ENTER);
//            elementClick(retriveLocators(xfeed.getProperty("feed.areaOfInterest")));
//          elementClick(retriveLocators(xfeed.getProperty("feed.save")));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        log.info("areaOfInterest Completed");
//    }
//
//}
