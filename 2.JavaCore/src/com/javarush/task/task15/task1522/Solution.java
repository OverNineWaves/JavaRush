package com.javarush.task.task15.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Закрепляем паттерн Singleton
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static Planet thePlanet;

    static {
        readKeyFromConsoleAndInitPlanet();
    }
    //add static block here - добавьте статический блок тут

    public static void readKeyFromConsoleAndInitPlanet() {
        // implement step #5 here - реализуйте задание №5 тут
        try {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine();
        if (str.equals(Planet.EARTH)){
             thePlanet = Earth.getInstance();
           // System.out.println("earth");
        } else if (str.equals(Planet.MOON)) {
             thePlanet = Moon.getInstance();
        } else if (str.equals(Planet.SUN)) {
            thePlanet = Sun.getInstance();
        }
            else  thePlanet = null;
        }
        catch (Exception e){
            throw new RuntimeException();
        }
    }
}
