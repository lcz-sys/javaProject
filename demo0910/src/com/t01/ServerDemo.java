package com.t01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {

    public static void main(String[] args) throws IOException {


        ServerSocket ss = new ServerSocket(1001);

        Socket s = ss.accept();

        InputStream is = s.getInputStream();

        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        String line;

        while((line=br.readLine())!=null){
            System.out.println(line);
        }

        ss.close();

    }
}
