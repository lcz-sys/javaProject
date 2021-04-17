package com.t05;

public class PrintableDemo {

    public static void main(String[] args) {

        usePrintable(i-> System.out.println(i));

        usePrintable(System.out::println);

    }

    private static void usePrintable(Printable p){
        p.printInt(666);
    }

}
