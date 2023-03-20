package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/

public class Solution {

    public static Map<String, String> runtimeStorage = new HashMap<>();

    public static void save(OutputStream outputStream) throws Exception {
        Properties propertiesSave = new Properties();
        propertiesSave.putAll(runtimeStorage);
        propertiesSave.store(outputStream, null);
        //реализовать логику записи в файл для карты runtimeStorage

    }

    public static void load(InputStream inputStream) throws IOException {
        //реализовать логику чтения из файла для runtimeStorage
        Properties propertiesLoad = new Properties();
        propertiesLoad.load(inputStream);

        for (String  name : propertiesLoad.stringPropertyNames()){
            runtimeStorage.put(name, propertiesLoad.getProperty(name));
        }

        /*for(Map.Entry<String, String> runMap : runtimeStorage.entrySet()){
            System.out.println(runMap.getKey() + " <key | value> " + runMap.getValue());
        }*/
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fis = new FileInputStream(reader.readLine());
             //FileOutputStream fos = new FileOutputStream(reader.readLine(),true);
        ) {
            load(fis);
            /*try {
                save(fos);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }*/
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(runtimeStorage);
    }
}
