package com.t09;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class clientDemo {

    public static void main(String[] args) throws IOException {


        Socket s = new Socket("192.168.136.1",1102);

        OutputStream os = s.getOutputStream();

        os.write("hello,中国".getBytes());

        s.close();

    }

}
