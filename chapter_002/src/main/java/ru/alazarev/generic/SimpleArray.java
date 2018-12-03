package ru.alazarev.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterator<T> {
    Object[] models;
    private int index = 0;
    private int position = 0;

    public SimpleArray(int size) {
        this.models = new Object[size];
    }

    public void add(T model) {
        this.models[index++] = model;
    }

    public void checkOverflow(int index) throws ArrayIndexOutOfBoundsException {
        if (index >= models.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void set(int index, T model) {
        checkOverflow(index);
        this.models[index] = model;
    }

    public void delete(int index) {
        checkOverflow(index);
        this.models[index] = "";
    }

    public T get(int index) {
        checkOverflow(index);
        return (T) this.models[index];
    }

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

    public T next() throws NoSuchElementException {
        if(!hasNext()){
            throw new NoSuchElementException();
        }
        return (T) models[position++];
    }
}
