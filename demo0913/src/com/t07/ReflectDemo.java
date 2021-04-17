package com.t07;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ReflectDemo {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class<?> c = Class.forName("com.t02.Student");

       /* Field name = c.getDeclaredField("name");

        Constructor<?> con = c.getDeclaredConstructor(String.class);
        con.setAccessible(true);

        Object obj = con.newInstance("zhangsan");

        System.out.println(obj);*/

        Constructor<?> con = c.getConstructor();

        Object obj = con.newInstance();

        System.out.println(obj);

//        Field name = c.getField("name");
        Field name = c.getDeclaredField("name");
        name.setAccessible(true);
        name.set(obj,"zhangsan");

        System.out.println(obj);

    }

}
