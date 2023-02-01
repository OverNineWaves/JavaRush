package com.javarush.task.pro.task05.task0505;

import java.util.Scanner;

/* 
Reverse
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] NR = new int[N];
        if (N > 0){
            for (int i = 0; i <NR.length ; i++) {
                int M = scan.nextInt();
                NR[i] = M;
            }
        }
            if (N%2 !=0){

                    for (int j = 0; j < NR.length; j++) {
                        System.out.println(NR[j]);
                }
            }
           else
            {
                for (int j = NR.length-1; j >= 0; j--) {
                    System.out.println(NR[j]);
               }
        }
       /* for (int i = 0; i < NR.length; i++) {
            System.out.println(NR[i]);
        }*/
    }
}
