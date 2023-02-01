package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static ArrayList<String> list1 = new ArrayList<>();
    private static ArrayList<String> list2 = new ArrayList<>();

    public static void main(String[] args) throws IOException {

    //FileReader readFile1 = new FileReader(bufferedReader.readLine());
    //FileReader readFile2 = new FileReader(bufferedReader.readLine());


    BufferedReader reader1 = new BufferedReader(new FileReader(bufferedReader.readLine()));
    BufferedReader reader2 = new BufferedReader(new FileReader(bufferedReader.readLine()));

    while (reader1.ready()){
       list1.add(reader1.readLine());
    }

    while (reader2.ready()){
       list2.add(reader2.readLine());
    }
        reader1.close();

        bufferedReader.close();
    reader2.close();

    Compare(list1, list2);

        for (LineItem strs : lines){
            System.out.println(strs.line + " " + strs.type);
        }
    }

    public static void Compare(ArrayList<String> list1, ArrayList<String> list2){
        while ((list1.size() > 0 && list2.size() > 0)){
            if (list1.get(0).equals(list2.get(0))){
                lines.add(new LineItem(Type.SAME, list1.get(0)));
                list1.remove(0);
                list2.remove(0);
            }
            else if (list1.get(1).equals(list2.get(0))) {
                lines.add(new LineItem(Type.REMOVED, list1.get(0)));
                list1.remove(0);
            }
            else if (list1.get(0).equals(list2.get(1))){
                lines.add(new LineItem(Type.ADDED, list2.get(0)));
                list2.remove(0);
            }}
             if (list1.size() == 0 && list2.size() > 0) {
                lines.add(new LineItem(Type.ADDED,list2.get(0)));
                list2.remove(0);
            } else if (list1.size() > 0 && list2.size() == 0) {
                lines.add(new LineItem(Type.REMOVED, list1.get(0)));
                list1.remove(0);
            }
    }

    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
