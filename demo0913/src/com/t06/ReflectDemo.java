package com.t06;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ReflectDemo {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class<?> c = Class.forName("com.t02.Student");

//        Field[] fields = c.getFields();

        Field[] fields = c.getDeclaredFields();

        for(Field field:fields){
            System.out.println(field);
        }

        Field address = c.getField("address");

        System.out.println(address);


        Constructor<?> con = c.getConstructor();

        Object obj = con.newInstance();

        address.set(obj,"xian");

        System.out.println(obj);


    }
}
