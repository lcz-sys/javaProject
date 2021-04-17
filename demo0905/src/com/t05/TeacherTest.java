package com.t05;

import java.util.Scanner;

public class TeacherTest {
    public static void main(String[] args) {
        Scanner ssc = new Scanner(System.in);

        System.out.println("请输入分数:");
        int i = ssc.nextInt();

        Teacher teacher = new Teacher();

        try {
            teacher.checkScore(i);
        } catch (ScoreException e) {
            e.printStackTrace();
        }

    }
}
