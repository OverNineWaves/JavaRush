package com.javarush.task.pro.task04.task0417;

import java.util.Scanner;

/* 
Скорость ветра
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();

        System.out.println(Math.round(a*3.6));

    }
}