package com.digite.actions.drivercapabilities;

import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.SimpleThreadScope;

public class BrowserScope extends SimpleThreadScope {

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        Object driver = super.get(name, objectFactory);
        if (driver instanceof RemoteWebDriver) {
            try {
                // Check if the session is valid
                ((RemoteWebDriver) driver).getSessionId();
            } catch (NoSuchSessionException e) {
                // If the session is stale, remove the instance and create a new one
                super.remove(name);
                driver = super.get(name, objectFactory); // Recreate if stale
            }
        } else if (driver == null) {
            // If no driver exists, create a new one
            driver = super.get(name, objectFactory);
        }
        return driver;
    }
}
