package ru.alazarev.tracker;
/**
 * Class MenuOutException решение задачи части 002. Урок 6.1. Обеспечить бесперебойную работу приложения Tracker. [#789]
 *
 * @author Aleksey Lazarev
 * @since 19.11.2018
 */
public class MenuOutException extends RuntimeException {
    /**
     * Constructor.
     * @param msg message to view.
     */
    public MenuOutException(String msg) {
        super(msg);
    }
}
