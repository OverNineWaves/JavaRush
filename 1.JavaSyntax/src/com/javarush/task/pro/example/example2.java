package com.javarush.task.pro.example;

import java.io.FileInputStream;
import java.io.IOException;

public class example2 {
    public static void main(String[] args) throws IOException {

            FileInputStream fileInputStream = new FileInputStream("/home/overninewaves/text.txt");

            int i;

            while((i=fileInputStream.read())!= -1){

                System.out.print((char)i);
            }
    }
}
