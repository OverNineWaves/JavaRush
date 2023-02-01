package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

       // String str = "/home/overninewaves/1.txt";
        //FileReader strRead = new FileReader(str);
        while (true){
            String str = bufferedReader.readLine();
            if (str.equals("exit")){
                break;
            }
            else {
                //Thread thread = new Thread(new ReadThread(str));
                //thread.start();
                new ReadThread(str).start();
            }
        }
        //new ReadThread(str).start();
        bufferedReader.close();
       /* ReadThread readThread = new ReadThread(str);
        readThread.start();
        readThread.join();*/

        /*for (Map.Entry<String, Integer> screen: resultMap.entrySet()) {
            System.out.println("File: " + screen.getKey() + "\n" + "Count: " + screen.getValue());
        }*/
    }

    public static class ReadThread extends Thread {
        Map<Integer, Integer> threadMap = new TreeMap<>();
        FileReader fileReader;
        String fileName;
        int count = 0;
        int result = 0;

        public ReadThread(String fileName) throws FileNotFoundException {
            this.fileName = fileName;
        }
        public void run(){
            try {
                fileReader = new FileReader(fileName);
                //FileInputStream fileReader = new FileInputStream(fileName);

                while (fileReader.ready()) {
                int readByte = fileReader.read();
                //while (fileReader.available() > 0) {
                if (!threadMap.containsKey(readByte)){
                    threadMap.put(readByte, 1);
                }
                else {
                    threadMap.replace(readByte, threadMap.get(readByte) + 1);
                }}

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            for (Map.Entry<Integer, Integer> resultMapka: threadMap.entrySet()) {
                if (resultMapka.getValue() > 0){
                    count = resultMapka.getValue();
                    result = resultMapka.getKey();
                }

            }
            //System.out.println(result + " output");
            resultMap.put(fileName, result);
            try {
                fileReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
