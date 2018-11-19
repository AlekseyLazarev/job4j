package ru.alazarev.tracker;

/**
 * Interface UserAction
 *
 * @author Aleksey Lazarev
 * @since 19.11.2018
 */
public interface UserAction {
    /**
     * Method return key of action.
     *
     * @return Key.
     */
    int key();

    /**
     * Main method.
     *
     * @param input   Object type Input
     * @param tracker Object type Tracker
     */
    void execute(Input input, Tracker tracker);
    /**
     * Method return information about this menu action.
     *
     * @return String menu.
     */
    String info();
}