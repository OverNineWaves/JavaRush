package com.javarush.task.task20.task2007;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Как сериализовать JavaRush?
*/

public class Solution {
    public static class JavaRush implements Serializable{
        public List<User> users = new ArrayList<>();
    }

    public static void main(String[] args) throws IOException {
        /*JavaRush jv = new JavaRush();
        FileOutputStream fos = new FileOutputStream("ser.dat");
        ObjectOutputStream ous = new ObjectOutputStream(fos);
        ous.writeObject(jv);
        fos.close();
        ous.close();*/

    }
}
