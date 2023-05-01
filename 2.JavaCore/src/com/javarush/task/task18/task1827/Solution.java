/*package com.javarush.task.task18.task1827;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
*/
/*
Прайсы
*/

/*public class Solution {
    public static void main(String[] args) throws Exception {

        if (args.length == 0){
            return;
        }
        else if (args[0].equals("-c")){

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String path = bufferedReader.readLine();
            BufferedReader readStr = new BufferedReader(new FileReader(path));
            FileWriter fileWriter = new FileWriter(path,true);
            bufferedReader.close();

            List<String> strArrayList = new ArrayList<>();
            while(readStr.ready()){
                strArrayList.add(readStr.readLine());
            }

            String[] strArray = new String[strArrayList.size()]; //массив для строк

            for (int i = 0; i < strArrayList.size() ; i++) {
                strArray[i] = strArrayList.get(i);
            }

            int[] idArrays = new int[strArray.length];

            for (int i = 0; i < strArray.length; i++) {
                String str = strArray[i];
                char[] strArrayChar = str.toCharArray();
                char[] eight = new char[8];
                for (int j = 0; j < 8; j++) {
                    eight[j] = strArrayChar[j];
                }
                String eightStr = String.valueOf(eight);
                idArrays[i] = Integer.parseInt(eightStr.trim());
            }
            int id = 0;

            for (int i = 0; i < idArrays.length; i++) {
                if (idArrays[i] > id){
                    id = idArrays[i];
                }
            }
            String idProduct = String.format("%-8d", id + 1);
            String productName = String.format("%-30.30s", args[1]);
            String price = String.format("%-8.2f", Double.parseDouble(args[2]));
            String quantity = String.format("%-4d",Integer.parseInt(args[3]));
            fileWriter.write(idProduct + productName + price + quantity + "\n");

            readStr.close();
            fileWriter.close();

        }
    }
}*/

package com.javarush.task.task18.task1827;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
Прайсы
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
        if (args.length == 0) {
            return;
        }

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
            case "-c":
                int id = 0;
                for (Product product : products) {
                    if (product.id > id) id = product.id;
                }
                String name = "";
                for (int i = 1; i < args.length - 2; i++) {
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
                Product product = new Product(++id, name.trim(), price, quantity);
                try (FileWriter fileWriter = new FileWriter(fileName, true)) {
                    fileWriter.write("\n");
                    fileWriter.write(product.toString());
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
