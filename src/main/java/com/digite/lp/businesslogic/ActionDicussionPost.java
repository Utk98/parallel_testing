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
@PropertySource("classpath:/objectRepository/actions_discussion_post.properties")
public class ActionDicussionPost extends Common {

    @Autowired
    private Environment discussionRepo;

    public ActionDicussionPost(WebDriverFactory webDriverFactory) throws Exception {
        super(webDriverFactory);
    }

    public void selectPostEditing(String title) throws Exception {
        log.info("selectPostEditing Started");
        try {
            super.elementClick(retriveLocators(multipleDynamicValueXpathGen(discussionRepo.getProperty("editButton"), title)));

        } catch (Exception e) {
            super.logger(scenario, e);
        }
        log.info("selectPostEditing Completed");
    }

    public void editPostTagUser(String editPost, String tagUser) throws Exception {
        log.info("editPostTagUser Started");
        try {
            super.enterText(retriveLocators(discussionRepo.getProperty("textboxEdit")),"");
            super.enterText(retriveLocators(discussionRepo.getProperty("textboxEdit")), editPost + "@" + tagUser);
            super.elementClick(retriveLocators(multipleDynamicValueXpathGen(discussionRepo.getProperty("OptionSelect"), tagUser)));
            super.elementClick(retriveLocators(discussionRepo.getProperty("postButton")));
        } catch (Exception e) {
            super.logger(scenario, e);
        }
        log.info("editPostTagUser Completed");

    }

    public void verifyEditButton(String title, String isCheck) {
        log.info("verifyEditButton Started");
        try {
            super.waitForPageToBeReady();
            boolean check = isElementVisible(retriveLocators(multipleDynamicValueXpathGen(discussionRepo.getProperty("editButton"), title)));
//            if (isCheck.equals("visible")) {
//                Assertions.assertTrue(check);
//            } else if (isCheck.equals("notVisible")) {
//                Assertions.assertTrue(!check);
//            }
        } catch (Throwable t) {
            super.logger(scenario, t);
        }
        log.info("verifyEditButton Completed");
    }

    public void viewPost(String titlePost) {
        log.info("viewPost Started");
        try {
            //after login page load 2seconds
            waitForTheElement(retriveLocators(multipleDynamicValueXpathGen(discussionRepo.getProperty("verifyPost"), titlePost)),VISIBILITY_OF_ELEMENT_LOCATED);
            scroll(retriveLocators(multipleDynamicValueXpathGen(discussionRepo.getProperty("verifyPost"), titlePost)));
//            Assertions.assertTrue(isElementVisible(retriveLocators(multipleDynamicValueXpathGen(discussionRepo.getProperty("verifyPost"), titlePost))));
        } catch (Throwable t) {
            super.logger(scenario, t);
        }
        log.info("viewPost Completed");
    }

    public void verifyPostInCafe(String post, String tag) {
        log.info("verifyPostInCafe Started");
        try {
            Thread.sleep(4000);
            refreshBrowser();
            //Jishnu-Check getText method has wait or not and report back
            waitForTheElement(retriveLocators(multipleDynamicValueXpathGen(discussionRepo.getProperty("verifyPostInCafe"), post)), VISIBILITY_OF_ELEMENT_LOCATED);
            String verifyPostInCafe = getText(multipleDynamicValueXpathGen(discussionRepo.getProperty("verifyPostInCafe"), post));
            String[] verifyPostInCafe2 = verifyPostInCafe.split(tag);
            scroll(retriveLocators(multipleDynamicValueXpathGen(discussionRepo.getProperty("verifyPostInCafe"), post)));
//            Assertions.assertEquals(verifyPostInCafe2[0], post);
        } catch (Throwable t) {
            super.logger(scenario, t);
        }
        log.info("verifyPostInCafe Completed");
    }

//    public void ListofLikedUser(String postName, String Users) throws Exception {
//        waitForPageToBeReady();
//        super.elementClick(retriveLocators(multipleDynamicValueXpathGen(discussionRepo.getProperty("LikesCount"), postName)));
//        int check = 0;
//        List<String> userLikeList = super.ge(discussionRepo.getProperty("likeUserList"));
//        if (Users.contains(",")) {
//            String[] usersList = Users.split(",");
//            for (String list : usersList) {  // System.out.println("Inside for loop 1st loop");
//                for (int i = 0; i < userLikeList.size(); i++) {
//                    //  System.out.println("Inside for loop 2nd loop");
//                    if (list.contains(userLikeList.get(i))) {
//                        Assertions.assertEquals(list, super.getText(userLikeList.get(i)));
//                        check = check + 1;
//                    }
//                }
//                if (check == 0) {
//                    Assertions.assertTrue(false);
//                }
//            }
//
//        } else {
//            //System.out.println("Inside else loop");
//            Assertions.assertEquals(Users, super.getText(discussionRepo.getProperty("likeUserList")));
//
//        }
//    }
//

    public void createCommentLP(String Comments, String Team, String workItem) throws Exception {
        scroll(retriveLocators(multipleDynamicValueXpathGen(discussionRepo.getProperty("comment"), workItem)));
        super.elementClick(retriveLocators(multipleDynamicValueXpathGen(discussionRepo.getProperty("comment"), workItem)));
        super.enterText(retriveLocators(discussionRepo.getProperty("addComments")), Comments);
        super.elementClick(retriveLocators(multipleDynamicValueXpathGen(discussionRepo.getProperty("tagTeam"), Team)));
        super.elementClick(retriveLocators(discussionRepo.getProperty("addCommentButton")));
        //Jishnu- You can remove frames
    }

    public void replyComment(String replyComment, String comment, String workItem, String tag) throws Exception {
        //Jishnu- You can remove frames
        //JIshnu- You can replcae below code with scroll method
        scroll(retriveLocators(multipleDynamicValueXpathGen(discussionRepo.getProperty("comment"), workItem)));
        super.elementClick(retriveLocators(multipleDynamicValueXpathGen(discussionRepo.getProperty("comment"), workItem)));
       ///Jishnu-Remove wait
        super.clickUsingAction(retriveLocators(multipleDynamicValueXpathGen(discussionRepo.getProperty("commentReplyButton"), comment)));
        ///Jishnu-Remove wait
        super.enterText(retriveLocators(discussionRepo.getProperty("commentReplyText")), replyComment);
        super.appendText(discussionRepo.getProperty("commentReplyText"), "@");
        super.elementClick(retriveLocators(multipleDynamicValueXpathGen(discussionRepo.getProperty("tagTeam"), tag)));
        super.clickUsingAction(retriveLocators(discussionRepo.getProperty("replyButton")));
        //Jishnu- You can remove frames

    }

}


