package com.t09;

public class StudentDemo {

    public static void main(String[] args) {


        useStudentBuilder((s, i) -> {
            return new Student(s, i);
        });

        useStudentBuilder(((name, age) -> new Student(name,age)));

        useStudentBuilder(Student::new);
    }

    private static void useStudentBuilder(StudentBuilder sb) {
        Student s = sb.build("zhangsan", 20);
        System.out.println(s);

    }
}
