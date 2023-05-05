package com.javarush.task.task19.task1907;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Считаем слово
*/

public class Solution {
    public static void main(String[] args) throws IOException{

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String readLine = bufferedReader.readLine();
        bufferedReader.close();
        BufferedReader bufferedReaderFile = new BufferedReader(new FileReader(readLine));
        String strRead = bufferedReaderFile.readLine();
        bufferedReaderFile.close();

        int counter = 0;
        //String[] strArray = strRead.split("\\W");
        String[] strArray = strRead.split("[\\p{Space} \\t\\n\\r]");

        for (String world: strArray) {
            if (world.equals("world")){
                counter++;
            }
        }
        System.out.println(counter);
    }
}
