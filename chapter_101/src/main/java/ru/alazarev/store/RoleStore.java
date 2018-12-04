package ru.alazarev.store;

/**
 * Class RoleStore решение задачи части 001. Урок 5.2.2. Реализовать Store<T extends Base> [#157].
 *
 * @author Aleksey Lazarev
 * @since 04.12.2018
 */
public class RoleStore extends AbstractStore<Role> {
    /**
     * Constructor.
     *
     * @param count Array size.
     */
    public RoleStore(int count) {
        super(count);
    }
}
