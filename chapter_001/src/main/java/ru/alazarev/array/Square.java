package ru.alazarev.array;

/**
 * Class Square решение задачи части 001. 6.0. Заполнить массив степенями чисел. [#33488].
 *
 * @author Aleksey Lazarev
 * @since 12.11.2018
 */
public class Square {
    /**
     * Create an array of a certain size.
     *
     * @param bound array size.
     * @return array of squares of numbers.
     */
    public int[] calculate(int bound) {
        int[] result = new int[bound];
        for (int i = 0; i < bound; i++) {
            result[i] = (int) Math.pow(i + 1, 2);
        }
        return result;
    }
}