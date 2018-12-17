package ru.alazarev.set;

import ru.alazarev.list.ContainerList;

import java.util.Iterator;

/**
 * Class SimpleSet решение задачи части 001. Урок 4.1. Реализовать коллекцию Set на массиве [#996]
 *
 * @author Aleksey Lazarev
 * @since 16.12.2018
 */
public class SimpleSet<E> implements Iterable<E> {
    private ContainerList<E> array;

    /**
     * Constructor.
     *
     * @param size Array size.
     */
    public SimpleSet(int size) {
        this.array = new ContainerList<>(size);
    }

    /**
     * Method check unique value.
     *
     * @param value Check value.
     * @return result check.
     */
    public boolean checkUnique(E value) {
        boolean result = true;
        for (E current : array) {
            if (current.equals(value)) {
                result = false;
            }
        }
        return result;
    }

    /**
     * Method add value if it unique.
     *
     * @param e Value for add.
     */
    public void add(E e) {
        if (checkUnique(e)) {
            array.add(e);
        }
    }

    /**
     * Method generate iterator.
     *
     * @return Array iterator.
     */
    public Iterator<E> iterator() {
        return array.iterator();
    }
}
