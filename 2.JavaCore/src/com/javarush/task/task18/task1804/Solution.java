package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Map<Integer, Integer> bytes = new HashMap<>();
        List<Integer> bytesArray = new ArrayList<>();

        BufferedReader file_Name_Reader = new BufferedReader(new InputStreamReader(System.in));
        String file_Name = file_Name_Reader.readLine();
        FileInputStream file_Reader = new FileInputStream(file_Name);

        while (file_Reader.available() > 0) {
            int byte_read = file_Reader.read();
            bytesArray.add(byte_read);
        }
        file_Name_Reader.close();
        file_Reader.close();

        int value = 0;
        int key = 0;


        for (int i = 0; i < bytesArray.size(); i++) {
            for (int j = 0; j < bytesArray.size(); j++) {
                if (bytesArray.get(i).equals(bytesArray.get(j))){
                    value++;
                    key = bytesArray.get(i);
                }
                if (j == bytesArray.size()-1 && value >= 1){
                    bytes.put(key,value);
                    value = 0;
                    key = 0;

                }
            }
        }
        int min_Count = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry: bytes.entrySet()){
            Integer i = entry.getValue();
            if (i < min_Count){
                min_Count = i;
            }
        }
        for (Map.Entry<Integer, Integer> entry: bytes.entrySet()){
            if (entry.getValue().equals(min_Count)){
                System.out.print(entry.getKey() + " ");
            }
        }
    }
}
