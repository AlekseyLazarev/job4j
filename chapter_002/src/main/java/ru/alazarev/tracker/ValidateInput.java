package ru.alazarev.tracker;

/**
 * Class ValidateInput решение задачи части 002. Урок 6.1. Обеспечить бесперебойную работу приложения Tracker. [#789]
 *
 * @author Aleksey Lazarev
 * @since 19.11.2018
 */
public class ValidateInput extends ConsoleInput {
    /**
     * Storage class Input object.
     */
    private final Input input;

    /**
     * Constructor.
     *
     * @param input Class Input object.
     */
    public ValidateInput(final Input input) {
        this.input = input;
    }

    /**
     * Method override view question and return answer from super class.
     *
     * @param question Question.
     * @return answer from console.
     */
    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    /**
     * Method validate and return value of string.
     *
     * @param question Program question.
     * @param range    Range values.
     * @return key value.
     */
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
