package com.javarush.task.pro.task15.task1507;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Пропускаем не всех
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        List<String> list = Files.readAllLines(Paths.get(scanner.nextLine()));
        for (int i = 0; i < list.size();) {
            System.out.println(list.get(i));
            i = i+2;
        }
    }
}

