package ru.alazarev.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class NodeList<E> implements Iterable<E> {
    private Node<E> first;
    private int size = 0;
    private int modCount = 0;

    public boolean checkEmpty() {
        return this.first == null;
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

    public void add(E value) {
        Node<E> newLink = new Node<>(value);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
        this.modCount++;
    }

    public E get(int index) {
        E resultData = null;
        checkOverflow(index);
        if (!checkEmpty()) {
            Node<E> result = this.first;
            while (index > 0) {
                if (result.next != null) {
                    result = result.next;
                } else {
                    result.data = null;
                }
                index--;
            }
            resultData = result.data;
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
                return first.next != null;
            }

            /**
             * Return next element in array.
             *
             * @return next element.
             * @throws NoSuchElementException
             */
            public E next() {
                E result = null;
                if (!checkEmpty()) {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    } else {
                        result = first.next.data;
                        first = first.next;
                    }
                }
                return result;
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
