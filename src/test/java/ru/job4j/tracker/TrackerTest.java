package ru.job4j.tracker;

import org.junit.Assert;
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
        Item[] items = new Item[100];
        tracker.add(new Item("test"));
        tracker.add(new Item("test2"));
        tracker.add(new Item("test3"));
        Item[] result = tracker.findAll(items);
        Assert.assertArrayEquals(new Item[3], result);
    }

    @Test
    public void whenFindByName() {
        Tracker tracker = new Tracker();
        Item[] items = new Item[100];
        tracker.add(new Item("test"));
        tracker.add(new Item("test2"));
        tracker.add(new Item("test3"));
        Item[] result = tracker.findByName("test5");
        for (int i = 0; i < result.length; i++) {
            Item it = result[i];
        assertThat("test2", is(it.getName()));
        }
    }
}