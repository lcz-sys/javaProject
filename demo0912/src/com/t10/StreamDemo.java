package com.t10;

import java.util.ArrayList;
import java.util.stream.Stream;

public class StreamDemo {

    public static void main(String[] args) {


        ArrayList<String> list = new ArrayList<>();

        list.add("路飞");
        list.add("索隆");
        list.add("山治");
        list.add("乌索普");
        list.add("乔巴");
        list.add("乌鸦");

        Stream<String> stream1 = list.stream().limit(4);
        Stream<String> stream2 = list.stream().skip(2);

//        Stream.concat(stream1,stream2).forEach(System.out::println);
        Stream.concat(stream1,stream2).distinct().forEach(System.out::println);

    }
}
