package ru.alazarev.services;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorArray implements Iterator {

    private final int[][] values;
    private int col = 0;
    private int row = 0;

    public IteratorArray(final int[][] values) {
        this.values = values;
    }

    public boolean hasNext() {
        return values[row].length > col || (values.length - 1) > row;
    }

    public Object next() {
        Object result = null;
        if (values.length == 0) {
            throw new NoSuchElementException("Null array");
        }
        if (values[row].length == col) {
            row++;
            col = 0;
        }
        result = values[row][col++];
        return result;
    }
}
