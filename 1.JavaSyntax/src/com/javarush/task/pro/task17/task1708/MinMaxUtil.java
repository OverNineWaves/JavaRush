package com.javarush.task.pro.task17.task1708;

/* 
Минимальное и максимальное
*/

import java.util.Map;

public class MinMaxUtil {
    //напишите тут ваш код
    public static int min(int a, int b){
        return Math.min(a, b);
    }
    public static int min(int b, int a, int c){
        int minOnePart = Math.min(a, b);
        return Math.min(c, minOnePart);
    }
    public static int min(int a, int b, int c, int d){
        int minOnePart = Math.min(a, b);
        int minTwoPart = Math.min(c, d);
        return Math.min(minOnePart, minTwoPart);
    }
    public static int min(int a, int b, int c, int d, int e){
        int minOnePart = Math.min(a, b);
        int minTwoPart = Math.min(c, d);
        int minThree = Math.min(minOnePart, minTwoPart);
        return Math.min(minThree, e);
    }

    public static int max(int a, int b){
        return Math.max(a, b);
    }
    public static int max(int b, int a, int c){
        int minOnePart = Math.max(a, b);
        return Math.max(c, minOnePart);
    }
    public static int max(int a, int b, int c, int d){
        int minOnePart = Math.max(a, b);
        int minTwoPart = Math.max(c, d);
        return Math.max(minOnePart, minTwoPart);
    }
    public static int max(int a, int b, int c, int d, int e){
        int minOnePart = Math.max(a, b);
        int minTwoPart = Math.max(c, d);
        int minThree = Math.max(minOnePart, minTwoPart);
        return Math.max(minThree, e);
    }

}
