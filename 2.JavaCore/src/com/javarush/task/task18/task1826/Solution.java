package com.javarush.task.task18.task1826;

import java.io.*;

/* 
Шифровка
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream reader = new FileInputStream(args[1]);
        FileOutputStream writer = new FileOutputStream(args[2]);

        switch (args[0]) {
            case "-e":
             while (reader.available() > 0) {
              writer.write(reader.read()*2);
                }
             break;
            case "-d":
                while (reader.available() > 0) {
                    writer.write(reader.read()/2);
                }
                break;
        }
        reader.close();
        writer.close();
    }
}
