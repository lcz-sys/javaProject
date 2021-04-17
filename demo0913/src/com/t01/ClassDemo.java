package com.t01;

public class ClassDemo {


    public static void main(String[] args) {

        /*for (int i = 0; i < 5; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }

            System.out.println();
        }*/

        ClassLoader c = ClassLoader.getSystemClassLoader();
        System.out.println(c);

        ClassLoader c2 = c.getParent();
        System.out.println(c2);

        ClassLoader c3 = c2.getParent();
        System.out.println(c3);

    }
}
