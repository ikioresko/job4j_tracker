package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String temp1 = o1.substring(0, o1.indexOf("/"));
        String temp2 = o2.substring(0, o2.indexOf("/"));
        int rslt = temp2.compareTo(temp1);
        return rslt == 0 ? temp1.compareTo(temp2) : rslt;
    }
}