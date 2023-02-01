package com.javarush.task.pro.task04.task0408;

import java.util.Scanner;

/* 
Максимум из введенных чисел
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Scanner scan = new Scanner(System.in);
        int max = Integer.MIN_VALUE;
        while (scan.hasNextInt()){
            int num = scan.nextInt();
            if (num%2 == 0){
                if (num>max){
                    max = num;
            }
            }
        }
        System.out.println(max);
    }
}