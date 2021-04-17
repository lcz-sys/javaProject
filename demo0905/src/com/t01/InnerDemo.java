package com.t01;

public class InnerDemo {

    public static void main(String[] args) {

        /*Outer.Inner inner = new Outer().new Inner();

        inner.show();*/

        Outer o = new Outer();

        o.method();
    }
}
