package com.digite.actions.commands;


import com.annotation.PageFragment;
import com.digite.actions.drivercapabilities.WebDriverFactory;
import com.digite.actions.errorlogging.ExceptionLogger;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

//@Slf4j
@PageFragment
@Component
public class Common extends ExceptionLogger {
    private final Logger log = LoggerFactory.getLogger(Common.class);
    public final WebDriver driver;
    public final AndroidDriver a_driver = null;
    public final ChromeDriver driver1 = null;
    public WebElement local_element = null;
    public final String VISIBILITY_OF_ELEMENT_LOCATED = "VISIBILITY_OF_ELEMENT_LOCATED";
    public final String CLICKABILITY_OF_ELEMENT_LOCATED = "CLICKABILITY_OF_ELEMENT_LOCATED";
    public final String PRESENCE_OF_ELEMENT_LOCATED = "PRESENCE_OF_ELEMENT_LOCATED";
    public final String INVISIBILITY_OF_ELEMENT = "INVISIBILITY_OF_ELEMENT";
    public final String IS_ALERT_PRESENT = "IS_ALERT_PRESENT";
    public final String FRAME_TO_BE_AVAILABLE_AND_SWITCH_TO_IT = "FRAME_TO_BE_AVAILABLE_AND_SWITCH_TO_IT";

    long startTime;
    long endTime;
    long duration;
    By local_by = null;
    String label = null;

    public String moduleName = null;

    // Constructor-based dependency injection
    public Common(WebDriverFactory webDriverFactory) {
        log.info("sdf");
        driver = webDriverFactory.getDriver();
    }

    public void enterText(By element, String valueToEnter) throws Exception {
        log.info("enterText Started");
        waitForTheElement(element, VISIBILITY_OF_ELEMENT_LOCATED);
        local_element = driver.findElement(element);
        local_element.click();
        local_element.clear();
        waitForPageToBeReady();
        local_element.sendKeys(valueToEnter);
        log.info(valueToEnter + " has been entered in " + label);
    }

    public void enterTextUsingJS(By locator, String text) throws Exception {
        boolean status = true;
        waitForTheElement(locator, VISIBILITY_OF_ELEMENT_LOCATED);
        try {
            if (!text.equals("")) {
                WebElement element = driver.findElement(locator);
                JavascriptExecutor jse = (JavascriptExecutor) driver;
                if (element.isEnabled() && element.isDisplayed()) {
                    jse.executeScript("arguments[0].value='" + text + "';", element);
                }
            }
        } catch (Exception e) {
            log.error("Error in enterTextUsingJS", e);
        }
    }

    /* Author : Bhavik Sangoi
     *  Description : to append string to any of the existing textbox value
     */
    public void appendText(String locator, String textToBeAppended) throws Exception {
        log.info("appendText Started");
        local_element = driver.findElement(retriveLocators(locator));
        local_element.sendKeys(Keys.CONTROL, Keys.END);
        local_element.sendKeys(" " + textToBeAppended);
        local_element.sendKeys(Keys.ENTER);
        log.info("appendText completed");
    }



    public void elementClick(By locator) throws Exception {
        waitForTheElement(locator, CLICKABILITY_OF_ELEMENT_LOCATED);
            driver.findElement(locator).click();
    }

    public void clickUsingJSexe(By locator) throws Exception {
        waitForTheElement(locator, CLICKABILITY_OF_ELEMENT_LOCATED);
        WebElement w_element1 = driver.findElement(locator);
        JavascriptExecutor w_executor = (JavascriptExecutor) driver;
        w_executor.executeScript("arguments[0].click();", w_element1);
    }
    public void clickUsingAction(By locator) throws Exception {
        waitForTheElement(locator, CLICKABILITY_OF_ELEMENT_LOCATED);
        WebElement w_element1 = driver.findElement(locator);
        Actions w_action = new Actions(driver);
        w_action.moveToElement(w_element1).click().perform();
    }

