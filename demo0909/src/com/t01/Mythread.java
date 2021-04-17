package com.t01;

public class Mythread extends Thread {

    @Override
    public void run() {
//        String name = getName();
//        System.out.println(name);

        Thread thread = Thread.currentThread();

//        System.out.println(thread);

        int priority = thread.getPriority();

        System.out.println(priority);
    }
}
