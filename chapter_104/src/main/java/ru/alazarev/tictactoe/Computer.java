package ru.alazarev.tictactoe;

import ru.alazarev.tictactoe.interfaces.IGraphicElement;
import ru.alazarev.tictactoe.interfaces.ILogic;

import java.util.Random;

/**
 * Class Computer решение задачи части 004. 7. Крестики-нолики ООД [#793]
 *
 * @author Aleksey Lazarev
 * @since 03.09.2019
 */
public class Computer implements ILogic {
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
     * Current computer step.
     *
     * @param pole Current pole.
     * @return result step.
     */
    @Override
    public int step(int[] pole) {
        return new Random().nextInt(pole.length);
    }
}
