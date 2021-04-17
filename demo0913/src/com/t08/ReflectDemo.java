package com.t08;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectDemo {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class<?> c = Class.forName("com.t02.Student");

        /*Method m1 = c.getMethod("method1");
        Method m2 = c.getMethod("toString");

        System.out.println(m1);
        System.out.println(m2);*/

       /* Method[] ms = c.getDeclaredMethods();

        for(Method m:ms){
            System.out.println(m);
        }*/

        Method m = c.getMethod("method1");

        Constructor<?> con = c.getConstructor();

        Object obj = con.newInstance();

        m.invoke(obj);

    }
}
