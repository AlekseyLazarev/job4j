package ru.alazarev.tracker;

public class StartUI {
    private final Input input;
    private final Tracker tracker;
    private static final String[] menu = {"0. Add new Item",
            "1. Show all items",
            "2. Edit item",
            "3. Delete item",
            "4. Find item by Id",
            "5. Find items by name",
            "6. Exit Program"};

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init() {
        ConsoleInput input = new ConsoleInput();
        boolean exit = false;
        while (exit) {
            System.out.println("Выберете пункт меню:");

            switch (input.toString()) {
                case "0":
                    System.out.print("some");
                    break;
            }
        }
        Tracker tracker = new Tracker();

    }

    public static void main(String[] args) {
        new StartUI(new ConsoleInput(),new Tracker()).init();

    }
}
