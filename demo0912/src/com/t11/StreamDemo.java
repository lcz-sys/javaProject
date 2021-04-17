package com.t11;

import java.util.ArrayList;

public class StreamDemo {

    public static void main(String[] args) {


        ArrayList<String> list = new ArrayList<>();

        list.add("lufei");
        list.add("suolong");
        list.add("sanzhi");
        list.add("wusuopu");
        list.add("qiaoba");
        list.add("wuya");

//        list.stream().sorted().forEach(System.out::println);

//        list.stream().sorted((s1,s2)->s1.length()-s2.length()).forEach(System.out::println);

        list.stream().sorted((s1,s2)->{
            int num1 = s1.length()-s2.length();
            int num2 = num1 == 0?s1.compareTo(s2):num1;
            return num2;
        }).forEach(System.out::println);
    }
}
