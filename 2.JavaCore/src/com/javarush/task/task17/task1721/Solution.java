package com.javarush.task.task17.task1721;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {



        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName_1 = bufferedReader.readLine();
        String fileName_2 = bufferedReader.readLine();
        bufferedReader.close();

        BufferedReader bufferedReader1 = new BufferedReader(new FileReader(fileName_1));
        BufferedReader bufferedReader2 = new BufferedReader(new FileReader(fileName_2));

        String str1 = null;
        String str2 = null;

        while ((str1 = bufferedReader1.readLine())!= null){
        allLines.add(str1);
        }

        while ((str2 = bufferedReader2.readLine())!= null){
            forRemoveLines.add(str2);
        }

        bufferedReader1.close();
        bufferedReader2.close();

        Solution solution = new Solution();
        solution.joinData();

    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)){
            allLines.removeAll(forRemoveLines);
        }
        else {
            allLines.clear();
            throw new CorruptedDataException();
        }

        /* for (int i = 0; i < allLines.size(); i++) {
            System.out.println(allLines.get(i));
        }*/
        // видимо нужно перебирать по индексу кадлый раз и сравнивать значения, если есть такой, то удалить.
        // если ни 1 не схож, то очистить allLines
    }
}
