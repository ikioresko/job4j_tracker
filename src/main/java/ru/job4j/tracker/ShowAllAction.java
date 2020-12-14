package ru.job4j.tracker;

public class ShowAllAction implements UserAction {
    @Override
    public String name() {
        return "=== Show all Item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item [] item = tracker.findAll();
        if (item.length > 0) {
            for (int i = 0; i < item.length; i++) {
                Item show = item[i];
                System.out.println(show);
            }
        } else {
            System.out.println("Заявок не найдено");
        }
        return true;
    }
}
