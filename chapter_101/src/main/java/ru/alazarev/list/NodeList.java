package ru.alazarev.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class ContainerList решение задачи части 001. 5.3.2. Создать контейнер на базе связанного списка  [#159].
 *
 * @author Aleksey Lazarev
 * @since 07.12.2018
 */
public class NodeList<E> implements Iterable<E> {
    private Node<E> first;
    private int size = 0;
    private int modCount = 0;

    /**
     * Check empty list.
     *
     * @return Result of check.
     */
    public boolean checkEmpty() {
        return this.first == null;
    }

    /**
     * Get method for size.
     *
     * @return Size.
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Check array overflow.
     *
     * @param index Index for check.
     * @throws IndexOutOfBoundsException
     */
    public void checkOverflow(int index) throws IndexOutOfBoundsException {
        if (index > size) {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Method add value in list.
     *
     * @param value Value for add.
     */
    public void add(E value) {
        Node<E> newLink = new Node<>(value);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
        this.modCount++;
    }

    public Node<E> findNode(int position) {
        Node<E> result = this.first;
        for (int index = 0; index < position; index++) {
            if (result.next != null) {
                result = result.next;
            }
        }
        return result;
    }

    /**
     * Method delete upper element and return that.
     *
     * @return Deleted element.
     */
    public E delete(int position) {
        Node<E> result = findNode(position);
        E resultData = result.data;
        result = result.next;
        this.size--;
        this.modCount++;
        this.first = result;
        return resultData;
    }

    /**
     * Get element from list.
     *
     * @param position Element position.
     * @return Element by this position.
     */
    public E get(int position) {
        E resultData = null;
        checkOverflow(position);
        if (!checkEmpty()) {
            resultData = findNode(position).data;
        }
        return resultData;
    }

    /**
     * Method create iterator.
     *
     * @return Iterator of E.
     */
    public Iterator iterator() {
        return new Iterator() {
            private int expectedModCount = modCount;
            private int size = getSize();
            private int position = 0;

            /**
             * Check has next element in list or not.
             *
             * @return true if has next element in list.
             * @throws ConcurrentModificationException
             */
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return this.position < this.size && first.next != null;
            }

            /**
             * Return next element in array.
             *
             * @return next element.
             * @throws NoSuchElementException
             */
            public E next() {
                Node<E> result = null;
                E resultData = null;
                if (!checkEmpty()) {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    result = first;
                    for (int index = 0; index < position; index++) {
                        result = result.next;
                    }
                    this.position++;
                    resultData = result.data;
                }
                return resultData;
            }
        };
    }

    /**
     * Storage date class.
     *
     * @param <E> Type element for storage.
     */
    private static class Node<E> {

        E data;
        Node<E> next;

        public Node(E data) {
            this.data = data;
        }

    }
}
