package ru.alazarev.array;

/**
 * Class Square решение задачи части 001. 6.2. Перевернуть массив. [#4441].
 *
 * @author Aleksey Lazarev
 * @since 12.11.2018
 */

public class Turn {

    /**
     * Reverse array.
     *
     * @param array Basic array.
     * @return Backward array.
     */
    public int[] back(int[] array) {
        for (int index = 0; index < array.length / 2; index++) {
            int temp = array[index];
            array[index] = array[array.length - index - 1];
            array[array.length - 1 - index] = temp;
        }
        return array;
    }
}
