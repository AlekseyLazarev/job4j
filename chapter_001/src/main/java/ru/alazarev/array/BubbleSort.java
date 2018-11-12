package ru.alazarev.array;

/**
 * Class BubbleSort решение задачи части 001. 6.3. Массив заполнен true или false [#53857][#86226]
 *
 * @author Aleksey Lazarev
 * @since 12.11.2018
 */
public class BubbleSort {
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
