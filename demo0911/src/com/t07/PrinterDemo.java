package com.t07;

public class PrinterDemo {

    public static void main(String[] args) {

        usePrinter((String s)->{
            String result = s.toUpperCase();

            System.out.println(result);
        });

        usePrinter(s-> System.out.println(s.toUpperCase()));

        PrintString ps = new PrintString();

        usePrinter(ps::printUpper);
    }

    private static void usePrinter(Printer p){
        p.printUppercase("Hello world");
    }
}
