package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
Serializable Solution
*/

public class Solution implements Serializable{
    public static void main(String[] args) {
        Solution savedObject = new Solution(4);
        Solution loadedObject;
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("sol2014.dat"));
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("sol2014.dat"));

            oos.writeObject(savedObject);
            try {
                loadedObject = (Solution) ois.readObject();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(savedObject);
        System.out.println(savedObject.string.equals(loadedObject.string));
        //System.out.println(savedObject.toString());
        //System.out.println(loadedObject.toString());
    }

    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
