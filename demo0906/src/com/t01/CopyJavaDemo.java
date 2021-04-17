package com.t01;

import java.io.*;

public class CopyJavaDemo {

    public static void main(String[] args) throws IOException {

        long startTime1 = System.currentTimeMillis();

        method1();

        long endTime1 = System.currentTimeMillis();

        System.out.println(endTime1 - startTime1);

        long startTime2 = System.currentTimeMillis();

        method2();

        long endTime2 = System.currentTimeMillis();

        System.out.println(endTime2 - startTime2);
    }

    private static void method2() {
        InputStreamReader reader;

        OutputStreamWriter writer;

        try {
            reader = new InputStreamReader(
                    new FileInputStream("D:\\JavaProject\\demo0906" +
                            "\\src\\com\\t01\\CopyJavaDemo.java"));

            writer = new OutputStreamWriter(new FileOutputStream("D:\\itcast\\Copy.java"));

            int len;

            char[] chs = new char[512];

            while ((len = reader.read(chs)) != -1) {
                writer.write(chs,0,len);
            }

            reader.close();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void method1() {

        InputStreamReader reader;

        OutputStreamWriter writer;

        try {
            reader = new InputStreamReader(
                    new FileInputStream("D:\\JavaProject\\demo0906" +
                            "\\src\\com\\t01\\CopyJavaDemo.java"));

            writer = new OutputStreamWriter(new FileOutputStream("D:\\itcast\\Copy.java"));

            int ch;

            while ((ch = reader.read()) != -1) {
                writer.write(ch);
            }

            reader.close();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
