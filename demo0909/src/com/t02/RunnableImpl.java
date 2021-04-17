package com.t02;

public class RunnableImpl implements Runnable {

    private static int ticket = 100;

    @Override
    public void run() {
       while (ticket > 0){
           System.out.println(Thread.currentThread().getName()+"\t"+ticket);
           ticket--;
       }
    }
}
