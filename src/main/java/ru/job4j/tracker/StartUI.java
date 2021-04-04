package ru.job4j.tracker;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Store tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.length) {
                out.println("Wrong input, you can select: 0 .. " + (actions.length - 1));
                continue;
            }
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        out.println("Menu.");
        int i = 0;
        for (UserAction show : actions) {
            out.println(i++ + ". " + show.name());
        }
    }

    public static void main(String[] args) {
        Input validate = new ValidateInput(new ConsoleOutput(), new ConsoleInput());
        try (Store tracker = new SqlTracker()) {
            UserAction[] actions = {
                    new CreateAction(new ConsoleOutput()),
                    new ShowAllAction(new ConsoleOutput()),
                    new EditAction(new ConsoleOutput()),
                    new DeleteAction(new ConsoleOutput()),
                    new FindByIdAction(new ConsoleOutput()),
                    new FindByNameAction(new ConsoleOutput()),
                    new ExitAction(new ConsoleOutput())
            };
            new StartUI(new ConsoleOutput()).init(validate, tracker, actions);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}