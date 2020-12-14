package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {
    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu() {
        System.out.println("Menu."
                + System.lineSeparator() +"0. Add new Item"
                        + System.lineSeparator() + "1. Show all items"
                        + System.lineSeparator() + "2. Edit item"
                        + System.lineSeparator() + "3. Delete item"
                        + System.lineSeparator() + "4. Find item by Id"
                        + System.lineSeparator() + "5. Find items by name"
                + System.lineSeparator() + "6. Exit Program");
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {new CreateAction(), new ShowAllAction(), new EditAction(), new DeleteAction(),
                 new FindByIdAction(), new FindByNameAction(), new ExitAction()};
        new StartUI().init(input, tracker, actions);
    }
}