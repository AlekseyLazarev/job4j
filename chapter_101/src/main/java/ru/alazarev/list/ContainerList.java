package ru.alazarev.list;

import java.util.Arrays;
import java.util.Iterator;

public class ContainerList<E> implements Iterable<E> {
    private Object[] container;

    public ContainerList(int size) {
        this.container = new Object[size];
    }

    public void extendContainer() {
        container = Arrays.copyOf(container, container.length * 2);
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            public boolean hasNext() {
                return true;
            }
            public E next() {
                return (E) container;
            }
        };
    }
}
