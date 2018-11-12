package ru.alazarev.array;

/**
 * Class FindLoop решение задачи части 001. 6.1. Классический поиск перебором. [#33489].
 *
 * @author Aleksey Lazarev
 * @since 12.11.2018
 */
public class FindLoop {
    /**
     * Find element in array.
     *
     * @param data array of elements.
     * @param el   Finding element.
     * @return Index of element.
     */
    public int indexOf(int[] data, int el) {
        int rst = -1;
        for (int index = 0; index < data.length; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}
