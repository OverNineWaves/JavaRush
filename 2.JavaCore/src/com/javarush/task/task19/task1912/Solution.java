package com.javarush.task.task19.task1912;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Ридер обертка 2
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
    PrintStream unit = System.out;

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream catchOut = new PrintStream(outputStream);

    System.setOut(catchOut);

    testString.printSomething();

    String catchStr = outputStream.toString().replace("te", "??");

    System.setOut(unit);

    System.out.println(catchStr);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
