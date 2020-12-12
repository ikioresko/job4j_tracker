package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {
    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                String name = input.askStr("Enter name: ");
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== Show all Item ====");
                Item [] item = tracker.findAll();
                if (item.length > 0) {
                    for (int i = 0; i < item.length; i++) {
                        Item show = item[i];
                        System.out.println(show);
                    }
                } else {
                    System.out.println("Заявок не найдено");
                }
            } else if (select == 2) {
                System.out.println("===  Edit Item ====");
                int id = input.askInt("Enter id: ");
                String name = input.askStr("Enter new name: ");
                Item item = new Item();
                item.setName(name);
                if (tracker.replace(id, item)) {
                    System.out.println("Completed");
                } else {
                    System.out.println("Error");
                }
            } else if (select == 3) {
                System.out.println("===  Delete Item ====");
                int id = input.askInt("Enter id: ");
                if (tracker.delete(id)) {
                    System.out.println("Completed");
                } else {
                    System.out.println("Error");
                }
            } else if (select == 4) {
                System.out.println("===  Find Item by Id ====");
                int id = input.askInt("Enter id: ");
                Item item = tracker.findById(id);
                if (item == null) {
                    System.out.println("Заявка с таким id не найдена");
                } else {
                    System.out.println("Item name: " + item);
                }
            } else if (select == 5) {
                System.out.println("===  Find Items by name ====");
                String name = input.askStr("Enter name: ");
                Item [] items = tracker.findByName(name);
                if (items.length > 0) {
                    for (int i = 0; i < items.length; i++) {
                        Item it = items[i];
                        System.out.println(it);
                    }
                } else {
                    System.out.println("Заявки с таким именем не найдены");
                }
            }
             else if (select == 6) {
                run = false;
            }
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
        new StartUI().init(input, tracker);
    }
}