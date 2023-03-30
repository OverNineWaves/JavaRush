package com.javarush.task.task20.task2013;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
Externalizable Person
*/

public class Solution {
    public static class Person implements Externalizable{
        private String firstName;
        private String lastName;
        private int age;
        private Person mother;
        private Person father;
        private List<Person> children;

        public Person() {
        }
        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public void setMother(Person mother) {
            this.mother = mother;
        }

        public void setFather(Person father) {
            this.father = father;
        }

        public void setChildren(List<Person> children) {
            this.children = children;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(firstName);
            out.writeObject(lastName);
            out.writeInt(age);
            out.writeObject(mother);
            out.writeObject(father);
            out.writeObject(children);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            firstName = (String)in.readObject();
            lastName = (String)in.readObject();
            age = in.readInt();
            mother = (Person) in.readObject();
            father = (Person) in.readObject();
            children = (List) in.readObject();
        }
        @Override
        public String toString(){
            return ("name " + firstName + "\n" + "lastname " + lastName + "\n" +
                    "age " + age + "\n" + "mother " + mother + "\n" + "father " + father + "\n" + "children " + children);
        }
    }

    public static void main(String[] args) {
        Person personExists = new Person("personName", "personLastname",20);
        personExists.setMother(new Person("motheName", "motherLastname", 40));
        personExists.setFather(new Person("fatherName", "fatherLastname", 42));
        personExists.setChildren(new ArrayList<>());

        Person personNew = new Person();

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("sol2013.dat"));
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("sol2013.dat"));

            personExists.writeExternal(oos);
            oos.close();

            try {
                personNew.readExternal(ois);
                ois.close();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.print(personExists.toString() + "\n\n" +  personNew.toString()) ;

    }
}
