package com.t07;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPSendDemo {

    public static void main(String[] args) throws IOException {

        DatagramSocket ds = new DatagramSocket();

       byte[] bys = "你好".getBytes();

        /*int len = bys.length;

        InetAddress address = InetAddress.getByName("192.168.136.1");

        int port = 10086;*/



        DatagramPacket p = new DatagramPacket(bys,bys.length,InetAddress.getByName("192.168.136.1"),10086);

        ds.send(p);

        ds.close();
    }
}
