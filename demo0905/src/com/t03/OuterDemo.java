package com.t03;

import java.util.Calendar;

public class OuterDemo {

    public static void main(String[] args) {
        Outer o = new Outer();

        o.method();

        Integer i1 = Integer.valueOf("100");
//        Integer i2 = Integer.valueOf("abc");

        System.out.println(i1);
//        System.out.println(i2);

        Calendar instance = Calendar.getInstance();

        System.out.println(instance);


    }
}
