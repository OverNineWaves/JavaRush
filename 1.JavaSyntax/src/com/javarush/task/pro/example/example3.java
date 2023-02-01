package com.javarush.task.pro.example;

import java.io.InputStream;
import java.net.URL;

public class example3 {
    public static void main(String[] args) throws Exception{
        URL url = new URL("https://javarush.ru");
        InputStream input = url.openStream();
        byte[] buffer = input.readAllBytes();
        String str = new String(buffer);
        System.out.println(str);
    }
}
