package com.javarush.task.task19.task1918;

import java.io.*;
import java.util.*;

/* 
Знакомство с тегами
*/

public class Solution {
    private static BufferedReader bufferedFileNameReader;
    private static BufferedReader bufferedFileReader;
    static List<String> list = new ArrayList();

    static Map<Integer, String> teg = new HashMap<>();

    static StringBuilder stringBuilder = new StringBuilder();

    static String[] linesSplit;

    public static void main(String[] args){
        String tag = args[0];
        String openTag = "<";
        String closeTag = "</" + tag + ">";
        int countOpenTag = 0;
        try {
            bufferedFileNameReader = new BufferedReader(new InputStreamReader(System.in));
            File fileNameReader = new File(bufferedFileNameReader.readLine());
            bufferedFileReader = new BufferedReader(new FileReader(String.valueOf(fileNameReader)));
            //String str;
            int str;
            while (bufferedFileReader.ready()){
                str = bufferedFileReader.read();
               stringBuilder.append(str);

            }
        } catch (IOException e){
            e.printStackTrace();
        }

        linesSplit = stringBuilder.substring(stringBuilder.indexOf(openTag + tag)).split("(?= openTag + tag)|| (openTag + tag + ">")");

        for (int i = 0; i <linesSplit.length ; i++) {
            System.out.println(linesSplit[i]);
        }

        /*for (int i = 0; i < list.size(); i++) {
            if (list.get(i).startsWith(openTag + tag)){
                countOpenTag++;
                System.out.println(countOpenTag);
                if (list.get(i).endsWith(closeTag)){
                    countOpenTag--;
                    System.out.println(countOpenTag);
                    if (countOpenTag == 0){
                        System.out.println(list.get(i));
                    }

                }

            }
        }*/
    }
}
