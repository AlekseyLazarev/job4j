package ru.alazarev.store;

/**
 * Class UserStore решение задачи части 001. Урок 5.2.2. Реализовать Store<T extends Base> [#157].
 *
 * @author Aleksey Lazarev
 * @since 04.12.2018
 */
public class UserStore extends AbstractStore<User> {
    /**
     * Constructor.
     *
     * @param count Array size.
     */
    public UserStore(int count) {
        super(count);
    }
}
