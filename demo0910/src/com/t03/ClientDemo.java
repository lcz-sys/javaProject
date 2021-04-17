package com.t03;

import java.io.*;
import java.net.Socket;

public class ClientDemo {

    public static void main(String[] args) throws IOException {

        Socket s = new Socket("192.168.136.1",1001);

        BufferedReader br = new BufferedReader(new FileReader("D:\\itcast\\a.txt"));

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

        String line;

        while ((line=br.readLine())!=null){
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        br.close();
        s.close();

    }
}
