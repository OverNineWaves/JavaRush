package com.javarush.task.task18.task1828;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Прайсы 2
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        List<Tovar> list = new ArrayList<>();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String path = bufferedReader.readLine();
        BufferedReader readFormFile = new BufferedReader(new FileReader(path));
        //FileReader fileReader = new FileReader(path);

        while (readFormFile.ready()){
            String readStr = readFormFile.readLine();
          //  String partseId = readStr.substring(0,8).replaceAll("//s", "");
            //int productId = Integer.parseInt(readStr.substring(0,8).replace(" ",""));
            int productId = Integer.parseInt(readStr.substring(0,8).trim());
          //  System.out.println(partseId);
            //int productId = Integer.parseInt(partseId);
            String productName = readStr.substring(8,38);
            Double price = Double.parseDouble(readStr.substring(38,46).trim());
            int quantity = Integer.parseInt(readStr.substring(46).trim());

            list.add(new Tovar(productId, productName, price, quantity));
            //fileReader.read(buffer);
        }


        //System.out.println(list);

        if (args[0].length() == 2){
            switch (args[0]){
                case "-u": {
                    for (int i = 0; i < list.size() ; i++) {
                        if (list.get(i).getId() == Integer.parseInt(args[1])){
                            list.get(i).setPoductName(args[2]);
                            list.get(i).setPrice(Double.parseDouble(args[3]));
                            list.get(i).setQuantity(Integer.parseInt(args[4]));
                        }
                    }
                    break;
                }
                case "-d": {
                    for (int i = 0; i < list.size() ; i++) {
                        if (list.get(i).getId() == Integer.parseInt(args[1])) {
                            list.remove(i);
                            i--;
                        }
                        }
                    break;
                }
            }
        }

        FileWriter writeSom = new FileWriter(path,false);
        writeSom.write("");
        writeSom.close();
        /*for (int i = 0; i < list.size(); i++) {

            System.out.println(i);
        }*/

        FileWriter fileWriter = new FileWriter(path,true);

        for (int i = 0; i < list.size() ; i++) {


            fileWriter.write(String.format("%-8d %-30s %-8.2f %4s",
                    list.get(i).getId(),
                    list.get(i).getPoductName(),
                    list.get(i).getPrice(),
                    list.get(i).getQuantity()));
        }
        readFormFile.close();
        fileWriter.flush();
        fileWriter.close();
    }
    private static class Tovar {
        int id;
        String poductName;
        Double price;
        int quantity;

        public void setId(int id) {
            this.id = id;
        }

        public void setPoductName(String poductName) {
            this.poductName = poductName;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        private Tovar(int id, String poductName, Double price, int quantity){
            this.id = id;
            this.poductName = poductName;
            this.price = price;
            this.quantity = quantity;

        }

        public int getId() {
            return id;
        }

        public String getPoductName() {
            return poductName;
        }

        public Double getPrice() {
            return price;
        }

        public int getQuantity() {
            return quantity;
        }


    }
}

