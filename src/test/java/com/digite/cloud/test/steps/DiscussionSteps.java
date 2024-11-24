package test.java.com.digite.cloud.test.steps;




import com.digite.lp.businesslogic.CommonApis;
//import com.digite.lp.businesslogic.Discussion;
//import com.digite.lp.businesslogic.LandingPage;
import io.cucumber.java8.En;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;


@Slf4j
class DiscussionSteps implements En {
//    @Autowired
//    Discussion discussion;
//    @Autowired
//    LandingPage lp;
    @Autowired
    CommonApis commonApis;

    public DiscussionSteps(WebDriver driver) {
        Given("^User loggedIn \"([^\"]*)\" \"([^\"]*)\" Starts a discussion \"([^\"]*)\"$", (String username, String password, String discussionContent) -> {
            commonApis.loginToDigite(username, password);
//            discussion.startDiscussion(;
//            discussion.enterPostTitle(discussionContent);
        });

//        When("user tags no one the post", () -> {
//            discussion.unSelectingUser("Users","Select All");
//            discussion.selectingUser("Users,user 1");
//            discussion.post();
//        });
//        Given("^user has access to the landing page and User loggedIn \"([^\"]*)\" \"([^\"]*)\"$", (String username, String password) -> {
//            commonApis.loginToDigite(username,password);
//        });
//        Then("System prompts {string}", (String confirmationMessage) -> {
//            discussion.verifyConfirmation(confirmationMessage);
//            commonApis.logout();
//        });
//
//        When("user confirms the pop up message displayed", () -> {
//            discussion.post();
////            discussion.confirmOnUntaggedPost("Please use some tag eg. @My Team, @My Projects or @person name, if not then post will be visible to you only at your My news feed. Are you sure?");
//        });
//
//        Then("post {string} should be available on users {string} feed", (String postTitle, String feedSection) -> {
//            discussion.selectNewsFeed(feedSection);
//            discussion.verifyPost(postTitle);
//        });
//
//        When("user cancels the pop up message displayed", () -> {
//            discussion.post();
//            discussion.cancelOnUntaggedPost("Please use some tag eg. @My Team, @My Projects or @person name, if not then post will be visible to you only at your My news feed. Are you sure?");
//        });
//
//        Then("user should be able to edit the discussion", () -> {
//            discussion.verifyPostButton();
//        });
//
//        //Liking a post and count
//        Then("Chirag likes the post {string}", (String postName) -> {
//            discussion.likePost(postName);
//        });
//        Then("Chirag view the {string} for post {string}", (String count, String postName) -> {
//            discussion.verifyLikeCount(count, postName);
//        });
//
//        Given("user has access to landing page", () -> {
//            commonApis.loginToDigite("deepak@digite.com", "password");
//        });
//
//        When("he selects the cover image from the set of images displayed from the library", () -> {
//            lp.setCoverPhoto("landmark photography of trees near rocky mountain under blue skies daytime", "save");
//        });
//
//        Then("selected image should be displayed as the cover image on landing page", () -> {
//            lp.verifySelectedCoverImage("1426604966848");
//        });
//
//        Given("Chirags selects {string} and {string} kudo", (String string, String string2) -> {
//            discussion.initiateKudo();
//            discussion.tagPersonOrTeam(string);
//            discussion.selectKudoType(string2);
//            discussion.previewKudo();
//        });
//
//        When("He posts the kudo", () -> {
//            discussion.post();
//        });
//
//        Then("system creates a kudos with {string} for {string} on his myNewsFeeds", (String kudoType, String userName) -> {
//            discussion.verifyPostedKudo(kudoType, userName);
//        });
//
//        Then("Same kudo with {string} for {string} on {string} of {string} should be seen", (String kudoType, String userName, String FeedType, String Tags) -> {
//            discussion.selectNewsFeed(FeedType);
//            discussion.verifyPostedKudo(kudoType, userName);
//        });
//
//        Then("On MyNewsFeed of {string} of selected tags", (String string) -> {
//            // Write code here that turns the phrase above into concrete actions
//            throw new io.cucumber.java8.PendingException();
//        });
//
//
//        // After(() -> {
//        //     Common.driver.quit();
//        //     log.info("Add the code in the Common Class for quiting the driver.");
//        // });
//
//        When("he tags using @ tag to {string}", (String person_name) -> {
//            discussion.appendText(person_name);
//            discussion.unSelectingUser("Users","Select All");
//            discussion.selectingUser("Users,user 1");
//            discussion.post();
//            commonApis.logout();
//        });
//
//        When("he tags using @ tag to multiple {string}", (String team_name) -> {
//
//                discussion.appendText(team_name);
//            discussion.unSelectingUser("Users","Select All");
//            discussion.selectingUser("Users,user 1");
//            discussion.post();
//        });
//
//        When("he is typing {string} using @", (String keywords) -> {
//            discussion.searchListWithKeyword(keywords);
//        });
//
//        Then("system should suggest {string} as person name, team name or project name that contains the keywords typed", (String expectedTagList) -> {
//            discussion.getTagList(expectedTagList);
//        });
//
//        Then("^Team members should see the post \"([^\"]*)\" and \"([^\"]*)\" on their respective Team news feed$", (String post, String tag) -> {
//            commonApis.logout();
//            commonApis.loginToDigite("deepak@digite.com","password");
//            discussion.tab("Team Space");
//            discussion.verifyTeamAndProjectCheckBox();
//            discussion.verifyingPost(post,tag);
//
//        });
//
//        And("user that has started discussion, {string} sees the post {string} on their respective personal feed", (String taggedPerson, String postTitle) -> {
//            discussion.verifyPost(postTitle);
//            discussion.getUserSession(taggedPerson);
//            discussion.verifyPost(postTitle);
//        });
//        And("^taggedUser \"([^\"]*)\" \"([^\"]*)\" that has started discussion, \"([^\"]*)\" sees the post on their respective personal feed$", (String username, String password, String taggedPerson) -> {
//          commonApis.loginToDigite(username,password);
//
//            discussion.verifyPostIsNotifyToTaggedUser(taggedPerson);
//
//        });
//        And("user that has started discussion, {string} sees the post on their respective personal feed", (String taggedPerson) -> {
//
//
//            discussion.verifyPost("We are meeting today for RCA Day4");
//        });
//
//        Given("user has access to the landing page", () -> {
//            log.info("Navigate to LP");
//            commonApis.loginToDigite("deepak@digite.com", "password");
//        });
//
//        When("he visits Landing Page", () -> {
//            log.info("LP loaded");
//        });
//
//        Then("Cover image should be seen by default loaded from the library", () -> {
//            lp.verifySelectedCoverImage("1490750967868");
//        });
//        Given("user initiates a Kudo card", () -> {
//            commonApis.loginToDigite("neha.parab@digite.com", "password");
//            discussion.initiateKudo();
//        });
//
//        When("he selects the users and kudo type", () -> {
//            discussion.unSelectingUser("Users","Select All");
//            discussion.selectingUser("Users,user 1");
//            discussion.tagPersonOrTeam("Deepak Naik");
//            discussion.selectKudoType("great-job");
//        });
//
//        Then("he should view the preview of the kudo post", () -> {
//            discussion.previewKudo();
//            discussion.verifyPostedKudo("Great Job","Deepak");
//            discussion.post();
//        });
//
//        Given("^user has preview of the kudo card$", () -> {
//            commonApis.loginToDigite("deepak@digite.com", "password");
//            discussion.initiateKudo();
//            discussion.tagPersonOrTeam("Deepak Naik");
//            discussion.selectKudoType("great-job");
//            discussion.previewKudo();
//        });
//
//        When("^he removes the Kudo immage$", () -> {
//            //discussion.editPost("Thank You for your significant contribution!! It's amazing to work with you!");
//            discussion.removeKudoImage();
//        });
//
//        Then("^he should be able to post the Kudo without image$", () -> {
//            discussion.verifyPostButton();
//        });
//
//        When("^he edits the Kudo card$", () -> {
//            discussion.editKudo();
//        });
//
//        Then("^he should be able to save the Changes required before posting it$", () -> {
//            discussion.verifyKudoPopupTitle();
//        });
//
//        Given("^user has posted a Kudo$", () -> {
//            commonApis.loginToDigite("neha.parab@digite.com", "password");
//        });
//        When("^he Edits the Kudo post$", () -> {
//            discussion.editKudoPost("Deepak");
//        });
//        Then("^he should be taken to the preview of Kudo post$", () -> {
//            discussion.verifyPostedKudo("Great Job","Deepak");
//            discussion.verifyPostButton();
//        });
//
//        Given("^user has access to preview Kudo post$", () -> {
//            commonApis.loginToDigite("neha.parab@digite.com", "password");
//        });
//        When("^he updates the Text of the Kudo$", () -> {
//            discussion.editKudoPost("Deepak");
//            discussion.modifyKudoText("All the best edited!!");
//            discussion.post();
//        });
//        Then("^tagged users should see the updated text on Kudo post$", () -> {
//           commonApis.logout();
//           commonApis.loginToDigite("deepak@digite.com","password");
//            discussion.verifyPostedKudo("Great Job","Deepak"); //getting issue in verifying kudo text.
//        });
//        Given("^user has uploaded the cover image from library$", () -> {
//            commonApis.loginToDigite("deepak@digite.com", "password");
//            lp.setCoverPhoto("landmark photography of trees near rocky mountain under blue skies daytime", "cancel");
//        });
//
//        When("he cancels the operation$", () -> {
//            lp.removeCoverPhoto();
//        });
//
//        Then("^he should see default cover image of the landing page set as cover image$", () -> {
//            lp.verifySelectedCoverImage("1490750967868");
//        });
//
//        When("^user removes the cover image uploaded$", () -> {
//            lp.removeCoverPhoto();
//        });
//
//        Then("^he should see default cover image on landing page$", () -> {
//            lp.verifySelectedCoverImage("1490750967868");
//        });
////Jishnu
//        Given("a Kudo post was of {string} Kudo Type with {string}",(String kudoType,String postName)->{
//            commonApis.loginToDigite("neha.parab@digite.com", "password");
//            discussion.editPostByUser(postName);
//        });
//        When("user updates it to {string} Kudo Type with {string}",(String postName,String user)->{
//            discussion.editKudo();
//            discussion.removeTagPerson("Deepak Naik");
//            discussion.tagPersonOrTeam(user);
//            discussion.selectKudoType(postName);
//            discussion.previewKudo();
//            discussion.post();
//        });
//        Then("Tagged {string} should see Updated Kudo Type as {string}",(String user,String kudoType)->{
//            commonApis.logout();
//            commonApis.loginToDigite("pramila.raju@digite.com","password");
//            discussion.verifyPostedKudo(kudoType,user);
//        });
//
//        Given("User had tagged {string} on Kudo Post {string}",(String user,String postName)->{
//            commonApis.loginToDigite("neha.parab@digite.com", "password");
//            discussion.editPostByUser(user);
//        });
//        When("he updates it to {string} from {string} on Kudo Post {string}",(String Team,String user,String postName)->{
//            discussion.editKudo();
//            discussion.removeTagPerson(user);
//            discussion.tagPersonOrTeam(Team);
//            discussion.selectKudoType(postName);
//            discussion.previewKudo();
//            discussion.post();
//        });
//        Then("Updated Kudo {string} will fall in {string} of the {string}",(String kudoType,String tab,String user)->{
//         commonApis.logout();
//            commonApis.loginToDigite("deepak@digite.com","password");
//            discussion.tab(tab);
//            discussion.verifyPostedKudo(kudoType,user);
//        });
//
//        When("^he sees News section$", () -> {
//            driver.getTitle();
//        });
//
//        Then("^he should see news Sections divided as My Space, Team Space and Project Space$", () -> {
//            discussion.verifyNewsSection();
//            commonApis.logout();
//
//        });
//
//        When("^there are no post availabe to display in any sections$", () -> {
//            discussion.getUserSession("Pramila");
////            discussion.loadNewsSection();
//        });
//
//        Then("^he should see message as \"([^\"]*)\"$", (String arg0) -> {
//            discussion.verifyNoPostsImage();
//        });
//
//        Then("^System should allow to post without any prompt$", () -> {
//            discussion.selectNewsFeed("My Space");
//            discussion.verifyPost("We are meeting today for RCA Day1");
//
//
//        });
//        When("^there are no post availabe to display in \"([^\"]*)\" any sections$", (String section) -> {
//       discussion.loadNewsSection(section);
//       commonApis.logout();
//        });
//
//        Given("user has been tagged to post a where he, his team and his project is tagged", () -> {
//            commonApis.loginToDigite("deepak@digite.com", "password");
//        });
//        When("^he visits on \"([^\"]*)\" page$", (String title) -> {
//             driver.getTitle();
//
//
//        });
//
//        Then("^same psot is available on all \"([^\"]*)\" sections$", (String space) -> {
//
//           discussion.loadNewsSection(space);
//        });
//
//        Given("post has been created with {string} and {string}", (String comment, String id) -> {
//            String[] person = id.split(",");
//            commonApis.loginToDigite("deepak@digite.com", "password");
//            discussion.startDiscussion();
//            discussion.enterPostTitle(comment);
//            discussion.appendText(person[0]);
//            discussion.unSelectingUser("Users","Select All");
//            discussion.selectingUser("Users,user 1");
//            discussion.post();
//        });
//
//        When("user visits landing page", () -> {
//           driver.getTitle();
//           commonApis.logout();
//           Thread.sleep(2000);
//        });
//        Then("^\"([^\"]*)\" member views  \"([^\"]*)\" on \"([^\"]*)\" section$", (String id, String post, String section) -> {
//            String[] email = id.split(",");
//            commonApis.loginToDigite(email[1],"password");
//            discussion.verifyPostInSections(email[0],post,section);
//
//
//        });
//
//        When("user add cover image in new Discussion Post {string}", (String discussionContent) -> {
//            discussion.startDiscussion();
//            discussion.enterPostTitle(discussionContent);
//            lp.newPostAttachment();
//            lp.uploadAttachment("screenshot.png");
//            lp.enableCoverImage();
//        });
//
//        Then("User add duplicate cover image snackbar should seen bottom of the cafe page", () -> {
//
//          lp.uploadAttachment("screenshot.png");
//          lp.verifyDuplicateSnackbar();
//        });
//
//        Then("User enable cover image without saving post", () -> {
//            lp.isCoverImageEnabled("Image already set as cover image");
//            lp.doneTab();
//            discussion.post();
//
//        });

    }
}
