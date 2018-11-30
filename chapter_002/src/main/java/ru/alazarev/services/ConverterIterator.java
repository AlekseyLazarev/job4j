package ru.alazarev.services;

import java.util.*;


public class ConverterIterator {
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            private Iterator<Integer> currentIterator;

            private void check() {
                if (currentIterator == null && it.hasNext())
                    currentIterator = it.next();
            }


            public boolean hasNext() {
                check();
                boolean result = false;
                if (currentIterator == null) {
                    result = false;
                } else if (currentIterator.hasNext()) {
                    result = true;
                } else if (it.hasNext()) {
                    currentIterator = it.next();
                    result = currentIterator.hasNext();
                }
                return result;
            }


            public Integer next() {
                check();
                if (currentIterator == null) {
                    throw new NoSuchElementException();
                }
                if (!currentIterator.hasNext() && it.hasNext()) {
                    currentIterator = it.next();
                }
                return currentIterator.next();
            }
        };
    }

    public static void main(String[] args) {
        Iterator<Integer> it1 = Arrays.asList(1, 2, 3).iterator();
        Iterator<Integer> it2 = Arrays.asList(4, 5, 6).iterator();
        Iterator<Integer> it3 = Arrays.asList(7, 8, 9).iterator();
        Iterator<Iterator<Integer>> its = Arrays.asList(it1, it2, it3).iterator();
        ConverterIterator IteratorOfIterators = new ConverterIterator();
        Iterator<Integer> it = IteratorOfIterators.convert(its);
        for (int i = 0; i < 9; i++) {
            System.out.print(it.next());
        }
    }
}
