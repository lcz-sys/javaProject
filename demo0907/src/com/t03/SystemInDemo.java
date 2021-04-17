package com.t03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SystemInDemo {

    public static void main(String[] args) throws IOException {

        InputStream is =System.in;

//        int by;
//
//        while((by=is.read())!=-1){
//            System.out.print((char) by);
//        }

        InputStreamReader isr = new InputStreamReader(is);

        BufferedReader br = new BufferedReader(isr);

        char[] chs = new char[1024];

        String line;

        while((line=br.readLine())!=null){
            System.out.print(line);
        }

    }
}
