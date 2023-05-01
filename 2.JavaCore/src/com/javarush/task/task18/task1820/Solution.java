package com.javarush.task.task18.task1820;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/*
Округление чисел
*/

public class Solution {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String forRead = bufferedReader.readLine();
            String forWrite = bufferedReader.readLine();
            BufferedReader readFile = new BufferedReader(new FileReader(forRead));
            PrintWriter printWriter = new PrintWriter(new FileWriter(forWrite));
            String readFromFile = readFile.readLine();

            Calculate.arrayAdd(readFromFile);
            //Calculate.outputScreen();
            Calculate.writeToFile(printWriter);

            bufferedReader.close();
            readFile.close();
            printWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    static class Calculate {
        static String[] numb;

        public static void arrayAdd(String str) {
            numb = str.split(" ");
        }


        /* public static void outputScreen(){
             for (int i = 0; i <numb.length ; i++) {
                 System.out.println(Math.round(Double.parseDouble(numb[i])));
             }
         }*/
        public static void writeToFile(PrintWriter printWriter) {
                 for (String numberStr : numb) {
                    double number = Double.parseDouble(numberStr);
                    long roundedNumber = Math.round(number);
                    printWriter.print(roundedNumber + " ");
                }
            }
        }
    }
