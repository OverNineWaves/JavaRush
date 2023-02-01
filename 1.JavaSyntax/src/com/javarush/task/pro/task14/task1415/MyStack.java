package com.javarush.task.pro.task14.task1415;

import java.util.ArrayList;
import java.util.List;

/* 
Стек в домашних условиях
*/

public class MyStack {

    private final List<String> storage = new ArrayList<>();

    public void push(String s) {
        //напишите тут ваш код
        storage.add(0 , s);
    }

    public String pop() {
        String s = storage.get(0);
        storage.remove(s);
        return s;
        //напишите тут ваш код
    }

    public String peek() {
        return storage.get(0);
        //напишите тут ваш код
    }

    public boolean empty() {
        if (storage.isEmpty()){
            return true;
        }
        else return false;
        //напишите тут ваш код
    }

    public int search(String s) {
        if (storage.contains(s)){
            return storage.indexOf(s);
        }
        else return -1;
        //напишите тут ваш код
    }
}
