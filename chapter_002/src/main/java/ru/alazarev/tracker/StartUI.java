package ru.alazarev.tracker;

/**
 * Class StartUI решение задачи части 002. Урок 4.1. Используя класс ConsoleInput в классе StartUI
 * обеспечить полноценную работу всего приложения [#784].
 *
 * @author Aleksey Lazarev
 * @since 15.11.2018
 */
public class StartUI {
    /**
     * Storage link to object class Input.
     */
    private final Input input;
    /**
     * Storage link to object class Tracker.
     */
    private final Tracker tracker;

    /**
     * Constructor.
     *
     * @param input   Input scanner instance.
     * @param tracker Created tracker instance.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Initiating method.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        int[] range = new int[menu.getActionsLength()];
        for (int index = 0; index < menu.getActionsLength(); index++) {
            range[index] = index;
        }
        do {
            menu.show();
            menu.select(this.input.ask("Select menu item: ", range));
        } while (!menu.isExit());
    }

    /**
     * Point to start program.
     *
     * @param args Arguments.
     */
    public static void main(String[] args) {
        Input input = new ValidateInput(new ConsoleInput());
        new StartUI(input, new Tracker()).init();
    }
}
