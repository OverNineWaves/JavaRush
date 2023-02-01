package com.javarush.task.pro.task16.task1607;

import java.time.LocalDate;

/* 
Освоение нового API
*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(nowExample());
        System.out.println(ofExample());
        System.out.println(ofYearDayExample());
        System.out.println(ofEpochDayExample());
    }

    static LocalDate nowExample() {
        //напишите тут ваш код
        LocalDate localDate = LocalDate.now();

        return localDate;
    }

    static LocalDate ofExample() {
        //напишите тут ваш код
        LocalDate dayOf = LocalDate.of(2020, 9, 12);

        return dayOf;
    }

    static LocalDate ofYearDayExample() {
        //напишите тут ваш код
        LocalDate ofYear = LocalDate.ofYearDay(2020, 256);

        return ofYear;
    }

    static LocalDate ofEpochDayExample() {
        //напишите тут ваш код
        LocalDate ofEpoch = LocalDate.ofEpochDay(18517);
        return ofEpoch;
    }
}
