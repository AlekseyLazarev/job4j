package ru.alazarev.map;

import java.util.*;

/**
 * Class User решение задачи части 001. Урок 5.8. Реализовать собственную структуру данных - HashMap [#1008].
 *
 * @author Aleksey Lazarev
 * @since 19.12.2018
 */
public class CustomMap<K, V> {
    private Object[][] customMap;
    private int countArgs = 2;

    /**
     * Constructor.
     *
     * @param size Inner array size.
     */
    public CustomMap(int size) {
        this.customMap = new Object[size][this.countArgs];
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
        if (this.customMap[keyHash][0] == null) {
            this.customMap[keyHash][0] = key;
            this.customMap[keyHash][1] = value;
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
        return this.customMap[keyHash] == null ? null : (V) this.customMap[keyHash][1];
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
            this.customMap[keyHash][0] = null;
            this.customMap[keyHash][1] = null;
            result = true;
        }
        return result;
    }

    /**
     * Method resize array. If array length = 0, setup size 1.
     */
    private void resize() {
        int sizeTo = 1;
        int oldLength = this.customMap.length;
        if (this.customMap.length != 0) {
            sizeTo = this.customMap.length * 2;
        }
        this.customMap = Arrays.copyOf(this.customMap, sizeTo);
        for (int index = oldLength; index < this.customMap.length; index++) {
            this.customMap[index] = new Object[]{null, null};
        }
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
}
