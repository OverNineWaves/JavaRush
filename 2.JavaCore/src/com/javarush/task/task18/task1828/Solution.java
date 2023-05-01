/*package com.javarush.task.task18.task1828;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
*/
/*
Прайсы 2
*/

/*public class Solution {
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

       /* FileWriter fileWriter = new FileWriter(path,true);

        for (int i = 0; i < list.size() ; i++) {


            fileWriter.write(String.format("%-8d%-30s%-8.2f%4s",
                    list.get(i).getId(),
                    list.get(i).getPoductName(),
                    list.get(i).getPrice(),
                    list.get(i).getQuantity()) + "\n");
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
}*/

package com.javarush.task.task18.task1828;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
Прайсы 2
*/

public class Solution {
    public static class Product {
        int id;
        String name;
        String price;
        String quantity;

        public Product(int id, String name, String price, String quantity) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        @Override
        public String toString() {
            return String.format("%-8d%-30s%-8s%-4s", id, name, price, quantity);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        List<Product> products = new ArrayList<>();

        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            while (fileReader.ready()) {
                Product product = getProduct(fileReader.readLine());
                products.add(product);
            }
        }

        switch (args[0]) {
            case "-u": {
                int id = Integer.parseInt(args[1]);
                String name = "";
                for (int i = 2; i < args.length - 2; i++) {
                    name += args[i] + " ";
                }
                if (name.length() > 30) {
                    name = name.substring(0, 30);
                }
                String price = args[args.length - 2];
                if (price.length() > 8) {
                    price = price.substring(0, 8);
                }
                String quantity = args[args.length - 1];
                if (quantity.length() > 4) {
                    quantity = quantity.substring(0, 4);
                }
                Product productToUpdate = null;
                for (Product product : products) {
                    if (product.id == id) productToUpdate = product;
                }
                if (productToUpdate != null) {
                    productToUpdate.name = name;
                    productToUpdate.price = price;
                    productToUpdate.quantity = quantity;
                }
                break;
            }
            case "-d": {
                int id = Integer.parseInt(args[1]);
                Product productToDelete = null;
                for (Product product : products) {
                    if (product.id == id) productToDelete = product;
                }
                if (productToDelete != null) products.remove(productToDelete);
                break;
            }
        }

        try (FileWriter fileWriter = new FileWriter(fileName)) {
            for (Product product : products) {
                fileWriter.write(product.toString());
                fileWriter.write("\n");
            }
        }
    }

    public static Product getProduct(String string) {
        String id = string.substring(0, 8).trim();
        String name = string.substring(8, 38).trim();
        String price = string.substring(38, 46).trim();
        String quantity = string.substring(46, 50).trim();
        return new Product(Integer.parseInt(id), name, price, quantity);
    }
}

