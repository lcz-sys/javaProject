package com.t03;

public interface Inter {

    /*private void show(){

    }*/

    default void show1(){
        System.out.println("show1");
        System.out.println("show1");
        System.out.println("show1");
        System.out.println("show1");
        System.out.println("show1");
    }

    default void show2(){
        System.out.println("show2");
        System.out.println("show2");
        System.out.println("show2");
        System.out.println("show2");
        System.out.println("show2");
    }

  /*  private void show(){
        System.out.println("show3");
        System.out.println("show3");
        System.out.println("show3");
        System.out.println("show3");
        System.out.println("show3");
    }*/

    static void method(){
        System.out.println("method");
        System.out.println("method");
        System.out.println("method");
        System.out.println("method");
        System.out.println("method");
    }

    static void method2(){
        System.out.println("method2");
        System.out.println("method2");
        System.out.println("method2");
        System.out.println("method2");
        System.out.println("method2");
    }

}
