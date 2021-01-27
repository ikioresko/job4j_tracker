package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Stream {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = -5; i < 15; i++) {
            list.add(i);
        }
        System.out.println(list);
        List<Integer> sortedList = list.stream().filter(l -> l > 0).collect(Collectors.toList());
        System.out.println(sortedList);
    }
}
