package ru.job4j.tracker.enm;

import ru.job4j.tracker.MemTracker;

public class TrackerSingleThree {
    private static final MemTracker INSTANCE = new MemTracker();

    private TrackerSingleThree() {
    }

    public static MemTracker getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        MemTracker tracker = TrackerSingleThree.getInstance();
    }
}
