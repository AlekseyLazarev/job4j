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
        if (index > size || index < 0) {
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
        Node<E> result = null;
        if (!checkEmpty()) {
            result = this.first;
            for (int index = 0; index < position; index++) {
                if (result.next != null) {
                    result = result.next;
                }
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
        checkOverflow(position);
        Node<E> previous, find;
        E result = null;
        if (!checkEmpty()) {
            if (position == 0) {
                result = first.data;
                first = first.next;
            } else {
                previous = findNode(position - 1);
                find = previous.next;
                result = find.data;
                previous.next = find.next;
            }
            this.size--;
            this.modCount++;
        }
        return result;
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
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int expectedModCount = modCount;
            private int size = getSize();
            private int position = 0;
            private Node<E> current = first;

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
                return this.position < this.size;
            }

            /**
             * Return next element in array.
             *
             * @return next element.
             * @throws NoSuchElementException
             */
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E result = current.data;
                current = current.next;
                position++;
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
