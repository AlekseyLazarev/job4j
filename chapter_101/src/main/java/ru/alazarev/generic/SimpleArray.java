package ru.alazarev.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class SimpleArray решение задачи части 001. Урок 5.2.1. Реализовать SimpleArray<T> [#156].
 *
 * @author Aleksey Lazarev
 * @since 03.12.2018
 */
public class SimpleArray<T> implements Iterator<T> {
    Object[] models;
    private int index = 0;
    private int position = 0;

    /**
     * Constructor.
     *
     * @param size Array size.
     */
    public SimpleArray(int size) {
        this.models = new Object[size];
    }

    /**
     * Add element in array.
     *
     * @param model Element for add.
     */
    public void add(T model) {
        this.models[index++] = model;
    }

    /**
     * Check array overflow.
     *
     * @param index Index for check.
     * @throws ArrayIndexOutOfBoundsException
     */
    public void checkOverflow(int index) throws ArrayIndexOutOfBoundsException {
        if (index >= models.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /**
     * Set element value by index.
     *
     * @param index Index element for set.
     * @param model Element for set.
     */
    public void set(int index, T model) {
        checkOverflow(index);
        this.models[index] = model;
    }

    /**
     * Delete element from array.
     *
     * @param index Element index.
     */
    public void delete(int index) {
        checkOverflow(index);
        this.models[index] = "";
    }

    /**
     * Get element by index.
     *
     * @param index Element index.
     * @return
     */
    public T get(int index) {
        checkOverflow(index);
        return (T) this.models[index];
    }

    /**
     * Check has next element in array or not.
     *
     * @return
     */
    public boolean hasNext() {
        boolean result = false;
        while (position < models.length) {
            if (models[position] != null) {
                result = true;
                break;
            }
            position++;
        }
        return result;
    }

    /**
     * Return next element in array.
     *
     * @return next element.
     * @throws NoSuchElementException
     */
    public T next() throws NoSuchElementException {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return (T) models[position++];
    }
}
