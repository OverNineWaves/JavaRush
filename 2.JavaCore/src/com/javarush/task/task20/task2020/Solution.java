package com.javarush.task.task20.task2020;

import java.io.*;
import java.util.logging.Logger;

/* 
Сериализация человека
*/

public class Solution {

    public static class Person implements Serializable {
        String firstName;
        String lastName;
        transient String fullName;
        transient final String greeting;
        String country;
        Sex sex;
        transient PrintStream outputStream;
        transient Logger logger;

        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greeting = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }

        public String toString(){
            return ("firstName " + firstName + " lastName " + lastName + " fullName " + fullName + " greeting " + greeting + " country "+ country + " sex " + sex) ;
        }

    }

    enum Sex {
        MALE,
        FEMALE
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String path = "sol2020.dat";
        FileOutputStream fos = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        Person persona = new Person("Vala", "Folla", "Brasil", Sex.FEMALE);

        oos.writeObject(persona);
        fos.close();
        oos.close();
        //System.out.println(persona);

        /*FileInputStream fis = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Person personaIsBack = (Person) ois.readObject();
        //personaIsBack = new Person(personaIsBack.firstName, personaIsBack.lastName, personaIsBack.country, personaIsBack.sex);

        fis.close();
        ois.close();
        System.out.println(personaIsBack);*/

    }
}
