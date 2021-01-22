package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchAtt {
    private static List<Attachment> filter(List<Attachment> attachment, Predicate<Attachment> predicate) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : attachment) {
            if (predicate.test(att)) {
                rsl.add(att);
            }
        }
        return rsl;
    }

    public static List<Attachment> size(List<Attachment> list) {
        Predicate<Attachment> predicate = new Predicate<Attachment>() {
            @Override
            public boolean test(Attachment attachment) {
                return attachment.getSize() > 100;
            }
        };
        return filter(list, predicate);
    }

    public static List<Attachment> names(List<Attachment> list) {
        Predicate<Attachment> predicate = new Predicate<Attachment>() {
            @Override
            public boolean test(Attachment attachment) {
                return attachment.getName().contains("bug");
            }
        };
        return filter(list, predicate);
    }

    public static void main(String[] args) {
        Attachment attachment1 = new Attachment("one", 115);
        Attachment attachment2 = new Attachment("two", 211);
        Attachment attachment3 = new Attachment("three", 32);
        Attachment attachment4 = new Attachment("bugss", 47);
        List<Attachment> alist = new ArrayList<>();
        alist.add(attachment1);
        alist.add(attachment2);
        alist.add(attachment3);
        alist.add(attachment4);
        System.out.println(names(alist));
        System.out.println(size(alist));
    }
}