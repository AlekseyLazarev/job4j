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
    private IInput input = new Input();
    private IGraphicElement graphicElement;

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
     * Current human step.
     *
     * @param pole Current pole.
     * @return result step.
     */
    @Override
    public int step(int[] pole) {
        return this.input.getNumber();
    }
}
