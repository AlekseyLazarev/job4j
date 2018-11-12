package ru.alazarev.array;

/**
 * Class Square решение задачи части 001. 6.3. Массив заполнен true или false [#53857][#86226]
 *
 * @author Aleksey Lazarev
 * @since 12.11.2018
 */
public class Check {
    /**
     * Checking the array for the equal values.
     *
     * @param data array of elements.
     * @return result of check.
     */
    public boolean mono(boolean[] data) {
        boolean result = false;
        for (int index = 0; index < data.length - 1; index++) {
            if (data[index] == data[index + 1]) {
                result = true;
            } else {
                result = false;
                break;
            }
        }
        return result;
    }
}
