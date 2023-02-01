package com.javarush.task.pro.task16.task1612;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAccessor;
import java.util.*;

/* 
Синтезируем LocalDateTime
*/

public class Solution {

    public static void main(String[] args) {
        Map<LocalDate, List<LocalTime>> dateMap = DateTimeGenerator.generateDateMap();
        printCollection(dateMap.entrySet());

        Set<LocalDateTime> dateSet = convert(dateMap);
        printCollection(dateSet);
    }

    static Set<LocalDateTime> convert(Map<LocalDate, List<LocalTime>> sourceMap) {
        HashSet<LocalDateTime> toSet  = new HashSet<>();

        for (Map.Entry<LocalDate, List<LocalTime>> conv: sourceMap.entrySet()) {
            LocalDate localDate = conv.getKey();
            List<LocalTime> localTime = conv.getValue();

            for (LocalTime time: localTime) {
                toSet.add(LocalDateTime.of(localDate, time));
            }
        }
        return toSet;
    }

    static void printCollection(Collection<?> collection) {
        System.out.println("-----------------------------------------------------");
        collection.forEach(System.out::println);
    }
}