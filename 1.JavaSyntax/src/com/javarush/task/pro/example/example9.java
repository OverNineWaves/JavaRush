package com.javarush.task.pro.example;

import java.time.*;

public class example9 {
    public static void main(String[] args) {
        ZoneId zone = ZoneId.of("Africa/Cairo");
        System.out.println("zone " + zone);
        ZonedDateTime cairoTime = ZonedDateTime.now(zone);
        System.out.println("cairoTime " + cairoTime);
        LocalDate localDate = cairoTime.toLocalDate();
        System.out.println("localDate " + localDate);
        LocalTime localTime = cairoTime.toLocalTime();
        System.out.println("localTime " + localTime);
        LocalDateTime localDateTime = cairoTime.toLocalDateTime();
        System.out.println("localDataTime " + localDateTime);
    }
}
