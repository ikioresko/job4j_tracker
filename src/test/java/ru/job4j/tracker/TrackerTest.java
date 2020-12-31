package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
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
        assertThat(items[0].getName(), is(tracker.findAll().get(0).getName()));
        assertThat(items[1].getName(), is(tracker.findAll().get(1).getName()));
        assertThat(items[2].getName(), is(tracker.findAll().get(2).getName()));
    }

    @Test
    public void whenFindByName() {
        Tracker tracker = new Tracker();
        Item[] items = {new Item("test"), new Item("test2"), new Item("test3")};
        tracker.add(new Item("test"));
        tracker.add(new Item("test2"));
        tracker.add(new Item("test3"));
        tracker.add(new Item("test"));
        assertThat(items[0].getName(), is(tracker.findByName("test").get(0).getName()));
        assertThat(items[1].getName(), is(tracker.findByName("test2").get(0).getName()));
    }

    @Test
    public void whenReplace() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        Item bugWithDesc = new Item();
        bugWithDesc.setName("Bug with description");
        tracker.replace(id, bugWithDesc);
        assertThat(tracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenDelete() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
    }

    @Test
    public void whenSortFromBigToSmall() {
        List<Item> expected = new ArrayList<Item>();
        expected.add (new Item(3, "test3"));
        expected.add (new Item(2,"test2"));
        expected.add (new Item(1,"test1"));
        Tracker tracker = new Tracker();
        tracker.add(new Item("test1"));
        tracker.add(new Item("test2"));
        tracker.add(new Item("test3"));
        List<Item> original = tracker.findAll();
        Collections.sort(original, new SortToSmall());
        assertThat(expected, is(original));
    }

    @Test
    public void whenSortFromSmallToBig() {
        List<Item> sorted = new ArrayList<Item>();
        sorted.add (new Item(3, "test3"));
        sorted.add (new Item(2,"test2"));
        sorted.add (new Item(1,"test1"));
        Tracker tracker = new Tracker();
        tracker.add(new Item("test1"));
        tracker.add(new Item("test2"));
        tracker.add(new Item("test3"));
        List<Item> original = tracker.findAll();
        Collections.sort(sorted, new SortToBig());
        assertThat(sorted, is(original));
    }
}