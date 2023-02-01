package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
User, Loser, Coder and Proger
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;

        while (true){
            String str = reader.readLine();
            if (str.equals("user")||str.equals("loser")||str.equals("coder")||str.equals("proger")){
                if (str.equals("user")){
                    Person.User user = new Person.User();
                    doWork(user);
                } else if (str.equals("loser")) {
                    Person.Loser loser = new Person.Loser();
                    doWork(loser);
                } else if (str.equals("coder")) {
                    Person.Coder coder = new Person.Coder();
                    doWork(coder);
                } else if (str.equals("proger")) {
                    Person.Proger proger = new Person.Proger();
                    doWork(proger);
                }
            }
            else break;
        }
    }

    public static void doWork(Person person) {
        // пункт 3
            if (person instanceof Person.User){
                ((Person.User) person).live();
            } else if (person instanceof Person.Loser) {
                ((Person.Loser) person).doNothing();
            }
            else if (person instanceof Person.Coder){
                ((Person.Coder) person).writeCode();
            }
            else if (person instanceof Person.Proger){
                ((Person.Proger) person).enjoy();
            }
    }
}
