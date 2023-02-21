package com.javarush.task.task19.task1926;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/* 
Перевертыши
*/

public class Solution {
    static BufferedReader bufferedReader;
    static BufferedReader bufferedReaderFile;
    //static List<String> list = new ArrayList<>();
    static List<String> listRevesre = new ArrayList<>();

    static StringBuilder sb;

    public static void main(String[] args) {
         try {
             bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             String fileName = bufferedReader.readLine();
             bufferedReader.close();
             bufferedReaderFile = new BufferedReader(new FileReader(fileName));//("/home/overninewaves/javaTestFiles/6.txt"));
             while (bufferedReaderFile.ready()){
                 String str = bufferedReaderFile.readLine();
                 //list.add(bufferedReaderFile.readLine());
                 //listRevesre = new ArrayList<>(reverseList(list));
                 sb = new StringBuilder(str).reverse();
                 //System.out.println(listRevesre);
                 listRevesre.add(sb.toString());
                 //System.out.println(sb);
             }
             bufferedReaderFile.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //System.out.print(listRevesre);

        //System.out.println(listRevesre.size());
        for (int i = 0; i < listRevesre.size(); i++) {
            System.out.println(listRevesre.get(i));
        }

    }
    /*public static List<String> reverseList(List<String> list){
        List<String> listBuffer = new ArrayList<>(list);
        Collections.reverse(listBuffer);
        return listBuffer;
    }*/

}
