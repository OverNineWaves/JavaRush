package com.javarush.task.task18.task1816;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/*
Английские буквы
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        FileInputStream paramRead = new FileInputStream(args[0]);
        List<Integer> list = new ArrayList<>();

        int count = 0;
        while (paramRead.available() > 0){
            list.add(paramRead.read());
        }

        for (int i = 0; i < list.size(); i++) {
            if ((list.get(i) >= 65 && list.get(i) <= 90) || (list.get(i) >=97 && list.get(i) <= 122)) {
                count++;}
        }
//
//
        System.out.println(count);
        paramRead.close();
    }
}
