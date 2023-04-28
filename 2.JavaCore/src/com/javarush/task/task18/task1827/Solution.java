package com.javarush.task.task18.task1827;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
Прайсы
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        if (args.length == 0){
            return;
        }
        else if (args[0].equals("-c")){

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String path = bufferedReader.readLine();
            BufferedReader readStr = new BufferedReader(new FileReader(path));
            FileWriter fileWriter = new FileWriter(path,true);
            bufferedReader.close();

            List<String> strArrayList = new ArrayList<>();
            while(readStr.ready()){
                strArrayList.add(readStr.readLine());
            }

            String[] strArray = new String[strArrayList.size()]; //массив для строк

            for (int i = 0; i < strArrayList.size() ; i++) {
                strArray[i] = strArrayList.get(i);
            }

            int[] idArrays = new int[strArray.length];

            for (int i = 0; i < strArray.length; i++) {
                String str = strArray[i];
                char[] strArrayChar = str.toCharArray();
                char[] eight = new char[8];
                for (int j = 0; j < 8; j++) {
                    eight[j] = strArrayChar[j];
                }
                String eightStr = String.valueOf(eight);
                idArrays[i] = Integer.parseInt(eightStr.trim());
            }
            int id = 0;

            for (int i = 0; i < idArrays.length; i++) {
                if (idArrays[i] > id){
                    id = idArrays[i];
                }
            }
            String idProduct = String.format("%-8d", id + 1);
            String productName = String.format("%-30.30s", args[1]);
            String price = String.format("%-8.2f", Double.parseDouble(args[2]));
            String quantity = String.format("%-4d",Integer.parseInt(args[3]));
            fileWriter.write(idProduct + productName + price + quantity + "\n");

            readStr.close();
            fileWriter.close();

        }
    }
}
