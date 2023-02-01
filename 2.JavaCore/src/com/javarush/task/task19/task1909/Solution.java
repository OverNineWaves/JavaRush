package com.javarush.task.task19.task1909;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Замена знаков
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        String pathRead = scanner.nextLine();
        String pathWrite = scanner.nextLine();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(pathRead));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathWrite));
        String str;
       /* while (bufferedReader.ready()){
            listArray.add(bufferedReader.readLine());
        }
        for (int i = 0; i < listArray.size() ; i++) {
            bufferedWriter.write(listArray.replaceAll("." , "!"));
        }*/
        while (bufferedReader.ready()){
            str = bufferedReader.readLine();

            bufferedWriter.write(str.replace(".","!"));
        }
        bufferedReader.close();
        bufferedWriter.close();
    }
}
