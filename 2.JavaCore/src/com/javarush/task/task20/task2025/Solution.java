package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* 
Алгоритмы-числа
*/

public class Solution {

    public static long[] getNumbers(long N) {
        List<Integer> arrResult = new ArrayList<>();
        for (int i = 1; i <= N; i++) { //перебираем числа от 1 до N включительно
            int lengthNum = String.valueOf(i).length(); //длина числа для степени
            List<Integer> temp = new ArrayList<>(); //массив для разделения числа на составляющие.
            int a = i;

            while (a != 0){
                temp.add(a%10);
                a = a/10;
            }
            //Collections.reverse(temp);
            //разворачиваем массив, опять же не нужно вроде как, но для себя сделал. т.к. всё равно там суммируется число и сравнивается.

            /*for (int j = 0; j <temp.size() ; j++) {
                System.out.print(temp.get(j));
            }*/
            int sum = 0;
            for (int k = 0; k < temp.size(); k++) { //цикл для перебора суммы числа в степени
                int c = (int)Math.pow(temp.get(k), lengthNum); //получает число в степени
                sum = sum + c; //суммируем числа
            }

            if (sum == i){
                arrResult.add(sum);
            }
        }
        long[] result = new long[arrResult.size()]; //нужен ли этот массив вообще? можно вернуть со списочного. но хз оставлю, мож валидатор придерется еще

        for (int i = 0; i < arrResult.size() ; i++) {
            result[i] = arrResult.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000)));
        long b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);

        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000000)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);
    }
}
