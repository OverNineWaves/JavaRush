package com.javarush.task.pro.task12.task1222;

import java.util.ArrayList;
import java.util.Arrays;

/* 
Выводим в консоли разные типы
*/

public class Solution {

    public static void main(String[] args) {

        int[] i = {1,2,3,4,5};

        for (int j = 0; j < i.length; j++) {
            printArray(j);

            //System.out.println(j);
        }
       //ошибка, не компилируется!
    }

    public static void printArray(Integer arr) {
        System.out.println(arr);
    }
}
