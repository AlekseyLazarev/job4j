package ru.alazarev.list;

/**
 * Class SimpleArrayList решение задачи части 001. Урок 5.3.0 Создать метод delete для односвязного списка [#51424].
 *
 * @author Aleksey Lazarev
 * @since 05.12.2018
 */
public class SimpleArrayList<E> {

    private int size;
    private Node<E> first;

    /**
     * Method add element in list.
     *
     * @param date Date element.
     */
    public void add(E date) {
        Node<E> newLink = new Node<>(date);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
    }

    /**
     * Method delete item from list.
     *
     * @return First date item.
     */
    public E delete() {
        Node<E> result = this.first;
        for (int index = 1; index < this.size - 1; index++) {
            result = result.next;
        }
        result.next = null;
        this.size--;
        return this.first.date;
    }

    /**
     * Method get item from list by his index.
     *
     * @param index Item index.
     * @return Date element.
     */
    public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            if (result.next != null) {
                result = result.next;
            } else {
                result.date = null;
            }
        }
        return result.date;
    }

    /**
     * Method get size list.
     *
     * @return Size list.
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Storage date class.
     *
     * @param <E> Element for storage.
     */
    private static class Node<E> {

        E date;
        Node<E> next;

        Node(E date) {
            this.date = date;
        }
    }
}
