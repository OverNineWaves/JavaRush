package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader_One = new BufferedReader(new InputStreamReader(System.in));
        String str = reader_One.readLine();

        FileInputStream fileInputStream = new FileInputStream(str);
        Scanner scanner = new Scanner(fileInputStream);

        StringBuilder stringBuilder = new StringBuilder();
        while (scanner.hasNextLine()){
            stringBuilder.append(scanner.nextLine()).append("\n");
        }
        System.out.print(stringBuilder.toString());
        reader_One.close();
        scanner.close();
    }
}