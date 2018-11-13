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
        for (int i = 0; i < array.length; i++) {
            String temp = array[i];
            for (int j = 0; j < array.length; j++) {
                if (i != j && temp.equals(array[j])) {
                    array[j] = array[array.length - 1];
                    array = Arrays.copyOf(array, array.length - 1);
                }
            }
        }
        return array;
    }
}
