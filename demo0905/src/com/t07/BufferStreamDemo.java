package com.t07;

import java.io.*;

public class BufferStreamDemo {

    public static void main(String[] args) {

        FileOutputStream fos;
        FileInputStream fis;

        BufferedInputStream bis;
        BufferedOutputStream bos;

        try {
            fis = new FileInputStream("C:\\Users\\恒心.DESKTOP-HNE4HK9\\Pictures\\微信图片_20191126141649.jpg");
            fos = new FileOutputStream("D:\\itcast\\mt1.jpg");

            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            int len;

            byte[] bys = new byte[819200];

            if ((len = bis.read(bys)) != -1) {
                bos.write(bys, 0, len);
//                System.out.print(new String(bys,0,len));
            }

            bis.close();
            bos.close();
            fis.close();
            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
