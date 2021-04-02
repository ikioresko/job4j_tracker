package ru.job4j.tracker.enm;

import ru.job4j.tracker.MemTracker;

public enum TrackerSingleOne {
    INSTANCE;
    private static MemTracker tracker = new MemTracker();

    public static MemTracker getTracker() {
        return tracker;
    }

    public static void main(String[] args) {
        MemTracker tracker = INSTANCE.getTracker();
    }
}
