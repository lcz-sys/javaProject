package com.t09;

import java.util.ArrayList;

public class StreamDemo {

    public static void main(String[] args) {


        ArrayList<String> list = new ArrayList<>();

        list.add("路飞");
        list.add("索隆");
        list.add("山治");
        list.add("乌索普");
        list.add("乔巴");
        list.add("乌鸦");

        list.stream().skip(3).forEach(System.out::println);

        list.stream().limit(3).forEach(System.out::println);

        list.stream().skip(2).limit(2).forEach(System.out::println);

    }
}
