package com.t08;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class IODemo {

    public static void main(String[] args) throws IOException {

        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("D:\\itcast\\java.txt"));

        osw.write(97);

        osw.flush();

        osw.close();
    }
}
