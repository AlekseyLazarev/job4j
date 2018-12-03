package ru.alazarev.services;

import java.util.*;

/**
 * Class ConvertIterator решение задачи части 001. 5.1.4. Создать convert(Iterator<Iterator>) [#152][#93950]
 *
 * @author Aleksey Lazarev
 * @since 03.12.2018
 */
public class ConverterIterator {
    /**
     * Method convert iterator of iterators to iterator integer.
     *
     * @param it Object iterator of iterators.
     * @return Iterator with integer values.
     */
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            private Iterator<Integer> currentIterator;

            /**
             * Method check inner current iterator empty.
             */
            private void check() {
                if (currentIterator == null && it.hasNext()) {
                    currentIterator = it.next();
                }
            }

            /**
             * Check has next element in iterator.
             * @return yes or no.
             */
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

            /**
             * Method return next element.
             * @return next element.
             */
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
