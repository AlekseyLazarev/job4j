package ru.alazarev.list;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class ContainerList решение задачи части 001. Урок 5.3.1. Создать динамический список на базе массива. [#158].
 *
 * @author Aleksey Lazarev
 * @since 06.12.2018
 */
public class ContainerList<E> implements Iterable<E> {
    private Object[] container;
    private int index = 0;
    private int modCount = 0;

    /**
     * Constructor.
     *
     * @param size List size.
     */
    public ContainerList(int size) {
        this.container = new Object[size];
    }

    /**
     * Check array overflow.
     *
     * @param index Index for check.
     * @throws ArrayIndexOutOfBoundsException
     */
    public void checkOverflow(int index) throws ArrayIndexOutOfBoundsException {
        if (index >= container.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void extendContainer() {
        container = Arrays.copyOf(container, container.length * 2);
    }

    /**
     * Add element in list.
     *
     * @param value Value for add.
     */
    public void add(E value) {
        modCount++;
        if (index == container.length) {
            extendContainer();
        }
        container[index++] = value;
    }

    /**
     * Method get list size.
     *
     * @return list size.
     */
    public int getListSize() {
        return container.length;
    }

    /**
     * Get element by index.
     *
     * @param index Element index.
     * @return element by index.
     */
    public E get(int index) {
        checkOverflow(index);
        return (E) container[index];
    }

    /**
     * Method create iterator.
     *
     * @return Iterator of E.
     */
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private final int expectedModCount = modCount;
            private int position = 0;

            /**
             * Check has next element in list or not.
             *
             * @return true if has next element in list.
             * @throws ConcurrentModificationException
             */
            public boolean hasNext() throws ConcurrentModificationException {
                boolean result = false;
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (position < index) {
                    for (int i = position; i < container.length; i++) {
                        if (container[i] != null) {
                            result = true;
                            break;
                        }
                    }
                }
                return result;
            }

            /**
             * Return next element in array.
             *
             * @return next element.
             * @throws NoSuchElementException
             */
            public E next() throws NoSuchElementException {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (E) container[position++];
            }
        };
    }
}
