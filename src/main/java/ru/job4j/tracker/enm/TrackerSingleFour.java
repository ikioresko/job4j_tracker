package ru.job4j.tracker.enm;

import ru.job4j.tracker.Tracker;

public class TrackerSingleFour {
    private TrackerSingleFour() {
    }

    public static Tracker getInstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final Tracker INSTANCE = new Tracker();
    }

    public static void main(String[] args) {
        Tracker tracker = TrackerSingleFour.getInstance();
    }
}
