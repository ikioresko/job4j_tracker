package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    private static final String LN = System.lineSeparator();

    public Connection init() {
        try (InputStream in = SqlTracker.class.getClassLoader()
                .getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            return DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Test
    public void createItem() {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("name"));
            assertThat(tracker.findByName("name").size(), is(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenFindAll() {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("name"));
            assertThat(tracker.findAll().size(), is(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void finByID() {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item = tracker.add(new Item("name"));
            assertThat(tracker.findById(item.getId()), is(item));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void finByName() {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("name"));
            assertThat(tracker.findByName("name").size(), is(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void replaceItem() {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item = tracker.add(new Item("name"));
            boolean replace = tracker.replace(item.getId(), new Item("new_name"));
            assertThat(replace, is(true));
            assertThat(tracker.findByName("new_name").size(), is(1));
            assertThat(tracker.findByName("name").size(), is(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteItem() {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item = tracker.add(new Item("name"));
            assertThat(tracker.findAll().size(), is(1));
            tracker.delete(item.getId());
            assertThat(tracker.findAll().size(), is(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenFindAllMenu() {
        Output out = new StubOutput();
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Input in = new StubInput(
                    new String[]{"0", "1"});
            UserAction[] actions = {new ShowAllAction(out), new ExitAction(out)};
            new StartUI(out).init(in, tracker, actions);
            Assert.assertEquals("Menu."
                    + LN + "0. Show all Item"
                    + LN + "1. Exit"
                    + LN + "=== Show all Item ===="
                    + LN + "Menu."
                    + LN + "0. Show all Item"
                    + LN + "1. Exit"
                    + LN, out.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenFindByNameMenu() {
        Output out = new StubOutput();
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Input in = new StubInput(
                    new String[]{"0", "name", "1"});
            UserAction[] actions = {new FindByNameAction(out), new ExitAction(out)};
            new StartUI(out).init(in, tracker, actions);
            Assert.assertEquals("Menu."
                    + LN + "0. Find Items by name"
                    + LN + "1. Exit"
                    + LN + "=== Find Items by name ===="
                    + LN + "Menu."
                    + LN + "0. Find Items by name"
                    + LN + "1. Exit"
                    + LN, out.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenFindByIdMenu() {
        Output out = new StubOutput();
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            String id = String.valueOf(1);
            Input in = new StubInput(
                    new String[]{"0", id, "1"});
            UserAction[] actions = {new FindByIdAction(out), new ExitAction(out)};
            new StartUI(out).init(in, tracker, actions);
            Assert.assertEquals("Menu."
                    + LN + "0. Find Item by Id"
                    + LN + "1. Exit"
                    + LN + "=== Find Item by Id ===="
                    + LN + "Заявка с таким id не найдена"
                    + LN + "Menu."
                    + LN + "0. Find Item by Id"
                    + LN + "1. Exit"
                    + LN, out.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenExitMenu() {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Output out = new StubOutput();
            Input in = new StubInput(
                    new String[]{"0"}
            );
            UserAction[] actions = {new ExitAction(out)};
            new StartUI(out).init(in, tracker, actions);
            Assert.assertEquals("Menu."
                    + LN + "0. Exit"
                    + LN, out.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenInvalidExit() {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Output out = new StubOutput();
            Input in = new StubInput(new String[]{"1", "0"});
            UserAction[] actions = {new ExitAction(out)};
            new StartUI(out).init(in, tracker, actions);
            Assert.assertEquals("Menu."
                    + LN + "0. Exit"
                    + LN + "Wrong input, you can select: 0 .. 0"
                    + LN + "Menu."
                    + LN + "0. Exit"
                    + LN, out.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}