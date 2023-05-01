package com.javarush.task.task19.task1904;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;

/*
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws IOException, ParseException {
        PersonScanner adapter = new PersonScannerAdapter(new Scanner(new File("/home/overninewaves/javaTestFiles/3.txt")));
        Person ps = adapter.read();
        System.out.println(ps);
        adapter.close();

    }

    public static class PersonScannerAdapter implements PersonScanner{

        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException, ParseException {
            String str = fileScanner.nextLine();
            String[] splitStr = str.split(" ");

            //String fromArray = splitStr[3] + " " +  splitStr[4] + " " + splitStr[5];
            Calendar calendar = new GregorianCalendar(Integer.parseInt(splitStr[5]), Integer.parseInt(splitStr[4]) - 1, Integer.parseInt(splitStr[3]));

            //Date data = new SimpleDateFormat("dd MM YYYY", Locale.ENGLISH).parse(splitStr[3] + " " +  splitStr[4] + " " + splitStr[5]);

            Date data = calendar.getTime();

            //Date trueData = null;
            /*try {
                trueData = data.parse(fromArray);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }*/
            return new Person(splitStr[1], splitStr[2], splitStr[0],data); //  lastName, firstName, middleName, birthDate
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}