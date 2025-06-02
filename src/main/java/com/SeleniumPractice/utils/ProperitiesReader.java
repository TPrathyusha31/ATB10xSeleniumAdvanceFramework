package com.SeleniumPractice.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ProperitiesReader {

    //It will read the data.properities file and will return the value based on the key
    public static String readKey(String key){
        Properties p;

        try {
            FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+"/src/resources/data.properities");
            p = new Properties();
            p.load(fileInputStream);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        return p.getProperty(key);
    }
}
