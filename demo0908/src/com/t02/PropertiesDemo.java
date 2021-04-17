package com.t02;

import java.util.Properties;
import java.util.Set;

public class PropertiesDemo {

    public static void main(String[] args) {

        Properties prop = new Properties();

        prop.put("001","张三");
        prop.put("002","李四");
        prop.put("003","王五");

        Set<Object> keySet = prop.keySet();

        for(Object key : keySet){
            Object value = prop.get(key);
            System.out.println(key+","+value);
        }
    }
}
