package com.digite.lp.businesslogic;//package com.digite.lp.businesslogic;
//
//
//import com.app.SE.PageObjectsFactory;
//import com.digite.actions.commands.Common;
//import io.cucumber.datatable.DataTable;
//import io.cucumber.java.Before;
//import io.cucumber.java.Scenario;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.Assertions;
//import org.openqa.selenium.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.env.Environment;
//import org.springframework.stereotype.Component;
//
//import java.util.*;
//
//
//@Slf4j
//@Component
//public class Discussion extends Common {
//
////    @Autowired
////    private Environment discussionRepo;
//    Properties discussionRepo= PageObjectsFactory.loadProperties("Discussion.properties");
//
//    Properties landingPageRepo= PageObjectsFactory.loadProperties("LandingPageComponent.properties");
//
//    Properties actions_discussion_post= PageObjectsFactory.loadProperties("actions_discussion_post.properties");
//
//    public Discussion(WebDriver driver) {
//        super(driver);
//    }
//    @Autowired
//    Session s1;
//
//    public void startDiscussion() throws Exception {
//        log.info("Start the Discussion Started");
//        try {
//            super.waitForPageToBeReady();
//            System.out.println(discussionRepo.getProperty("StartDiscussion"));
//            super.elementClick(retriveLocators(discussionRepo.getProperty("StartDiscussion")));
//        } catch (Throwable t) {
//            super.logger(scenario, t);
//        }
//        log.info("Start the Discussion completed");
//    }
//
//    public void enterPostTitle(String contentToBeDiscussed) throws Exception {
//        log.info("Enter title for a post Started");
//        try {
//            super.enterText(retriveLocators(discussionRepo.getProperty("Title")), contentToBeDiscussed + Keys.CONTROL + Keys.END);
//
//        } catch (Exception e) {
//            super.logger(scenario, e);
//        }
//
//        log.info("Enter title for a post completed");
//    }
//
//    /*
//               Author     : Raies
//               Description: unselectin all user in individual,teams,projects
//               Example    : select particular user's,team,projetc
//               Input      : unselect All, users
//               OutputType : return null
//           */
//    public void unSelectingUser(String user, String unselect) {
//        log.info("Selecting User");
//        try {
//            String[] users = user.split(",");
//            String[] unselects = unselect.split(",");
//            elementClick(retriveLocators(discussionRepo.getProperty("postTag")));
//            for (int i = 0; i < users.length; i++) {
//
//                elementClick(retriveLocators(multipleDynamicValueXpathGen(discussionRepo.getProperty("postVisiblitySettings"), users[i])));
//                elementClick(retriveLocators(multipleDynamicValueXpathGen(discussionRepo.getProperty("selectUser"), "Select all users")));
//            }
//
////            elementClick(retriveLocators(discussionRepo.getProperty("postSaveButton")));
//
//        } catch (Exception e) {
//            super.exceptionLogger(scenario, e);
//        }
//        log.info("User selected");
//    }
//
//     /*
//                    Author     : Raies
//                    Description: selecting users in postTo
//                    Example    :selectingUser(user)
//                    Input      :String User
//                    OutputType : return null
//                */
//
//    public void selectingUser(String user) {
//        log.info("Selecting User");
//        try {
//            String[] users = user.split(",");
//            if (isElementVisible(retriveLocators(discussionRepo.getProperty("postTag"))))
//                elementClick(retriveLocators(discussionRepo.getProperty("postTag")));
////            elementClick(retriveLocators(discussionRepo.getProperty("postTag")));
//            if (users[0].equals("Users")){
//                enterText(retriveLocators(discussionRepo.getProperty("search")), users[1].substring(0,3));
//            }
//            elementClick(retriveLocators(multipleDynamicValueXpathGen(discussionRepo.getProperty("postVisiblitySettings"), users[0])));
////          Thread.sleep(5000);
////            elementClick(retriveLocators(landingPageData.get("postInputField")));
////           enterText(landingPageData.get("postInputField"),users[1]);
//            elementClick(retriveLocators(multipleDynamicValueXpathGen(discussionRepo.getProperty("selectUser"), users[1])));
//            elementClick(retriveLocators(discussionRepo.getProperty("postSaveButton")));
//
//        } catch (Exception e) {
//            super.exceptionLogger(scenario, e);
//        }
//        log.info("User selected");
//    }
//
//    public void post() {
//        log.info("Posting the discussion");
//        try {
//            super.elementClick(retriveLocators(discussionRepo.getProperty("Post")));
//        } catch (Throwable t) {
//            super.logger(scenario, t);
//        }
//        log.info("Posted the discussion");
//
//    }
//
//    public void cancel(String action) {
//        log.info("Cancel the discussion");
//        try {
//            super.elementClick(retriveLocators(discussionRepo.getProperty("Cancel")));
//        } catch (Throwable t) {
//            super.logger(scenario, t);
//        }
//        log.info("Cancelled the discussion");
//
//    }
//
//    public boolean verifyPost(String title) {
//        log.info("Verifying the discussion posted");
//        try {
//            Assertions.assertEquals(title, super.getText(discussionRepo.getProperty("PostedDiscussion")));
//
//        } catch (Throwable t) {
//            super.logger(scenario, t);
//        }
//        log.info("Verified the discussion posted");
//        return true;
//    }
//
//    public boolean verifyMembersTagged(String taggedMembers) {
//        //verify the post
//        try {
//            List<WebElement> personaID = super.getListOfElements("lpUsers");
//            if (taggedMembers.contains(",")) {
//                String[] splitPersonas = taggedMembers.split("\n ,");
//                for (String personas :
//                        splitPersonas) {
//                    for (int i = 0; i < personaID.size(); i++) {
//                        Assertions.assertEquals(personas, super.getText(String.valueOf(personaID.get(i))));
//                    }
//                }
//                Assertions.assertEquals("", super.getText("users"));
//            } else {
//                Assertions.assertEquals(taggedMembers, super.getText("users"));
//            }
//
//        } catch (Throwable t) {
//            super.logger(scenario, t);  // check for common handler
//        }
//        return true;
//    }
//
//    public void confirmOnUntaggedPost(String confirmation) {
//        log.info("Confirming the warning message displayed when no-one is tagged");
//        try {
//            Assertions.assertEquals(confirmation, super.getText(discussionRepo.getProperty("ConfirmationMessage")));
//            elementClick(retriveLocators(discussionRepo.getProperty("AcceptConfirmation")));
//        } catch (Throwable t) {
//            super.logger(scenario, t);
//        }
//        log.info("Confirmed the warning message displayed when no-one is tagged");
//    }
//
//    public void verifyConfirmation(String confirmation) {
//        log.info("verify the warning message displayed when no-one is tagged");
//        try {
//            Assertions.assertEquals(confirmation, super.getText(discussionRepo.getProperty("ConfirmationMessage")));
//        } catch (Throwable t) {
//            super.logger(scenario, t);
//        }
//        log.info("verify the warning message displayed when no-one is tagged");
//    }
//
//    public void cancelOnUntaggedPost(String confirmation) {
//        log.info("Cancelling the warning message displayed when no-one is tagged");
//        try {
//            Assertions.assertEquals(confirmation, super.getText(discussionRepo.getProperty("ConfirmationMessage")));
//            cancel("Cancel");
//        } catch (Throwable t) {
//            super.logger(scenario, t);
//        }
//        log.info("Cancelling the warning message displayed when no-one is tagged");
//    }
//
//    public void verifyPostButton() {
//        log.info("verifyPostButton when user clicks on cancel in confirmation message.");
//        try {
//            Assertions.assertTrue(isElementVisible(retriveLocators(discussionRepo.getProperty("Post"))));
//
//        } catch (Throwable t) {
//            super.logger(scenario, t);
//        }
//        log.info("verifyPostButton when user clicks on cancel in confirmation message.");
//    }
//
//    //like post
//    public void likePost(String postName) {
//        log.info("clicking on like button");
//        try {
//            //after login page load 2seconds
//            waitForTheElement(retriveLocators(multipleDynamicValueXpathGen(discussionRepo.getProperty("post"), postName)),VISIBILITY_OF_ELEMENT_LOCATED);
//            scroll(retriveLocators(multipleDynamicValueXpathGen(discussionRepo.getProperty("post"), postName)));
//            super.elementClick(retriveLocators(multipleDynamicValueXpathGen(discussionRepo.getProperty("likeButton"), postName)));
//        } catch (Throwable t) {
//            super.logger(scenario, t);
//        }
//        log.info("post is liked");
//    }
//
//    public void verifyLikeCount(String count, String postName) {
//        log.info("verify the liked count on post");
//        try {
//            waitForTheElement(retriveLocators(multipleDynamicValueXpathGen(discussionRepo.getProperty("postDiscuss"), postName)),VISIBILITY_OF_ELEMENT_LOCATED);
//            super.scroll(retriveLocators(multipleDynamicValueXpathGen(discussionRepo.getProperty("postDiscuss"), postName)));
//            String likeCount = super.getText(multipleDynamicValueXpathGen(actions_discussion_post.getProperty("LikesCount"), postName));
//            if (!isElementVisible(retriveLocators(multipleDynamicValueXpathGen(actions_discussion_post.getProperty("LikesCount"), postName)))) {
//                Assertions.assertTrue(true);
//            } else if (likeCount.equals(count)) {
//                Assertions.assertTrue(true);
//            } else {
//                Assertions.assertTrue(false);
//            }
//        } catch (Throwable t) {
//            super.logger(scenario, t);
//        }
//        log.info("verified the liked count on post");
//    }
//
//    public void initiateKudo() {
//        log.info("Initiate Kudo Started");
//        try {
//            super.waitForPageToBeReady();
//            super.elementClick(retriveLocators(discussionRepo.getProperty("Kudos")));
//        } catch (Throwable t) {
//            super.logger(scenario, t);
//        }
//        log.info("Initiate Kudo completed");
//    }
//
//
//    public void tagPersonOrTeam(String PersonOrTeamToBeTagged) {
//        log.info("tagPersonOrTeam Started");
//        try {
////            driver.findElement(retriveLocators(discussionRepo.getProperty("SearchColleague"))).clear();
//            super.enterText(retriveLocators(discussionRepo.getProperty("SearchColleague")), PersonOrTeamToBeTagged);
//            super.elementClick(retriveLocators(multipleDynamicValueXpathGen(discussionRepo.getProperty("SelectPersonTeamProject"), PersonOrTeamToBeTagged)));
//            super.elementClick(retriveLocators(discussionRepo.getProperty("Next")));
//        } catch (Throwable t) {
//            super.logger(scenario, t);
//        }
//        log.info("tagPersonOrTeam completed");
//    }
//
//    public void selectKudoType(String kudoType) {
//        log.info("selectKudoType Started");
//        try {
//            super.elementClick(retriveLocators(multipleDynamicValueXpathGen(discussionRepo.getProperty("selectKudoType"), kudoType)));
//
//        } catch (Throwable t) {
//            super.logger(scenario, t);
//        }
//        log.info("selectKudoType completed");
//    }
//
//    public void previewKudo() {
//        log.info("previewKudo Started");
//        try {
//            super.elementClick(retriveLocators(discussionRepo.getProperty("Preview")));
//
//        } catch (Throwable t) {
//            super.logger(scenario, t);
//        }
//        log.info("previewKudo completed");
//    }
//
//    public void selectNewsFeed(String FeedType) {
//        log.info("selectNewsFeed Started");
//        try {
//            super.elementClick(retriveLocators(multipleDynamicValueXpathGen(discussionRepo.getProperty("selectNewsFeed"), FeedType)));
//
//        } catch (Throwable t) {
//            super.logger(scenario, t);
//        }
//        log.info("selectNewsFeed completed");
//    }
//
//    public void tab(String tab) {
//        log.info("verifyPostedKudo Started");
//        try {
//            super.elementClick(retriveLocators(multipleDynamicValueXpathGen(discussionRepo.getProperty("cafe_tab"), tab)));
//        } catch (Throwable t) {
//            super.logger(scenario, t);
//        }
//        log.info("verifyPostedKudo completed");
//    }
//
//    public void verifyTeamAndProjectCheckBox() {
//        log.info("verifyTeamAndProjectCheckBox Started");
//
//        try {
//            Thread.sleep(2000);
//            elementClick(retriveLocators(discussionRepo.getProperty("settingIcn")));
//            if (isElementVisible(retriveLocators(discussionRepo.getProperty("radioBox")))) {
//                elementClick(retriveLocators(discussionRepo.getProperty("selectAll")));
//                elementClick(retriveLocators(discussionRepo.getProperty("applyBtn")));
//            } else elementClick(retriveLocators(discussionRepo.getProperty("applyBtn")));
//
//        } catch (Throwable t) {
//            super.logger(scenario, t);
//        }
//        log.info("verifyTeamAndProjectCheckBox completed");
//    }
//
//    public void verifyPostedKudo(String kudotype, String kudoUser) {
//        log.info("verifyPostedKudo Started");
//        try {
//            //waiting till page load and element visible
//            waitForTheElement(retriveLocators(discussionRepo.getProperty("PostedKudoType")),VISIBILITY_OF_ELEMENT_LOCATED);
//            Assertions.assertEquals( kudotype,super.getText(discussionRepo.getProperty("PostedKudoType")), "Both Actual and Expected are False");
//            Assertions.assertEquals( kudoUser, super.getText(discussionRepo.getProperty("PostedKudoUser")),"Both Actual and Expected are False");
//
//        } catch (Throwable t) {
//            super.logger(scenario, t);
//        }
//        log.info("verifyPostedKudo completed");
//    }
//
//    public void verifyPostedKudoInTeamAndProjectSection(String tab, String kudoUser) {
//        log.info("verifyPostedKudo Started");
//        try {
//            elementClick(retriveLocators(multipleDynamicValueXpathGen(discussionRepo.getProperty("spaceSection"), tab)));
//            Assertions.assertEquals(kudoUser, super.getText(discussionRepo.getProperty("PostedKudoUser")));
//        } catch (Throwable t) {
//            super.logger(scenario, t);
//        }
//        log.info("verifyPostedKudo completed");
//    }
//
//    public void isAppendText(String locator, String textToBeAppended) throws Exception {
//        log.info("appendText Started");
//        try {
//            //Jishnu-You can use enterCHords methods for belwo lines
//            super.enterChordKeys(this.retriveLocators(locator),Keys.CONTROL,"");
//            for (char c : textToBeAppended.toCharArray()) {
//                Thread.sleep(1000);
//                if (c == ' ') break;
//                else {
//                    //Jishnu-Check whether we can use enter text here
//                    this.local_element.sendKeys(new CharSequence[]{"" + c});
//
//                }
//            }
//            this.local_element.sendKeys(new CharSequence[]{Keys.ENTER});
//        } catch (Exception e) {
//            super.logger(scenario, e);
//        }
//
//        log.info("appendText completed");
//    }
//
//
//    public void appendText(String textToBeAppended) {
//        log.info("appendText Started");
//        try {
//            isAppendText(discussionRepo.getProperty("Title"), Keys.SPACE+"@" + textToBeAppended.substring(0));
//           //Jishnu-Remove this mehtod
//
//        } catch (Throwable t) {
//            super.logger(scenario, t);
//        }
//        log.info("appendText completed");
//    }
//
//    public void searchListWithKeyword(String keyword) {
//        log.info("searchListWithKeyword Started");
//        try {
//            //Jishnu- Remove This lines with enterChords
//            enterText(super.retriveLocators(discussionRepo.getProperty("Title"))," " + "@" + keyword);
//        } catch (Throwable t) {
//            super.logger(scenario, t);
//        }
//        log.info("searchListWithKeyword completed");
//    }
//
//    public void getTagList(String expectedTagList) throws Exception {
//        log.info("getTagList Started");
//        try {
//            String[] taggedList = expectedTagList.split(",");
//            //Jishnu-Remove unsued variables
//            String actualTagList = "";
//            Set<String> set = new LinkedHashSet<>();
//            for (String str : taggedList) {
//
//                set.add(str);
//            }
//
//            for (String list : set) {
//                actualTagList = actualTagList + list + ",";
//            }
//            Assertions.assertEquals(expectedTagList, actualTagList);
//        } catch (Exception e) {
//            super.logger(scenario, e);
//        }
//
//        log.info("getTagList completed");
//    }
//
//    public void verifyPostForEachUser(DataTable a_data, String FeedType, String PostTitle) {
//        log.info("verifyPostForEachUser Started");
//        try {
//            List<List<String>> w_datas = a_data.cells();
//            for (int i = 0; i < w_datas.size(); i++) {
//                String w_userName = w_datas.get(i).toString();
//                s1.getUserSession(w_userName);
//                selectNewsFeed(FeedType);
//                verifyPost(PostTitle);
//            }
//        } catch (Throwable t) {
//            super.logger(scenario, t);
//        }
//        log.info("verifyPostForEachUser completed");
//    }
//
//    public void getUserSession(String userName) {
//        log.info("getUserSession Started");
//        try {
//            s1.getUserSession(userName);
//
//        } catch (Throwable t) {
//            super.logger(scenario, t);
//        }
//        log.info("getUserSession completed");
//    }
//
//    public void verifyPostIsNotifyToTaggedUser(String userName) {
//        log.info("Verify Post Is Notify To TaggedUser");
//        try {
//            waitForTheElement(retriveLocators(multipleDynamicValueXpathGen(discussionRepo.getProperty("taggedUser"), userName)), VISIBILITY_OF_ELEMENT_LOCATED);
//            scroll(retriveLocators(multipleDynamicValueXpathGen(discussionRepo.getProperty("taggedUser"), userName)));
//            //Jishnu-Remove the variable and directly write in assertions
//            Assertions.assertEquals(userName, getText(multipleDynamicValueXpathGen(discussionRepo.getProperty("taggedUser"), userName)));
//        } catch (Throwable t) {
//            super.logger(scenario, t);
//        }
//        log.info("getUserSession completed");
//    }
//
//    public void verifyingPost(String post, String tag) {
//        log.info("Verify Post Is Notify To TaggedUser");
//        try {
//            waitForPageToBeReady();
//            scroll(retriveLocators(multipleDynamicValueXpathGen(discussionRepo.getProperty("post"), post)));
//            String text = getText(multipleDynamicValueXpathGen(discussionRepo.getProperty("post"), post));
//            String[] comments = text.split(tag);
//            Assertions.assertEquals(post, comments[0].trim(), "Both Actual: " + post + " Expected: " + comments[0] + " are true");
//
//
//        } catch (Throwable t) {
//            super.logger(scenario, t);
//        }
//        log.info("getUserSession completed");
//    }
//
//    public void editPostByUser(String postName) {
//        log.info("editPost Started");
//        try {
//            super.clickUsingJSexe(retriveLocators(multipleDynamicValueXpathGen(discussionRepo.getProperty("editKudoPost"), postName)));
//        } catch (Throwable t) {
//            super.logger(scenario, t);
//        }
//        log.info("editPost completed");
//    }
//
//    public void editPost(String postName) {
//        log.info("editPost Started");
//        try {
//            Thread.sleep(2000);
//            scroll(retriveLocators(multipleDynamicValueXpathGen(discussionRepo.getProperty("editPost"), postName)));
//            super.elementClick(retriveLocators(multipleDynamicValueXpathGen(discussionRepo.getProperty("editPost"), postName)));
//        } catch (Throwable t) {
//            super.logger(scenario, t);
//        }
//        log.info("editPost completed");
//    }
//
//    public void editKudoPost(String postName) {
//        log.info("editKudoPost Started");
//        try {
//            super.elementClick(retriveLocators(multipleDynamicValueXpathGen(discussionRepo.getProperty("editKudoPost"), postName)));
//
//        } catch (Throwable t) {
//            super.logger(scenario, t);
//        }
//        log.info("editKudoPost completed");
//    }
//
//    public void removeKudoImage() {
//        log.info("removeKudoImage Started");
//        try {
//            super.elementClick(retriveLocators(discussionRepo.getProperty("deleteKudoType")));
//        } catch (Throwable t) {
//            super.logger(scenario, t);
//        }
//        log.info("removeKudoImage completed");
//    }
//
//    public void editKudo() {
//        log.info("editKudo Started");
//        try {
//            super.elementClick(retriveLocators(discussionRepo.getProperty("editKudoType")));
//
//        } catch (Throwable t) {
//            super.logger(scenario, t);
//        }
//        log.info("editKudo completed");
//    }
//
//    public void removeTagPerson(String user) {
//        log.info("remove tagged user started");
//        try {
//            super.clickUsingAction(retriveLocators(discussionRepo.getProperty("SearchColleague")));
//            enterText(retriveLocators(discussionRepo.getProperty("SearchColleague")),""+Keys.BACK_SPACE);
//        } catch (Throwable t) {
//            super.logger(scenario, t);
//        }
//        log.info("remove tagged user completed");
//    }
//
//    public void verifyKudoPopupTitle() {
//        log.info("verifyKudoPopupTitle");
//        try {
//            waitForTheElement(retriveLocators(discussionRepo.getProperty("kudoPopupTitle")),VISIBILITY_OF_ELEMENT_LOCATED);
//            Assertions.assertTrue(isElementVisible(retriveLocators(discussionRepo.getProperty("kudoPopupTitle"))));
//        } catch (Throwable t) {
//            super.logger(scenario, t);
//        }
//        log.info("verifyKudoPopupTitle");
//    }
//
//    public void modifyKudoText(String textToBeAppended) {
//        log.info("modifyKudoText Started");
//        try {
//            //Jishnu-Enterchords methods
//            enterText(super.retriveLocators(discussionRepo.getProperty("Title"))," " + textToBeAppended);
//
//        } catch (Throwable t) {
//            super.logger(scenario, t);
//        }
//        log.info("modifyKudoText completed");
//    }
//
//    public void loadNewsSection(String section) {
//        log.info("loadNewsSection Started");
//        try {
//            String[] split = section.split(",");
//            for (int i = 0; i < split.length; i++) {
//                elementClick(retriveLocators(multipleDynamicValueXpathGen(discussionRepo.getProperty("section"), split[i])));
//                verifyNoPostsImage();
//            }
//
//        } catch (Throwable t) {
//            super.logger(scenario, t);
//        }
//        log.info("loadNewsSection completed");
//    }
//
//    public void verifyPostInSections(String tag, String post, String section) {
//        log.info("loadNewsSection Started");
//        try {
//            String[] split = section.split(",");
//            for (int i = 0; i < split.length; i++) {
//                if (isElementVisible(retriveLocators(multipleDynamicValueXpathGen(discussionRepo.getProperty("section"), split[i])))) {
//                    elementClick(retriveLocators(multipleDynamicValueXpathGen(discussionRepo.getProperty("section"), split[i])));
//                    verifyingPost(post, tag);
//                } else {
//                    refreshBrowser();
//                    elementClick(retriveLocators(multipleDynamicValueXpathGen(discussionRepo.getProperty("section"), split[i])));
//                }
//            }
//
//        } catch (Throwable t) {
//            super.logger(scenario, t);
//        }
//        log.info("loadNewsSection completed");
//    }
//
//
//    public void verifyNewsSection() {
//        log.info("verifyNewsSection Started");
//        try {
//            Thread.sleep(2000);
//            Assertions.assertTrue(isElementVisible(super.retriveLocators(discussionRepo.getProperty("myNews"))));
//            Assertions.assertTrue(isElementVisible(super.retriveLocators(discussionRepo.getProperty("teamNews"))));
//            Assertions.assertTrue(isElementVisible(super.retriveLocators(discussionRepo.getProperty("projectNews"))));
//
//        } catch (Throwable t) {
//            super.logger(scenario, t);
//        }
//        log.info("verifyNewsSection completed");
//    }
//
//    public void verifyNoPostsImage() {
//        log.info("verifyNoPostsImage Started");
//        try {
//
//            if (isElementVisible(super.retriveLocators(discussionRepo.getProperty("noPostImage")))) {
//
//                Assertions.assertTrue(isElementVisible(super.retriveLocators(discussionRepo.getProperty("noPostImage"))));
//            } else if (!isElementVisible(super.retriveLocators(discussionRepo.getProperty("noPostImage")))) {
//                Assertions.assertFalse(isElementVisible(super.retriveLocators(discussionRepo.getProperty("noPostImage"))));
//            }
//        } catch (Throwable t) {
//            super.logger(scenario, t);
//        }
//        log.info("verifyNoPostsImage completed");
//    }
//    /*
//                        Author     : Raies
//                        Description: selecting post in postTo
//                        Example    :selectingPost(DataTable table),unSelectingUser(user),selectingUser(user
//                        Input      :DataTable table,String User
//                        OutputType : return null
//                    */
//    public void selectingPost(DataTable table) { //o(N pow 2) --> time complexity //o(n) space complexity
//        //upgrade code with better time complexity
//        log.info("Selecting post");
//        try {
//
//            List<List<String>> lists = table.asLists();
//
//            int j = 1, k = 0;
//            int l = 0;
//            List<String> strings = lists.get(j);
//            for (String str : strings) { // n
//                //unselecting all user
//                String[] split = str.split(","); //creatin a new space o(n)
//                if (split[0].contains("Select All")) {
//                    unSelectingUser(lists.get(0).get(k), "Select All");
//                }
//
//                j++;
//                k++;
////                elementClick(retriveLocators(landingPageData.get("postTag")));
//
//                for (int i = 0; i < split.length; i++) { //n
//
//                    //selecting what user u need
//                    String newArr = lists.get(0).get(l++) + "," + split[i]; //o(1)
//                    selectingUser(newArr);
//
//                }
//
//            }
//            // total n * n == o(n pow 2). poor time complexity.
//        } catch (Exception e) {
//            super.exceptionLogger(scenario, e);
//        }
//        log.info("Post Selected");
//    }
//    public void createWorkitemLP(String cardDetails) throws Exception {
//        log.info("CreateWorkitem LP Started");
//        try {
//            switchFrame("contentframe");
//            By work = retriveLocators(landingPageRepo.getProperty("createWorkItem"));
//            super.clickUsingAction(work);
//            String[] card = cardDetails.split(",");
//            super.elementClick(retriveLocators(landingPageRepo.getProperty("workItem")));
//            JavascriptExecutor je = (JavascriptExecutor) driver;
//            Thread.sleep(3000);
//            scroll(retriveLocators(multipleDynamicValueXpathGen(landingPageRepo.getProperty("lp.workitemType"), card[1])));
//            Thread.sleep(1000);
//            super.clickUsingAction(retriveLocators(multipleDynamicValueXpathGen(landingPageRepo.getProperty("lp.workitemType"), card[1])));
//            super.elementClick(retriveLocators(landingPageRepo.getProperty("titleName")));
//            super.enterText(retriveLocators(landingPageRepo.getProperty("titleName")), card[2]);
//            super.elementClick(retriveLocators(landingPageRepo.getProperty("ownerTextbox")));
//            waitForPageToBeReady();
//            super.enterText(retriveLocators(landingPageRepo.getProperty("ownerTextbox")), card[3]);
//            waitForPageToBeReady();
//            super.clickUsingAction(By.xpath("//label[text()='"+card[3]+"']"));
//            elementClick(retriveLocators(landingPageRepo.getProperty("createButton")));
//            switchToDefaultFrame();
//        }catch (Exception e) {
//            super.exceptionLogger(scenario, e);
//        }
//        log.info("CreateWorkitem LP completed");
//    }
//    /*
//                  Author     : Raies
//                  Description: Verify Certifcate Are appearing in Cafe Feed
//                  Example    :verifyCertificateInCafeFeed(String certificate)
//                  Input      :(String certificate)
//                  OutputType : return null
//              */
//    public void verifyCertificateInCafeFeed(String certificate) {
//
//        log.info("Verify Certificate");
//        try {
//            switchFrame("contentframe");
//            scroll(retriveLocators(multipleDynamicValueXpathGen(landingPageRepo.getProperty("cafe_feed"), certificate)));
//            Assertions.assertTrue(isElementVisible(retriveLocators(multipleDynamicValueXpathGen(landingPageRepo.getProperty("cafe_feed"), certificate))));
//            switchToDefaultFrame();
//        } catch (Exception e) {
//            super.exceptionLogger(scenario, e);
//        }
//        log.info("Verified Successfully");
//    }
//
//
//    /*
//           Author     : Raies
//           Description: PostTo tab in cafe page it will available in discussion and kudo's section
//           Example    :postTo()
//           Input      :null
//           OutputType : return null
//       */
//    public void postTo(){
//        log.info("Navigating to post");
//        try {
//            elementClick(retriveLocators(landingPageRepo.getProperty("postTag")));
//
//        } catch (Exception e) {
//            super.exceptionLogger(scenario, e);
//        }
//        log.info("Navigated To Post");
//    }
//
//    /*
//                    Author     : Raies
//                    Description: It will verify user having access. If user having access return false;
//                    Example    :verifyUserAccess()
//                    Input      :null
//                    OutputType : return null
//                */
//    public void verifyUserAccess() {
//
//        log.info("verify user having access or not");
//        try {
//
//            Assertions.assertFalse(isElementVisible(retriveLocators(multipleDynamicValueXpathGen(landingPageRepo.getProperty("postVisiblitySettings"), "Users"))));
//
//        } catch (Exception e) {
//            super.exceptionLogger(scenario, e);
//        }
//        log.info("verifyUserAccess Completed");
//    }
//
//
//    /*
//               Author     : Raies
//               Description: verifying post in kudo's discussion post etc..
//               Example    :verifyPost(String post, Datatable  table)
//               Input      :String post, Datatable  table
//               OutputType : return null
//           */
//    public void verifyPost(String post, List<String> space, List<String> table) { //time complexity o(n) average time complexity o(n) space complexity
//
//        log.info("Verify Post");
//        try {
//
////            List<List<String>> lists = table.asLists();
////            List<String> strings = lists.get(1);
//
//            for (int i = 1; i < table.size(); i++) {//o(12n)
////                String[] users_data = .split(",");
//
//
//                if (table.get(i).equalsIgnoreCase("Yes")) {
//
//                    elementClick(retriveLocators(multipleDynamicValueXpathGen(landingPageRepo.getProperty("postVisiblitySettings"), space.get(i))));
//                    waitForTheElement(retriveLocators(multipleDynamicValueXpathGen(landingPageRepo.getProperty("verifyPost"), post)),VISIBILITY_OF_ELEMENT_LOCATED);
//                    scrollToElement(retriveLocators(multipleDynamicValueXpathGen(landingPageRepo.getProperty("verifyPost"), post)));
//                    Assertions.assertTrue(isElementVisible(retriveLocators(multipleDynamicValueXpathGen(landingPageRepo.getProperty("verifyPost"), post))));
//                } else if (table.get(i).equalsIgnoreCase("No")) {
//                    elementClick(retriveLocators(multipleDynamicValueXpathGen(landingPageRepo.getProperty("postVisiblitySettings"), space.get(i))));
//                    JavascriptExecutor js = (JavascriptExecutor) driver;
//                    js.executeScript("window.scrollBy(0,350)", "");
//                    Thread.sleep(5000);
//                    Assertions.assertFalse(isElementVisible(retriveLocators(multipleDynamicValueXpathGen(landingPageRepo.getProperty("verifyPost"), post))));
//
//                }
//
////                String verifyPost = getText(retriveLocators(multipleDynamicValueXpathGen(landingPageRepo.getProperty("verifyPost"), users_data[3])));
////                Assert.assertEquals(users_data[3], verifyPost);
//            }
//            //total removing constant then, o(n)
//        } catch (Exception e) {
//            super.exceptionLogger(scenario, e);
//
//        }
//        log.info("Post Verified");
//    }
//
//    /*
//                    Author     : Raies
//                    Description: This feature will move workitem assigned lane
//                    Example    :moveTo(String card,String lane)
//                    Input      :String card,String lane
//                    OutputType : return null
//                */
//    public void moveTo(String card,String lane) throws Exception {
//        log.info("moveTo Started");
//        try {
//            String[] lanes = lane.split(",");
//            scroll(retriveLocators(multipleDynamicValueXpathGen(discussionRepo.getProperty("footers_button"),card+"|"+"Move To")));
//            clickUsingJSexe(retriveLocators(multipleDynamicValueXpathGen(discussionRepo.getProperty("footers_button"),card+"|"+"Move To")));
//            elementClick(retriveLocators(discussionRepo.getProperty("moveTo_dd")));
//            customWaitForElement(retriveLocators(multipleDynamicValueXpathGen(discussionRepo.getProperty("selectLane"),lane)),VISIBILITY_OF_ELEMENT_LOCATED,20);
//            elementClick(retriveLocators(multipleDynamicValueXpathGen(discussionRepo.getProperty("selectLane"),lane)));
//            elementClick(retriveLocators(discussionRepo.getProperty("moveToButton")));
//        } catch (Exception e) {
//            super.exceptionLogger(scenario, e);
//        }
//        log.info("moveTo completed");
//    }
//    /*
//                 Author     : Raies
//                 Description: It will navigate to lp comment
//                 Example    :navigateToComment(String card)
//                 Input      :String card
//                 OutputType : return null
//             */
//    public void navigateToComment(String card){
//        log.info("navigateToComment started");
//        try {
//            elementClick(retriveLocators(multipleDynamicValueXpathGen(discussionRepo.getProperty("comment_icon"),card)));
//
//        } catch (Exception e) {
//            super.exceptionLogger(scenario, e);
//        }
//        log.info("navigateToComment Completed");
//    }
//    /*
//                 Author     : Raies
//                 Description: verifying post in kudo's discussion post etc..
//                 Example    :verifyPost(String post, Datatable  table)
//                 Input      :String post, Datatable  table
//                 OutputType : return null
//             */
//    public void addComment(String comment, String tag){
//        log.info("addComment started");
//        try {
//
//            enterText(retriveLocators(discussionRepo.getProperty("comment_placeholder")), comment+" "+tag);
//            elementClick(retriveLocators(discussionRepo.getProperty("comment_save_button")));
//
//        } catch (Exception e) {
//            super.exceptionLogger(scenario, e);
//        }
//        log.info("addComment Completed");
//    }
//    /*
//                 Author     : Raies
//                 Description: verifying comment on lp
//                 Example    :verifyCommentInLp(String comment)
//                 Input      :String comment
//                 OutputType : return null
//             */
//    public void verifyCommentInLp(String comment){
//        log.info("addComment started");
//        try {
//            Assertions.assertTrue(isElementVisible(retriveLocators(multipleDynamicValueXpathGen(discussionRepo.getProperty("verifyComments"), comment))));
//        } catch (Exception e) {
//            super.exceptionLogger(scenario, e);
//        }
//        log.info("addComment Completed");
//    }
//
//    /*
//                   Author     : Raies
//                   Description: updating Due date
//                   Example    :dueDate(String currentDate)
//                   Input      :String currentDate
//                   OutputType : return null
//               */
//    public void dueDate(String currentDate){
//        log.info("dueDate started");
//        try {
//            elementClick(retriveLocators(discussionRepo.getProperty("dueDate")));
//            elementClick(retriveLocators(multipleDynamicValueXpathGen(discussionRepo.getProperty("today"),currentDate)));
//        } catch (Exception e) {
//            super.exceptionLogger(scenario, e);
//        }
//        log.info("dueDate Completed");
//    }
//
//    /*
//                  Author     : Raies
//                  Description: block card in cafe
//                  Example    :block(String currentDate)
//                  Input      :String currentDate
//                  OutputType : return null
//              */
//    public void block(String card,String block_reason,String addComment){
//        log.info("block started");
//        try {
//
//            scroll(retriveLocators(multipleDynamicValueXpathGen(discussionRepo.getProperty("footers_button"),card+"|"+"Block")));
//            clickUsingJSexe(retriveLocators(multipleDynamicValueXpathGen(discussionRepo.getProperty("footers_button"),card+"|"+"Block")));
//            clickUsingAction(retriveLocators(discussionRepo.getProperty("block_reason")));
//            clickUsingJSexe(retriveLocators(multipleDynamicValueXpathGen(discussionRepo.getProperty("select_block_reason"),block_reason)));
//            enterText(retriveLocators(discussionRepo.getProperty("block_description")), addComment);
//            clickUsingJSexe(retriveLocators(discussionRepo.getProperty("add_block")));
//        } catch (Exception e) {
//            super.exceptionLogger(scenario, e);
//        }
//        log.info("block Completed");
//    }
//
//    /*
//                  Author     : Raies
//                  Description: unblock card in cafe
//                  Example    :dueDate(String currentDate)
//                  Input      :String currentDate
//                  OutputType : return null
//              */
//    public void unblock(String card,String description){
//        log.info("dueDate started");
//        try {
//            scroll(retriveLocators(multipleDynamicValueXpathGen(discussionRepo.getProperty("footers_button"),card+"|"+"Block")));
//            clickUsingJSexe(retriveLocators(multipleDynamicValueXpathGen(discussionRepo.getProperty("footers_button"),card+"|"+"Block")));
//             clickUsingJSexe(retriveLocators(discussionRepo.getProperty("unblock")));
//             enterText(retriveLocators(discussionRepo.getProperty("unblock_description")),description);
//             elementClick(retriveLocators(discussionRepo.getProperty("unblock_btn")));
//        } catch (Exception e) {
//            super.exceptionLogger(scenario, e);
//        }
//        log.info("dueDate Completed");
//    }
//
//    /*
//               Author     : Raies
//               Description: updating workitem details that will reflect on cna
//               Example    :updateDetails(String details, String values)
//               Input      :String details, String values
//               OutputType : return null
//           */
//    public void updateDetails(String details, String values){
//        log.info("selectDetails started");
//        try {
//            scroll(retriveLocators(multipleDynamicValueXpathGen(discussionRepo.getProperty("eb.fields"),details)));
//            elementClick(retriveLocators(multipleDynamicValueXpathGen(discussionRepo.getProperty("eb.fields"),details)));
//            elementClick(retriveLocators(multipleDynamicValueXpathGen(discussionRepo.getProperty("cardTypeValue"),values)));
//        } catch (Exception e) {
//            super.exceptionLogger(scenario, e);
//        }
//        log.info("selectDetails Completed");
//    }
//
//    /*
//               Author     : Raies
//               Description: verifying button's enabled or not particularly created for nform workitem
//               Example    :verifyPostFootersButton(String details)
//               Input      :String details
//               OutputType : return null
//           */
//    public void verifyPostFootersButton(String workitem,String post_footers){
//        log.info("verifyPostFootersButton started");
//        try {
//            String[] footers = post_footers.split(",");
//            for (String buttons : footers) {
//                if (!isElementVisible(retriveLocators(multipleDynamicValueXpathGen(discussionRepo.getProperty("post_footer"), workitem+"|"+buttons)))
//                        && isElementVisible(retriveLocators(multipleDynamicValueXpathGen(discussionRepo.getProperty("overflowButton"), workitem)))) {
//                    scroll(retriveLocators(multipleDynamicValueXpathGen(discussionRepo.getProperty("overflowButton"), workitem)));
//                    elementClick(retriveLocators(multipleDynamicValueXpathGen(discussionRepo.getProperty("overflowButton"), workitem)));
//                    Assertions.assertTrue(!isElementVisible(retriveLocators(multipleDynamicValueXpathGen(discussionRepo.getProperty("toDo"),workitem+"|"+buttons))));
//                }
//                else{
//                    scroll(retriveLocators(multipleDynamicValueXpathGen(discussionRepo.getProperty("post_footer"), workitem+"|"+"move to")));
//                    Assertions.assertFalse(isElementVisible(retriveLocators(multipleDynamicValueXpathGen(discussionRepo.getProperty("post_footer"),workitem+"|"+buttons))));
//                }
//            }
//        } catch (Exception e) {
//            super.exceptionLogger(scenario, e);
//        }
//
//        log.info("verifyPostFootersButton Completed");
//    }
//
//
///*
//    public void deselectTaggedUser() throws Exception {
//        log.info("deselectTaggedUser Started");
//        try {
//            //By title = super.retriveLocators(discussionRepo.get("SearchColleague"));
//            //driver.findElement(title).clear();
//
//            List<WebElement> elementClickCross = driver.findElements(By.xpath(""));
//            for(WebElement a1: elementClickCross)
//            {
//                a1.click();
//            }
//
//        } catch (Throwable t) {
//            super.logger(scenario, t);
//        }
//        log.info("deselectTaggedUser completed");
//    }*/
//
//}
//
//
//
//
