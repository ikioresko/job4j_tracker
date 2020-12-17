package ru.job4j.tracker.enm;

import ru.job4j.tracker.Tracker;

public class TrackerSingleTwo {
    private static Tracker instance;

    private TrackerSingleTwo() {
    }

    public static Tracker getInstance() {
        if (instance == null) {
            instance = new Tracker();
        }
        return instance;
    }

    public static void main(String[] args) {
        Tracker tracker  = TrackerSingleTwo.getInstance();
    }
}
