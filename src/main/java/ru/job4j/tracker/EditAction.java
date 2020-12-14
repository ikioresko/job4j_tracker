package ru.job4j.tracker;

public class EditAction implements UserAction {
    private final Output out;

    public  EditAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Edit Item";
    }
    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Edit Item ====");
        int id = input.askInt("Enter id: ");
        String name = input.askStr("Enter new name: ");
        Item item = new Item();
        item.setName(name);
        if (tracker.replace(id, item)) {
            out.println("Completed");
        } else {
            out.println("Error");
        }
        return true;
    }
}
