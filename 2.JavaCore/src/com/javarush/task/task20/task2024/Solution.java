package com.javarush.task.task20.task2024;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/*
Знакомство с графами
*/

public class Solution implements Serializable{
    int node;
    List<Solution> edges = new LinkedList<>();

    public Solution(int a){
        node = a;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Solution s1 = new Solution(1);
        Solution s2 = new Solution(2);
        Solution s3 = new Solution(3);

        s1.edges.add(s2);
        s2.edges.add(s1);
        s3.edges.add(s2);
        s3.edges.add(s3);


        ByteArrayOutputStream byos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(byos);

        oos.writeObject(s1);
        oos.writeObject(s2);
        oos.writeObject(s3);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(byos.toByteArray()));

        Solution loadS1 = (Solution) ois.readObject();
        Solution loadS2 = (Solution) ois.readObject();
        Solution loadS3 = (Solution) ois.readObject();

        byos.close();
        ois.close();

        System.out.println(Objects.equals(s1, loadS1));
        System.out.println(Objects.equals(s2, loadS2));
        System.out.println(Objects.equals(s3, loadS3));
    }
}
