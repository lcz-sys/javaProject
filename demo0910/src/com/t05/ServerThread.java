package com.t05;

import java.io.*;
import java.net.Socket;

public class ServerThread implements Runnable {
    private Socket s;

    ServerThread(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {

        int count = 0;
        File file = new File("D:\\itcast\\b"+count+".txt");
        while (file.exists()){
            count++;
            file = new File("D:\\itcast\\b"+count+".txt");
        }

        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
                BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
                BufferedWriter bwServer = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()))
        ) {
            String line;

            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
                bw.flush();
            }

            bwServer.write("文件上传成功");
            bwServer.newLine();
            bwServer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
