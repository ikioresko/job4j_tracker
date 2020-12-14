package ru.job4j.tracker;

public class EditAction implements UserAction {
    @Override
    public String name() {
        return "===  Edit Item ====";
    }
    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter id: ");
        String name = input.askStr("Enter new name: ");
        Item item = new Item();
        item.setName(name);
        if (tracker.replace(id, item)) {
            System.out.println("Completed");
        } else {
            System.out.println("Error");
        }
        return true;
    }
}
