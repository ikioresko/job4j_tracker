package ru.job4j.stream;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Matrix {
    public static void main(String[] args) {
        Integer[][] matrix = {{1, 2, 3}, {4, 5, 6}};
        System.out.println(Stream.of(matrix).flatMap(Arrays::stream).collect(Collectors.toList()));
    }
}
