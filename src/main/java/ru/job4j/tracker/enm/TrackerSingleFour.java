package ru.job4j.tracker.enm;

import ru.job4j.tracker.MemTracker;

public class TrackerSingleFour {
    private TrackerSingleFour() {
    }

    public static MemTracker getInstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final MemTracker INSTANCE = new MemTracker();
    }

    public static void main(String[] args) {
        MemTracker tracker = TrackerSingleFour.getInstance();
    }
}
