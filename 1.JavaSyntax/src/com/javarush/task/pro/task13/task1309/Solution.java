package com.javarush.task.pro.task13.task1309;

import java.util.HashMap;

/* 
Успеваемость студентов
*/

public class Solution {
    public static HashMap<String, Double> grades = new HashMap<>();

    public static void main(String[] args) {
        addStudents();
        System.out.println(grades);
    }

    public static void addStudents() {
        //напишите тут ваш код
        grades.put("Максим Максимов", 5.0);
        grades.put("qwer qwert" , 3.0);
        grades.put("qw qwer", 2.0);
        grades.put("asd as", 4.0);
        grades.put("sdf sd", 5.0);

    }
}