    public void elementDoubleClick(By locator) throws Exception {
        log.info("elementDoubleClick started");
        Actions w_actions = new Actions(driver);
        waitForTheElement(locator, CLICKABILITY_OF_ELEMENT_LOCATED);
        WebElement w_ele = driver.findElement(locator);
        w_actions.doubleClick(w_ele).perform();
        log.info("elementDoubleClick completed");
    }

    public void performmoveToElement(By locator) throws Exception {
        log.info("performmoveToElement started");
        waitForTheElement(locator, VISIBILITY_OF_ELEMENT_LOCATED);
        WebElement w_web_Element_To_Be_Hovered = driver.findElement(locator);
        Actions w_builder = new Actions(driver);
        w_builder.moveToElement(w_web_Element_To_Be_Hovered).build().perform();
        log.info("performmoveToElement completed");
    }
    public void mouseHoverAndMove(By locator, int x_offset) throws Exception {
        Actions actions = new Actions(driver);
        WebElement slider = driver.findElement(locator);
        actions.moveToElement(slider).build().perform();
        actions.clickAndHold();
        actions.dragAndDropBy(slider, x_offset, 0).build().perform();
    }


    public boolean isElementVisible(By locator) {
        boolean w_visible = false;
        if(!isAndroidDriver()) {
            try {
                if (driver.findElement(locator).isDisplayed()) {
                    w_visible = true;
                }
            } catch (Exception e) {
              log.info("Element was not visible");
            }
        }else{
            try{
                if(!driver.findElements(locator).isEmpty()){
                    w_visible = true;
                }
            }catch (Exception e){
                log.info("Element was not visible");
            }
        }
        return w_visible;
    }

    public void dragDropElement(By a_source, By a_destination , int xOffset, int yOffset) throws Exception {
        WebElement w_src =  driver.findElement(a_source);
        WebElement w_dest =  driver.findElement(a_destination);
        Actions w_act = new Actions(driver);
        w_act.clickAndHold(w_src).moveByOffset(xOffset, yOffset).moveToElement(w_dest, xOffset, yOffset).release().build().perform();
    }
    public void simpleDragDrop(By a_source, By a_destination) throws Exception {
        //log.info("simpleDragDrop started");
        WebElement w_src =  driver.findElement(a_source);
        WebElement w_dest =  driver.findElement(a_destination);
        Actions w_act = new Actions(driver);
        w_act.dragAndDrop(w_src, w_dest).build().perform();
        //log.info("simpleDragDrop completed");
    }
    public static String w_mainWindow =null;
    public String getParentWindow(){
            return  driver.getWindowHandle();
    }

    public Set<String> getAllWindows(){
        return driver.getWindowHandles();
    }

    public void switchToWindow(String windowsName){
        driver.switchTo().window(windowsName);
    }

    public void switchWindow( ){
        w_mainWindow = getParentWindow();
        Set<String> w_childWindow = getAllWindows();
        for (String w_child : w_childWindow) {
            if (!w_child.equals(w_mainWindow)) {
                  switchToWindow(w_child);
                  break;
            }
        }
    }


    public String getText(String element) throws Exception {
        log.info("Get Text Started");
        waitForTheElement(retriveLocators(element), VISIBILITY_OF_ELEMENT_LOCATED);
        if(!isAndroidDriver()) {
            scroll(local_by);
        }
        local_element = driver.findElement(local_by);
        String elementText = local_element.getText();
        log.info("Text : " + elementText + " is retirved");
        return elementText;
    }



