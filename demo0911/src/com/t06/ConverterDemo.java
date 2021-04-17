package com.t06;

import com.t02.Inter;

public class ConverterDemo {

    public static void main(String[] args) {

        useConverter((String s)->{
            return Integer.parseInt(s);
        });

        useConverter(s->Integer.parseInt(s));

        useConverter(Integer::parseInt);

    }

    private static void useConverter(Converter c){

        int number = c.convert("666");

        System.out.println(number);
    }
}
