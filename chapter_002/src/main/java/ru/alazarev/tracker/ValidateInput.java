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
                System.out.println("GG MOE");
            } catch (NumberFormatException nfe) {
                System.out.println("GG NFE");
            }

        } while (invalid);
        return value;
    }
}
