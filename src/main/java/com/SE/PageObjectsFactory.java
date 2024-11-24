package com.SE;

import com.annotation.PageFragment;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@PageFragment
public class PageObjectsFactory {
    public static Properties loadProperties(String fileName) {
        Properties properties = new Properties();
        String path = "objectRepository/";
        try (InputStream input = PageObjectsFactory.class.getClassLoader().getResourceAsStream(path +fileName)) {
            if (input != null) {
                properties.load(input);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}

