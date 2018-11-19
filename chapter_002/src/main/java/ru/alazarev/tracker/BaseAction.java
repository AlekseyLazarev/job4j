package ru.alazarev.tracker;

public abstract class BaseAction implements UserAction {
    /**
     * Store key action.
     */
    private final int key;
    /**
     * Store name action.
     */
    private final String name;

    /**
     * Constructor.
     *
     * @param key  Key Action.
     * @param name Name Action.
     */
    protected BaseAction(final int key, final String name) {
        this.key = key;
        this.name = name;
    }

    /**
     * Method return key of this action.
     *
     * @return Key value.
     */
    @Override
    public int key() {
        return this.key;
    }

    /**
     * Method Return info about this action.
     *
     * @return String with key and name of action.
     */
    @Override
    public String info() {
        return String.format("%s. %s", this.key, this.name);
    }
}
