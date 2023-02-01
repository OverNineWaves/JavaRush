package com.javarush.task.task18.task1817;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* 
Пробелы
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        FileInputStream readArguments = new FileInputStream(args[0]);

        List<Integer> list = new ArrayList<>();

        int countAll = 0;
        int countSpace = 0;

        while (readArguments.available() > 0){
            list.add(readArguments.read());
        }

        for (int i = 0; i < list.size(); i++) {
            int unit = list.get(i);
            if (unit == 32){
                countSpace++;
                countAll++;
            }
            else countAll++;
        }
        System.out.println("всё: " + countAll + "\n"  + "чисто пробелы: " + countSpace);
            readArguments.close();
    }
}
