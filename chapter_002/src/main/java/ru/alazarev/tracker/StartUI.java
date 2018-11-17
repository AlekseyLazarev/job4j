package ru.alazarev.tracker;

/**
 * Class StartUI решение задачи части 002. Урок 4.1. Используя класс ConsoleInput в классе StartUI
 * обеспечить полноценную работу всего приложения [#784].
 *
 * @author Aleksey Lazarev
 * @since 15.11.2018
 */
public class StartUI {
    private final Input input;
    private final Tracker tracker;
    private static final String[] MENU = {"0. Add new Item",
            "1. Show all items",
            "2. Edit item",
            "3. Delete item",
            "4. Find item by Id",
            "5. Find items by name",
            "6. Exit Program"};

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
        ConsoleInput input = new ConsoleInput();
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Select menu item: ");
            switch (answer) {
                case "0":
                    createItem();
                    break;
                case "1":
                    this.showAllItems();
                    break;
                case "2":
                    this.editItem();
                    break;
                case "3":
                    this.deleteItem();
                    break;
                case "4":
                    this.findItemById();
                    break;
                case "5":
                    this.findItemsByName();
                    break;
                case "6":
                    exit = true;
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * Method for showing menu items.
     */
    public void showMenu() {
        System.out.println();
        System.out.println("Menu: ");
        for (String menu : MENU) {
            System.out.println(menu);
        }
    }

    /**
     * Method for create item.
     */
    public void createItem() {
        System.out.println("___ ADD NEW ITEM ___");
        String name = this.input.ask("Input name: ");
        String desc = this.input.ask("Input description");
        Item item = new Item(name, desc);
        tracker.add(item);
        System.out.printf("___ NEW ITEM WITH ID: %s ___%n", item.getId());
    }

    /**
     * Method to display items.
     *
     * @param items Items to display.
     */
    public void printItems(Item[] items) {
        for (Item item : items) {
            System.out.printf("ID: %15s Name: %10s Desc: %20s %n", item.getId(), item.getName(), item.getDesc());
        }
    }

    /**
     * Method for show all items in tracker.
     */
    public void showAllItems() {
        System.out.println("___ START SHOW ALL ITEM ___");
        Item[] items = tracker.findAll();
        printItems(items);
        System.out.println("___ END SHOW ALL ITEM ___");
    }

    /**
     * Method for edit item.
     */
    public void editItem() {
        System.out.println("___ EDIT ITEM ___");
        String replaceId = this.input.ask("Input ID old item");
        String name = this.input.ask("Input new name: ");
        String desc = this.input.ask("Input new description");
        Item item = new Item(name, desc);
        Boolean result = tracker.replace(replaceId, item);
        System.out.printf("___ RESULT ITEM EDIT IS %s ___%n", result.toString());
    }

    /**
     * Method for delete item.
     */
    public void deleteItem() {
        System.out.println("___ DELETE ITEM ___");
        String delId = this.input.ask("Input ID item for delete");
        Boolean result = tracker.delete(delId);
        System.out.printf("___ DELETE ITEM IS %s ___%n", result.toString());
    }

    /**
     * Method for found item by id.
     */
    public void findItemById() {
        System.out.println("___ FIND ITEM BY ID___");
        String findId = this.input.ask("Input ID item for found");
        printItems(new Item[]{tracker.findById(findId)});
        System.out.println("___ FOUND ITEM BY ID ___");
    }

    /**
     * Method for found items by name.
     */
    public void findItemsByName() {
        System.out.println("___ FIND ITEMS BY NAME ___");
        String name = this.input.ask("Input name: ");
        Item[] items = tracker.findByName(name);
        printItems(items);
        System.out.println("___ FOUNDED ITEMS BY NAME ___");
    }

    /**
     * Point to start program.
     *
     * @param args Arguments.
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();

    }
}
