package com.t05;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServeRDemo {


    public static void main(String[] args) throws IOException {

        ServerSocket ss = new ServerSocket(1101);

        while (true){
            Socket s = ss.accept();

            new Thread(new ServerThread(s)).start();
        }

    }

}
