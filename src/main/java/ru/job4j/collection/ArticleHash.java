package ru.job4j.collection;

import java.util.Arrays;
import java.util.HashSet;

public class ArticleHash {
    public static boolean generateBy(String origin, String line) {
        int count = 0;
        HashSet<String> original = new HashSet<>(Arrays.asList(origin.split(" ")));
        HashSet<String> copy = new HashSet<>(Arrays.asList(line.split(" ")));
        for (String o : copy) {
            for (String c : original) {
                if (c.contains(o)) {
                    count++;
                    break;
                }
            }
        }
        return count == copy.size();
    }
}
