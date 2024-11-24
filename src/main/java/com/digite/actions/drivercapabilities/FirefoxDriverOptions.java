package com.digite.actions.drivercapabilities;


import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Set;


@Slf4j
public class FirefoxDriverOptions {

    public FirefoxOptions setOptions(String mode){
        log.info("FirefoxDriver options are being set");
        FirefoxOptions w_options = new FirefoxOptions()
                .addArguments("--headless")
                .addPreference("browser.startup.page", 1)
                .addPreference("browser.startup.homepage", "https://www.google.com");

        Set<String> ind = w_options.getCapabilityNames();
        System.err.println(ind.size());
        log.info("Firefox Driver options are successfully set");
        return w_options;
    }

}
