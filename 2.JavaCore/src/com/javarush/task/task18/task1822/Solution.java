package com.javarush.task.task18.task1822;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* 
Поиск данных внутри файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(bufferedReader.readLine()));
        bufferedReader.close();
        //HashMap<Integer, String> mapStr = new HashMap<>();
        List <String> stringList = new ArrayList<>();
        while(fileReader.ready()){
        String str = fileReader.readLine();
        if (str.startsWith(args[0] + " ")){
            stringList.add(str);
        }}
        fileReader.close();

        for (int i = 0; i <stringList.size() ; i++) {
            System.out.print(stringList.get(i));
        }
        /*if (args[0] !=null){
            String str = fileReader.readLine();
            while (fileReader.ready()){

            }
        }*/
    }
}
