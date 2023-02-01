package com.javarush.task.pro.example;

import java.time.ZoneId;

public class example8 {
    public static void main(String[] args) {
        for (String zones: ZoneId.getAvailableZoneIds()
             ) {
            System.out.println(zones);
        }
    }
}
