package ru.job4j.tracker.enm;

import ru.job4j.tracker.MemTracker;

import org.junit.Test;
import static org.junit.Assert.assertSame;
import static ru.job4j.tracker.enm.TrackerSingleOne.INSTANCE;

public class MemTrackerSingleOneTest {
    @Test
    public void whenEnumTracker() {
        MemTracker tracker = INSTANCE.getTracker();
        MemTracker tracker2 = INSTANCE.getTracker();
        assertSame(tracker, tracker2);
    }

    @Test
    public void whenStaticFieldLazyTracker() {
        MemTracker tracker  = TrackerSingleTwo.getInstance();
        MemTracker tracker2  = TrackerSingleTwo.getInstance();
        assertSame(tracker, tracker2);
    }

    @Test
    public void whenStaticFinalFieldEagerTracker() {
        MemTracker tracker = TrackerSingleThree.getInstance();
        MemTracker tracker2 = TrackerSingleThree.getInstance();
        assertSame(tracker, tracker2);
    }

    @Test
    public void whenPrivateStaticFinalClassLazyTracker() {
        MemTracker tracker = TrackerSingleFour.getInstance();
        MemTracker tracker2 = TrackerSingleFour.getInstance();
        assertSame(tracker, tracker2);
    }
}