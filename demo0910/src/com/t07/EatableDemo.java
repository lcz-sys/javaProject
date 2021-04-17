package com.t07;

public class EatableDemo {

    public static void main(String[] args) {

        EatableImpl e = new EatableImpl();
        useEatable(e);

        useEatable(new Eatable() {
            @Override
            public void eat() {
                System.out.println("哈哈2");
            }
        });

        useEatable(()->{
            System.out.println("哈哈3");
        });

    }

    private static void useEatable(Eatable e){
        e.eat();
    }
}
