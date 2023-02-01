package com.javarush.task.pro.task05.task0511;

import java.util.Scanner;

/* 
Создаем двумерный массив
*/

public class Solution {
    public static int[][] multiArray;

    public static void main(String[] args) {
        //напишите тут ваш код
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        multiArray = new int[N][];

        for (int i = 0; i < N; i++) {
            int n = scan.nextInt();
            multiArray[i] = new int[n];
            for (int j = 0; j < multiArray[i].length ; j++) {
                //multiArray[i][j]= i + j;
                System.out.print(multiArray[i][j] + " ");
            }
            System.out.println(" ");
        }
    }
}
