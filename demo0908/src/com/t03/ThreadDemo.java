package com.t03;

public class ThreadDemo {

    public static void main(String[] args) {

        MyThread mt = new MyThread();

        mt.start();

        for (int i = 0; i < 20; i++) {
            System.out.println("main:" + i);
        }
    }
}
