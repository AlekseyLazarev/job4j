package ru.alazarev.seafight.interfaces;

/**
 * Interface IInput решение задачи части "Создание игры морской бой".
 *
 * @author Aleksey Lazarev
 * @since 18.09.2019
 */
public interface IInput {
    /**
     * Method getting a number.
     *
     * @return received number.
     */
    int intInput();

    /**
     * Method getting a string.
     *
     * @return received string.
     */
    String stringInput();
}
