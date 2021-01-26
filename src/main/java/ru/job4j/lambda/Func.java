package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Func {
    public static List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> dl = new ArrayList<>();
        for (double i = start; i < end; i++) {
            dl.add(func.apply(i));
        }
        return dl;
    }

    public static List<Double> linear(int s, int e) {
        Function<Double, Double> func = x -> 2 * x + 1;
        return diapason(s, e, func);
    }

    public static List<Double> quad(int s, int e) {
        Function<Double, Double> func = x -> ((2 * x) * (2 * x)) + (1 * x) + 0;
        return diapason(s, e, func);
    }

    public static List<Double> indicative(int s, int e) {
        Function<Double, Double> func = x -> Math.pow(2, x);
        return diapason(s, e, func);
    }
}