package com.javarush.task.task18.task1808;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Разделение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream inputFileOne = new FileInputStream(bufferedReader.readLine());
        FileOutputStream outputFileTwo = new FileOutputStream(bufferedReader.readLine());
        FileOutputStream outputFileThree = new FileOutputStream(bufferedReader.readLine());
        bufferedReader.close();

        byte[] buffer = new byte[inputFileOne.available()];
        while (inputFileOne.available() > 0){
            int count = inputFileOne.read(buffer);

            if (count % 2 == 0){
                outputFileTwo.write(buffer, 0, count/2);
                outputFileThree.write(buffer, count/2, count/2);
            }
            else  {
                outputFileTwo.write(buffer, 0, count/2 + 1);
                outputFileThree.write(buffer, count/2 + 1, count/2);
            }


        }

        inputFileOne.close();
        outputFileTwo.close();
        outputFileThree.close();
    }
}
