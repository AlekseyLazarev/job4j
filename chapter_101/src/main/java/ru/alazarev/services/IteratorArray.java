package ru.alazarev.services;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class IteratorArray решение задачи части 001. Урок 5.1.1. Итератор для двухмерного массива int[][] [#9539].
 *
 * @author Aleksey Lazarev
 * @since 29.11.2018
 */
public class IteratorArray implements Iterator {

    private final int[][] values;
    private int col = 0;
    private int row = 0;

    /**
     * Constructor
     *
     * @param values array of numbers.
     */
    public IteratorArray(final int[][] values) {
        this.values = values;
    }

    /**
     * Check for the next item.
     *
     * @return result check.
     */
    public boolean hasNext() {
        boolean result = false;
        try {
            result = values[row].length > col || (values.length - 1) > row;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    /**
     * Method returning element of array.
     *
     * @return element array.
     * @throws NoSuchElementException
     */
    public Object next() throws NoSuchElementException {
        Object result = null;
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        if (values[row].length == col) {
            row++;
            col = 0;
        }
        result = values[row][col++];
        return result;
    }
}
