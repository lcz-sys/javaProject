package com.t02;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {

    public static void main(String[] args) throws IOException {

        ServerSocket ss = new ServerSocket(1001);

        Socket s = ss.accept();

        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

        BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\itcast\\s.txt"));

        String line;

        while ((line=br.readLine())!=null){
            bw.write(line);

            bw.newLine();
            bw.flush();
        }

        bw.close();

        ss.close();

    }
}
