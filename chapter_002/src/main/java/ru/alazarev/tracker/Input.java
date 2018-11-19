package ru.alazarev.tracker;

/**
 * Interface for input string.
 */
public interface Input {
    String ask(String question);

    int ask(String question, int[] range);

}
