package com.javarush.task.task19.task1911;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Ридер обертка
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

    PrintStream until = System.out;

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    PrintStream after = new PrintStream(outputStream);

    System.setOut(after);

    testString.printSomething();

    String result = outputStream.toString().toUpperCase();


    System.setOut(until);

    System.out.println(result);


    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
