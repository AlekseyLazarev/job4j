package ru.alazarev.tracker;

public interface UserAction {
    /**
     * Method return key of option.
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

}