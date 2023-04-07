package com.javarush.task.task20.task2021;

import java.io.*;

/* 
Сериализация под запретом
*/

public class Solution implements Serializable {
    public static class SubSolution extends Solution {

        private void writeObject(ObjectOutputStream oos) throws NotSerializableException {
            throw new NotSerializableException("бум");
        }

        private void readObject(ObjectInputStream ois) throws NotSerializableException {
            throw new NotSerializableException("бац");
        }
    }

    public static void main(String[] args) {

    }
}
