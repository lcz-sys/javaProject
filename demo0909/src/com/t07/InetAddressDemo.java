package com.t07;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {

    public static void main(String[] args) throws UnknownHostException {


        InetAddress address = InetAddress.getByName("192.168.136.1");

        String hostName = address.getHostName();

        String ip = address.getHostAddress();

        System.out.println(address);
        System.out.println(hostName);
        System.out.println(ip);

    }
}
