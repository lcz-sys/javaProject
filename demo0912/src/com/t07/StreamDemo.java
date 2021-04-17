package com.t07;

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

        ArrayList<String> wuList = new ArrayList<>();

        for (String s:list){
            if(s.startsWith("乌")){
                wuList.add(s);
            }
        }

        ArrayList<String> threeList = new ArrayList<>();

        for(String s:wuList){
            if(s.length()==3){
                threeList.add(s);
            }
        }

        for (String s:threeList){
            System.out.println(s);
        }

//        list.stream().filter(s->s.startsWith("乌")).filter(s->s.length()==3).forEach(s-> System.out.println(s));
        list.stream().filter(s->s.startsWith("乌")).filter(s->s.length()==3).forEach(System.out::println);

    }

}
