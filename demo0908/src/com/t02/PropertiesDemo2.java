package com.t02;

import java.util.Properties;
import java.util.Set;

public class PropertiesDemo2 {
    public static void main(String[] args) {

        Properties prop = new Properties();

        prop.setProperty("001","林青霞");

        prop.setProperty("002","sjdks");

        prop.setProperty("003","java");

        Set<String> names = prop.stringPropertyNames();

        for(String key : names){
//            System.out.println(key);
            String value = prop.getProperty(key);
            System.out.println(key+","+value);
        }
    }
}
