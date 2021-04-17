package com.t04;

public class RunnableImpl implements Runnable {

    private static int ticket = 100;

    @Override
    public void run() {
        while (true) {
//            payTicket();
            payTicketStatic();
        }

    }

    public static synchronized void payTicketStatic() {

        if (ticket > 0) {

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "\t" + ticket);
            ticket--;
        }
    }

    public synchronized void payTicket() {

        if (ticket > 0) {

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "\t" + ticket);
            ticket--;
        }
    }
}
