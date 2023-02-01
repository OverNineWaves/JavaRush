package com.javarush.task.pro.example;

import java.text.SimpleDateFormat;
import java.util.Date;

public class example4 {
    public static void main(String[] args) {
        Date current = new Date(122, 5, 4, 12, 15, 0);
        System.out.println(current);
        SimpleDateFormat date1 = new SimpleDateFormat("YYYY-MMMM");
        String message = date1.format(current);
        System.out.println(message);
    }
}
