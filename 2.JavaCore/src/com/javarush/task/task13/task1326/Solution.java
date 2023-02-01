package com.javarush.task.task13.task1326;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

/* 
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        try {
            FileInputStream fileInputStream = new FileInputStream(new Scanner(System.in).nextLine());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            //List<Integer> list = new ArrayList<>();
            bufferedReader.lines().map(Integer::parseInt).filter(x -> x % 2 == 0).sorted().forEach(System.out::println);

            /* while (fileInputStream.available() > 0) {
                List<Integer> list = new ArrayList<>();
                list.add(fileInputStream.read());
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i) % 2 == 0) {
                        System.out.println(list.get(i));
                    }
                }
                //int readFiles = fileInputStream.read();
            }*/
            fileInputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
