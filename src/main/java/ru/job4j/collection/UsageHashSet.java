package ru.job4j.collection;

import java.util.HashSet;

public class UsageHashSet {
    public static void main(String[] args) {
        HashSet<String> auto = new HashSet<String>();
        auto.add("Lada");
        auto.add("BMW");
        auto.add("Volvo");
        auto.add("Toyota");
        for (String show: auto){
            System.out.println(show);
        }
    }
}
