package com.javarush.task.task18.task1821;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
//import java.io.FileReader;
import java.io.FileReader;
import java.io.IOException;
//import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/*
Встречаемость символов
*/

/*public class Solution {
    public static void main(String[] args) {

        Map<Integer, Integer> map = new TreeMap<>();
        try {
            FileReader fileReader = new FileReader(args[0]);
            while(fileReader.ready()){
                int someInt = fileReader.read();
                if (!map.containsKey(someInt)){
                    map.put(someInt, 1);
                }
                else {
                    map.put(someInt, map.get(someInt) + 1);
                }
            }


               /* while ((reader = fileInputStream.read()) >=0 ){
                    if (map.containsKey(reader)){
                        map.replace(reader, ++count);
                    }
                    else count = 1;
                        map.put(reader,count);
                }*/
         /*   for (Map.Entry<Integer, Integer> TreeMap:map.entrySet()) {
                System.out.println("Значение: " + ((char)((int)TreeMap.getKey())) + " Количество: " + TreeMap.getValue());
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}*/

public class Solution {
    public static void main(String[] args) throws IOException {
        int[] aSCII = new int[256];
        try (FileReader reader = new FileReader(args[0])) {
            while (reader.ready()) {
                aSCII[reader.read()]++;
            }
        }
        for (int i = 0; i < aSCII.length; i++) {
            if (aSCII[i] != 0) {
                System.out.println((char) i + " " + aSCII[i]);
            }
        }
    }
}
