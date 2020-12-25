package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("example@gmail.com", "Федоров Владимир Петрович");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.print("Key is: " + key + System.lineSeparator() + "Value is: " + value);
        }
    }
}
