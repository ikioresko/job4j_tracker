package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = 0;
        int length = left.length();
        int i = 0;
        if (left.length() < right.length()) {
            length = right.length();
        }
        while (length != 0) {
            if (left.length() <= i) {
               return Character.compare('0', right.charAt(i));
            }
            if (right.length() <= i) {
                return Character.compare(left.charAt(i), '0');
            }
            result = Character.compare(left.charAt(i), right.charAt(i));
            if (result != 0) {
                return result;
            }
            length--;
            i++;
        }
        return result;
    }
}
