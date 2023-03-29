package com.javarush.task.task20.task2011;

import java.io.*;

/* 
Externalizable для апартаментов
*/

public class Solution {

    public static class Apartment implements Externalizable {

        private String address;
        private int year;

        /**
         * Mandatory public no-arg constructor.
         */
        public Apartment() {
            super();
        }

        public Apartment(String addr, int y) {
            address = addr;
            year = y;
        }

        /**
         * Prints out the fields used for testing!
         */
        public String toString() {
            return ("Address: " + address + "\n" + "Year: " + year);
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(address);
        out.writeInt(year);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        address = (String) in.readObject();
        year = in.readInt();
        }
    }

    public static void main(String[] args) throws IOException {
        String file = "file.dat";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        //new Apartment("12", 12).writeExternal(oos);
        Apartment a1 = new Apartment("adrees 1", 1885);
        a1.writeExternal(oos);
        oos.close();
        try {
            a1.readExternal(ois);
            ois.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(a1.toString());

    }
}
