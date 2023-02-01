package com.javarush.task.task19.task1913;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Выводим только цифры
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        PrintStream trueOut = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        PrintStream catchOut = new PrintStream(outputStream);

        System.setOut(catchOut);

        testString.printSomething();

        String outNumbers = outputStream.toString().replaceAll("\\D" , "");

        System.setOut(trueOut);

        System.out.println(outNumbers);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}
