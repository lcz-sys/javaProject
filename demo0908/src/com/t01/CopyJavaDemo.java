package com.t01;

import java.io.*;

public class CopyJavaDemo {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new FileReader("D:\\JavaProject\\demo0908\\src\\com\\t01\\CopyJavaDemo.java"));

        PrintWriter pw = new PrintWriter(new FileWriter("D:\\itcast\\names.txt",true));

        String line;

        while((line=br.readLine())!=null){
            pw.println(line);
        }

        br.close();
        pw.close();


    }
}
