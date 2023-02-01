package com.javarush.task.pro.example;

import java.time.*;

public class example5 {
    public static void main(String[] args) {
        ZoneId ru = ZoneId.of("Asia/Shanghai");
        LocalDate today = LocalDate.now(ru);
        System.out.println(today);


        LocalDate date = LocalDate.of(2019, Month.FEBRUARY, 22);
        System.out.println(date);


        LocalDate year = LocalDate.ofEpochDay(1000L);
        System.out.println(year);

        LocalDate dayOne = LocalDate.now();
        Month month = dayOne.getMonth();
        System.out.println(month);
    }

}
