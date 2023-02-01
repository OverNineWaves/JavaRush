package com.javarush.task.pro.example.example10;

public class HandleBar {
    int c = 5;
    int b = 6;
    public void run(int a, int b){
        int c = a + b;
        System.out.println(c + " cm");
    }
    public class Set{
        public void runAway(){
            System.out.println("Длина руля короче");
            System.out.println("Переменная С = " + HandleBar.this.c);
        }
    }
}
