package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    public List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .sorted(Comparator.comparing(ad -> ad.getAddress().getCity()))
                .map(Profile::getAddress)
                .distinct()
                .collect(Collectors.toList());
    }
}