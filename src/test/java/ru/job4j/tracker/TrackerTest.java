package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item();
        item.setName("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenFindAll() {
        Tracker tracker = new Tracker();
        Item[] items = {new Item("test"), new Item("test2"), new Item("test3")};
        tracker.add(new Item("test"));
        tracker.add(new Item("test2"));
        tracker.add(new Item("test3"));
        assertThat(items[0].getName(), is(tracker.findAll()[0].getName()));
        assertThat(items[1].getName(), is(tracker.findAll()[1].getName()));
        assertThat(items[2].getName(), is(tracker.findAll()[2].getName()));
    }

    @Test
    public void whenFindByName() {
        Tracker tracker = new Tracker();
        Item[] items = {new Item("test"), new Item("test2"), new Item("test3")};
        tracker.add(new Item("test"));
        tracker.add(new Item("test2"));
        tracker.add(new Item("test3"));
        tracker.add(new Item("test"));
        assertThat(items[0].getName(), is(tracker.findByName("test")[0].getName()));
        assertThat(items[0].getName(), is(tracker.findByName("test")[1].getName()));
    }
}