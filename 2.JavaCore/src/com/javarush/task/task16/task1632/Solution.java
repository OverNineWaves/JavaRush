package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Клубок
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new Thread1());
        threads.add(new Thread2());
        threads.add(new Thread3());
        threads.add(new Thread4());
        threads.add(new Thread5());
    }
    public static void main(String[] args) {
//        Thread1 thread1 = new Thread1();
//        thread1.start();
       Thread2 thread2 = new Thread2();
       thread2.start();
  //      thread2.interrupt();
    //   Thread3 thread3 = new Thread3();
  //     thread3.start();
//        Thread4 thread4 = new Thread4();
//        thread4.start();
//        thread4.showWarning();
//        Thread5 thread5 = new Thread5();
//        thread5.start();
    }
}

class Thread1 extends Thread{
    @Override
    public void run(){
        while (true){

        }
    }
}
 class Thread2 extends Thread{
    @Override
    public void run(){
        try {
            Thread.sleep(0);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        }
    }
}
 class Thread3 extends Thread{
    @Override
    public void run(){
        while (true){
            try {
                System.out.println("Ура");
                Thread.sleep(500);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
 class Thread4 extends Thread implements Message{
    boolean cancel = false;
    @Override
    public void run(){
        while (!cancel){

        }
    }

    @Override
    public void showWarning() {
        if (isAlive()){
            cancel = true;
        }
    }
}
 class Thread5 extends Thread{
    @Override
    public void run(){
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            int sum = 0;
            boolean a = true;
            while (a){
                String str = bufferedReader.readLine();
                if (str.equals("N")){
                    a = false;
                    bufferedReader.close();
                }
                else
                sum+= Integer.parseInt(str);
            }
            System.out.println(sum);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}