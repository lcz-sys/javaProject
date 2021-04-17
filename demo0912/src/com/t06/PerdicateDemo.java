package com.t06;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PerdicateDemo {

    public static void main(String[] args) {

        String[] strArray = {"zhangsan,30", "lisi,33", "wangwu,3", "zhaoliu,35"};

        ArrayList<String> arrayList = myFilter(strArray, s ->s.split(",")[0].length()>6,
                s->Integer.parseInt(s.split(",")[1])>=30);

        for (String s:arrayList){
            System.out.println(s);
        }


    }

    private static ArrayList<String> myFilter(String[] strArray, Predicate<String> pre1, Predicate<String> pre2) {
        ArrayList<String> list = new ArrayList<>();

        for (String s : strArray) {
            if (pre1.and(pre2).test(s)) {
                list.add(s);
            }
        }

        return list;
    }
}
