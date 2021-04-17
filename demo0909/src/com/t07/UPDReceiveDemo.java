package com.t07;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UPDReceiveDemo {

    public static void main(String[] args) throws IOException {


        DatagramSocket ds = new DatagramSocket(10086);

        //创建一个数据包
        byte[] bys = new byte[1024];

        DatagramPacket p = new DatagramPacket(bys,bys.length);

        ds.receive(p);

        byte[] data = p.getData();

        int len = p.getLength();

        String dataStr = new String(data,0,len);

        System.out.println(dataStr);

        ds.close();

    }
}
