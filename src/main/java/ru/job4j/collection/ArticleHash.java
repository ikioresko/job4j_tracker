package ru.job4j.collection;

import java.util.Arrays;
import java.util.HashSet;

public class ArticleHash {
    public static boolean generateBy(String origin, String line) {
        HashSet<String> original = new HashSet<>(Arrays.asList(origin.replaceAll("[,.!]", "").split(" ")));
        HashSet<String> copy = new HashSet<>(Arrays.asList(line.split(" ")));
        for (String s : copy) {
            if (!original.contains(s)) {
                return false;
            }
        }
        return true;
    }
}
