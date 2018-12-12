package ru.alazarev.set;

import java.util.Iterator;

/**
 * Class SimpleSet решение задачи части 001. Урок 5.3.0 Создать метод delete для односвязного списка [#51424].
 *
 * @author Aleksey Lazarev
 * @since 12.12.2018
 */
public class SimpleSet<E> implements Iterable<E> {
    public void add(E e) {

    }


    public Iterator<E> iterator() {
        return new Iterator<E>() {

            public boolean hasNext() {
                return false;
            }

            public E next() {
                return null;
            }
        };
    }
}
