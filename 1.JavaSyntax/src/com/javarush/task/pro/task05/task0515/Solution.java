package com.javarush.task.pro.task05.task0515;

import java.util.Arrays;

/* 
Сравнение двумерных массивов
*/

public class Solution {


    public static void main(String[] args) {
        int[] x = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Arrays.fill(x, 3, 4, 999);


        String str = Arrays.toString(x);
        System.out.println(str);
    }
}
