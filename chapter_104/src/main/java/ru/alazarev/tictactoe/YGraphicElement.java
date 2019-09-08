package ru.alazarev.tictactoe;

import ru.alazarev.tictactoe.interfaces.IGraphicElement;

/**
 *
 */
public class YGraphicElement implements IGraphicElement {

    @Override
    public String elementName() {
        return "Y";
    }

    @Override
    public int poleSymbol() {
        return -3;
    }
}
