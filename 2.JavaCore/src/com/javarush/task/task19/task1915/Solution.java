package com.javarush.task.task19.task1915;

import java.io.*;

/* 
Дублируем текст
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

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

        /*String str = outputStream.toString();

        System.setOut(trueOut);

        System.out.println(str);

        try {
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.write(str);
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/


        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(fileName);
            fileOutputStream.write(outputStream.toByteArray());
            fileOutputStream.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.setOut(trueOut);
        System.out.println(outputStream.toString());

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

