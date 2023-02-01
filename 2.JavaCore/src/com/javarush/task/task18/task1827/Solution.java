package com.javarush.task.task18.task1827;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Прайсы
*/

public class Solution {
    public static void main(String[] args) throws Exception {



        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String path = bufferedReader.readLine();
        FileReader fileReader = new FileReader(path);
        FileWriter fileWriter = new FileWriter(path,true);

        char[] buffer = new char[100];

        while (fileReader.ready()){
            fileReader.read(buffer);
        }

        char[] eight = new char[8];

        for (int i = 0; i < 8; i++) {
            eight[i] = buffer[i];
        }
        int id = Integer.parseInt(new String(eight));
        //String productId = String.format("%.8d",id);
        String productName = String.format("%-30.30s", args[1]);
        String price = String.format("%-8.2f", Double.parseDouble(args[2]));
        String quantity = String.format("%-4d",Integer.parseInt(args[3]));

        //System.out.println(args[0] + " " + id + " " + productName.trim() + " " + price.trim() + " " + quantity);

        if (args[0].equals("-c")){
            fileWriter.write((id + 1) + productName.trim() + price.trim() + quantity);
        }
        fileReader.close();
        fileWriter.close();
    }
}
