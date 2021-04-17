package com.t03;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectDemo {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class<?> c = Class.forName("com.t02.Student");

//        Constructor<?>[] cons = c.getConstructors();
        Constructor<?>[] cons = c.getDeclaredConstructors();

        for(Constructor con:cons){
            System.out.println(con);
        }

        System.out.println("-------");

        Constructor<?> con = c.getConstructor();

        System.out.println(con);

        Object obj = con.newInstance();

        System.out.println(obj);


    }

}
