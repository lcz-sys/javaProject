package com.t03;

import java.io.FileNotFoundException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

public class SystemOutDemo {

    public static void main(String[] args) throws FileNotFoundException {
//        PrintStream out = System.out;

//        out.print("hello");
//        out.print(100);

//        out.println("hello");
//        out.println(100);

        PrintStream ps = new PrintStream("D:\\itcast\\names.txt");
//        OutputStreamWriter writer = new OutputStreamWriter(ps);

//        ps.write(97);

        ps.print(97);

        ps.close();

    }
}
