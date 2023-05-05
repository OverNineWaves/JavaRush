package com.javarush.task.task19.task1910;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/*
Пунктуация
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader buffConcole = new BufferedReader(new InputStreamReader(System.in));
//        Scanner scanner = new Scanner(System.in);
//        String pathRead = scanner.nextLine();
//        String pathWrite = scanner.nextLine();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(buffConcole.readLine()));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(buffConcole.readLine()));
        buffConcole.close();

        String str = null;

        while (bufferedReader.ready()){
            str = bufferedReader.readLine();
            bufferedWriter.write(str.replaceAll("\\p{Punct}" , ""));
        }
        bufferedReader.close();
        bufferedWriter.close();
    }
}
