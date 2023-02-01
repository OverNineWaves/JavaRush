package com.javarush.task.pro.task03.task0306;

import java.util.Scanner;

/* 
Треугольник
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        int age = 35;
        boolean isYoung = (age < 18);
        boolean isOld = (age > 65);
        if (!isYoung && !isOld)
            System.out.println(isYoung + " " + isOld);
            System.out.println("Вы можете работать");
    }
}
