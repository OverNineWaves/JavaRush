package com.javarush.task.task19.task1906;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Четные символы
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        List<Integer> arrayList = new ArrayList<>();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileRead = bufferedReader.readLine();
        String fileWrite = bufferedReader.readLine();

        FileReader fileReader = new FileReader(fileRead);
        FileWriter fileWriter = new FileWriter(fileWrite);

        bufferedReader.close();

        while (fileReader.ready()){
            arrayList.add(fileReader.read());
        }
        fileReader.close();

        for (int i = 1; i < arrayList.size(); i+=2) {
                fileWriter.write(arrayList.get(i));
        }
        fileWriter.close();
    }
}
