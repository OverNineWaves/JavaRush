package com.javarush.task.pro.task08.task0809;

/* 
Counter

*/
public class Solution {

    public static void main(String[] args) throws InterruptedException {
        printNumbers();
    }

    public static void printNumbers() throws InterruptedException {
        //напишите тут ваш код+
        //int count=0;
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
            if (i < 10) {
                Thread.sleep(1, 300_00);
               // count++;
               // System.out.println(count + " count");
            }
        }
    }
}
