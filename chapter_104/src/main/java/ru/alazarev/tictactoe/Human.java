package ru.alazarev.tictactoe;

import ru.alazarev.tictactoe.interfaces.IGraphicElement;
import ru.alazarev.tictactoe.interfaces.IInput;
import ru.alazarev.tictactoe.interfaces.ILogic;

/**
 * Class Human решение задачи части 004. 7. Крестики-нолики ООД [#793]
 *
 * @author Aleksey Lazarev
 * @since 03.09.2019
 */
public class Human implements ILogic {
    private IInput input;
    private IGraphicElement graphicElement;

    public Human(IInput input) {
        this.input = input;
    }

    /**
     * Method get element for this logic.
     *
     * @return element.
     */
    @Override
    public IGraphicElement getElement() {
        return this.graphicElement;
    }

    /**
     * Method set element for this logic.
     *
     * @param element Element.
     */

    @Override
    public void setElement(IGraphicElement element) {
        this.graphicElement = element;
    }

    /**
     * Current step.
     *
     * @return result step.
     */
    @Override
    public int step() {
        return this.input.getNumber();
    }
}
