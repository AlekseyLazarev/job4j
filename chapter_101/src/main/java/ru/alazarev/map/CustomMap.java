package ru.alazarev.map;

import java.util.*;

/**
 * Class User решение задачи части 001. Урок 5.8. Реализовать собственную структуру данных - HashMap [#1008].
 *
 * @author Aleksey Lazarev
 * @since 19.12.2018
 */
public class CustomMap<K, V> {
    private Node<K, V>[] customMap;

    /**
     * Constructor.
     *
     * @param size Inner array size.
     */
    public CustomMap(int size) {
        this.customMap = new Node[size];
    }

    /**
     * Method insert value by key.
     *
     * @param key   Key for find.
     * @param value Value for insert by key.
     * @return Result insert.
     */
    public boolean insert(K key, V value) {
        boolean result = false;
        int keyHash = key.hashCode();
        if (keyHash >= this.customMap.length - 1) {
            resize();
        }
        if (this.customMap[keyHash] == null) {
            this.customMap[keyHash] = new Node(key, value);
            result = true;
        }
        return result;
    }

    /**
     * Method return value by key.
     *
     * @param key Key for find.
     * @return Value by key.
     */
    public V get(K key) {
        int keyHash = key.hashCode();
        return this.customMap[keyHash] == null ? null : this.customMap[keyHash].value;
    }

    /**
     * Method delete value by key.
     *
     * @param key Key for find.
     * @return Result delete.
     */
    public boolean delete(K key) {
        boolean result = false;
        int keyHash = key.hashCode();
        if (keyHash < this.customMap.length) {
            this.customMap[keyHash] = null;
            result = true;
        }
        return result;
    }

    /**
     * Method resize array. If array length = 0, setup size 1.
     */
    private void resize() {
        int sizeTo = 1;
        if (this.customMap.length != 0) {
            sizeTo = this.customMap.length * 2;
        }
        this.customMap = Arrays.copyOf(this.customMap, sizeTo);
    }

    /**
     * Method return iterator.
     *
     * @return Iterator.
     */
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            private int position = 0;

            /**
             * Check has next element in list or not.
             *
             * @return true if has next element in list.
             */
            public boolean hasNext() {
                boolean result = false;
                for (int i = position; i < customMap.length; i++) {
                    if (customMap[i] != null) {
                        result = true;
                        break;
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
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (K) customMap[position++];
            }
        };
    }

    /**
     * Storage class.
     *
     * @param <K> Key.
     * @param <V> Value.
     */
    class Node<K, V> {
        private K key;
        private V value;

        /**
         * Constructor.
         *
         * @param key Key.
         * @param value Value.
         */
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        /**
         * Override hashCode method.
         *
         * @return Hash code.
         */
        @Override
        public int hashCode() {
            return 31 * this.key.hashCode() * this.value.hashCode();
        }

        /**
         * Override equal method.
         *
         * @param obj Object for equal.
         * @return Result equal.
         */
        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            } else if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Node<K,V> node = (Node) obj;
            if (this.key != null ? !this.key.equals(node.key) : node.key != null) {
                return false;
            }
            if (this.value != null ? !this.value.equals(node.value) : node.value != null) {
                return false;
            }
            return true;
        }
    }
}
