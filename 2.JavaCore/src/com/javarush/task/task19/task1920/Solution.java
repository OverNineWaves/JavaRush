package com.javarush.task.task19.task1920;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* 
Самый богатый
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
        Double maxValue = Collections.max(listArray.values());
        for (String name : listArray.keySet() ) {
            if (listArray.get(name).equals(maxValue)){
                System.out.println(name);
            }
        }
    }
}
