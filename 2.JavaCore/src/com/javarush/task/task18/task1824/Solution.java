package com.javarush.task.task18.task1824;

import java.io.*;

/* 
Файлы и исключения
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String strRead = bufferedReader.readLine();
            File path = new File(strRead);
                if (path.exists()){
                    continue;
                }
                else throw new FileNotFoundException(strRead);
        }
    }
}
