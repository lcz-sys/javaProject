package com.t03;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

@Pro(className = "com.t03.Student",methodName = "study")
public class ReflectDemo {

    public static void main(String[] args) throws IOException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException, ClassNotFoundException {

        Class<ReflectDemo> reflectDemoClass = ReflectDemo.class;

        ClassLoader classLoader = reflectDemoClass.getClassLoader();

        InputStream is = classLoader.getResourceAsStream("pro.properties");

        Properties prop = new Properties();

        prop.load(is);

        Pro an = reflectDemoClass.getAnnotation(Pro.class);

        String className = an.className();
        String methodName = an.methodName();

        if(className==null && methodName==null){
            className = prop.getProperty("className");
            methodName = prop.getProperty("methodName");
        }

        Class<?> c = Class.forName(className);

        Object obj = c.newInstance();

        Method m = c.getDeclaredMethod(methodName);

        m.invoke(obj);


    }

}
