package ru.alazarev.services;

import java.util.Iterator;

public class ConverterIterator  {
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {

            private int index = 0;
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Integer next() {

                return it.next().next();
            }
        };
    }
    public static void main(String[] args) {

    }
}
