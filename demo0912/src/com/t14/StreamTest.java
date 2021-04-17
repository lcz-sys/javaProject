package com.t14;

import java.util.*;
import java.util.stream.Collectors;

public class StreamTest {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();

        list.add("zhangsan");
        list.add("lisi");

        List<String> collectlist = list.stream().collect(Collectors.toList());

        Set<Integer> set = new HashSet<>();

        set.add(10);
        set.add(20);
        set.add(30);

        Set<Integer> set1 = set.stream().collect(Collectors.toSet());


        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("zhangsan,30");
        arrayList.add("lisi,350");

        Map<String, String> collect = arrayList.stream().collect(Collectors.toMap(s -> s.split(",")[0], s -> s.split(",")[1]));

        Set<String> keySet = collect.keySet();

        for (String s:keySet){
            String s1 = collect.get(s);
            System.out.println(s+","+s1);
        }

    }
}
