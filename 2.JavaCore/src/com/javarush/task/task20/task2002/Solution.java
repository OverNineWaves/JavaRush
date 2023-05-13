package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/

public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            User Vasha = new User();
            Vasha.setFirstName("Vasha");
            Vasha.setLastName("Shika");
            Vasha.setBirthDate(new Date(22,12,01));
            Vasha.setMale(true);
            Vasha.setCountry(User.Country.RUSSIA);
            javaRush.users.add(Vasha);
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);

            if (javaRush.equals(loadedObject)){
                System.out.println("true");
            }
            else System.out.println("false");
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter printWriter = new PrintWriter(outputStream);
            for (User user : users){
                String firstName, lastName, date,male, country;
                firstName = user.getFirstName() !=null ? "yes" : "no";
                lastName = user.getLastName() !=null ? "yes" : "no";
                date = user.getBirthDate() !=null ? "yes" : "no";
                male = user.isMale() == true ? "yes" : "no";
                country = user.getCountry() !=null ? "yes" : "no";

                printWriter.println(firstName);
                printWriter.println(user.getFirstName());

                printWriter.println(lastName);
                printWriter.println(user.getLastName());

                printWriter.println(date);
                printWriter.println(user.getBirthDate().getTime());

                printWriter.println(male);
                printWriter.println(user.isMale());

                printWriter.println(country);
                printWriter.println(user.getCountry().getDisplayName());

                printWriter.flush();
            }
            printWriter.close();


            //implement this method - реализуйте этот метод
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            User loadSaveUser = new User();
            while (bufferedReader.ready()){
                String firstName = bufferedReader.readLine();
                if (firstName.equals("yes")){
                    loadSaveUser.setFirstName(bufferedReader.readLine());
                }
                else loadSaveUser.setFirstName(null);
                String lastName = bufferedReader.readLine();
                if (lastName.equals("yes")){
                    loadSaveUser.setLastName(bufferedReader.readLine());
                }
                else loadSaveUser.setLastName(null);

                String date = bufferedReader.readLine();
                if (date.equals("yes")){
                    loadSaveUser.setBirthDate(new Date(Long.parseLong(bufferedReader.readLine())));
                }
                else loadSaveUser.setBirthDate(null);

                String male = bufferedReader.readLine();
                if (male.equals("yes")){
                    loadSaveUser.setMale(Boolean.parseBoolean(bufferedReader.readLine()));
                }
                else loadSaveUser.setMale(false);

                String county = bufferedReader.readLine();
                if (county.equals("yes")){
                    User.Country select;
                    String selectCounty = bufferedReader.readLine();
                    switch (selectCounty){
                        case "Ukraine" : select = User.Country.UKRAINE;
                            break;
                        case "Russia" : select = User.Country.RUSSIA;
                            break;
                        case "Other" :select = User.Country.OTHER;
                            break;
                        default:select = null;
                            break;
                    }
                    loadSaveUser.setCountry(select);
                }
                else loadSaveUser.setCountry(null);
                this.users.add(loadSaveUser);
                //implement this method - реализуйте этот метод
            }
            bufferedReader.close();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
