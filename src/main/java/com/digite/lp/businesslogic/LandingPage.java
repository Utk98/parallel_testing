package com.digite.lp.businesslogic;//package com.digite.lp.businesslogic;
//
//
//import com.digite.actions.commands.Common;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.Assertions;
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.context.annotation.PropertySources;
//import org.springframework.core.env.Environment;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@Slf4j
//@PropertySources({
//        @PropertySource("classpath:/objectRepository/Discussion.properties"),
//        @PropertySource("classpath:/objectRepository/LandingPageComponent.properties"),
//})
//@Component
//public class LandingPage extends Common {
//
//    @Autowired
//    private Environment discussionRepo;
//    @Autowired
//    private Environment landingPageRepo;
//
//    public LandingPage(WebDriver driver) {
//        super(driver);
//    }
//
////Jishnu- Removed Unused methods
//
//
//    public void setCoverPhoto(String image, String action) throws Exception{
//        log.info("Set cover photo started");
//        try {
//            Thread.sleep(2000);
//            super.elementClick(retriveLocators(landingPageRepo.getProperty("editCoverPhoto")));
//            if(!isElementVisible(retriveLocators(landingPageRepo.getProperty("selectImage")))){
//                super.elementClick(retriveLocators(landingPageRepo.getProperty("editCoverPhoto")));
//            }
//            super.elementClick(retriveLocators(landingPageRepo.getProperty("selectImage")));
//            this.selectImage(image, action);
//        }catch (Throwable t) {
//            super.logger(scenario, t);
//        }
//        log.info("Set cover photo completed");
//    }
//
//    public void selectImage(String image, String action)throws Exception{
//        log.info("Image Selection started");
//        try {
//            super.elementClick(retriveLocators(multipleDynamicValueXpathGen(landingPageRepo.getProperty("selectImageFromLibrary"),image)));
//            super.elementClick(retriveLocators(discussionRepo.getProperty("Post")));
//            if(action == "cancel")
//                super.elementClick(retriveLocators(landingPageRepo.getProperty("cancelChanges")));
//
//            else if(action == "save")
//                super.elementClick(retriveLocators(landingPageRepo.getProperty("saveChanges")));
//            //Jishnu-Remove else statement
//        }catch (Throwable t) {
//            super.logger(scenario, t);
//        }
//        log.info("Image Selection completed");
//    }
//
//    public void verifySelectedCoverImage(String imageID)throws Exception{
//        log.info("verifySelectedCoverImage started");
//        try {
//            //waiting till page load and element visible
//            waitForTheElement(retriveLocators(multipleDynamicValueXpathGen(landingPageRepo.getProperty("coverPhoto"), imageID)), VISIBILITY_OF_ELEMENT_LOCATED);
//            Assertions.assertTrue(isElementVisible(retriveLocators(multipleDynamicValueXpathGen(landingPageRepo.getProperty("coverPhoto"), imageID))));
//        }catch (Throwable t) {
//            super.logger(scenario, t);
//        }
//        log.info("verifySelectedCoverImage completed");
//    }
//
//    public void removeCoverPhoto() throws Exception{
//        log.info("Remove cover photo started");
//        try {
//            super.elementClick(retriveLocators(landingPageRepo.getProperty("editCoverPhoto")));
//            super.elementClick(retriveLocators(landingPageRepo.getProperty("removeCoverPhoto")));
//            super.elementClick(retriveLocators(landingPageRepo.getProperty("saveChanges")));
//        }catch (Throwable t) {
//            super.logger(scenario, t);
//        }
//        log.info("Remove cover photo completed");
//    }
//    /*
//             Author     : Raies
//             Description: uploading file in post
//             Example    : uploadAttachment(String fileName)
//             Input      : String fileName
//             OutputType : return null
//         */
//    public void uploadAttachment(String fileName) throws Exception {
//        log.info("uploading a attachment");
//        try {
//            final String objectPath = System.getProperty("user.dir") + "/src/test/resources/uploadResources/"+fileName;
//            elementClick(retriveLocators(landingPageRepo.getProperty("addButton")));
////            ((JavascriptExecutor) driver).executeScript("document.getElementsByTagName('input').style.display='none';");
////            WebElement upload = driver.findElement(By.xpath("//input[@data-testid='file-upload']"));
////            upload.sendKeys(objectPath);
//            WebElement element = driver.findElement(By.xpath("//input[@type='file']"));
//            element.sendKeys(objectPath);
//            Thread.sleep(3000);//This wait is required as upload takes time
//        } catch (Exception e) {
//            super.exceptionLogger(scenario, e);
//        }
//        log.info("successfully uploaded");
//    }
//    /*
//             Author     : Raies
//             Description: navigate to attachment after navigate to discussion post
//             Example    : newPostAttachment()
//             Input      : return null
//             OutputType : return null
//         */
//    public void newPostAttachment() throws Exception {
//        log.info("selectAttachment a attachment");
//        try {
//            elementClick(retriveLocators(landingPageRepo.getProperty("newPostAttachSection")));
//        } catch (Exception e) {
//            super.exceptionLogger(scenario, e);
//        }
//        log.info("selectAttachment uploaded");
//    }
//    /*
//         Author     : Raies
//         Description: verifying snackbar appearing when we upload duplicate file in post
//         Example    : verifyDuplicateSnackbar()
//         Input      : return null
//         OutputType : return null
//     */
//    public void verifyDuplicateSnackbar() throws Exception {
//        log.info("verifyDuplicateSnackbar Started");
//        try {
//           Assertions.assertTrue(isElementVisible(retriveLocators(landingPageRepo.getProperty("duplicatePop-up"))));
//        } catch (Exception e) {
//            super.exceptionLogger(scenario, e);
//        }
//        log.info("verifyDuplicateSnackbar Completed");
//    }
//
//
//    /*
//            Author     : Raies
//            Description: verifying cover image button is enabled
//            Example    : isCoverImageEnabled(String enabled)
//            Input      : String enabled
//            OutputType : return null
//        */
//    public void isCoverImageEnabled(String enabled){
//        log.info("isCoverImageEnabled Started");
//        try {
//            String titile = getElementsAttribute(retriveLocators(landingPageRepo.getProperty("cafe.verifyCoverImageIsEnabled")), "title");;
//            System.out.println(titile);
//            Assertions.assertTrue( enabled.equals(titile));
//        } catch (Exception e) {
//            super.exceptionLogger(scenario, e);
//        }
//        log.info("isCoverImageEnabled Completed");
//    }
//    /*
//            Author     : Raies
//            Description: once user upload file done tab is enabled so user should save files in post
//            Example    : doneTab()
//            Input      : return null
//            OutputType : return null
//        */
//    public void doneTab(){
//        log.info("doneTab Started");
//        try {
//
//            elementClick(retriveLocators(landingPageRepo.getProperty("doneButton")));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        log.info("doneTab Completed");
//    }
//    /*
//            Author     : Raies
//            Description: Enabling Cover image on discussion post
//            Example    : enableCoverImage()
//            Input      : return null
//            OutputType : return null
//        */
//    public void enableCoverImage(){
//        log.info("enableCoverImage Started");
//        try {
//
//            elementClick(retriveLocators(landingPageRepo.getProperty("setCoverImage")));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        log.info("enableCoverImage Completed");
//    }
//
//    /*
//               Author     : Raies
//               Description: verify img on the discussion post
//               Example    : verifyCoverImageOnPost(String img)
//               Input      : String img
//               OutputType : return null
//           */
//    public void verifyCoverImageOnPost(String post){
//        log.info("enableCoverImage Started");
//        try {
//            Assertions.assertTrue(isElementVisible(retriveLocators(multipleDynamicValueXpathGen(landingPageRepo.getProperty("verifyCoverImage"),post))));
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        log.info("enableCoverImage Completed");
//    }
//
//
//
//}