package ru.alazarev.services;

import java.util.*;


public class ConverterIterator {
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            private Iterator<Integer> currentIterator;

            private void check() {
                if (currentIterator == null && it.hasNext()) {
                    currentIterator = it.next();
                }
            }

            public boolean hasNext() {
                check();
                boolean result = false;
                while ((it.hasNext()) || currentIterator.hasNext()) {
                    if (!currentIterator.hasNext()) {
                        currentIterator = it.next();
                    } else {
                        result = true;
                        break;
                    }
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
}
