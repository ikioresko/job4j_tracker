package ru.job4j.collection;

import java.util.HashSet;

public class UniqueText {
    public static boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        for (String show : origin) {
            check.add(show);
        }
        for (String dblckt : text) {
           if (!check.contains(dblckt)) {
               rsl = false;
               break;
           }
        }
        return rsl;
    }
}
