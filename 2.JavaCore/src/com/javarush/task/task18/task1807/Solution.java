package com.javarush.task.task18.task1807;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Подсчет запятых
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        List<Integer> array = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //String s = bufferedReader.readLine();
        FileInputStream fileInputStream = new FileInputStream(bufferedReader.readLine());

        //System.out.println(bufferedReader.readLine());
        while (fileInputStream.available() > 0){
            array.add(fileInputStream.read());
        }
        int count = 0;
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).equals(44)){
                count++;
            }
        }
        fileInputStream.close();
        bufferedReader.close();
        System.out.println(count);
    }
}
