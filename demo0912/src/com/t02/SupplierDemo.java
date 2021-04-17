package com.t02;

import java.util.function.Supplier;

public class SupplierDemo {

    public static void main(String[] args) {

        int[] arr = {11,23,85,4,6,75};

        int result = getMax(()->{
            int max = arr[0];
            for(int i=1;i<arr.length;i++){
                if(arr[i]>max){
                    max = arr[i];
                }
            }

            return max;
        });

        System.out.println(result);

    }

    private static int getMax(Supplier<Integer> sup){

        return sup.get();
    }
}
