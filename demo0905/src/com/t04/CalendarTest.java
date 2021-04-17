package com.t04;

import java.util.Calendar;
import java.util.Scanner;

public class CalendarTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("请输入年份:");

        int year = sc.nextInt();

        Calendar instance = Calendar.getInstance();

        instance.set(year,2,1);

        instance.add(Calendar.DATE,-1);

        int date = instance.get(Calendar.DATE);

        System.out.println(date);
    }
}
