package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одинадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) {
        try {
            BufferedReader buffFileName = new BufferedReader(new InputStreamReader(System.in));
            String filename = buffFileName.readLine();
            buffFileName.close();
            //BufferedReader buffFileStrLine = new BufferedReader(new FileReader("/home/overninewaves/javaTestFiles/5.txt"));
            BufferedReader buffFileStrLine = new BufferedReader(new FileReader(filename));
            while (buffFileStrLine.ready()){
                String fileLine = buffFileStrLine.readLine();
                for (Map.Entry<Integer, String> mapka : map.entrySet()) { //переборка мапки
                    fileLine = fileLine.replaceAll("\\b" + mapka.getKey() + "\\b", mapka.getValue()); //экранируем спец символ регулярки который ищет по совпадению с начала или с конца.
                    // указали на совпадение по ключу с начала и с конца. и меняем его на значение из мапки
                }
                System.out.println(fileLine);}
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
