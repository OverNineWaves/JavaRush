package com.javarush.task.task18.task1809;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Реверс файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileOne = new FileInputStream(reader.readLine());
        FileOutputStream fileTwo = new FileOutputStream(reader.readLine());

        //List<Integer> array = new ArrayList<>();

        byte[] bytes = new byte[fileOne.available()];
        while (fileOne.available() > 0){
            fileOne.read(bytes);
            for (int i = bytes.length -1 ; i >=0; i--) {
                fileTwo.write(bytes[i]);
            }
        }
        fileOne.close();
        fileTwo.close();
    }
}