    public void scroll(By locator) throws Exception {
        log.info("Scroll to Element Started");
        JavascriptExecutor w_js = (JavascriptExecutor) driver;
        local_element = driver.findElement((locator));
        w_js.executeScript("arguments[0].scrollIntoView();", local_element);
        log.info("Scroll to Element Completed");
    }
    public void scrollByCoordinates(By a_element) throws Exception{
        Coordinates coordinate = ((Locatable)driver.findElement(a_element)).getCoordinates();
        coordinate.onPage();
        coordinate.inViewPort();

    }
    public  void scrollToElement(By locator) throws Exception {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        boolean isScrollable = true;
        while (isScrollable && !isElementVisible(locator)) {
            // Get the initial scroll position
            long initialScrollPosition = (long) js.executeScript("return window.pageYOffset;");
            // Scroll to the element
//            js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(locator));
            js.executeScript("arguments[0].scrollIntoView();", driver.findElement(locator));
            // Get the current scroll position
            long currentScrollPosition = (long) js.executeScript("return window.pageYOffset;");
            // If the scroll position remains the same after scrolling, the page is not scrollable anymore
            if (initialScrollPosition == currentScrollPosition) {
                isScrollable = false;
            }
        }
    }
    public  void scrollToElementDropDown(By locator) throws Exception {
        Actions actions = new Actions(driver);
        WebElement w_element1 = driver.findElement(locator);
        for (int maxScrollAttempts = 0; maxScrollAttempts < 10; maxScrollAttempts++) {
            if (!(isElementVisible(locator))) {
                actions.moveToElement(w_element1).build().perform();
                actions.sendKeys(Keys.ARROW_DOWN).build().perform();
            }
        }
    }

    public List<WebElement> getListOfElements(String elements) throws Exception {
        log.info("Get List of Elements Started");
        List<WebElement> locators = driver.findElements(retriveLocators(elements));
        if (locators.size() == 0) {
            throw new NoSuchElementException("ERR : Empty List is retrived");
        }
        log.info("Get List of Elements Completed");
        return locators;
    }

    public void navigate(String url) throws Exception {
        driver.get(url);
    }


