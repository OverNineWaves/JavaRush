package com.javarush.task.pro.task15.task1504;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/* 
Перепутанные байты
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        //напишите тут ваш код
        Scanner scan = new Scanner(System.in);
        //String fromTxt = scan.nextLine();
        Scanner scan2 = new Scanner(System.in);
        //String toTxt = scan2.nextLine();
        try (InputStream src = Files.newInputStream(Paths.get(scan.nextLine()));
           OutputStream out = Files.newOutputStream(Paths.get(scan2.nextLine()))){
       {
           byte[] buffer = src.readAllBytes();
           byte temp;
           for (int i = 0; i < buffer.length - 1; ) {
                temp = buffer[i];
                buffer[i] = buffer[i + 1];
                buffer[i + 1] = temp;
                i +=2;
           }
           out.write(buffer);
           src.close();
           out.close();
       }
    }
}}

