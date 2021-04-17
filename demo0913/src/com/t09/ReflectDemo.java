package com.t09;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectDemo {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {


        Class<?> c = Class.forName("com.t02.Student");

        Constructor<?> con = c.getConstructor();

        Object obj = con.newInstance();

        Method method1 = c.getMethod("method1");

        method1.invoke(obj);

        Method method2 = c.getMethod("method2", String.class);

        method2.invoke(obj,"zhangsan");

        Method method3 = c.getMethod("method3", String.class, int.class);

        Object o = method3.invoke(obj, "zhangsan", 30);

        System.out.println(o);

        Method funciton = c.getDeclaredMethod("function");

        funciton.setAccessible(true);

        funciton.invoke(obj);

    }
}
