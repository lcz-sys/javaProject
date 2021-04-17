package com.t05;

import java.io.*;
import java.net.Socket;

public class ClientDemo {

    public static void main(String[] args) throws IOException {

        Socket s = new Socket("192.168.136.1",1101);

        BufferedReader br = new BufferedReader(new FileReader("D:\\itcast\\a.txt"));

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

        String line;

        while ((line=br.readLine())!=null){
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

//        bw.write("886");
//        bw.newLine();
//        bw.flush();

        s.shutdownOutput();

        BufferedReader brClient = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String data = brClient.readLine();
        System.out.println(data);

        brClient.close();
        br.close();
        s.close();

    }
}
