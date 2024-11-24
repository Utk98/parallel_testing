package com.SE;

import com.annotation.PageFragment;
import com.digite.actions.commands.Common;
import com.digite.actions.drivercapabilities.WebDriverFactory;

import java.util.HashMap;
import java.util.Properties;

@PageFragment
public class MenuNavigation extends Common {
    Properties properties=PageObjectsFactory.loadProperties("menuNavigation.properties");
    public static HashMap<String, String> navigate= new HashMap<String, String>();
    public static HashMap<String, String> leftMenuNavigate= new HashMap<String, String>();

    public MenuNavigation(WebDriverFactory webDriverFactory) {
        super(webDriverFactory);
    }
    /*
                 Author     : Jishnu Nambiar
                 Description: This method will share the locator value for navigation of the left menu
                 Example    : getMenu(Cafe)
                 Input      : String  menu
                 OutputType : return String
    */
    private static String getMenu(String menu) {
        leftMenuNavigate.put("Cafe", "homeIcon");
        leftMenuNavigate.put("Analytics", "dashboardIcon");
        leftMenuNavigate.put("MyWorkspace", "MX_LOCK_Home");
        leftMenuNavigate.put("Integrations", "workspaceIcon,MX_LOCK_Integrations");
        leftMenuNavigate.put("PPM","workspaceIcon,MX_LOCK_Portfolio_Management");
        leftMenuNavigate.put("Organization", "workspaceIcon,MX_LOCK_Organization_Name");
        leftMenuNavigate.put("OKR", "workspaceIcon,MX_LOCK_OKRs");
        leftMenuNavigate.put("ViewMyProject", "projectIcon");
        leftMenuNavigate.put("Favourites","favouritesIcon");
        leftMenuNavigate.put("Help","helpIcon");
        if(leftMenuNavigate.get(menu)==null){
            return menu;
        }
        else{
            return leftMenuNavigate.get(menu);
        }

    }

