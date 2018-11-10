package ru.alazarev.max;
/**
 * Class Max решение задачи части 001. Урок 4.2. Максимум из двух чисел [#189].
 * @author Aleksey Lazarev
 * @since 10.11.2018
 */
public class Max {
    /**
     * Return max value method.
     * @param first First value.
     * @param second Second value.
     * @return max value.
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }

    public int max(int first, int second, int third) {
        int temp = max(first, second);
        temp = max(temp, third);
        return temp;
    }
}
