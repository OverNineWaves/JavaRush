package com.javarush.task.task19.task1914;

import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

/* 
Решаем пример
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream trueOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        PrintStream catchOut = new PrintStream(outputStream);

        System.setOut(catchOut);

        testString.printSomething();

        String[] numbs = outputStream.toString().split(" ");

        int a = Integer.parseInt(numbs[0]);
        int b = Integer.parseInt(numbs[2]);

        System.setOut(trueOut);

        switch (numbs[1]){
            case "+" :
                System.out.println(a + " + " + b + " = " + (a + b));
                break;
            case "-" :
                System.out.println(a + " - " + b + " = " + (a - b));
                break;
            case "*" :
                System.out.println(a + " * " + b + " = " + (a * b));
                break;
            default: break;
        }
        //System.out.println(numbs[1]);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 * 6 = ");
        }
    }
}

