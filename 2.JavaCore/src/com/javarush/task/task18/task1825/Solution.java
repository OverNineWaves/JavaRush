/*package com.javarush.task.task18.task1825;

import java.io.*;
import java.nio.file.Files;
import java.util.*;
*/
/*
Собираем файл
*/

/*public class Solution {
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
}*/
package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/*
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Set<String> files = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] parts1 = o1.split(".part");
                String[] parts2 = o2.split(".part");
                int number1 = Integer.parseInt(parts1[parts1.length - 1]);
                int number2 = Integer.parseInt(parts2[parts2.length - 1]);
                return number1 - number2;
            }
        });
        String outputFile = null;
        String readString;
        while (!(readString = reader.readLine()).equals("end")) {
            files.add(readString);
            if (outputFile == null) {
                int indexOfSuffix = readString.lastIndexOf(".part");
                outputFile = readString.substring(0, indexOfSuffix);
            }
        }
        if (outputFile == null) return;
        try (FileOutputStream fileOutputStream = new FileOutputStream(outputFile)) {
            for (String file : files) {
                try (FileInputStream fileInputStream = new FileInputStream(file)) {
                    byte[] buffer = new byte[fileInputStream.available()];
                    while (fileInputStream.available() > 0) {
                        int bytesRead = fileInputStream.read(buffer);
                        fileOutputStream.write(buffer, 0, bytesRead);
                    }
                }
            }
        }
    }
}
