package com.javarush.task.pro.task05.task0516;

import java.util.Arrays;

/* 
Заполняем массив
*/

public class Solution {

    public static int[] array = new int[20];
    public static int valueStart = 10;
    public static int valueEnd = 13;

    public static void main(String[] args) {
        //напишите тут ваш код

        if (array.length % 2 ==0){
            for (int i = 0; i <= array.length/2 ; i++) {
                Arrays.fill(array, 0, i, valueStart);
                Arrays.fill(array, i+1, array.length, valueEnd);
            }
        }
        else if (array.length % 2 !=0) {
            for (int i = 0; i <= array.length/2; i++) {
                Arrays.fill(array, 0, i+1, valueStart);
                Arrays.fill(array, i+1, array.length, valueEnd);
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
