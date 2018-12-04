package ru.alazarev.store;

/**
 * Class Base решение задачи части 001. Урок 5.2.2. Реализовать Store<T extends Base> [#157].
 *
 * @author Aleksey Lazarev
 * @since 04.12.2018
 */
public abstract class Base {
    private final String id;

    /**
     * Constructor.
     *
     * @param id Element id.
     */
    protected Base(final String id) {
        this.id = id;
    }

    /**
     * Method get id element.
     *
     * @return Element id.
     */
    public String getId() {
        return id;
    }
}
