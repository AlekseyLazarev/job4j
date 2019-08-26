package ru.alazarev.isp;

import java.util.List;

/**
 * Interface IElement  решение задачи части 004. 4.1 Создать меню. [#4748].
 *
 * @author Aleksey Lazarev
 * @since 29.06.2019
 */
public interface IElement extends IElementPrint, IElementAction {
    /**
     * Method return child of elements.
     *
     * @return Elements list.
     */
    List<IElement> getChild();

    /**
     * Method return current element name.
     *
     * @return current element name.
     */
    String getName();

    /**
     * Return divider.
     *
     * @return divider.
     */
    String getDivider();

    /**
     * Set divider.
     *
     * @param s divider.
     */
    void setDivider(String s);
}
