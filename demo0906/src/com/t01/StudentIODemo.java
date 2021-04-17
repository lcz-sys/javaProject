package com.t01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class StudentIODemo {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new FileReader("D:\\itcast\\names.txt"));

        ArrayList<Student> array = new ArrayList<>();

        String line;

        while ((line = br.readLine()) == null) {
            String[] strArray = line.split(",");

            Student s = new Student();

            s.setSid(strArray[0]);
            s.setName(strArray[1]);
            s.setAge(Integer.parseInt(strArray[2]));
            s.setAddress(strArray[3]);

            array.add(s);
        }

        br.close();

        for (Student s : array) {
            System.out.println(s.getSid() + "," + s.getName() + "," + s.getAge() + "," + s.getAddress());
        }
    }
}
