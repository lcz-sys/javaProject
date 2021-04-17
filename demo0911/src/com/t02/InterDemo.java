package com.t02;

public class InterDemo {

    public static void main(String[] args) {

        Inter i = new InterImpl();

        i.show();
        i.method();
        Inter.test();

    }

}
