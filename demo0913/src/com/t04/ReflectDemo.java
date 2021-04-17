package com.t04;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectDemo {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class<?> c = Class.forName("com.t02.Student");

        Constructor<?> con = c.getConstructor(String.class, int.class, String.class);

        System.out.println(con);

        Object obj = con.newInstance("zhangsan", 30, "xian");
        System.out.println(obj);

    }
}
