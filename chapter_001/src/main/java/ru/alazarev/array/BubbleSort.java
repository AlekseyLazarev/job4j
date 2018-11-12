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
        for (int outindex = 0; outindex < array.length - 1; outindex++) {
            for (int index = 0; index < array.length - outindex - 1; index++) {
                int temp;
                if (array[index + 1] < array[index]) {
                    temp = array[index + 1];
                    array[index + 1] = array[index];
                    array[index] = temp;
                }
            }
        }
        return array;
    }
}
