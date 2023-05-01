package com.javarush.task.task18.task1818;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
Два в одном
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileWriter fileOne = new FileWriter(bufferedReader.readLine(), true);
        FileReader fileTwo = new FileReader(bufferedReader.readLine());
        FileReader fileThree = new FileReader(bufferedReader.readLine());

        CopyText.fromTwoToOne(fileTwo, fileOne);
        CopyText.fromThreeToOne(fileThree, fileOne);
        bufferedReader.close();
        fileOne.close();
        fileTwo.close();
        fileThree.close();

    }
    static class CopyText{
        public static void fromTwoToOne(FileReader fileTwo, FileWriter fileOne) throws IOException {
            while (fileTwo.ready()){
                int fromTwo = fileTwo.read();
                fileOne.write(fromTwo);
            }
        }
        public static void fromThreeToOne(FileReader fileThree, FileWriter fileOne) throws IOException{
            while (fileThree.ready()){
                int fromThree = fileThree.read();
                fileOne.write(fromThree);
            }
        }
    }

}

