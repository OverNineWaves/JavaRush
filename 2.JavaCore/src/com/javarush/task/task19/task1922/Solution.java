package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();
    static BufferedReader bufferedFileNameReader;
    static BufferedReader bufferedFileReader;
    static String fileName;

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) {
        bufferedFileNameReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            fileName = bufferedFileNameReader.readLine();
            bufferedFileNameReader.close();
            bufferedFileReader = new BufferedReader(new FileReader(fileName));

            while (bufferedFileReader.ready()){
                String strLine = bufferedFileReader.readLine();
                String[] strLineArray = strLine.split(" ");
                int count = 0;
                for (int i = 0; i < words.size() ; i++) {
                    for (int j = 0; j < strLineArray.length; j++) {
                        if (words.get(i).equals(strLineArray[j])){
                            count++;}
                    }
                }
                if (count == 2){
                    System.out.println(strLine);
                }
            }
            bufferedFileReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
