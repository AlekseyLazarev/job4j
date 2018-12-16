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

    public SimpleSet(int size) {
        this.array = new ContainerList<>(size);
    }

    public void add(E e) {
        for (E current : array) {
            if (current.equals(e)) {
                return;
            }
        }
        array.add(e);
    }


    public Iterator<E> iterator() {
        return array.iterator();
    }
}
