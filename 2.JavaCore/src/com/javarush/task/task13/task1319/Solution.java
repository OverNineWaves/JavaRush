package com.javarush.task.task13.task1319;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(System.in));
            String adress = bufferedReader.readLine();
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(adress));
            while (true){
                String str = bufferedReader.readLine();
                bufferedWriter.write(str + "\n");
                if (str.equals("exit")){break;}
                //bufferedWriter.newLine();
            }
            bufferedReader.close();
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }
}
