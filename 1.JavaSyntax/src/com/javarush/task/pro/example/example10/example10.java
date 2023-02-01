package com.javarush.task.pro.example.example10;

public class example10 {
    public static void main(String[] args) {
        HandleBar handleBar = new HandleBar();
        handleBar.run(5,2);
        HandleBar.Set set = handleBar.new Set();
        set.runAway();
    }

}
