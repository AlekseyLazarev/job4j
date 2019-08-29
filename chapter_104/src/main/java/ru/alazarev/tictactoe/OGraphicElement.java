package ru.alazarev.tictactoe;

import ru.alazarev.tictactoe.interfaces.IGraphicElement;

/**
 * Class OGraphicElement решение задачи части 004. 7. Крестики-нолики ООД [#793]
 *
 * @author Aleksey Lazarev
 * @since 26.08.2019
 */
public class OGraphicElement implements IGraphicElement {
    /**
     * Method return this element name.
     *
     * @return this element name.
     */
    @Override
    public String elementName() {
        return "O";
    }

    /**
     * Method return this element pole symbol.
     *
     * @return this element pole symbol.
     */
    @Override
    public int poleSymbol() {
        return -2;
    }
}
