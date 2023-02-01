package com.javarush.task.pro.task15.task1516;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/* 
Файл или директория
*/

public class Solution {
    private static final String THIS_IS_FILE = " - это файл";
    private static final String THIS_IS_DIR = " - это директория";

    public static void main(String[] args) {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        Boolean a = true;
        while (a){
            String path = scanner.nextLine();

            if (Files.isRegularFile(Path.of(path))){
            System.out.println(path + THIS_IS_FILE);
            continue;
        } else if (Files.isDirectory(Path.of(path))) {
            System.out.println(path + THIS_IS_DIR);
            continue;
        }
        else a = false;
    }}
}

