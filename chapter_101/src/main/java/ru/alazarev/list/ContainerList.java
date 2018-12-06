package ru.alazarev.list;

import java.util.Arrays;
import java.util.Iterator;

public class ContainerList<E> implements Iterable<E> {
    private Object[] container;
    private int index = 0;

    public ContainerList(int size) {
        this.container = new Object[size];
    }

    public void extendContainer() {
        container = Arrays.copyOf(container, container.length * 2);
    }

    public void add(E value) {
        container[index++] = value;
    }

    public E get(int index) {
        return (E) container[index];
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            public boolean hasNext() {
                boolean result = false;
                for(int index = 0; index < container.length; index++) {
                    if(container[index] != null) {
                        result = true;
                        break;
                    }
                }
                return result;
            }
            public E next() {
                E result = null;
                if(hasNext()){
                    result = (E) container[index++];
                }
                return result;
            }
        };
    }
}
