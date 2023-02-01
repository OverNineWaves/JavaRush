package com.javarush.task.task18.task1810;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
DownloadException
*/

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //boolean c = true;
        while (true){
            FileInputStream readFile = new FileInputStream(reader.readLine());
            //byte[] thousand = new byte[1000];
            byte[] buffer = new byte[readFile.available()];
            //if (readFile.available() > 0){
                readFile.read(buffer);
                if (buffer.length < 1000){
                   // c = false;
                    reader.close();
                    readFile.close();
                    throw new DownloadException();
                    //break;
               // }
             //   else continue;
            }
        }

    }

    public static class DownloadException extends Exception {

    }
}
