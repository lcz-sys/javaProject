package com.t05;

import java.util.function.Predicate;

public class predicateDemo {

    public static void main(String[] args) {

      /*  boolean flag = checkString("hello", s -> s.length() > 8);
        System.out.println(flag);*/

        boolean b1 = checkString("hello", s -> s.length() > 8, s -> s.length() < 15);

        boolean b2 = checkString("hello world", s -> s.length() > 8, s -> s.length() < 15);

        System.out.println(b1);
        System.out.println(b2);

    }

    private static boolean checkString(String s, Predicate<String> pre1, Predicate<String> pre2){
        /*boolean b1 = pre1.test(s);
        boolean b2 = pre2.test(s);
        return b1 && b2;*/

        return pre1.and(pre2).test(s);
    }

    private static boolean checkString(String s, Predicate<String> pre) {
//        return pre.test(s);
        return pre.negate().test(s);
    }
}
