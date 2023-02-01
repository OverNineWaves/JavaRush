package com.javarush.task.pro.task16.task1601;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* 
Лишь бы не в понедельник :)
*/

public class Solution {

    static Date birthDate = new Date(1990, 10, 27);

    public static void main(String[] args) {
        System.out.println(getDayOfWeek(birthDate));
    }

    static String getDayOfWeek(Date date) {
        Locale locale = new Locale("ru");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE", locale);
        String day = simpleDateFormat.format(date);
        return day;
    }
}
