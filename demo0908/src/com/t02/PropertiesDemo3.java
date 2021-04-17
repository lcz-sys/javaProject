package com.t02;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class PropertiesDemo3 {

    public static void main(String[] args) throws IOException {

//        myStore();

        myLoad();
    }

    private static void myLoad() throws IOException {

        Properties prop = new Properties();

        FileReader fr = new FileReader("src\\com\\t02\\java.txt");

        prop.load(fr);

        fr.close();

        System.out.println(prop);

        Set<Object> keySet = prop.keySet();

        for(Object key : keySet){
            String value = prop.getProperty((String) key);
            System.out.println(key+"="+value);
        }

    }

    private static void myStore() throws IOException {
        Properties prop = new Properties();

        prop.setProperty("001","java");
        prop.setProperty("002","javase");
        prop.setProperty("003","javaee");

        FileWriter fw = new FileWriter("src\\com\\t02\\java.txt");

        prop.store(fw,null);

        fw.close();
    }
}
