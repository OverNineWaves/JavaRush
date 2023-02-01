package com.javarush.task.pro.task04.task0403;

import java.util.Scanner;

/* 
Суммирование
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int sum = 0;
        boolean a = true;
        while (a){
            //String s = scan.nextLine();
            if (scan.hasNextInt()){
                int num = scan.nextInt();
                sum+=num;
                //System.out.println(sum);
            }
            else if (!scan.nextLine().equals("e")) {
                System.out.println(sum);
                a = false;
            }
        }
    }
}