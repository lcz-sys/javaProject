package com.t03;

import java.util.function.Consumer;

public class ConsumerDemo {

    public static void main(String[] args) {
        operatorString("zhangsan", s -> {
            System.out.println(s);
        });

        operatorString("lisi",System.out::println);

        operatorString("wangwu",s->System.out.println(new StringBuilder(s).reverse().toString()));

        operatorString("zhaoliu",s-> System.out.println(s),s-> System.out.println(new StringBuilder(s).reverse().toString()));

    }
    private static void operatorString(String name, Consumer<String> con1,Consumer<String> con2) {
//        con1.accept(name);
//        con2.accept(name);

        con1.andThen(con2).accept(name);
    }

    private static void operatorString(String name, Consumer<String> con) {
        con.accept(name);
    }
}
