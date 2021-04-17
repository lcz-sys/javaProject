package com.t01;

public class ThreadDemo {

    public static void main(String[] args) {

        Mythread mt = new Mythread();

        mt.start();

        new Mythread().start();
        new Mythread().start();

    }
}
