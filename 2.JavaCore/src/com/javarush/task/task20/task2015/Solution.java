package com.javarush.task.task20.task2015;

import java.io.*;

/*
Переопределение сериализации
*/

public class Solution implements Serializable, Runnable {
    private transient Thread runner;
    private int speed;

    public Solution(int speed) {
        this.speed = speed;
        runner = new Thread(this);
        runner.start();
    }

    public void run() {
        System.out.println("message");
        System.out.println(Thread.currentThread());
        // do something here, doesn't matter what
    }

    /**
     * Переопределяем сериализацию.
     * Для этого необходимо объявить методы:
     * private void writeObject(ObjectOutputStream out) throws IOException
     * private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
     * Теперь сериализация/десериализация пойдет по нашему сценарию :)
     */
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        Thread thread1 = new Thread(this);
        thread1.start();
    }

    public static void main(String[] args) {
        Solution solution = new Solution(20);
        try {
            ByteArrayOutputStream byts = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(byts);
            oos.writeObject(solution);
            oos.close();

            ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(byts.toByteArray()));
            try {
                Solution solution1 = (Solution) ois.readObject();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
