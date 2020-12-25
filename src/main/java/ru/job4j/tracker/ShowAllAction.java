package ru.job4j.tracker;

import java.util.List;

public class ShowAllAction implements UserAction {
    private final Output out;

    public  ShowAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Show all Item ====");
        List<Item> item = tracker.findAll();
        for (Item show: item) {
            out.println(show);
        }
        return true;
    }
}
