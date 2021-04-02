package ru.job4j.tracker.enm;

import ru.job4j.tracker.MemTracker;

public class TrackerSingleTwo {
    private static MemTracker instance;

    private TrackerSingleTwo() {
    }

    public static MemTracker getInstance() {
        if (instance == null) {
            instance = new MemTracker();
        }
        return instance;
    }

    public static void main(String[] args) {
        MemTracker tracker  = TrackerSingleTwo.getInstance();
    }
}
