package com.t02;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectOutputStreamDemo {

    public static void main(String[] args) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src\\com\\t02\\oos.txt"));


        Student s = new Student("哈哈",300);

        oos.writeObject(s);

        oos.close();

    }
}
