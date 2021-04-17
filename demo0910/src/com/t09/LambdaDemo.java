package com.t09;

public class LambdaDemo {

    public static void main(String[] args) {

        useAddable((x, y) -> {
            return x + y;
        });

    }

    private static void useAddable(Addable a) {
        int sum = a.add(10, 20);
        System.out.println(sum);
    }

    private static void useFlyable(Flyable f){
        f.fly("好好喝");
    }

}
