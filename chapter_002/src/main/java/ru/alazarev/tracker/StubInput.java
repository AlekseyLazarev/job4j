package ru.alazarev.tracker;

public class StubInput implements Input {
    /**
     * User answers.
     * Example.
     * 0 - Select menu item "Add new .
     * name - Name.
     * desc - Description.
     * 6 - Select menu item "exit".
     */
    private final String[] value;

    /**
     * Position pointer.
     */
    private int position;

    /**
     * Constructor.
     *
     * @param value Array of actions.
     */
    public StubInput(final String[] value) {
        this.value = value;
    }

    /**
     * Method runs everything on the list value.
     */
    public String ask(String question) {
        return this.value[this.position++];
    }

    /**
     * Method extract key.
     *
     * @param question Program question.
     * @param range    Range values.
     * @return key.
     */
    public int ask(String question, int[] range) {
        int key = Integer.valueOf(value[position++]);
        boolean exist = false;
        for (int i : range) {
            if (i == key) {
                exist = true;
            }
        }
        if (!exist) {
            throw new MenuOutException("Out of menu range.");
        }
        return key;
    }
}