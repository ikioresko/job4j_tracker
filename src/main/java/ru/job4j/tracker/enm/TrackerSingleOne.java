package ru.job4j.tracker.enm;

import ru.job4j.tracker.Tracker;

public enum TrackerSingleOne {
    INSTANCE;
    private static Tracker tracker = new Tracker();

    public static Tracker getTracker() {
        return tracker;
    }

    public static void main(String[] args) {
        Tracker tracker = INSTANCE.getTracker();
    }
}
