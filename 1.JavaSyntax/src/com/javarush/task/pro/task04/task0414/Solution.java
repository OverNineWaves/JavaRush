package com.javarush.task.pro.task04.task0414;

import java.util.Scanner;

/* 
Хорошего не бывает много
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        int num = scan.nextInt();
        do {
            System.out.println(str);
            num--;
        }
        while (num > 0 && num < 4);
    }
}