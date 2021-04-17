package com.t10;

public class MyInterfaceDemo {

    public static void main(String[] args) {

        MyInterface mi = () -> System.out.println("函数式接口");

        mi.show();

    }
}
