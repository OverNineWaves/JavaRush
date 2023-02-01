package com.javarush.task.pro.task13.task1320;

public class Solution {

    public static void main(String[] args) {
        System.out.println(getMonthByIndex(4));
        System.out.println(getMonthByIndex(8));
        System.out.println(getMonthByIndex(12));
    }

    public static String getMonthByIndex(int monthIndex) {
        String MonthString;
        switch(monthIndex)
        {
            case 1:
                MonthString = "Январь";
                break;
            case 2:
                MonthString= "Февраль";
                break;
            case 3:
                MonthString = "Март";
                break;
            case 4:
                MonthString = "Апрель";
                break;
            case 5:
                MonthString = "Май";
                break;
            case 6:
                MonthString = "Июнь";
                break;
            case 7:
                MonthString = "Июль";
                break;
            case 8:
                MonthString = "Август";
                break;
            case 9:
                MonthString = "Сентябрь";
                break;
            case 10:
                MonthString = "Октябрь";
                break;
            case 11:
                MonthString = "Ноябрь";
                break;
            case 12:
                MonthString = "Декабрь";
                break;
            default:
                MonthString = "Недействительный месяц";
        }
            return MonthString;
    }
}
