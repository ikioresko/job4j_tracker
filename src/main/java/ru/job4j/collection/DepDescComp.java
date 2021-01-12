package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o2.compareTo(o1); // Сортировка по убыванию
    }
   // int rslt = o2.compareTo(o1); сортировка по убыванию
   // return rslt == 0 ? o1.compareTo(o2) : rslt; если элементы равны то сортировка по возрастанию
    // Но ни в в первом ни во втором случае тесты которые даны в задании не пройдет
}