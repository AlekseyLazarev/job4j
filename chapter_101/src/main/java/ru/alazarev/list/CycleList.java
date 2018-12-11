package ru.alazarev.list;

/**
 * Class CycleList решение задачи части 001. Урок 5.3.4. Задан связанный список. Определить цикличность. [#161].
 *
 * @author Aleksey Lazarev
 * @since 11.12.2018
 */
public class CycleList {
    /**
     * Storage date class.
     *
     * @param <T> Type element for storage.
     */
    static class Node<T> {
        T value;
        Node<T> next;

        /**
         * Constructor.
         *
         * @param value Value to add.
         */
        public Node(T value) {
            this.value = value;
        }
    }

    /**
     * Method check node.
     *
     * @param first First node in node list.
     * @return result check.
     */
    public boolean checkEmpty(Node first) {
        return first != null;
    }

    /**
     * Method check cycle.
     *
     * @param first First node in node list.
     * @return result check.
     */
    public boolean hasCycle(Node first) {
        boolean result = false;
        if (checkEmpty(first)) {
            Node nodeOne = first;
            Node nodeTwo = first.next;
            while (nodeOne != null && nodeTwo != null) {
                if (nodeOne == nodeTwo) {
                    result = true;
                    break;
                }
                if (nodeOne == null || nodeTwo == null || nodeTwo.next == null) {
                    break;
                }
                nodeOne = nodeOne.next;
                nodeTwo = nodeTwo.next.next;
            }
        }
        return result;
    }
}