    /*
                  Author     : Jishnu Nambiar
                  Description: This method will share the locator value for navigation of the menu
                  Example    : getBreadCrumbMenu("executionBoard")
                  Input      : String  menu
                  OutputType : return String
    */
    private static String getBreadCrumbMenu(String menu) {
        //Menu Option Under PLAN
        navigate.put("projectDetails", "LOCK_Plan,LOCK_Project_Details_SelfService");
        navigate.put("teamMembers", "LOCK_Plan,LOCK_Team_Members");
        navigate.put("teams", "LOCK_Plan,LOCK_Teams");
        navigate.put("releases", "LOCK_Plan,LOCK_Releases");
        navigate.put("sprints", "LOCK_Plan,LOCK_Sprints");
        navigate.put("roadMapping", "LOCK_Plan,LOCK_Roadmapping");
        navigate.put("teamMemberRequest", "LOCK_Plan,LOCK_Team_Member_Request");
        navigate.put("teamMemberAllocation", "LOCK_Plan,LOCK_Team_Member_Allocation");

        //Menu Option Under People Planning
//        navigate.put("teamMemberRequest","LOCK_People_Planning,LOCK_Team_Member_Request");
//        navigate.put("teamMemberAllocation","LOCK_People_Planning,LOCK_Team_Member_Allocation");

        //Menu Option Under Agile Planning
        navigate.put("backlogRefinement","LOCK_Agile_Planning,LOCK_Backlog_Refinement");
        navigate.put("sprintPlanning","LOCK_Agile_Planning,LOCK_Sprint_Planning");
        navigate.put("releasePlanning","LOCK_Agile_Planning,LOCK_Release_Planning");
        navigate.put("relativeSizing","LOCK_Agile_Planning,LOCK_Relative_Sizing");
        navigate.put("storyMapping","LOCK_Agile_Planning,LOCK_Story_Mapping");


        //Menu Option Under Execution
        navigate.put("executionBoard","LOCK_Execute,LOCK_Execution_Board");
        navigate.put("userRequirement","LOCK_Execute,LOCK_User_Requirements");
        navigate.put("taskPlans","LOCK_Execute,LOCK_Task_Plans");
        navigate.put("themes","LOCK_Execute,LOCK_Themes");
        navigate.put("epics","LOCK_Execute,LOCK_Epics");
        navigate.put("features","LOCK_Execute,LOCK_Features");
        navigate.put("userStories","LOCK_Execute,LOCK_User_Stories");
        navigate.put("technicalStories","LOCK_Execute,LOCK_Technical_Stories");
        navigate.put("defects","LOCK_Execute,LOCK_Defects");
        navigate.put("adhocWork","LOCK_Execute,LOCK_Adhoc Work");

        //Menu Option Under Manage
        navigate.put("changeRequests","LOCK_Manage,LOCK_Change_Requests");
        navigate.put("risks","LOCK_Manage,LOCK_Risks");
        navigate.put("actionItems","LOCK_Manage,LOCK_Action_Items");
        navigate.put("issues","LOCK_Manage,LOCK_Issues");
        navigate.put("training","LOCK_Manage,Training");

        //Menu Option Under Dashboard
        navigate.put("analytics","LOCK_Dashboard,LOCK_Analytics");
        navigate.put("releaseSprints","LOCK_Dashboard,LOCK_Releases___Sprints");
        navigate.put("projectHealth","LOCK_Dashboard,LOCK_Project_Health");

        //Menu Option Under Configure
        navigate.put("activityMatrix","LOCK_Configure,LOCK_Activity Matrix");
        navigate.put("timesheetApprovers","LOCK_Configure,LOCK_Timesheet Approvers");
        navigate.put("calendar","LOCK_Configure,LOCK_Calendar");
        navigate.put("accessConfiguration","LOCK_Configure,LOCK_Access_Configuration");
        navigate.put("formConfiguration","LOCK_Configure,LOCK_Form_Configuration");
        navigate.put("form2.0Configuration","LOCK_Configure,LOCK_Form 2.0 Configuration");
        navigate.put("businessRules 2.0","LOCK_Configure,LOCK_Business Rules 2.0");
        navigate.put("masterLists","LOCK_Configure,LOCK_Master_Lists");
        navigate.put("preferences","LOCK_Configure,LOCK_Preferences");
        navigate.put("businessRules","LOCK_Configure,LOCK_Business_Rules");
        navigate.put("aiPoweredAutoFillFields","LOCK_Configure,LOCK_AI-Powered_Auto-fill_Fields");
        navigate.put("aiPoweredSimiliarWorkitems","LOCK_Configure,LOCK_AI-Powered_Similar_Workitems");
        navigate.put("webhooks","LOCK_Configure,LOCK_Webhooks");
        navigate.put("incomingWebhooks","LOCK_Configure,LOCK_Incoming Webhooks");
        navigate.put("externalWorkRequest","LOCK_Configure,LOCK_External_Work_Requests");


        //Menu Option Under Process Goverance
        navigate.put("templates","LOCK_Process_Governance,LOCK_Templates");
        navigate.put("practices","LOCK_Process_Governance,LOCK_Practices");
        navigate.put("phases","LOCK_Process_Governance,LOCK_Phases");
        navigate.put("standardActivities","LOCK_Process_Governance,Standard Activities");
        navigate.put("masterLists_1","LOCK_Process_Governance,LOCK_Master_Lists");

        //Menu Option Under People Management
        navigate.put("users","LOCK_People_Management,LOCK_Users");
        navigate.put("personas","LOCK_People_Management,LOCK_Personas");
        navigate.put("teamMemberAllocation_1","LOCK_People_Management,LOCK_Team_Member_Allocation");
        navigate.put("teams_1","LOCK_People_Management,LOCK_Teams");
        navigate.put("utilizationView","LOCK_People_Management,LOCK_Utilization_View");
        navigate.put("demandVsCapacity","LOCK_People_Management,LOCK_Demand_VS_Capacity");

        //Menu Option Under Administration
        navigate.put("organizationProfile","Administration,LOCK_Organization_Profile");
        navigate.put("OrganizationCalendar","Administration,LOCK_Organization_Calendar");
        navigate.put("licenseManagement","Administration,LOCK_License_Management");
        navigate.put("applicationUsage","Administration,LOCK_Application_Usage");
        navigate.put("applicationPreferences","Administration,LOCK_Application_Preferences");
        navigate.put("menuConfiguration","Administration,LOCK_Menu_Configuration");
        navigate.put("accessConfiguration_1","Administration,LOCK_Access_Configuration");
        navigate.put("aiSimilarityConfiguration","Administration,LOCK_AI_Similarity_Configuration");
        navigate.put("webhooks_1","Administration,LOCK_Webhooks");


        //Menu Option Under My Work
        navigate.put("myProject","LOCK_My_Work,LOCK_My Projects");
        navigate.put("projectRequest","LOCK_My_Work,My Project Requests");
        navigate.put("myCalendar","LOCK_My_Work,My Calendar");

        //Menu Option Under My Work
        navigate.put("timeTracking","LOCK_Timesheet,LOCK_Time Tracking");
        navigate.put("timesheetApproval","LOCK_Timesheet,LOCK_Timesheet_Approval");

        if(navigate.get(menu)==null){
            return menu;
        }
        else{
            return navigate.get(menu);
        }
    }

