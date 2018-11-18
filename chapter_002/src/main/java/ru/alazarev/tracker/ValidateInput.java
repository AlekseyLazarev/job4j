package ru.alazarev.tracker;

public class ValidateInput extends ConsoleInput {
    private final Input input;

    public ValidateInput(final Input input) {
        this.input = input;
    }

    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = this.input.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Please select an item from the menu");
            } catch (NumberFormatException nfe) {
                System.out.println("Please input correct value");
            }

        } while (invalid);
        return value;
    }
}
