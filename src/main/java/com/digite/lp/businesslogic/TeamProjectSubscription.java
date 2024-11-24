package com.digite.lp.businesslogic;//package com.digite.lp.businesslogic;
//
//import com.digite.actions.commands.Common;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.Assertions;
//import org.openqa.selenium.WebDriver;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.env.Environment;
//import org.springframework.stereotype.Component;
//
//@Slf4j
//@Component
//@PropertySource("classpath:/objectRepository/teamProjectSubscription.properties")
//public class TeamProjectSubscription extends Common {
//
//    @Autowired
//   private Environment teamProjectSubscribe;
//
//    public TeamProjectSubscription(WebDriver driver) {
//        super(driver);
//    }
//
//    /*
//        Author     : Mayur Ovhal
//        Description: It will open the subscription setting on landing page
//        Example    : openSubscriptionPopup()
//        Input      : null
//        OutputType : return null
//    */
//   public void openSubscriptionPopup(){
//       log.info("click on subscription setting Started, Success");
//        try{
//
//            super.waitForPageToBeReady();
//            super.clickUsingAction(retriveLocators(teamProjectSubscribe.getProperty("subscriptionSetting")));
//            Assertions.assertTrue(super.isElementVisible(retriveLocators(teamProjectSubscribe.getProperty("verifyPopup"))));
//        }catch (Throwable t){
//            super.logger(scenario, t);
//        }
//       log.info("click on subscription setting Completed, Success");
//   }
//
//    /*
//         Author     : Mayur Ovhal
//         Description: It will verify the teams and projects which are selected/subscribe in Team News/Project News, setting landing page
//         Example    : verifySubscription(String subscriptionType, String selectedOption)
//         Input      : subscriptionType=Team News/Project News; selectedOption=Teams Name/Project Names
//         OutputType : return null
//     */
//   public void verifySubscription(String subscriptionType, String selectedOption){
//       log.info("verify subscription Started, Success");
//       try{
//           String[] options =selectedOption.split(",");
//           super.waitForPageToBeReady();
//
//            if(subscriptionType.equalsIgnoreCase("Team News")){
//                super.clickUsingAction(retriveLocators(multipleDynamicValueXpathGen(teamProjectSubscribe.getProperty("genericCommonButton"), subscriptionType)));
//            }else{
//                super.clickUsingAction(retriveLocators(multipleDynamicValueXpathGen(teamProjectSubscribe.getProperty("genericCommonButton"), subscriptionType)));
//            }
//           for (String eachOption:options) {
//               Assertions.assertTrue(super.isElementVisible(retriveLocators(multipleDynamicValueXpathGen(teamProjectSubscribe.getProperty("checkedOption"), eachOption))));
//           }
//           super.clickUsingAction(retriveLocators(teamProjectSubscribe.getProperty("closePopup")));
//           super.waitForPageToBeReady();
//           Assertions.assertFalse(super.isElementVisible(retriveLocators(teamProjectSubscribe.getProperty("verifyPopup"))));
//
//       }catch (Throwable t){
//           super.logger(scenario, t);
//       }
//       log.info("verify subscription Completed, Success");
//   }
//
//    /*
//          Author     : Mayur Ovhal
//          Description: It will verify the posts in respective space (Team Space/Project Space), present or not
//          Example    : verifyPosts(String spaceName, String taggedPosts, String value)
//          Input      : spaceName=Team Space/Project Space; taggedPosts=Hi this is the Test :Demo1,How are you :Demo2 (It will be comma separator after that it will separate by colon as text and tagName)
//                        value=not visible/visible (this condition is for the post should visible or not)
//          OutputType : return null
//      */
//   public void verifyPosts(String spaceName, String taggedPosts, String value){
//       log.info("verify Posts on Team and project space Started, Success");
//        try{
//            String[] eachTaggedPosts = taggedPosts.split(",");
//            super.clickUsingAction(retriveLocators(multipleDynamicValueXpathGen(teamProjectSubscribe.getProperty("genericCommonButton"), spaceName)));
//            super.waitForPageToBeReady();
//            for (String allPosts:eachTaggedPosts) {
//                String[] eachTagPost = allPosts.split(":");
//                if(value.equalsIgnoreCase("visible")){
//                   scroll(retriveLocators(multipleDynamicValueXpathGen(teamProjectSubscribe.getProperty("posts"), eachTagPost[0]+"|"+eachTagPost[1])));
//                   waitForTheElement(retriveLocators(multipleDynamicValueXpathGen(teamProjectSubscribe.getProperty("posts"), eachTagPost[0]+"|"+eachTagPost[1])),VISIBILITY_OF_ELEMENT_LOCATED);
//                    Assertions.assertTrue(super.isElementVisible(retriveLocators(multipleDynamicValueXpathGen(teamProjectSubscribe.getProperty("posts"), eachTagPost[0]+"|"+eachTagPost[1]))));
//                } else{
//                    Assertions.assertFalse(isElementVisible(retriveLocators(multipleDynamicValueXpathGen(teamProjectSubscribe.getProperty("posts"), eachTagPost[0]+"|"+eachTagPost[1]))));
//                }
//
//            }
//
//        }catch (Throwable t){
//            super.logger(scenario, t);
//        }
//       log.info("verify Posts on Team and project space Completed, Success");
//   }
//
//    /*
//         Author     : Mayur Ovhal
//         Description: It will unsubscribe the teams/projects from Team News/Project News in setting landing page
//         Example    : unsubscribeTeamAndProject(String subscriptionType, String selectedOption)
//         Input      : subscriptionType=Team News/Project News; selectedOption=Teams Name/Project Names
//         OutputType : return null
//     */
//   public void unsubscribeTeamAndProject(String subscriptionType, String selectedOption){
//       log.info("Unsubscribe team and project Started, Success");
//        try{
//
//            String[] options =selectedOption.split(",");
//            super.waitForPageToBeReady();
//
//            if(subscriptionType.equalsIgnoreCase("Team News")){
//                super.clickUsingAction(retriveLocators(multipleDynamicValueXpathGen(teamProjectSubscribe.getProperty("genericCommonButton"), subscriptionType)));
//            }else{
//                super.clickUsingAction(retriveLocators(multipleDynamicValueXpathGen(teamProjectSubscribe.getProperty("genericCommonButton"), subscriptionType)));
//            }
//
//            for (String eachOption:options) {
//                super.clickUsingAction(retriveLocators(multipleDynamicValueXpathGen(teamProjectSubscribe.getProperty("checkedOption"), eachOption)));
//            }
//            super.clickUsingAction(retriveLocators(multipleDynamicValueXpathGen(teamProjectSubscribe.getProperty("genericCommonButton"), "APPLY")));
//            super.waitForPageToBeReady();
//            Assertions.assertFalse(super.isElementVisible(retriveLocators(teamProjectSubscribe.getProperty("verifyPopup"))));
//
//        }catch (Throwable t){
//            super.logger(scenario, t);
//        }
//       log.info("Unsubscribe team and project Completed, Success");
//   }
//}
