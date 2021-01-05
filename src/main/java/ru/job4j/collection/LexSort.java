package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String numLeft = left.substring(0, left.indexOf('.'));
        String numRight = right.substring(0, right.indexOf('.'));
        int lnum = Integer.parseInt(numLeft);
        int rnum = Integer.parseInt(numRight);
        return Integer.compare(lnum, rnum);
    }
}