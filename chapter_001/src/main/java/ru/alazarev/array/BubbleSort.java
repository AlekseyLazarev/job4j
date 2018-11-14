package ru.alazarev.array;

/**
 * Class BubbleSort решение задачи части 001. 6.5. Создать программу для сортировки массива методом перестановки. [#195].
 *
 * @author Aleksey Lazarev
 * @since 12.11.2018
 */
public class BubbleSort {
    /**
     * Sort array ascending.
     *
     * @param array array of elements.
     * @return array ascending.
     */
    public int[] sort(int[] array) {
        for (int out = 0; out < array.length - 1; out++) {
            for (int in = 0; in < array.length - out - 1; in++) {
                int temp;
                if (array[in + 1] < array[in]) {
                    temp = array[in + 1];
                    array[in + 1] = array[in];
                    array[in] = temp;
                }
            }
        }
        return array;
    }
}
