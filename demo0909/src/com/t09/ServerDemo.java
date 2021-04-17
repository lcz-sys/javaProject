package com.t09;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {

    public static void main(String[] args) throws IOException {


        ServerSocket s = new ServerSocket(1102);

        Socket accept = s.accept();

        InputStream is = accept.getInputStream();

        byte[] bys = new byte[1024];
        int len = is.read(bys);

        String dataStr = new String(bys, 0, len);

        System.out.println(dataStr);

        s.close();

        accept.close();


    }


}
