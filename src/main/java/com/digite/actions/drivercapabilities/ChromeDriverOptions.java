package com.digite.actions.drivercapabilities;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;

import java.util.HashMap;
import java.util.logging.Level;

//import static com.digite.actions.commands.Common.driver;


@Slf4j
public class ChromeDriverOptions  {
    public ChromeOptions setOptions(String mode){
        log.info("ChromeDriver options are being set");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("disable-features=NetworkService");
        options.addArguments("--remote-allow-origins=*");
        if(mode.equalsIgnoreCase("headless")){
            options.addArguments("headless");//to run on headless chrome browser on linux.Comment this line when running on local machine
        }
        options.addArguments("window-size=1920x1080");
        options.setAcceptInsecureCerts(true);
        options.addArguments("--enable-javascript");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-plugins");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-popup-blocking");
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        options.addArguments("--test-type");
        options.addArguments("start-maximized");
        options.addArguments("--user-agent=Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.5005.63 Safari/537.36");
        options.addArguments("--disable-gpu");
      options.addArguments("--disable-dev-shm-usage");
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable( LogType.PERFORMANCE, Level.ALL );
        log.info("ChromeDriver options are successfully set");
        return options;
    }

}
