package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    private static final String LN = System.lineSeparator();

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenFindAll() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("New item"));
        UserAction[] actions = {new ShowAllAction(out), new ExitAction(out)};
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("New item"));
    }

    @Test
    public void whenFindById() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("New item"));
        String id = String.valueOf(item.getId());
        Input in = new StubInput(
                new String[] {"0", id, "1"});
        UserAction[] actions = {
                new FindByIdAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is("New item"));
    }

    @Test
    public void whenFindByName() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("New task"));
        String name = String.valueOf(item.getName());
        Input in = new StubInput(
                new String[] {"0", name, "1"});
        UserAction[] actions = {
                new FindByNameAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is("New task"));
        assertThat(String.valueOf(item.getId()), is("1"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String it = String.valueOf(item.getId());
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0", it, replacedName, "1"}
        );
        UserAction[] actions = {
                new EditAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        String it = String.valueOf(item.getId());
        Input in = new StubInput(
                new String[] {"0",it , "1"}
        );
        UserAction[] actions = {
                new DeleteAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + LN + "0. Exit" + LN));
    }

    @Test
    public void whenFindAllMenu() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Input in = new StubInput(
                new String[] {"0","1"}
        );
        UserAction[] actions = {new ShowAllAction(out), new ExitAction(out)};
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + LN + "0. Show all Item"
                + LN + "1. Exit" + LN + "=== Show all Item ====" + LN + "Заявок не найдено" + LN + "Menu."
                + LN + "0. Show all Item" + LN + "1. Exit" + LN));
    }

    @Test
    public void whenFindByNameMenu() {
        Output out = new StubOutput();
        Item item = new Item();
        Tracker tracker = new Tracker();
        String name = String.valueOf(item.getName());
        Input in = new StubInput(
                new String[] {"0", name, "1"});
        UserAction[] actions = {
                new FindByNameAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + LN + "0. Find Items by name"
                + LN + "1. Exit" + LN + "=== Find Items by name ====" + LN  + "Заявки с таким именем не найдены"
                + LN + "Menu." + LN + "0. Find Items by name" + LN + "1. Exit" + LN));
    }

    @Test
    public void whenFindByIdMenu() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = new Item();
        String id = String.valueOf(item.getId());
        Input in = new StubInput(
                new String[] {"0", id, "1"});
        UserAction[] actions = {
                new FindByIdAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + LN + "0. Find Item by Id"
                + LN + "1. Exit" + LN + "=== Find Item by Id ====" + LN + "Заявка с таким id не найдена"
                + LN + "Menu." + LN + "0. Find Item by Id" + LN + "1. Exit" + LN));
    }
}