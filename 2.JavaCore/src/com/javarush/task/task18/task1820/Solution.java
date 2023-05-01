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
            BufferedReader readFile = new BufferedReader(new FileReader(bufferedReader.readLine()));
            String readFromFile = readFile.readLine();

            //FileReader fileOne = new FileReader(bufferedReader.readLine());
            //Calculate.addNumb(fileOne);
            //Calculate.calculate();

            // FileWriter fileTwo = new FileWriter(bufferedReader.readLine());

            Calculate.arrayAdd(readFromFile);
            Calculate.outputScreen();
            // Calculate.readBuff(readFile);
            // Calculate.printFile();
            bufferedReader.close();
            readFile.close();
            //fileOne.close();
            // fileTwo.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }
    static class Calculate{
        //static List<String> numb = new ArrayList<>();
        static String[] numb;
        public static void arrayAdd(String str){
            numb = str.split(" ");
        }


        public static void outputScreen(){
            for (int i = 0; i <numb.length ; i++) {
                System.out.println(Math.round(Double.parseDouble(numb[i])));
            }
        }


        /*public static void readBuff(BufferedReader bufferedReader) throws IOException {
            while (bufferedReader.ready()){
                numb.add(bufferedReader.readLine().split(" "));
            }
        }

        public static void printFile(){
            for (int i = 0; i <numb.size() ; i++) {
                System.out.println(numb.get(i));
            }
        }*/


        /*public static void addNumb(FileReader fileReader){
               try{

                   while (fileReader.ready()){
                    double read = fileReader.read();
                    numb.add(read);
                }}
               catch (IOException e){
                   throw new RuntimeException(e);
               }
        }*/

        /*public static void calculate(){
            for (int i = 0; i < numb.size(); i++) {
                    double n = numb.get(i);
                if (n%((int)n) > 5 ){
                    System.out.println("орп " + n);
                }
                else System.out.println(n + " не опа");
            }
        }*/

    }
}
