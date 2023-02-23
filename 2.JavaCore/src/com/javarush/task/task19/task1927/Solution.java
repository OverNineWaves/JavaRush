package com.javarush.task.task19.task1927;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

/* 
Контекстная реклама
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream trueOut = System.out;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);

        System.setOut(printStream);
        testString.printSomething();

        System.setOut(trueOut);

        int count = 1;
        int numb =  0;
        String[] str = byteArrayOutputStream.toString().split("\n");
        for (int i = 0; i < str.length + 2; i++) {
            if (count % 3 == 0){
                //System.out.println(str[i]);
                System.out.println("JavaRush - курсы Java онлайн");
                count = 1;
            }

            else {
            System.out.println(str[numb]);
            numb++;
            count++;}

        }

    }
    
    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
