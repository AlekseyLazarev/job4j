package ru.alazarev.tictactoe.interfaces;

/**
 * Class  решение задачи части
 *
 * @author Aleksey Lazarev
 * @since 28.08.2019
 */
public interface IInput {
    /**
     * Method get number.
     *
     * @return Number.
     */
    int getNumber();

    /**
     * Method get pole size.
     *
     * @return Pole size.
     */
    int getPoleSize();

    /**
     * Method return who starts the game.
     *
     * @return who starts the game.
     */
    boolean pcFirst();
}
