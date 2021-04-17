package com.t07;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamDemo {

    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("D:\\JavaProject\\demo0905\\src\\com\\t07\\FileInputStreamDemo.java");

      /*  byte[] b = new byte[8];

        int len = fis.read(b);

        System.out.println(len);

        System.out.println(new String(b));*/

        byte[] bys = new byte[1024];

        int len;

        while((len = fis.read(bys))!=-1){
            System.out.print(new String(bys,0,len));
        }


        fis.close();


    }
}
