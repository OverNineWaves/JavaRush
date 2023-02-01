package com.javarush.task.task19.task1915;

import java.io.*;

/* 
Дублируем текст
*/

public class Solution {
    public static TestString testString = new TestString();
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {


        String fileName;

        {
            try {
                fileName = bufferedReader.readLine();
                bufferedReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    PrintStream trueOut = System.out;

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream catchOut = new PrintStream(outputStream);

    System.setOut(catchOut);

    testString.printSomething();

    String str = outputStream.toString();

    System.setOut(trueOut);

    System.out.println(str);

        try {
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.write(str);
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

