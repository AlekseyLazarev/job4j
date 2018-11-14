package ru.alazarev.array;

import java.util.Arrays;

/**
 * Class ArrayDuplicate решение задачи части 001. 6.8. Удаление дубликатов в массиве. [#225].
 *
 * @author Aleksey Lazarev
 * @since 13.11.2018
 */
public class ArrayDuplicate {
    /**
     * Delete duplicates in array.
     *
     * @param array String array with duplicated values.
     * @return array without duplicates.
     */
    public String[] remove(String[] array) {
        int length = array.length;
        for (int outIndex = 0; outIndex < length; outIndex++) {
            for (int in = 0; in < length; in++) {
                if (outIndex != in && array[outIndex].equals(array[in])) {
                    array[in] = array[length - 1];
                    length--;
                }
            }
        }
        return Arrays.copyOf(array, length);
    }
}
