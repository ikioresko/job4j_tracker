package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class StartUITest {
//    private static final String LN = System.lineSeparator();
//
//    @Test
//    public void whenCreateItem() {
//        Output out = new StubOutput();
//        Input in = new StubInput(new String[] {"0", "TestName", "1"});
//        MemTracker tracker = new MemTracker();
//        List<UserAction> actions = new ArrayList<>();
//        actions.add(new CreateAction(out));
//        actions.add(new ExitAction(out));
//        new StartUI(out).init(in, tracker, actions);
//        Assert.assertEquals("TestName", tracker.findAll().get(0).getName());
//    }
//
//    @Test
//    public void whenFindAll() {
//        Output out = new StubOutput();
//        Input in = new StubInput(
//                new String[] {"0", "1"}
//        );
//        MemTracker tracker = new MemTracker();
//        Item item = tracker.add(new Item("TestName"));
//        List<UserAction> actions = new ArrayList<>();
//        actions.add(new ShowAllAction(out));
//        actions.add(new ExitAction(out));
//        new StartUI(out).init(in, tracker, actions);
//        Assert.assertEquals("TestName", tracker.findAll().get(0).getName());
//    }
//
//    @Test
//    public void whenFindById() {
//        Output out = new StubOutput();
//        MemTracker tracker = new MemTracker();
//        Item item = tracker.add(new Item("New item"));
//        String id = String.valueOf(item.getId());
//        Input in = new StubInput(
//                new String[] {"0", id, "1"});
//        List<UserAction> actions = new ArrayList<>();
//        actions.add(new FindByIdAction(out));
//        actions.add(new ExitAction(out));
//        new StartUI(out).init(in, tracker, actions);
//        Assert.assertEquals("New item", tracker.findById(item.getId()).getName());
//    }
//
//    @Test
//    public void whenFindByName() {
//        Output out = new StubOutput();
//        MemTracker tracker = new MemTracker();
//        Item item = tracker.add(new Item("New task"));
//        String name = String.valueOf(item.getName());
//        Input in = new StubInput(
//                new String[] {"0", name, "1"});
//        List<UserAction> actions = new ArrayList<>();
//        actions.add(new FindByNameAction(out));
//        actions.add(new ExitAction(out));
//        new StartUI(out).init(in, tracker, actions);
//        Assert.assertEquals("New task", tracker.findById(item.getId()).getName());
//        Assert.assertEquals("1", String.valueOf(item.getId()));
//    }
//
//    @Test
//    public void whenReplaceItem() {
//        Output out = new StubOutput();
//        MemTracker tracker = new MemTracker();
//        Item item = tracker.add(new Item("Replaced item"));
//        String it = String.valueOf(item.getId());
//        String replacedName = "New item name";
//        Input in = new StubInput(
//                new String[] {"0", it, replacedName, "1"}
//        );
//        List<UserAction> actions = new ArrayList<>();
//        actions.add(new EditAction(out));
//        actions.add(new ExitAction(out));
//        new StartUI(out).init(in, tracker, actions);
//        Assert.assertEquals(replacedName, tracker.findById(item.getId()).getName());
//    }
//
//    @Test
//    public void whenDeleteItem() {
//        Output out = new StubOutput();
//        MemTracker tracker = new MemTracker();
//        Item item = tracker.add(new Item("Deleted item"));
//        String it = String.valueOf(item.getId());
//        Input in = new StubInput(
//                new String[] {"0", it, "1"}
//        );
//        List<UserAction> actions = new ArrayList<>();
//        actions.add(new DeleteAction(out));
//        actions.add(new ExitAction(out));
//        new StartUI(out).init(in, tracker, actions);
//        Assert.assertEquals(null, tracker.findById(item.getId()));
//    }
//
//    @Test
//    public void whenExit() {
//        Output out = new StubOutput();
//        Input in = new StubInput(
//                new String[] {"0"}
//        );
//        MemTracker tracker = new MemTracker();
//        List<UserAction> actions = new ArrayList<>();
//        actions.add(new ExitAction(out));
//        new StartUI(out).init(in, tracker, actions);
//        Assert.assertEquals("Menu." + LN + "0. Exit" + LN, out.toString());
//    }
//
//    @Test
//    public void whenFindAllMenu() {
//        Output out = new StubOutput();
//        MemTracker tracker = new MemTracker();
//        Input in = new StubInput(
//                new String[] {"0", "1"}
//        );
//        List<UserAction> actions = new ArrayList<>();
//        actions.add(new ShowAllAction(out));
//        actions.add(new ExitAction(out));
//        new StartUI(out).init(in, tracker, actions);
//        Assert.assertEquals("Menu." + LN + "0. Show all Item"
//                + LN + "1. Exit" + LN + "=== Show all Item ====" + LN + "Menu."
//                + LN + "0. Show all Item" + LN + "1. Exit" + LN, out.toString());
//    }
//
//    @Test
//    public void whenFindByNameMenu() {
//        Output out = new StubOutput();
//        Item item = new Item();
//        MemTracker tracker = new MemTracker();
//        String name = String.valueOf(item.getName());
//        Input in = new StubInput(
//                new String[] {"0", name, "1"});
//        List<UserAction> actions = new ArrayList<>();
//        actions.add(new FindByNameAction(out));
//        actions.add(new ExitAction(out));
//        new StartUI(out).init(in, tracker, actions);
//        Assert.assertEquals("Menu." + LN + "0. Find Items by name"
//                + LN + "1. Exit" + LN + "=== Find Items by name ===="
//                + LN + "Menu." + LN + "0. Find Items by name" + LN
//                + "1. Exit" + LN, out.toString());
//    }
//
//    @Test
//    public void whenFindByIdMenu() {
//        Output out = new StubOutput();
//        MemTracker tracker = new MemTracker();
//        Item item = new Item();
//        String id = String.valueOf(item.getId());
//        Input in = new StubInput(
//                new String[] {"0", id, "1"});
//        List<UserAction> actions = new ArrayList<>();
//        actions.add(new FindByIdAction(out));
//        actions.add(new ExitAction(out));
//        new StartUI(out).init(in, tracker, actions);
//        Assert.assertEquals("Menu." + LN + "0. Find Item by Id"
//                + LN + "1. Exit" + LN + "=== Find Item by Id ====" + LN
//                + "Заявка с таким id не найдена" + LN + "Menu." + LN
//                + "0. Find Item by Id" + LN + "1. Exit" + LN, out.toString());
//    }
//
//    @Test
//    public void whenInvalidExit() {
//        Output out = new StubOutput();
//        Input in = new StubInput(new String[]{"1", "0"});
//        MemTracker tracker = new MemTracker();
//        List<UserAction> actions = new ArrayList<>();
//        actions.add(new ExitAction(out));
//        new StartUI(out).init(in, tracker, actions);
//        Assert.assertEquals("Menu." + LN + "0. Exit" + LN + "Wrong input, you can select: 0 .. 0"
//                + LN + "Menu." + LN + "0. Exit" + LN, out.toString());
//    }
}