package com.javarush.task.task19.task1923;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
Слова с цифрами
*/

public class Solution {
    static BufferedReader bufferedFileReader;
    static BufferedWriter bufferedFileWriter;
    static List<String> listReadBuffer = new ArrayList<>();
    public static void main(String[] args) {
        try {
            bufferedFileReader = new BufferedReader(new FileReader(args[0]));
            bufferedFileWriter = new BufferedWriter(new FileWriter(args[1]));
            addToList(bufferedFileReader);
            bufferedFileReader.close();
            writeCharDigi(listReadBuffer, bufferedFileWriter);
            bufferedFileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static void addToList(BufferedReader fileReader){
        try{
            while (fileReader.ready()){
                String[] str = fileReader.readLine().split(" ");
                for (int i = 0; i < str.length; i++) {
                    listReadBuffer.add(str[i]);
                }
            }}
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    static void writeCharDigi(List<String> array , BufferedWriter bufferedWriter){
        /*for (int i = 0; i < array.size(); i++) {
            //System.out.println(array.get(i));
            if (array.get(i).matches(".*\\d.*")){
                try {
                    bufferedWriter.write(array.get(i) + " ");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            }*/
        for(String list :array){
            if (list.matches(".*\\d.*")){
                try {
                    bufferedWriter.write(list + " ");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
