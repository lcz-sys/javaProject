package com.t07;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDmeo {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos =new FileOutputStream("D:\\itcast\\java.txt",true);

        byte b[] = {100,102,106,101};

        fos.write(b);

        fos.close();
    }
}
