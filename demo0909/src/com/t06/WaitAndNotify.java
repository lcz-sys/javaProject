package com.t06;

public class WaitAndNotify {

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

        new Thread() {
            @Override
            public void run() {
                System.out.println("做包子");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (obj){
                    System.out.println("做好包子");
                    obj.notify();
                }

            }
        }.start();
    }
}
