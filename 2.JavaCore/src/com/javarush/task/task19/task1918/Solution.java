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
            while (bufferedFileReader.ready()){
               stringBuilder.append(bufferedFileReader.readLine());

            }
            bufferedFileReader.close();
            bufferedFileNameReader.close();
        } catch (IOException e){
            e.printStackTrace();
        }

        linesSplit = stringBuilder.substring(stringBuilder.indexOf(openTag + tag)).split("(?=<" + tag + ">)|(?=</" + tag + ">)");

       /* for (int i = 0; i < linesSplit.length; i++) {
            System.out.println(linesSplit[i]);
        }*/
        List<String> lineOut = new ArrayList<>();
        String out = "";
        for (int i = 0; i < linesSplit.length; i++) {
            if (linesSplit[i].startsWith(openTag + tag)){
                countOpenTag++;
               // System.out.println("countOpenTag ++ Количество тагов  <span" + countOpenTag);
                out = out + linesSplit[i];
                //lineOut.add(linesSplit[i]);
                }
            else if (linesSplit[i].startsWith(closeTag)){
                countOpenTag--;
               // System.out.println("countOpenTag -- Количество тагов  <span " + countOpenTag);
                out = out + linesSplit[i];
                //lineOut.add(linesSplit[i]);
                //System.out.println(countOpenTag);
                }

            if (countOpenTag == 0){
                //System.out.println(new ArrayList<>(lineOut));
                //lineOut.remove(0);
                list.add(out);

                //System.out.println(out);
                out= "";
                    }
        }
        for (String result : list) {
            System.out.println(result);
        }
    }
}
