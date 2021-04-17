package com.t10;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectDemo {

    public static void main(String[] args) throws IOException, NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Properties prop = new Properties();
        FileReader fr = new FileReader("src\\com\\t10\\class.txt");

        prop.load(fr);

        fr.close();

        String className = prop.getProperty("className");
        String methodName = prop.getProperty("methodName");

        Class<?> c = Class.forName(className);

        Constructor<?> con = c.getConstructor();

        Object obj = con.newInstance();

        Method m = c.getDeclaredMethod(methodName);

        m.invoke(obj);


    }
}
