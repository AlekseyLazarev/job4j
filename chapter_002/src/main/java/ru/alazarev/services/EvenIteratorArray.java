package ru.alazarev.services;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class EvenIteratorArray решение задачи части 001. Урок 5.1.2. Создать итератор четные числа [#150].
 *
 * @author Aleksey Lazarev
 * @since 29.11.2018
 */
public class EvenIteratorArray implements Iterator {

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
     * Method check parity of number.
     *
     * @param number Number for check.
     * @return result of check.
     */
    public boolean checkEven(int number) {
        return number % 2 == 0;
    }

    /**
     * Check for the next even item.
     *
     * @return result check.
     */
    public boolean hasNext() {
        return checkEven(numbers[index + 1]);
    }

    /**
     * Method returning element of array.
     *
     * @return element array.
     * @throws NoSuchElementException
     */
    public Object next() throws NoSuchElementException {
        if (numbers.length == 0) {
            throw new NoSuchElementException("Null array");
        }
        return checkEven(numbers[index]) ? numbers[index++] : "odd";
    }
}
