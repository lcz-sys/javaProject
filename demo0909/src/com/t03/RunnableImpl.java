package com.t03;

public class RunnableImpl implements Runnable {

    private int ticket = 100;

    Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (obj) {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "\t" + ticket);
                    ticket--;
                }
            }
        }

    }
}
