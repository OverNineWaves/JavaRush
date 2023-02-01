package com.javarush.task.task16.task1617;

/* 
Отсчет на гонках
*/

import javax.swing.plaf.TableHeaderUI;

public class Solution {
    public static volatile int numSeconds = 4;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
        Thread.sleep(3500);
        clock.interrupt();
        //add your code here - добавь код тут
    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }

        Thread current = Thread.currentThread();

        public void run() {
           while (!current.isInterrupted()){
                   System.out.print(numSeconds + " ");
               try {
                   Thread.sleep(1000);
                   numSeconds--;
                   if (numSeconds == 0){
                       System.out.println("Марш!");
                       break;
                   }

               }
               catch (InterruptedException e) {
                   //throw new RuntimeException(e);
                   System.out.println("Прервано!");

                   break;
               }


                /*   Начинаем решение с метода run()
                   Здесь мы:
                   1. пока поток не прерван
                   2. выводим в консоль numSeconds + " "
                   3. усыпляем этот поток на 1000 мс
                   4. numSeconds - -
                   5. если numSeconds == 0 "Марш!"

                   Через catch:
                   6. InterruptedException
                   7. "Прервано!"
                   8. break;

                   Далее идем в main:
                   9. Thread.sleep(3500);
                   10. поток часов.interrupt();*/
           }
        }
    }
}