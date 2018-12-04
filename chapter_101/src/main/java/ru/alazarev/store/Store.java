package ru.alazarev.store;

/**
 * Interface Store решение задачи части 001. Урок 5.2.2. Реализовать Store<T extends Base> [#157].
 *
 * @author Aleksey Lazarev
 * @since 04.12.2018
 */
public interface Store<T extends Base> {
    /**
     * Method add element.
     *
     * @param model Element for add.
     */
    void add(T model);

    /**
     * Method replace element with id with ref element.
     *
     * @param id    Id replaced element.
     * @param model Required element id.
     * @return Result replaces.
     */
    boolean replace(String id, T model);

    /**
     * Method delete element by his id.
     *
     * @param id Element id.
     * @return Result delete.
     */
    boolean delete(String id);

    /**
     * Find element by id.
     *
     * @param id Element id.
     * @return Find element.
     */
    T findById(String id);
}

