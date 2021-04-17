package com.t01;

import java.io.*;

public class BufferCopyJavaDemo {

    public static void main(String[] args) {

        long startTime1 = System.currentTimeMillis();


        InputStreamReader reader;

        OutputStreamWriter writer;

        BufferedWriter bw;

        BufferedReader br;

        try {
            reader = new InputStreamReader(
                    new FileInputStream("D:\\JavaProject\\demo0906" +
                            "\\src\\com\\t01\\CopyJavaDemo.java"));

            writer = new OutputStreamWriter(new FileOutputStream("D:\\itcast\\Copy.java"));

            br = new BufferedReader(reader);

            bw = new BufferedWriter(writer);

            int len;

            char[] chs = new char[1024];

            while ((len = br.read(chs)) != -1) {
                bw.write(chs,0,len);
            }

            bw.close();
            br.close();
            reader.close();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        long endTime1 = System.currentTimeMillis();

        System.out.println(endTime1 - startTime1);


    }
}
