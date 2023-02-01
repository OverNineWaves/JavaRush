package com.javarush.task.pro.task16.task1616;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.TreeSet;

/* 
Тренировка временных зон
*/

public class Solution {

    public static void main(String[] args) {
        TreeSet<String> sortedZones = getSortedZones();
        System.out.println(sortedZones.size());
        System.out.println(sortedZones.first());
        System.out.println(sortedZones.last());

        System.out.println(getBeijingDateTime());
    }

    static TreeSet<String> getSortedZones() {
        //напишите тут ваш код
        TreeSet<String> treeSet = new TreeSet<>();
        for (String Set: ZoneId.getAvailableZoneIds()) {
            treeSet.add(Set);
        }
        return treeSet;
    }

    static ZonedDateTime getBeijingDateTime() {
        //напишите тут ваш код
        ZoneId zoneId = ZoneId.of("Asia/Shanghai");
        ZonedDateTime time = ZonedDateTime.now();
        return time;
    }
}
