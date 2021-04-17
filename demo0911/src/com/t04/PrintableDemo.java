package com.t04;

import java.io.PrintWriter;

public class PrintableDemo {

    public static void main(String[] args) {

        usePrintable(s-> System.out.println(s));

    }

    private static void usePrintable(Printable p){
        p.printString("java");
    }

}
