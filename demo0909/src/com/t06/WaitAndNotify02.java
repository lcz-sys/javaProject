package com.t06;

public class WaitAndNotify02 {

    public static void main(String[] args) {

        Object obj = new Object();

        new Thread() {
            @Override
            public void run() {
                synchronized (obj) {
                    System.out.println("买包子");
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("吃包子");
                }
            }
        }.start();

    }
}
