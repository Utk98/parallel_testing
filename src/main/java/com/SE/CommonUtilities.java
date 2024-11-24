    package com.SE;

    import com.annotation.PageFragment;
    import com.digite.actions.commands.Common;
    import com.digite.actions.drivercapabilities.WebDriverFactory;
    import org.springframework.util.Assert;

    import java.util.Properties;

    @PageFragment
    public class CommonUtilities extends Common {

        public CommonUtilities(WebDriverFactory webDriverFactory) {
            super(webDriverFactory);
        }
        Properties common=PageObjectsFactory.loadProperties("commonUtilities.properties");
        /*
                   Author     : Jishnu Nambiar
                   Description: Login user into Nimble application
                   Example    : loginToNimble("a_UserId","Welcome@1")
                   Input      : String a_userName, String a_Password1
                   OutputType : return null
       */
        public void login(String a_userName, String a_Password1) {
            try {
                waitForPageToBeReady();
                super.enterText(retriveLocators(common.getProperty("loginID")), a_userName);
                super.enterText(retriveLocators(common.getProperty("password")), a_Password1);
                super.elementClick(retriveLocators(common.getProperty("login")));
                if (isElementVisible(retriveLocators(common.getProperty("TemporarilyUnAvailable")))||isElementVisible(retriveLocators(common.getProperty("badGatewayTimeout")))||isElementVisible(retriveLocators(common.getProperty("badGateway")))) {
                    super.refreshBrowser();
                    Thread.sleep(15000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /*
                    Author     : Jishnu Nambiar
                    Description: Logout User from Nimble application
                    Example    : logoutNimble()
                    Input      : null
                    OutputType : return null
        */
        public void logout() throws Exception {
            try {
                waitForPageToBeReady();
                super.performmoveToElement(retriveLocators(common.getProperty("profilePic")));
                super.clickUsingJSexe(retriveLocators(common.getProperty("profilePic")));
                super.clickUsingJSexe(retriveLocators(common.getProperty("logout")));
                handleAlert("Accept");
                waitForPageToBeReady();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        /*
                   Author     : Jishnu Nambiar
                   Description: Add entity(cards,TeamMembers,Projects) from top left Add button on Nimble Page
                   Example    : addEntity("cards")
                   Input      : String entityType
                   OutputType : return null
       */
        public void addEntity(String entityType) {
            try {
                waitForPageToBeReady();
                super.elementClick(retriveLocators(common.getProperty("addButton")));
                switch(entityType.toLowerCase()){
                    case "card":
                        super.elementClick(retriveLocators(common.getProperty("card")));
                        break;
                    case "team members":
                        super.elementClick(retriveLocators(common.getProperty("project")));
                        break;
                    case "project":
                        super.elementClick(retriveLocators(common.getProperty("teamMembers")));
                        break;
                    default:
                        Assert.isTrue(false,"Action passed is not a valid one.Please check the parameter passed.");
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        public void inviteTeamMember(String role,String emailID) throws Exception {
            super.elementClick(retriveLocators(common.getProperty("teamMemberRole")));
            super.elementClick(retriveLocators(multipleDynamicValueXpathGen(common.getProperty("teamMemberRoleOption"),role)));
            super.enterText(retriveLocators(common.getProperty("teamMemberEmailID")),emailID);
            super.elementClick(retriveLocators(common.getProperty("inviteButton")));
        }
        /*
                          Author     : Jishnu Nambiar
                          Description: Open Project from Project Listing page
                          Example    : openProject("Landing Page")
                          Input      : String projectName
                          OutputType : return null
              */
        public void openProject(String projectName) throws Exception {
            try {
                waitForPageToBeReady();
//                String prjName=project.replace(" "," ");
                waitForPageToBeReady();
                scroll(retriveLocators(multipleDynamicValueXpathGen(common.getProperty("openProject"),projectName)));
                super.elementClick(retriveLocators(multipleDynamicValueXpathGen(common.getProperty("openProject"),projectName)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void userProfileAction(String option){
            try{
                super.waitForPageToBeReady();
                super.elementClick(retriveLocators(common.getProperty("userProfileIcon")));
                switch(option.toLowerCase().replaceAll("\\s","")){
                    case "myprofile":
                        super.elementClick(retriveLocators(common.getProperty("myprofile")));
                        break;
                    case "preferences":
                        super.elementClick(retriveLocators(common.getProperty("preferences")));
                        break;
                    case "changepassword":
                        super.elementClick(retriveLocators(common.getProperty("changePassword")));
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
              }
        }
        /*
                                Author     : Jishnu Nambiar
                                Description: Close Project from Project Details page
                                Example    : closeProject(Actual Date:12-Apr-2024,Comments: Closeing the project,Actual End Date: 20-Apr-2024)
                                Input      : String data
                                             FieldName1:FieldValue1,FieldName2:FieldValue2
                                OutputType : return null
                    */
        public void closeProject(String data) throws Exception {
            super.waitForPageToBeReady();
            String []spiltValue=data.split(",");
            super.elementClick(retriveLocators(common.getProperty("closeProject")));
            switchWindow();
            for(String dataValue: spiltValue){
                String []values=dataValue.split(":");
                if(values[0].equalsIgnoreCase("Comments")){
                    super.enterText(retriveLocators(multipleDynamicValueXpathGen(common.getProperty("commentfields"),values[0])),values[1]);
                }
                else{
                    super.enterText(retriveLocators(multipleDynamicValueXpathGen(common.getProperty("dateFields"),values[0])),values[1]);
                }
            }
            super.elementClick(retriveLocators(common.getProperty("closeProject")));
            switchToWindow(Common.w_mainWindow);
        }

        public void setDatePreference(String format) {
           
            try {
                super.elementClick(retriveLocators(common.getProperty("selectDateFormatButton")));
                super.elementClick(retriveLocators(multipleDynamicValueXpathGen(common.getProperty("datePreference"),format)));
                super.elementClick(retriveLocators(common.getProperty("datePreferenceSave")));
            } catch (Exception e) {
                e.printStackTrace();
            }
         
        }
    }

