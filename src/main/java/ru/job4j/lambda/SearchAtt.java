package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchAtt {
    private static List<Attachment> filter(List<Attachment> attachment,
                                           Predicate<Attachment> predicate) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : attachment) {
            if (predicate.test(att)) {
                rsl.add(att);
            }
        }
        return rsl;
    }

    public static List<Attachment> size(List<Attachment> list) {
        Predicate<Attachment> predicate = attachment -> attachment.getSize() > 100;
        return filter(list, predicate);
    }

    public static List<Attachment> names(List<Attachment> list) {
        Predicate<Attachment> predicate = attachment -> attachment.getName().contains("bug");
        return filter(list, predicate);
    }

    public static void main(String[] args) {
        List<Attachment> alist = List.of(new Attachment("one", 115),
                new Attachment("two", 211),
                new Attachment("three", 32),
                new Attachment("bugss", 47));
        System.out.println(names(alist));
        System.out.println(size(alist));
    }
}