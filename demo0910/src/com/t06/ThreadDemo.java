package com.t06;

public class ThreadDemo {

    public static void main(String[] args) {

        /*MyThread mt = new MyThread();

        new Thread(mt).start();*/

        new Thread(()->{
            System.out.println("多线程程序启动了");
        }).start();
    }
}
