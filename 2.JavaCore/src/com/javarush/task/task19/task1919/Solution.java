package com.javarush.task.task19.task1919;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* 
Считаем зарплаты
*/

public class Solution {
    static BufferedReader bufferedReader;

    static Map<String, Double> listArray = new TreeMap<>();
    public static void main(String[] args) {
        try {
            bufferedReader = new BufferedReader(new FileReader(args[0]));
            while (bufferedReader.ready())
            {
            String[] arrayReader = bufferedReader.readLine().split(" ");
            String name = arrayReader[0];
            Double value = Double.parseDouble(arrayReader[1]);
            //listArray.put(arrayReader[0], Double.parseDouble(arrayReader[1]));
                if (listArray.containsKey(name)){
                    listArray.put(name, listArray.get(name).doubleValue() + value);
                }
                else listArray.put(name, value);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (Map.Entry<String, Double> mapka: listArray.entrySet()){
            System.out.println(mapka.getKey() + " " + mapka.getValue());
        }
    }
}
