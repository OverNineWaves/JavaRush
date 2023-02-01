package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Выделяем числа
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String pathRead = scanner.nextLine();
        String pathWrite = scanner.nextLine();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(pathRead));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathWrite));

        String[] str = null;
        while (bufferedReader.ready()){
            str = bufferedReader.readLine().split(" ");
        }
        bufferedReader.close();
        for (int i = 0; i < str.length; i++) {
            if (str[i].matches("\\d*")){
               // System.out.println(str[i]);
                bufferedWriter.write(str[i]+ " ");
            }
        }
        bufferedWriter.close();
    }
}
