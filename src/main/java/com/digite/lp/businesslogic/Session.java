package com.digite.lp.businesslogic;


import com.digite.actions.commands.Common;
import com.digite.actions.drivercapabilities.WebDriverFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class Session extends Common {

    public Session(WebDriverFactory webDriverFactory) {
        super(webDriverFactory);
    }

    @Autowired
    private Environment sessionRepo;
//    private final Map<String, String> sessionRepo = super.readPropertiesFile(PageObjectsFactory.LPSession);

    /*
    private String Ninad = "12346";
    private String Emelda = "12376";

    public String getUserId(String userName) {
        String userId = "";
        if (userName.equalsIgnoreCase("Ninad")) {
            userId = this.Ninad;
        }
        else if (userName.equalsIgnoreCase("Emelda")) {
            userId = this.Emelda;
        }
        return userId;
    }*/
    public void getUserSession(String userName) throws Exception {
        log.info("getUserSession Started");
        try {

            String url = sessionRepo.getProperty(userName);//key
            super.navigate(url);

        } catch (Throwable t) {
            super.logger(scenario, t);
        }
        log.info("getUserSession completed");
    }


}


