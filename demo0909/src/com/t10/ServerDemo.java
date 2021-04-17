package com.t10;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {

    public static void main(String[] args) throws IOException {

        ServerSocket ss = new ServerSocket(1101);

        Socket s = ss.accept();

        InputStream is = s.getInputStream();

        byte[] bys = new byte[1024];

        int len=is.read(bys);

        System.out.println(new String(bys,0,len));

        OutputStream os = s.getOutputStream();

        os.write("数据已经收到".getBytes());

        s.close();
        ss.close();

    }
}
