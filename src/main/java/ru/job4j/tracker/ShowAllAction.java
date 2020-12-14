package ru.job4j.tracker;

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
        Item [] item = tracker.findAll();
        if (item.length > 0) {
            for (int i = 0; i < item.length; i++) {
                Item show = item[i];
                out.println(show);
            }
        } else {
            out.println("Заявок не найдено");
        }
        return true;
    }
}
