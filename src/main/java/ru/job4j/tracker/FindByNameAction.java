package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
    private final Output out;

    public  FindByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find Items by name";
    }
    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find Items by name ====");
        String name = input.askStr("Enter name: ");
        Item [] items = tracker.findByName(name);
        if (items.length > 0) {
            for (int i = 0; i < items.length; i++) {
                Item it = items[i];
                out.println(it);
            }
        } else {
            out.println("Заявки с таким именем не найдены");
        }
        return true;
    }
}
