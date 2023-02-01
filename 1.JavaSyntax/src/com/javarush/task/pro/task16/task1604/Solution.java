package com.javarush.task.pro.task16.task1604;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/* 
День недели рождения твоего
*/

public class Solution {

    static Calendar birthDate = new GregorianCalendar (1990, Calendar.OCTOBER, 27);

    public static void main(String[] args) {
        System.out.println(getDayOfWeek(birthDate));
    }

    static String getDayOfWeek(Calendar calendar) {
        //напишите тут ваш код
        Locale locale = new Locale("ru");
        Date calendare = calendar.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE",locale);
        String dayOfWeek = simpleDateFormat.format(calendare);
        return dayOfWeek;
    }
}
