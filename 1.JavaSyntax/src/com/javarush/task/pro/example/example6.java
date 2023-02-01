package com.javarush.task.pro.example;

import java.time.LocalTime;

public class example6 {
    public static void main(String[] args) {
        LocalTime time = LocalTime.now();
        System.out.println("s4a vrimya = " + time);



        System.out.println(time.getNano() + " - это нано че то, а вот часы - " + time.getHour());
    }
}
