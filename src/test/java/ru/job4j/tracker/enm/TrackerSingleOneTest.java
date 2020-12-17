package ru.job4j.tracker.enm;

import ru.job4j.tracker.Tracker;

import org.junit.Test;
import static org.junit.Assert.assertSame;
import static ru.job4j.tracker.enm.TrackerSingleOne.INSTANCE;

public class TrackerSingleOneTest {
    @Test
    public void whenEnumTracker() {
        Tracker tracker = INSTANCE.getTracker();
        Tracker tracker2 = INSTANCE.getTracker();
        assertSame(tracker, tracker2);
    }

    @Test
    public void whenStaticFieldLazyTracker() {
        Tracker tracker  = TrackerSingleTwo.getInstance();
        Tracker tracker2  = TrackerSingleTwo.getInstance();
        assertSame(tracker, tracker2);
    }

    @Test
    public void whenStaticFinalFieldEagerTracker() {
        Tracker tracker = TrackerSingleThree.getInstance();
        Tracker tracker2 = TrackerSingleThree.getInstance();
        assertSame(tracker, tracker2);
    }

    @Test
    public void whenPrivateStaticFinalClassLazyTracker() {
        Tracker tracker = TrackerSingleFour.getInstance();
        Tracker tracker2 = TrackerSingleFour.getInstance();
        assertSame(tracker, tracker2);
    }
}