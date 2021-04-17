package com.t03;

public class Outer {

    public void method(){

        new Inter() {
            @Override
            public void show() {
                System.out.println("匿名内部类");
            }
        }.show();
    }
}
