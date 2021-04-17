package com.t01;

import java.util.function.Supplier;

public class SupplierDemo {

    public static void main(String[] args) {

        String s = getString(()->{
           return "hh";
        });

        System.out.println(s);

        String s2 = getString(()->"hsdakdas");

        System.out.println(s2);

        int i = getInteger(()->{
            return 12;
        });

        System.out.println(i);

    }

    private static Integer getInteger(Supplier<Integer> sup){
        return sup.get();
    }

    private static String getString(Supplier<String> sup){
        return sup.get();
    }
}
