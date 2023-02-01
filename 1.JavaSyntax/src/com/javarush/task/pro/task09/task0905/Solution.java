package com.javarush.task.pro.task09.task0905;

import java.util.regex.Pattern;

/* 
Восьмеричный конвертер
*/

public class Solution {
    public static void main(String[] args) {
        int decimalNumber = 21;
        System.out.println("Десятичное число " + decimalNumber + " равно восьмеричному числу " + toOctal(decimalNumber));
        int octalNumber = 25;
        System.out.println("Восьмеричное число " + octalNumber + " равно десятичному числу " + toDecimal(octalNumber));
    }

    public static int toOctal(int decimalNumber) {
        //напишите тут ваш код
        int i = 0;
        int v = 0;
        if (decimalNumber > 0) {
            while (decimalNumber != 0) {
                int d = decimalNumber % 8;
                v = (int) (v + d * (Math.pow(10, i)));
                decimalNumber = decimalNumber / 8;
                i++;
            }
            return v;
        }
        else return 0;
    }

    public static int toDecimal(int octalNumber) {
        //напишите тут ваш код
        int i = 0;
        int decimalNumber = 0;
if (octalNumber > 0) {
    while (octalNumber != 0) {
        int ost = octalNumber % 10;//5
        decimalNumber = (int) (decimalNumber + ost * Math.pow(8, i));//00
        octalNumber = octalNumber / 10;
        i++;
    }
    return decimalNumber;
}
else return 0;
    }
}
