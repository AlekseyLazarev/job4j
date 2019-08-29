package ru.alazarev.tictactoe.interfaces;

/**
 * Interface IGraphicElement решение задачи части 004. 7. Крестики-нолики ООД [#793]
 *
 * @author Aleksey Lazarev
 * @since 26.08.2019
 */
public interface IGraphicElement {
    /**
     * Method return this element name.
     *
     * @return this element name.
     */
    String elementName();

    /**
     * Method return this element pole symbol.
     *
     * @return this element pole symbol.
     */
    int poleSymbol();
}
