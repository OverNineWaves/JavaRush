package com.javarush.task.pro.task08.task0804;

/* 
Randomizer
*/

import java.util.Random;

public class Solution {

    public static void main(String[] args) {
        System.out.println(generateNumber());
        Random r = new Random();
        float f = r.nextFloat();
        System.out.println(f);
    }

    public static double generateNumber() {
        //напишите тут ваш код
        return (Math.random()*10.0);
    }
}
