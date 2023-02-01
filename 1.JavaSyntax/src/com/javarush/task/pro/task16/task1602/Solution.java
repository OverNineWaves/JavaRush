package com.javarush.task.pro.task16.task1602;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
Подчищаем хвосты
*/

public class Solution {

    public static void main(String[] args) {
        List<Date> dateList = new ArrayList<>();
        dateList.add(new Date(2015, 12, 25, 20, 40));
        dateList.add(new Date("July 20, 1969"));
        dateList.add(new Date(1989, 11, 9));
        dateList.add(new Date("January 1, 2000"));

        System.out.println("before fixes:");
        dateList.forEach(System.out::println);

        fixDate(dateList);

        System.out.println("after fixes:");
        dateList.forEach(System.out::println);
    }

    static void fixDate(List<Date> brokenDates) {
        //напишите тут ваш код
        Date currentDate = new Date();
        //currentDate.setYear(122);
        //currentDate.setMonth(5);

        for (Date date1 : brokenDates) {
            if (date1.after(currentDate)){
                date1.setYear(date1.getYear()-1900);
                date1.setMonth(date1.getMonth() - 1);
            }
        }
        //System.out.println("currentDate" + currentDate);
        }

}
