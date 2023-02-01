package com.javarush.task.pro.example;

import org.w3c.dom.ls.LSOutput;

import java.io.*;

public class example1 {
    public static void main(String[] args) {
        StringWriter writer = new StringWriter();
        writer.write("Hello");
        writer.write(String.valueOf(123));

        String result = writer.toString();
        System.out.println(result);
    }


}
