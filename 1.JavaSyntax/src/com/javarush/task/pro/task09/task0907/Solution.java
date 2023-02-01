package com.javarush.task.pro.task09.task0907;

import java.util.regex.Pattern;

/* 
Шестнадцатеричный конвертер
*/

public class Solution {
    private static final String HEX = "0123456789abcdef";

    public static void main(String[] args) {
        int decimalNumber = 1256;
        System.out.println("Десятичное число " + decimalNumber + " равно шестнадцатеричному числу " + toHex(decimalNumber));
        String hexNumber = "4e8";
        System.out.println("Шестнадцатеричное число " + hexNumber + " равно десятичному числу " + toDecimal(hexNumber));
    }

    public static String toHex(int decimalNumber) {
        //напишите тут ваш код
        if (decimalNumber <=0) {
            return "";
        }
        else {
            String index = "";

            while (decimalNumber !=0){
                index = HEX.charAt(decimalNumber%16) + index;
                decimalNumber = decimalNumber/16;
            }
            return index;
        }
    }

    public static int toDecimal(String hexNumber) {
        //напишите тут ваш код
        int decimalNumber = 0;
        if ((hexNumber == "")||(hexNumber == null)){
            return 0;
        }
        else {
            //Убедись, что метод toDecimal(String) возвращает 0, если на вход получает пустую строку или null.
            for (int i = 0; i < hexNumber.length(); i++) {
                decimalNumber = 16 * decimalNumber + HEX.indexOf(hexNumber.charAt(i));
            }
            return decimalNumber;
        }
    }
}
