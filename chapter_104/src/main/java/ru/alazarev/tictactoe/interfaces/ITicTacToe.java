package ru.alazarev.tictactoe.interfaces;

import java.util.List;

/**
 * Interface ITicTacToe решение задачи части 004. 7. Крестики-нолики ООД [#793]
 *
 * @author Aleksey Lazarev
 * @since 28.08.2019
 */
public interface ITicTacToe {
    /**
     * Method return Input variable.
     *
     * @return Input variable.
     */
    IInput getInput();

    /**
     * Method return current pole state.
     *
     * @return current pole state.
     */
    int[] getPole();

    /**
     * Method return pole size.
     *
     * @return pole size.
     */
    int getPoleSize();

    /**
     * Method game logic.
     */
    void game();

    /**
     * Method insert element by index.
     *
     * @param index   Insert index element.
     * @param element Insert element.
     */
    void insertElement(int index, IGraphicElement element);

    /**
     * Return the result of checking the end of the game.
     *
     * @param number Current number for check.
     * @return result of checking.
     */
    boolean isGameOver(int number);

    /**
     * Method initiate start params.
     *
     * @param logic    List of logic.
     * @param elements List of elements.
     * @return this object.
     */
    ITicTacToe init(List<ILogic> logic, List<IGraphicElement> elements);
}
