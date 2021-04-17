package com.t04;

import java.util.function.Consumer;

public class ConsumerDemo {

    public static void main(String[] args) {

        String[] array = {"zhangsan,25","lisi,250","wangwu,3"};

        operatorString(array,s->{
            String name = s.split(",")[0];
            System.out.print("姓名："+name);
        },s->{
            int age = Integer.parseInt(s.split(",")[1]);
            System.out.println("，年龄："+age);
        });

    }

    private static void operatorString(String[] strArray, Consumer<String> con1, Consumer<String> con2){
        for(String s:strArray){
            con1.andThen(con2).accept(s);
        }
    }
}
