package com.javarush.task.task20.task2001;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Читаем и пишем в файл: Human
*/

public class Solution {
    public static void main(String[] args) {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("file.txt", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Human ivanov = new Human("Ivanov", new Asset("home", 999_999.99), new Asset("car", 2999.99));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            inputStream.close();

           // System.out.println("somePerson name: " + somePerson.name);

            if (ivanov.equals(somePerson)){
                System.out.println("равны");
            }
            else System.out.println("не равны");
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream);
            //BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
            String isThereName;
            String isThereAssets;
            //************************
            if (name != null){          //чекаем, не пустой ли name и создаем флаг
                isThereName = "yes";
            }
            else isThereName = "no";

            printWriter.println(isThereName);
            printWriter.flush();

            if (name != null){          //если name не null, записываем
                printWriter.println(name);
            }

            if (assets != null){
                isThereAssets = "yes";
            }
            else isThereAssets = "no";

            printWriter.println(isThereAssets);
            printWriter.flush();

            for (Asset list : assets){
                printWriter.println(list.getName());
                printWriter.println(list.getPrice());
                printWriter.flush();
            }
//            for (Asset list : assets){
//                System.out.print("name: " + list.getName() + " " + "price: " + list.getPrice() + "\n");
//            }

            outputStream.close();
            printWriter.close();
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String isThereName = reader.readLine();
            //Human human = new Human();
            if (isThereName.equals("yes")){
                this.name = reader.readLine();
                    //System.out.print("name: " + human.name + "\n");
            }
            else this.name = null;

            String isThereAssets = reader.readLine();
//            while (reader.ready()){
//                System.out.println(reader.readLine());
//            }
            //System.out.println(isThereAssets);
            if (isThereAssets.equals("yes")){
                while (reader.ready()){
                    String home = reader.readLine();
                    Double price = Double.parseDouble(reader.readLine());
                    //System.out.println(home + " " + price);
                    Asset loadAssets = new Asset(home, price);
                    this.assets.add(loadAssets);

//                    for(Asset asset : assets){
//                        System.out.print("price: " + asset.getPrice() + "\n");
//                   }
                }
            }

            reader.close();
            //implement this method - реализуйте этот метод
        }

    }
}
