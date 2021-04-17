package com.t07;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class IOBufferedDemo {

    public static void main(String[] args) {

        long startTime1 = System.currentTimeMillis();

        method1();


        long endTime1 = System.currentTimeMillis();

        System.out.println("共耗时:"+(endTime1-startTime1));

        long startTime2 = System.currentTimeMillis();

        method2();


        long endTime2 = System.currentTimeMillis();

        System.out.println("共耗时:"+(endTime2-startTime2));

        long startTime3 = System.currentTimeMillis();

        method3();


        long endTime3 = System.currentTimeMillis();

        System.out.println("共耗时:"+(endTime3-startTime3));

        long startTime4 = System.currentTimeMillis();

        method4();


        long endTime4 = System.currentTimeMillis();

        System.out.println("共耗时:"+(endTime4-startTime4));


    }

    private static void method4() {
        FileOutputStream fos;
        FileInputStream fis;

        BufferedInputStream bis;
        BufferedOutputStream bos;

        try {
            fis = new FileInputStream("E:\\A我的发家史\\篮浅公司\\LED篮球框灯\\安装视频\\进球测试.mp4");
            fos = new FileOutputStream("D:\\itcast\\NBA.mp4");

            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            byte[] bys = new byte[1024];

            int len;

            while ((len=bis.read(bys))!=-1){
                bos.write(bys,0,len);
            }

            bis.close();
            bos.close();
            fis.close();
            fos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void method3() {
        FileOutputStream fos;
        FileInputStream fis;

        BufferedInputStream bis;
        BufferedOutputStream bos;

        try {
            fis = new FileInputStream("E:\\A我的发家史\\篮浅公司\\LED篮球框灯\\安装视频\\进球测试.mp4");
            fos = new FileOutputStream("D:\\itcast\\NBA.mp4");

            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            int by;

            while ((by=bis.read())!=-1){
                bos.write(by);
            }

            bis.close();
            bos.close();
            fis.close();
            fos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void method2() {
        FileOutputStream fos;
        FileInputStream fis;

        try {
            fis = new FileInputStream("E:\\A我的发家史\\篮浅公司\\LED篮球框灯\\安装视频\\进球测试.mp4");
            fos = new FileOutputStream("D:\\itcast\\NBA.mp4");

            byte[] bys = new byte[1024];

            int len;

            while ((len=fis.read(bys))!=-1){
                fos.write(bys,0,len);
            }

            fis.close();
            fos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void method1() {
        FileOutputStream fos;
        FileInputStream fis;

        try {
            fis = new FileInputStream("E:\\A我的发家史\\篮浅公司\\LED篮球框灯\\安装视频\\进球测试.mp4");
            fos = new FileOutputStream("D:\\itcast\\NBA.mp4");

            int by;

            while ((by=fis.read())!=-1){
                fos.write(by);
            }

            fis.close();
            fos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
