package ru.alazarev.isp;

/**
 * Interface IElement  решение задачи части 004. 4.1 Создать меню. [#4748].
 *
 * @author Aleksey Lazarev
 * @since 29.06.2019
 */
public interface IElement extends IElementPrint, IElementAction {
    /**
     * Method add element into list.
     *
     * @param element Element object.
     */
    void addElement(IElement element);

    /**
     * Method get current lvl.
     *
     * @return current lvl.
     */
    int getLvl();

    /**
     * Method set current id.
     *
     * @param currentId Current id value.
     */
    void setCurrentId(int currentId);

    /**
     * Method find element by id.
     *
     * @param id Digital id.
     * @return IElement object.
     */
    IElement finder(int id);
}
