package com.t03;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PrintWriteDemo {

    public static void main(String[] args) throws FileNotFoundException {

        PrintWriter pw = new PrintWriter("D:\\itcast\\names.txt");

        pw.write("中");

        pw.write("\r\n");

        pw.write("国");

        pw.close();
    }
}
