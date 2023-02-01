package com.javarush.task.task18.task1825;

import java.io.*;
import java.nio.file.Files;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        Map<Integer, String> filesSortMap = new TreeMap<>();
        BufferedReader bufferedReaderPath = new BufferedReader(new InputStreamReader(System.in));
        String outFileName = "/home/overninewaves/completeFile.txt";
        FileOutputStream fileOutputStream = new FileOutputStream(outFileName, true);
        //FileWriter fileWriter = new FileWriter(outFileName);
        String strPath = "";
        //FileReader fileReader = new FileReader(strPath);
        while (!(strPath = bufferedReaderPath.readLine()).equals("end")){
            String[] spitFileName = strPath.split(".part");
            String id = spitFileName[1];
            filesSortMap.put(Integer.parseInt(id),strPath);
        }
        bufferedReaderPath.close();
        //файла не существует, переписать.
        FileInputStream fileInputStream;
        for (Map.Entry<Integer, String> mapka: filesSortMap.entrySet()) {
             fileInputStream = new FileInputStream(mapka.getValue());
             //FileReader fileReader = new FileReader(mapka.getValue());
                   while (fileInputStream.available() > 0){
                       byte[] bytesBuffer = new byte[fileInputStream.available()];
                       int count = fileInputStream.read(bytesBuffer);
                    fileOutputStream.write(bytesBuffer);
                    }
             fileInputStream.close();
                //System.out.println(mapka.getValue());
        }
        fileOutputStream.close();
    }
}
