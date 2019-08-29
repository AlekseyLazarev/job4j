package ru.alazarev.tictactoe.interfaces;

/**
 * Interface ILogic решение задачи части 004. 7. Крестики-нолики ООД [#793]
 *
 * @author Aleksey Lazarev
 * @since 03.09.2019
 */
public interface ILogic {
    /**
     * Method get element for this logic.
     *
     * @return element.
     */
    IGraphicElement getElement();

    /**
     * Method set element for this logic.
     *
     * @param element Element.
     */
    void setElement(IGraphicElement element);

    /**
     * Current step.
     *
     * @return result step.
     */
    int step();
}
