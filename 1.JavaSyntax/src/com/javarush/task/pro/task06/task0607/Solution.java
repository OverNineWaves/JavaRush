package com.javarush.task.pro.task06.task0607;

/* 
Добро пожаловать! Но не всем.
*/

public class Solution {

    public static void main(String[] args) {
        //multiple("123", 10);
        System.out.println(multiple("123",10));
    }

   public static String multiple(String str, int times)
    {
        String result = "";
        for (int i = 0; i < times; i++)
            result = result + " "+ str;
        return result;
    }
}
