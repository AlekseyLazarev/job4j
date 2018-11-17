package ru.alazarev.tracker;

import java.util.ArrayList;
import java.util.List;

/**
 * Class MenuTracker решение задачи части 002.
 * Урок 4.6. Доработать тесты в StartUITest проверяющие вывод данных в консоль. [#33585].
 *
 * @author Aleksey Lazarev
 * @since 17.11.2018
 */

public class MenuTracker {

    private Input input;
    private Tracker tracker;
    private List<UserAction> actions = new ArrayList<>();
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
     * @param input   Object type Input.
     * @param tracker Object type Tracker.
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
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
     * Method fill List actions.
     */
    public void fillActions() {
        this.actions.add(new AddItem());
        this.actions.add(new ShowAll());
        this.actions.add(new MenuTracker.EditItem());
        this.actions.add(new MenuTracker.DeleteItem());
        this.actions.add(new FindItemById());
        this.actions.add(new FindItemsByName());
        this.actions.add(new Exit());
    }

    /**
     * Метод для получения массива меню.
     *
     * @return длину массива
     */
    public int getActionsLentgh() {
        return this.actions.size();
    }

    /**
     * Method run action by key.
     *
     * @param key Action key.
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    /**
     * Show menu list.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(info(action));
            }
        }
    }

    /**
     * Method return information about this menu action.
     *
     * @return String menu.
     */
    public String info(UserAction action) {
        return MENU[action.key()];
    }

    /**
     * Class AddItem implements UserAction interface.
     */
    private class AddItem implements UserAction {

        @Override
        public int key() {
            return 0;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("___ ADD NEW ITEM ___");
            String name = input.ask("Input name: ");
            String desc = input.ask("Input description");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.printf("___ NEW ITEM WITH ID: %s ___%n", item.getId());
        }

    }

    /**
     * Class ShowAll implements UserAction interface.
     */
    private class ShowAll implements UserAction {

        @Override
        public int key() {
            return 1;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("___ START SHOW ALL ITEM ___");
            Item[] items = tracker.findAll();
            printItems(items);
            System.out.println("___ END SHOW ALL ITEM ___");
        }
    }

    /**
     * Class Edit implements UserAction interface.
     */
    private static class EditItem implements UserAction {

        @Override
        public int key() {
            return 2;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("___ EDIT ITEM ___");
            String replaceId = input.ask("Input ID old item");
            String name = input.ask("Input new name: ");
            String desc = input.ask("Input new description");
            Item item = new Item(name, desc);
            Boolean result = tracker.replace(replaceId, item);
            System.out.printf("___ RESULT ITEM EDIT IS %s ___%n", result.toString());
        }

    }

    /**
     * Class Delete implements UserAction interface.
     */
    private static class DeleteItem implements UserAction {

        @Override
        public int key() {
            return 3;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("___ DELETE ITEM ___");
            String delId = input.ask("Input ID item for delete");
            Boolean result = tracker.delete(delId);
            System.out.printf("___ DELETE ITEM IS %s ___%n", result.toString());
        }


    }

    /**
     * Class FindItemById implements UserAction interface.
     */
    private class FindItemById implements UserAction {

        @Override
        public int key() {
            return 4;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("___ FIND ITEM BY ID___");
            String findId = input.ask("Input ID item for found");
            printItems(new Item[]{tracker.findById(findId)});
            System.out.println("___ FOUND ITEM BY ID ___");
        }

    }

    /**
     * Class FindItemsByName implements UserAction interface.
     */
    private class FindItemsByName implements UserAction {

        @Override
        public int key() {
            return 5;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("___ FIND ITEMS BY NAME ___");
            String name = input.ask("Input name: ");
            Item[] items = tracker.findByName(name);
            printItems(items);
            System.out.println("___ FOUNDED ITEMS BY NAME ___");
        }


    }

    /**
     * Class Exit implements UserAction interface.
     */
    private class Exit implements UserAction {

        @Override
        public int key() {
            return 6;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("___ EXIT PROGRAM ___");
        }


    }

}
