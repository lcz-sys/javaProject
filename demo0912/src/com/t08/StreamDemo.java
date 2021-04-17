package com.t08;

import java.util.*;
import java.util.stream.Stream;

public class StreamDemo {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        Stream<String> streamList = list.stream();

        Set<String> set = new HashSet<>();
        Stream<String> streamSet = set.stream();

        Map<String,Integer> map = new HashMap<>();
        Stream<String> keyStream = map.keySet().stream();
        Stream<Integer> valuesStream = map.values().stream();
        Stream<Map.Entry<String, Integer>> entryStream = map.entrySet().stream();

        String[] strs = {"zhangsan","lisi"};
        Stream<String> stringStream = Stream.of(strs);
        Stream<String> stream = Stream.of("1", "2");
        Stream<Integer> integerStream = Stream.of(1, 2, 3);
    }


}
