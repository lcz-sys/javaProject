package com.t08;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class FileInputStreamDemo {

    public static void main(String[] args) throws UnsupportedEncodingException {


        String s = "中国";

        byte[] bys = s.getBytes();

        System.out.println(Arrays.toString(bys));

//        String ss = new String(bys,"UTF-8");
        String ss = new String(bys,"GBK");

        System.out.println(ss);
    }
}
