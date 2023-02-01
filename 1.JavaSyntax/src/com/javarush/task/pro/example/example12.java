package com.javarush.task.pro.example;

public class example12 {

    public int a = getSum();
    public int b = getSum() - a;
    public int c = getSum() - a - b;

    public static void main(String[] args) {
    }



   public  static void getSum1(int a){
       System.out.println(a);
   }

    public int getSum()
    {
        return a + b + c;
    }

}
