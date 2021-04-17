package com.t10;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class ReflectTest {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        ArrayList<Integer> array = new ArrayList<>();


        Class<? extends ArrayList> c = array.getClass();

        Method add = c.getMethod("add", Object.class);

        add.invoke(array,"hello");

        System.out.println(array);

    }
}
