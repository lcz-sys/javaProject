package com.t10;

public class LambdaDemo {

    public static void main(String[] args) {

        useInter(()->{
            System.out.println("ssdassdas");
        });

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("匿名内部类");
//            }
//        }).start();

        Runnable runnable = ()-> System.out.println("Lambda");

        new Thread(runnable).start();

    }

    private static void useInter(Inter i){

        i.show();
    }
}
