package ru.alazarev.isp;

/**
 * Interface IMenu решение задачи части 004. 4.1 Создать меню. [#4748].
 *
 * @author Aleksey Lazarev
 * @since 26.08.2019
 */
public interface IMenu {
    /**
     * Method adding element into menu.
     *
     * @param element Adding element.
     * @param parent  Parent element.
     */
    void addElement(IElement element, IElement parent);

    /**
     * Method print element.
     */
    void printElements();

    /**
     * Method return find element.
     *
     * @param number Element number.
     * @return IElement.
     */
    IElement finder(String number);
}
