package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        List<Integer> bytesArray = new ArrayList<>();
        List<Integer> sortArray = new ArrayList<>();
        BufferedReader file_Name_Reader = new BufferedReader(new InputStreamReader(System.in));
        String file_Name = file_Name_Reader.readLine();
        FileInputStream file_Reader = new FileInputStream(file_Name);

        Map<Integer, Integer> bytes = new HashMap<>();
        while (file_Reader.available() > 0) {
            int byte_read = file_Reader.read();
            bytesArray.add(byte_read);
        }
        file_Name_Reader.close();
        file_Reader.close();

        for (int i = 0; i < bytesArray.size(); i++) {
            bytes.put(bytesArray.get(i), i);
        }

        for (Map.Entry<Integer, Integer>  entry: bytes.entrySet()) {
                sortArray.add(entry.getKey());
        }
        Collections.sort(sortArray);
        //System.out.println(sortArray);

        for (int i:sortArray) {
            System.out.print(i + " ");
        }

        //Collections.addAll(bytesArray);
        //bytesArray.stream().distinct().sorted().forEach(s->System.out.print(s+" "));
    }
}
