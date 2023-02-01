package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader file_Name_Reader = new BufferedReader(new InputStreamReader(System.in));
        String file_Name = file_Name_Reader.readLine();

        FileInputStream file_Reader = new FileInputStream(file_Name);
        int min_byte = 120;
        while (file_Reader.available() > 0) {
            int read = file_Reader.read();

            if (read < min_byte){
                min_byte = read;

            }
        }
        file_Name_Reader.close();
        file_Reader.close();
        System.out.println(min_byte);
    }
}
