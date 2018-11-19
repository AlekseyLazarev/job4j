package ru.alazarev.tracker;

import java.util.Scanner;

/**
 * Class ConsoleInput решение задачи части 002. Урок 4.1. Используя класс ConsoleInput в классе StartUI
 * обеспечить полноценную работу всего приложения [#784].
 *
 * @author Aleksey Lazarev
 * @since 15.11.2018
 */
public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    /**
     * Method view question and return answer from console.
     *
     * @param question Question.
     * @return answer from console.
     */
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

    /**
     * Method extract key.
     *
     * @param question Program question.
     * @param range    Range values.
     * @return key.
     */
    public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exists = false;
        for (int value : range) {
            if (value == key) {
                exists = true;
                break;
            }
        }
        if (exists) {
            return key;
        } else {
            throw new MenuOutException("Out of menu range");
        }
    }

}
