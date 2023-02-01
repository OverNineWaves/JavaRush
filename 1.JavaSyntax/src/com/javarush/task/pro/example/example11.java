package com.javarush.task.pro.example;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class example11 {
    public static void main(String[] args) {
        String[] strings = {"java", "kava", "baja"};

     /*   Iterator<String> iterator =
        (iterator.hasNext()){
            String s = iterator.next();
            System.out.println(s);
        }
*/

        Integer[] arr={1,2,3};
        List<Integer> arrAsList = Arrays.asList(arr);
        Iterator<Integer> iter = arrAsList.iterator();

        while(iter.hasNext()){
            int s = iter.next();
            System.out.print(" " + s);
        }

    }
}