    public Map<String, String> readPropertiesFile(String propertyFile) {
        Map<String, String> map = null;
        try {
            FileReader read = new FileReader(propertyFile);
            Properties p = new Properties();
            p.load(read);
            map = new HashMap<String, String>();
            for (String key : p.stringPropertyNames()) {
                map.put(key, p.getProperty(key));
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

        return map;
    }




    /*
       Author     : Jishnu Nambiar
       Description: API will replace multiple dynamic values in the locator.Multiple Dynamic values will be passed
                    as single input string separate by comma's.
       Input      : identifier-Locator
                    inputValue-dynamic values to replaced in locator
       OutPutType : finalLocator-Locator after replacing the dynamic values
       Example    : multipleDynamicValueXpathGen(String identifier, String inputValue)
                    identifier-//div[@role='<dynamic value1>'][@data-id='<dynamic value2>']
                    inputValue-row,1
                    finalLocator-//div[@role='row'][@data-id='1']
   */
    public String multipleDynamicValueXpathGen(String identifier, String inputValue) {
        log.info("dynamicXpathGenerator started");
        String[] dynamicValues = inputValue.split("\\|");
        String finalLocator = "";
        for (int i = 0; i < dynamicValues.length; i++) {
            identifier =identifier.replace("<dynamic value" + (i + 1) + ">", dynamicValues[i]);
        }
        log.info("dynamicXpathGenerator completed");
        return identifier;
    }



    //To perform operations like ctrl+a, ctrl+z together
    public void enterChordKeys(By a_element, Keys a_key, String b_key) throws Exception {
        log.info("enterChordKeys started");
        waitForTheElement(a_element, VISIBILITY_OF_ELEMENT_LOCATED);
        driver.findElement(a_element).sendKeys(a_key, Keys.chord(b_key));
        log.info("enterChordKeys completed");
    }
    public void enterKeys(By a_element, CharSequence... a_key) throws Exception {
        this.waitForTheElement(a_element, VISIBILITY_OF_ELEMENT_LOCATED);
        if (driver.findElement(a_element).isDisplayed()) {
            driver.findElement(a_element).sendKeys(a_key);
        }

    }

    public void tearDown() throws Exception {
        log.info("tearDown started");
        driver.quit();
        log.info("tearDown completed");
    }

    // author:ankitagarge
    public void switchFrame(String a_framename) throws Exception {
        log.info("switchFrame started");
        driver.switchTo().frame(a_framename);
        log.info("switchFrame completed");
    }

    public void switchToDefaultFrame() throws Exception {
        log.info("switchToDefaultFrame started");
        driver.switchTo().defaultContent();
        log.info("switchToDefaultFrame completed");
    }

    public void switchToParentFrame() throws Exception {
        log.info("switchToParentFrame started");
        driver.switchTo().parentFrame();
        log.info("switchToParentFrame completed");
    }
    public void switchToContentframe() throws Exception {
            waitForPageToBeReady();
            switchFrame("contentframe");
    }

    // author:Hanoob Haridas
    // this code is to switch frame using xpath
        public void switchFrameByXpath(By locator) throws Exception {
        log.info("switchFrameByXpath started");
        WebElement w_identifiedElement = driver.findElement(locator);
        driver.switchTo().frame(w_identifiedElement);
        log.info("switchFrameByXpath completed");
    }

    public void pasteFromClipBoard() {
        try {
            Actions builder = new Actions(driver);
            builder.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();
            Thread.sleep(4000);
        } catch (Exception e) {
            e.getLocalizedMessage();
        }
    }

    public void handleAlert(String action) {
        switch (action.toLowerCase()) {
            case "accept":
                driver.switchTo().alert().accept();
                break;
            case "dismiss":
            case "cancel":
                driver.switchTo().alert().dismiss();
                break;
            default: Assert.isTrue(false,"Action passed is not a valid one.Please check the parameter passed.");
        }
    }


    /*
       Author     : Jishnu Nambiar
       Description: API will do a refresh at browser level
       Input      : null
       OutPutType : void
       Example    : refreshBrowser()
   */
    public void refreshBrowser() {
        driver.navigate().refresh();
    }

    /*
          Author     : Jishnu Nambiar
          Description: API will perform forward/back navigation based of the parameter passed
          Input      : String navigateType-Forward/back
          OutPutType : void
          Example    : browserNavigation(forward)
      */
    public void browserNavigation(String navigateType) {
        if (navigateType.equalsIgnoreCase("back")) {
            driver.navigate().back();
        }
        if (navigateType.equalsIgnoreCase("forward")) {
            driver.navigate().forward();
        }
    }


    public void implicitWait(int timeunit) throws Exception {
        log.info("elementimplicitlyWait started");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeunit));
        log.info("elementimplicitlyWait completed");
    }


    /*
   Author:Jishnu Nambiar
   Description:Select an option from the drop Down
   Input: By a_element-By selector of the dropdown
          String visibleText-Visible text of the option
   output:Void
   */
    public void selectFromDropDown(By a_element, String visibleText) throws Exception {
        waitForTheElement(a_element, VISIBILITY_OF_ELEMENT_LOCATED);
        Select dropdown = new Select(driver.findElement(a_element));
        dropdown.selectByVisibleText(visibleText);
    }

    /*
      Author:Jishnu Nambiar
      Description:To find the  today's  date
      Input:String dateFormat-Date Format
      output:String date_Today's Date
      Examples: Date format -MM-dd-YYYY
                             dd-MM-YYYY
                             E,MM YYYY
                duration:Today,Year,Months,Days,Minutes,Seconds
                amount-the amount of date or time to be added to the field(0 if todays )
      */
    public String getDatenTime(String dateFormat, String duration, int  amount) {
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        if (!duration.equalsIgnoreCase("Today")) {
            switch (duration.toLowerCase()) {
                case "years":
                    c.add(Calendar.YEAR, amount);
                    break;
                case "months":
                    c.add(Calendar.MONTH, amount);
                    break;
                case "days":
                    c.add(Calendar.DATE, amount);
                    break;
                case "hours":
                    c.add(Calendar.HOUR, amount);
                    break;
                case "minutes":
                    c.add(Calendar.MINUTE, amount);
                    break;
            }
        }
        String date = formatter.format(c.getTime());
        return date;
    }

