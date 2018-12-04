package ru.alazarev.services;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class EvenIteratorArray решение задачи части 001. Урок 5.1.2. Создать итератор четные числа [#150].
 *
 * @author Aleksey Lazarev
 * @since 29.11.2018
 */
public class EvenIteratorArray implements Iterator<Integer> {

    private final int[] numbers;

    private int index = 0;

    /**
     * Constructor.
     *
     * @param numbers array of numbers.
     */
    public EvenIteratorArray(int[] numbers) {
        this.numbers = numbers;
    }

    /**
     * Check for the next even item.
     *
     * @return result check.
     */
    public boolean hasNext() {
        boolean result = false;
        while (index < numbers.length) {
            if (numbers[index] % 2 == 0) {
                result = true;
                break;
            }
            index++;
        }
        return result;
    }

    /**
     * Method returning element of array.
     *
     * @return element array.
     * @throws NoSuchElementException
     */
    public Integer next() throws NoSuchElementException {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return numbers[index++];
    }
}
