package com.t04;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;

public class TestCheck {

    public static void main(String[] args) throws IOException {

        Calculator c = new Calculator();

        Class<? extends Calculator> cls = (Class<? extends Calculator>) c.getClass();

        Method[] methods = cls.getDeclaredMethods();

        BufferedWriter bw = new BufferedWriter(new FileWriter("src\\com\\t04\\bug.txt",true));

        int number = 0;

        for(Method m:methods){
            if(m.isAnnotationPresent(Check.class)){
                try {
                    m.invoke(c);
                } catch (Exception e) {

                    number++;

                    bw.write("异常的方法:"+m.getName());
                    bw.newLine();
                    bw.write("异常的名称:"+e.getCause().getClass().getName());
                    bw.newLine();
                    bw.write("异常的原因:"+e.getCause().getMessage());
                    bw.newLine();
                    bw.write("--------------------------------");
                    bw.newLine();
                }
            }
        }

        bw.flush();
        bw.close();

        System.out.println("本次运行出现"+number+"次异常");

    }
}
