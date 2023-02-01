package com.javarush.task.pro.task04.task0406;

import java.util.Scanner;

/* 
Показываем, что получаем
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Scanner scan = new Scanner(System.in);
        while (true){
            String a = scan.nextLine();
            if (a.equals("enough")){
                break;
            }
            else  System.out.println(a);

        }
    }
}