    public void navigateBreadCrumb(String breadCrumbMenu) throws Exception {
        try {
            waitForPageToBeReady();
            String[] w_array;
            Thread.sleep(1000);
            String w_value=getBreadCrumbMenu(breadCrumbMenu);
            w_array = w_value.split(",", -1);
            if (!isElementVisible(retriveLocators(multipleDynamicValueXpathGen(properties.getProperty("menuOption"),w_array[0])))) {
                super.performmoveToElement(retriveLocators(properties.getProperty("moreOption")));
            }
            super.performmoveToElement(retriveLocators(multipleDynamicValueXpathGen(properties.getProperty("menuOption"),w_array[0])));
            waitForPageToBeReady();
            super.performmoveToElement(retriveLocators(multipleDynamicValueXpathGen(properties.getProperty("menuOption"),w_array[1])));
            super.clickUsingAction(retriveLocators(multipleDynamicValueXpathGen(properties.getProperty("menuOption"),w_array[1])));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
                 Author     : Jishnu Nambiar
                 Description: To navigate the left menu in Nimble
                 Example    : navigateLeftMenu(Cafe)
                 Input      : String menuOption
                 OutputType : return null
                 Limitation : Currently this method has not taken Favourites and Help sub menu options
    */
    public void navigateLeftMenu(String menuOption) throws Exception {
        try {
            waitForPageToBeReady();
            String w_value = getMenu(menuOption);
            String[] w_array = w_value.split(",", -1);

                        if (!isElementVisible(retriveLocators(multipleDynamicValueXpathGen(properties.getProperty("menuOption"),w_array[0])))) {
                waitForPageToBeReady();
                super.clickUsingAction(retriveLocators(properties.getProperty("expandLeftMenu")));
            }
            waitForPageToBeReady();
            if(w_array.length>1){
                //The below condition was added because by default Apps is expanded
                if(!isElementVisible(retriveLocators(multipleDynamicValueXpathGen(properties.getProperty("adminOption"),w_array[1])))){
                    super.elementClick(retriveLocators(multipleDynamicValueXpathGen(properties.getProperty("menuOption"),w_array[0])));
                }
                waitForPageToBeReady();
                super.elementClick(retriveLocators(multipleDynamicValueXpathGen(properties.getProperty("adminOption"),w_array[1])));
            }
            else{

                super.elementClick(retriveLocators(multipleDynamicValueXpathGen(properties.getProperty("menuOption"),w_array[0])));
            }
            if(menuOption.equalsIgnoreCase("ViewMyProject")){
                super.elementClick(retriveLocators(properties.getProperty("viewMyProject")));
            }
            waitForPageToBeReady();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
