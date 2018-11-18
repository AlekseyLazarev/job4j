package ru.alazarev.tracker;

public class ValidateInput extends ConsoleInput {

    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
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
