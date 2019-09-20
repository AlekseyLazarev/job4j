package ru.alazarev.seafight.interfaces;

/**
 * Interface ISeaFight решение задачи части "Создание игры морской бой".
 *
 * @author Aleksey Lazarev
 * @since 18.09.2019
 */
public interface ISeaFight {
    /**
     * Initiate method.
     *
     * @return ISeaFight object.
     */
    ISeaFight init();

    /**
     * Game method.
     */
    void game();
}
