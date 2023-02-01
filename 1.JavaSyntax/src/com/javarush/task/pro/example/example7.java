package com.javarush.task.pro.example;

import java.time.Instant;

public class example7 {
    public static void main(String[] args) {
        Instant instant = Instant.now();
        System.out.println(instant);

        Instant mil = Instant.ofEpochMilli(50000000L);
        System.out.println(mil);

        System.out.println(instant.getEpochSecond() + " " + instant.getNano() + " " + instant.toEpochMilli());
    }
}
