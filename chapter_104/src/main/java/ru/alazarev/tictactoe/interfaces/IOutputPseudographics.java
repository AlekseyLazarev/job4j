package ru.alazarev.tictactoe.interfaces;

import com.google.common.collect.BiMap;

/**
 * Interface IOutputPseudographics решение задачи части 004. 7. Крестики-нолики ООД [#793]
 *
 * @author Aleksey Lazarev
 * @since 26.08.2019
 */
public interface IOutputPseudographics {
    /**
     * Method print pole square.
     *
     * @param game Current game.
     */
    void printSquare(ITicTacToe game);

    /**
     * Method init.
     *
     * @param graphicMap pseudographic objects.
     * @return this object.
     */
    IOutputPseudographics init(BiMap<Integer, IGraphicElement> graphicMap);

    /**
     * Method get pseudographic objects.
     *
     * @return graphic map.
     */
    BiMap<Integer, IGraphicElement> getGraphicMap();

    /**
     * Method set divider line.
     *
     * @param line Divider line.
     */
    void setLine(String line);
}