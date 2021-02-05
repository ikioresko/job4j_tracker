package ru.job4j.collection;

import java.util.*;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        int i = 1;
        List<String> origin = Arrays.asList(left.split(""));
        List<String> dubl = Arrays.asList(right.split(""));
        Collections.sort(origin);
        Collections.sort(dubl);
        Map<Integer, String> hashMap = new HashMap<>();
        for (String s : origin) {
            hashMap.put(i++, s);
        }
        i = 1;
        Map<Integer, String> hashMap2 = new HashMap<>();
        for (String s2 : dubl) {
            hashMap2.put(i++, s2);
        }
        return hashMap.entrySet().stream()
                .allMatch(e -> e.getValue().equals(hashMap2.get(e.getKey())));
    }
}