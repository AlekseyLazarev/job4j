package ru.alazarev.tracker;

        import java.util.ArrayList;
        import java.util.List;

/**
 * Class Edit implements UserAction interface using for edit request tracker.
 *
 * @author Aleksey Lazarev
 * @since 19.11.2018
 */
class EditItem extends BaseAction {
    /**
     * Constructor.
     *
     * @param key  Key of this action.
     * @param name Name of this action.
     */
    public EditItem(int key, String name) {
        super(key, name);
    }

    /**
     * Method starts edit item.
     *
     * @param input   Object type Input
     * @param tracker Object type Tracker
     */
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
 * Class MenuTracker решение задачи части 002.
 * Урок 4.6. Доработать тесты в StartUITest проверяющие вывод данных в консоль. [#33585].
 *
 * @author Aleksey Lazarev
 * @since 17.11.2018
 */
public class MenuTracker {
    /**
     * Storage menu tracker status.
     */
    private boolean exit = false;
    /**
     * Storage class Input object.
     */
    private Input input;
    /**
     * Storage class Tracker object.
     */
    private Tracker tracker;
    /**
     * Storage list of user actions.
     */
    private List<UserAction> actions = new ArrayList<>();

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
        this.actions.add(new AddItem(0, "Add new Item"));
        this.actions.add(new ShowAll(1, "Show all items"));
        this.actions.add(new EditItem(2, "Edit item"));
        this.actions.add(new MenuTracker.DeleteItem(3, "Delete item"));
        this.actions.add(new FindItemById(4, "Find item by Id"));
        this.actions.add(new FindItemsByName(5, "Find items by name"));
        this.actions.add(new Exit(6, "Exit Program"));
    }

    /**
     * Method get actions length.
     *
     * @return length action list.
     */
    public int getActionsLength() {
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
                System.out.println(action.info());
            }
        }
    }

    /**
     * Class AddItem implements UserAction interface using for add request to tracker.
     *
     * @author Aleksey Lazarev
     * @since 19.11.2018
     */
    private class AddItem extends BaseAction {
        /**
         * Constructor.
         *
         * @param key  Key of this action.
         * @param name Name of this action.
         */
        public AddItem(int key, String name) {
            super(key, name);
        }

        /**
         * Method add item.
         *
         * @param input   Object type Input
         * @param tracker Object type Tracker
         */
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
     * Class ShowAll implements UserAction interface using for show all requests in console.
     *
     * @author Aleksey Lazarev
     * @since 19.11.2018
     */
    private class ShowAll extends BaseAction {
        /**
         * Constructor.
         *
         * @param key  Key of this action.
         * @param name Name of this action.
         */
        public ShowAll(int key, String name) {
            super(key, name);
        }

        /**
         * Method show all items.
         *
         * @param input   Object type Input
         * @param tracker Object type Tracker
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("___ START SHOW ALL ITEM ___");
            Item[] items = tracker.findAll();
            printItems(items);
            System.out.println("___ END SHOW ALL ITEM ___");
        }
    }

    /**
     * Class DeleteItem implements UserAction interface using for delete request requests from tracker.
     *
     * @author Aleksey Lazarev
     * @since 19.11.2018
     */
    private static class DeleteItem extends BaseAction {
        /**
         * Constructor.
         *
         * @param key  Key of this action.
         * @param name Name of this action.
         */
        public DeleteItem(int key, String name) {
            super(key, name);
        }

        /**
         * Method delete item.
         *
         * @param input   Object type Input
         * @param tracker Object type Tracker
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("___ DELETE ITEM ___");
            String delId = input.ask("Input ID item for delete");
            Boolean result = tracker.delete(delId);
            System.out.printf("___ DELETE ITEM IS %s ___%n", result.toString());
        }


    }

    /**
     * Class FindItemById implements UserAction interface using for find request by id in tracker.
     *
     * @author Aleksey Lazarev
     * @since 19.11.2018
     */
    private class FindItemById extends BaseAction {
        /**
         * Constructor.
         *
         * @param key  Key of this action.
         * @param name Name of this action.
         */
        public FindItemById(int key, String name) {
            super(key, name);
        }

        /**
         * Method find item by id.
         *
         * @param input   Object type Input
         * @param tracker Object type Tracker
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("___ FIND ITEM BY ID___");
            String findId = input.ask("Input ID item for found");
            printItems(new Item[]{tracker.findById(findId)});
            System.out.println("___ FOUND ITEM BY ID ___");
        }

    }

    /**
     * Class FindItemsByName implements UserAction interface using for find request by name in tracker.
     *
     * @author Aleksey Lazarev
     * @since 19.11.2018
     */
    private class FindItemsByName extends BaseAction {
        /**
         * Constructor.
         *
         * @param key  Key of this action.
         * @param name Name of this action.
         */
        public FindItemsByName(int key, String name) {
            super(key, name);
        }

        /**
         * Method find item by name.
         *
         * @param input   Object type Input
         * @param tracker Object type Tracker
         */
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
     * Class Exit implements UserAction interface using for exit from menu.
     *
     * @author Aleksey Lazarev
     * @since 19.11.2018
     */
    private class Exit extends BaseAction {
        /**
         * Constructor.
         *
         * @param key  Key of this action.
         * @param name Name of this action.
         */
        public Exit(int key, String name) {
            super(key, name);
        }

        /**
         * Method exit menu.
         *
         * @param input   Object type Input
         * @param tracker Object type Tracker
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("___ EXIT PROGRAM ___");
            exit = true;
        }


    }

    /**
     * Method check program status.
     *
     * @return program status.
     */
    public boolean isExit() {
        return exit;
    }
}
