package com.t07;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IODemo {


    public static void main(String[] args) {


        FileInputStream fis;

        FileOutputStream fos;


        try {
            fis = new FileInputStream("C:\\Users\\恒心.DESKTOP-HNE4HK9\\Pictures\\微信图片_20191126141649.jpg");
            fos = new FileOutputStream("D:\\itcast\\mt.jpg");

            byte[] bys = new byte[1024];

            int len;

            while((len=fis.read(bys))!=-1){
                fos.write(bys,0,len);
            }

            fis.close();
            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