    /*
      Author:Jishnu Nambiar
      Description:To find the difference between two images
      Input:String fileName-Screenshot which needs to be compared
      output:boolean diff.hasDiff()-True if there is differnce else false
      Examples: compareScreenshots(jishnu.png)
      */
    public boolean compareScreenshots(String fileName) throws Exception {
        String file = fileName.toUpperCase();
        String[] fileformat = file.split("\\.");
        waitForPageToBeReady();
        Screenshot screenshot = new AShot().takeScreenshot(driver);
        ImageIO.write(screenshot.getImage(), fileformat[1], new File(System.getProperty("user.dir") + "/src/test/resources/ActualScreenshots/" + fileName));
        BufferedImage actualImage = screenshot.getImage();
        BufferedImage expectedImage = ImageIO.read(new File(System.getProperty("user.dir") + "/src/test/resources/ExpectedScreenshots/" + fileName));
        ImageDiffer imgDiff = new ImageDiffer();
        ImageDiff diff = imgDiff.makeDiff(actualImage, expectedImage);
        if (diff.hasDiff()) {
            log.info("Difference in pixel --->" + diff.getDiffSize());
        }
        log.info("Images have difference? --->" + diff.hasDiff());
        return diff.hasDiff();
    }
    /*
         Author:Jishnu Nambiar
         Description:To find the difference between two images with tolerance of pixel
         Input:String fileName-Screenshot which needs to be compared
                int tolerancePixel=Difference in the pixel allowed
         output:boolean diff.hasDiff()-True if there is differnce else false
         Examples: compareScreenshots(jishnu.png,10)
         */
    public boolean compareScreenshots(String fileName, int tolerancePixel) throws Exception {
        String file = fileName.toUpperCase();
        String[] fileformat = file.split("\\.");
        waitForPageToBeReady();
        Screenshot screenshot = new AShot().takeScreenshot(driver);
        ImageIO.write(screenshot.getImage(), fileformat[1], new File(System.getProperty("user.dir") + "/src/test/resources/ActualScreenshots/" + fileName));
        BufferedImage actualImage = screenshot.getImage();
        BufferedImage expectedImage = ImageIO.read(new File(System.getProperty("user.dir") + "/src/test/resources/ExpectedScreenshots/" + fileName));
        ImageDiffer imgDiff = new ImageDiffer();
        ImageDiff diff = imgDiff.makeDiff(actualImage, expectedImage).withDiffSizeTrigger(tolerancePixel);
        log.info("Difference in pixel --->" + diff.getDiffSize());
        log.info("Images have difference? --->" + diff.hasDiff());
        return diff.hasDiff();
    }

    /*
         Author:Jishnu Nambiar
         Description:To capture screenshots and store
         Input:String fileName-Screenshot name
         output:null
         Examples: captureScreenshot(jishnu.png)
     */
    public void captureScreenshot(String fileName) throws Exception {
        String file = fileName.toUpperCase();
        String[] fileformat = file.split("\\.");
        waitForPageToBeReady();
        Screenshot screenshot = new AShot().takeScreenshot(driver);
        ImageIO.write(screenshot.getImage(), fileformat[1], new File(System.getProperty("user.dir") + "/src/test/resources/ActualScreenshots/" + fileName));
    }


