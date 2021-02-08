package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {
    private static List<Integer> list;

    public static EasyStream of(List<Integer> source) {
        return new Builder()
                .buildList(source)
                .build();
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        List<Integer> temp = new ArrayList<>();
        for (Integer i : list) {
            temp.add(fun.apply(i));
        }
        return new Builder()
                .buildList(temp)
                .build();
    }

    public EasyStream filter(Predicate<Integer> fun) {
        List<Integer> temp = new ArrayList<>();
        for (Integer i : list) {
            if (fun.test(i)) {
                temp.add(i);
            }
        }
        return new Builder()
                .buildList(temp)
                .build();
    }

    public List<Integer> collect() {
        return list;
    }

    public static class Builder {
        private List<Integer> list;

        Builder buildList(List<Integer> list) {
            this.list = list;
            return this;
        }

        EasyStream build() {
            EasyStream newEasyStream = new EasyStream();
            EasyStream.list = list;
            return newEasyStream;
        }
    }
}
