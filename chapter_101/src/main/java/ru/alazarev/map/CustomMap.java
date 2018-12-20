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
    private int load = 0;

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
        if (this.load == this.customMap.length) {
            resize();
        }
        if (key != null) {
            int currentHash = hash(key.hashCode());
            int indexForHash = indexFor(currentHash);
            if (this.customMap[indexForHash] == null) {
                this.customMap[indexForHash] = new Node(key, value);
                result = true;
            }
        }
        this.load++;
        return result;
    }

    /**
     * Method generate hash by hashCode.
     *
     * @param h HashCode.
     * @return Hash.
     */
    private int hash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    /**
     * Method return index with length and hash.
     *
     * @param h Hash.
     * @return Index in array.
     */
    private int indexFor(int h) {
        return h % (this.customMap.length - 1);
    }

    /**
     * Method return value by key.
     *
     * @param key Key for find.
     * @return Value by key.
     */
    public V get(K key) {
        int currentHash = hash(key.hashCode());
        int indexForHash = indexFor(currentHash);
        return this.customMap[indexForHash] == null ? null : this.customMap[indexForHash].value;
    }

    /**
     * Method delete value by key.
     *
     * @param key Key for find.
     * @return Result delete.
     */
    public boolean delete(K key) {
        boolean result = false;
        int indexForHash = indexFor(key.hashCode());
        if (indexForHash < this.customMap.length) {
            this.customMap[indexForHash] = null;
            result = true;
        }
        this.load--;
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
         * @param key   Key.
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
            Node<K, V> node = (Node) obj;
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
