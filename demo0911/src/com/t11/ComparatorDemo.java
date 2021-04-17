package com.t11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class ComparatorDemo {

    public static void main(String[] args) {

        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("cc");
        arrayList.add("c1");
        arrayList.add("c2");

        System.out.println(arrayList);

//        Collections.sort(arrayList);
        Collections.sort(arrayList,getComparator());

        System.out.println(arrayList);

    }

    private static Comparator<String> getComparator(){
      /*  Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        };

        return comp;*/

     /* return new Comparator<String>() {
          @Override
          public int compare(String o1, String o2) {
              return o1.length()-o2.length();
          }
      };*/

     return (s1,s2) -> s1.length() - s2.length();
    }
}
