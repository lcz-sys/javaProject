package com.t02;

public interface Inter {

    void show();

    default void method(){
        System.out.println("Inter default method");
    }

    static void test(){
        System.out.println("Inter static method");
    }

}
