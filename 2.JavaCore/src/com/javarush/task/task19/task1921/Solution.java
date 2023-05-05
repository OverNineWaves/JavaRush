package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/*
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();
    static BufferedReader bufferedFileReader;
    static SimpleDateFormat dataFormat = new SimpleDateFormat("dd MM yyyy");

    public static void main(String[] args) {
        try {
            bufferedFileReader = new BufferedReader(new FileReader(args[0]));
            while(bufferedFileReader.ready()){
                String str = bufferedFileReader.readLine();
                try {
                    PEOPLE.add(new Person(str.replaceAll("[^а-яА-Я ]","").trim(), dataFormat.parse(str.replaceAll("[^0-9 ]", "").trim())));
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }
            bufferedFileReader.close();
        }  catch (IOException e) {
            throw new RuntimeException(e);
        }
       /* for (int i = 0; i <PEOPLE.size() ; i++) {
            System.out.println(PEOPLE.get(i).getName() + " " + PEOPLE.get(i).getBirthDate());
        }*/
    }
}
