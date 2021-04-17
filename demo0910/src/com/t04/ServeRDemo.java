package com.t04;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServeRDemo {


    public static void main(String[] args) throws IOException {

        ServerSocket ss = new ServerSocket(1101);

        Socket s = ss.accept();

        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\itcast\\b.txt",true));

        String line;

        while((line=br.readLine())!=null){
//            if("886".equals(line)){
//                break;
//            }
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        BufferedWriter bwServer = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        bwServer.write("文件上传成功");
        bwServer.newLine();
        bwServer.flush();

        bwServer.close();
        bw.close();
        ss.close();
    }

}
