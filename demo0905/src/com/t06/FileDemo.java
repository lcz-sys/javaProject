package com.t06;

import java.io.File;
import java.io.IOException;

public class FileDemo {

    public static void main(String[] args) throws IOException {

        File f1 = new File("D:\\itcast\\java.txt");

        System.out.println(f1.createNewFile());

        File f2 = new File("D:\\itcast\\javase");

        System.out.println(f2.mkdir());

        File f3 = new File("D:\\itcast\\javaweb\\html");

        System.out.println(f3.mkdirs());



    }
}