     /*
      Author:Jishnu Nambiar
      Description:To find the hidden text in a Barcode/QR Code
      Input:String locator-Locator of the BarCode/QRCode
      output:String result.getText()-Returns the text hidden inside the barcode/Qr code
      Examples: scanBarandQRCode(By.xpath("//h2[text()='QR Code']//following-sibling::div[@class=\"widget-content\"]//img[1]))
      */
    public String scanBarandQRCode(By locator) throws Exception {
        String barcodeUrl = driver.findElement(locator).getAttribute("src");
        URL url = new URL(barcodeUrl);
        BufferedImage bufferedImage = ImageIO.read(url);
        LuminanceSource luminanceSource = new BufferedImageLuminanceSource(bufferedImage);
        BinaryBitmap binary = new BinaryBitmap(new HybridBinarizer(luminanceSource));
        Result result = new MultiFormatReader().decode(binary);
        return result.getText();
    }
    /*

     */
   public By belowOF(By selector,By selectorBelowOF){
       WebElement elementBelowOF = driver.findElement(selectorBelowOF);
       By element = RelativeLocator.with(selector).below(elementBelowOF);
       return  element;
   }

    public By aboveOF(By selector,By selectorAboveOF){
        WebElement elementAboveOF = driver.findElement(selectorAboveOF);
        By element = RelativeLocator.with(selector).above(elementAboveOF);
        return  element;
    }

    public By nearOF(By selector,By selectorNearOF){
        WebElement elementNearOF = driver.findElement(selectorNearOF);
        return RelativeLocator.with(selector).near(elementNearOF);
    }
    public By nearOFAtMostPixelDif(By selector,By selectorNearOF,int pixelDiff){
        WebElement elementNearOF = driver.findElement(selectorNearOF);
        return RelativeLocator.with(selector).near(elementNearOF,pixelDiff);
    }

