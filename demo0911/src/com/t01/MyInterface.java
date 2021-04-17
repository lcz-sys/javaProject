package com.t01;

public interface MyInterface {

    void show();

    void show2();

    public default void show3(){
        System.out.println("show3");
    }
}
