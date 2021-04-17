package com.t08;

public class MyStringDemo {

    public static void main(String[] args) {

        useMyString((s,x,y)-> s.substring(x,y));

        useMyString(String::substring);

    }

    private static void useMyString(MyString ms){
        String s = ms.mySubString("helloworld", 2, 5);
        System.out.println(s);
    }
}