    public By toLeftOf(By selector,By selectorLeftOF){
        WebElement elementLeftOF = driver.findElement(selectorLeftOF);
        return RelativeLocator.with(selector).toLeftOf(elementLeftOF);
    }
    public By toRightOf(By selector,By selectorRightOF){
        WebElement elementRightOf = driver.findElement(selectorRightOF);
        return RelativeLocator.with(selector).toLeftOf(elementRightOf);
    }
    // author:anup
    // this code is working fine and waiting for page to load
    public void waitForPageToBeReady() throws Exception {
        if(!isAndroidDriver()) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            for (int i = 0; i < 100; i++) {
                Thread.sleep(500);
                // To check page ready state.
                if (js.executeScript("return document.readyState").toString().equals("complete")) {
                    break;
                }
            }
        }
        //log.info("waitForPageToBeReady completed");
    }

    public void waitForTheElement(By locator, String waitType) throws Exception {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            startTime = System.currentTimeMillis();
            if (CLICKABILITY_OF_ELEMENT_LOCATED.equalsIgnoreCase(waitType)) {
                wait.until(ExpectedConditions.elementToBeClickable(locator));
            } else if (PRESENCE_OF_ELEMENT_LOCATED.equalsIgnoreCase(waitType)) {
                wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            } else if (FRAME_TO_BE_AVAILABLE_AND_SWITCH_TO_IT.equalsIgnoreCase(waitType)) {
                wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
            } else if (INVISIBILITY_OF_ELEMENT.equalsIgnoreCase(waitType)) {
                wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
            } else if (IS_ALERT_PRESENT.equalsIgnoreCase(waitType)) wait.until(ExpectedConditions.alertIsPresent());
            else wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        }catch (Exception e){
            log.trace(String.valueOf(e));
        }finally {
            calWaitTimeAndLogToFile(startTime,locator);
        }
    }
    private void calWaitTimeAndLogToFile(long startTime,By locator) throws Exception {
        if(!isAndroidDriver()) {
            endTime = System.currentTimeMillis();
            duration = (endTime - startTime); //convert in sec / 1000
            getInfo(locator, duration);
        }
    }

    private boolean isAndroidDriver() {
        String driverDetails=driver.getClass().getName();
        String[] driverDetailSpilt=driverDetails.split("\\.");
        String driverType=driverDetailSpilt[driverDetailSpilt.length-1];
        return driverType.equalsIgnoreCase("AndroidDriver");
    }

    /*
    Author-Jishnu Nambiar
    Description-Explicit wait with customized timeout
    input paramter-"By locator-Locator of element
    String a_waitType-Type of wait
    Int seconds-Seconds to wait for element"
    output paramter-null
     */
    public void customWaitForElement(By locator, String waitType, int seconds) throws Exception {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
            startTime = System.currentTimeMillis();
            if (CLICKABILITY_OF_ELEMENT_LOCATED.equalsIgnoreCase(waitType)) {
                wait.until(ExpectedConditions.elementToBeClickable(locator));
            } else if (PRESENCE_OF_ELEMENT_LOCATED.equalsIgnoreCase(waitType)) {
                wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            } else if (FRAME_TO_BE_AVAILABLE_AND_SWITCH_TO_IT.equalsIgnoreCase(waitType)) {
                wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
            } else if (INVISIBILITY_OF_ELEMENT.equalsIgnoreCase(waitType)) {
                wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
            } else if (IS_ALERT_PRESENT.equalsIgnoreCase(waitType)) {
                wait.until(ExpectedConditions.alertIsPresent());
            } else {
                wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            }
        }catch (Exception e){
            log.trace(String.valueOf(e));
        }finally {
            calWaitTimeAndLogToFile(startTime,locator);
        }
    }

    public void getInfo(By locator, long duration)throws Exception {
        if(ExceptionLogger.tagNames != null){
            for (String eachTagName:ExceptionLogger.tagNames) {
                if(eachTagName.contains("Data") || eachTagName.contains("data")){
                    String[] splitTagName = eachTagName.split("@");
                    moduleName = splitTagName[1];
                    break;
                }else if(eachTagName.contains("Scenario")){
                    String[] splitTagName = eachTagName.split("@");
                    String[] tag = splitTagName[1].split("S");
                    moduleName = tag[0];
                    break;
                }
            }
        }
        String currentUrl = driver.getCurrentUrl();
        String baseURL = "";
        URL url = new URL(currentUrl);
        String protocol = url.getProtocol();
        String host = url.getHost();
        baseURL = protocol + "://" +host;
        String[] eachElement = locator.toString().split("\\.");
        String[] locatorElement = eachElement[1].split(": ");
        String title = driver.getTitle();//Title of Page
        log.debug("Module_Name="+moduleName+";"+"Web_page="+title+";"+"Element_business_name="+label+";"+"Locator_strategy="+
                locatorElement[0]+";"+"Element_locator="+locatorElement[1]+";"+"WaitTime="+duration+"ms"+";"+"Current_URL="+currentUrl);
    }

    public By retriveLocators(String element) throws Exception {
        By locator = null;
        String[] beforeSplit = element.split(":", 2);
        label = beforeSplit[0];
        String[] defineLocator = beforeSplit[1].split("=", 2);
        String locatorType = defineLocator[0];
        String locatorValue = defineLocator[1];
        if(!isAndroidDriver()){
            locatorValue.replace(" ","\\u00a0");
        }
        switch (locatorType) {
            case "id":
                locator = By.id(locatorValue);
                break;
            case "class":
                locator = By.className(locatorValue);
                break;
            case "css":
                locator = By.cssSelector(locatorValue);
                break;
            case "xpath":
                locator = By.xpath(locatorValue);
                break;
        }
        local_by = locator;
        return locator;
    }

    public boolean isEnabled(By a_element) throws Exception {
        return  driver.findElement(a_element).isEnabled();

    }
    public boolean isElementSelected(By a_element) throws Exception {
       return driver.findElement(a_element).isSelected();
    }
    public String getElementsAttribute(By m_element, String m_attribute) {
        return driver.findElement(m_element).getAttribute(m_attribute);
    }
}

