package com.t01;

import java.util.Comparator;
import java.util.TreeSet;

public class TresSetToFileDemo {

    public static void main(String[] args) {


        TreeSet<Student> ts = new TreeSet<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {

                int num = o1.getSum() - o2.getSum();

                int num1 = num == 0 ? o1.getChinese() - o2.getChinese() : num;
                int num2 = num1 == 0 ? o1.getMath() - o2.getMath() : num1;
                int num3 = num2 == 0 ? o1.getName().compareTo(o2.getName())  : num2;

                return num3;
            }
        });
    }
}
