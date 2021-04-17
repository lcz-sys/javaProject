package com.t05;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectDemo {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class<?> c = Class.forName("com.t02.Student");


        Constructor<?> con = c.getDeclaredConstructor(String.class);

        con.setAccessible(true);

        Object obj = con.newInstance("zhangsan");
        System.out.println(obj);
        

    }
}
