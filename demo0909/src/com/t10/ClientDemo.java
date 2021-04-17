package com.t10;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientDemo {

    public static void main(String[] args) throws IOException {

        Socket s = new Socket("192.168.136.1", 1101);

        OutputStream os = s.getOutputStream();

        os.write("捏宝最棒".getBytes());

        InputStream is = s.getInputStream();

        byte[] bys = new byte[1024];

        int len = is.read(bys);

        System.out.println(new String(bys, 0, len));

       /* os.close();
        is.close();*/
        s.close();

    }
}
