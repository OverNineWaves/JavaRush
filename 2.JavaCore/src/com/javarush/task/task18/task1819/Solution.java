package com.javarush.task.task18.task1819;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
Объединение файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException{

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileOnePath = bufferedReader.readLine();

        FileReader fileOneReader = new FileReader(fileOnePath);
        FileReader fileTwoReader = new FileReader(bufferedReader.readLine());

        copyToOne copyToOne = new copyToOne();
        copyToOne.readFileOne(fileOneReader);
        copyToOne.readFileTwo(fileTwoReader);

        copyToOne.unityTwo();
        copyToOne.unityOne();

        FileWriter fileOneWriter = new FileWriter(fileOnePath);
        copyToOne.unityAll(fileOneWriter);

        bufferedReader.close();
        fileOneWriter.close();
        fileOneReader.close();
        fileTwoReader.close();
    }
}

class copyToOne{
    List<Integer> listFileTwo = new ArrayList<>();
    List<Integer> listFileOne = new ArrayList<>();
    List<Integer> listAll = new ArrayList<>();
    public void readFileOne(FileReader fileOneReader){
        try{
            while (fileOneReader.ready()){
                int some = fileOneReader.read();
                listFileOne.add(some);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void readFileTwo(FileReader fileTwoReader){
        try{
            while (fileTwoReader.ready()){
                int readFileTwo = fileTwoReader.read();
                listFileTwo.add(readFileTwo);
            }
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    public void unityOne(){
        for (int i = 0; i < listFileOne.size(); i++) {
            listAll.add(listFileOne.get(i));
        }
    }
    public void unityTwo(){
        for (int i = 0; i < listFileTwo.size(); i++) {
            listAll.add(listFileTwo.get(i));
        }
    }
    public void unityAll(FileWriter fileOneWriter){
        for (int i = 0; i < listAll.size(); i++) {
            int someArray = listAll.get(i);
            try {
                fileOneWriter.write(someArray);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
