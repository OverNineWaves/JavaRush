package com.javarush.task.task19.task1925;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
Длинные слова
*/

public class Solution {
    static BufferedReader reader;
    static BufferedWriter writer;
    static List<String> listArray = new ArrayList<>();
    public static void main(String[] args) {
        try {
            reader = new BufferedReader(new FileReader(args[0]));

            writer = new BufferedWriter(new FileWriter(args[1]));
            while (reader.ready()){
                String str = reader.readLine();
                String[] arr = str.split(" ");
                for (int i = 0; i < arr.length; i++) {
                    listArray.add(arr[i]);
                }
            }
            reader.close();
            String zpt = "";
            for (int i = 0; i < listArray.size(); i++) {
                if (listArray.get(i).length() > 6) {
                    writer.write(zpt);
                    writer.write(listArray.get(i));
                    zpt = ",";
                }
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
