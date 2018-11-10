package ru.alazarev.loop;
/**
 * Class Counter решение задачи части 001. Урок 5.1. Подсчет суммы чётных чисел в диапазоне [#192].
 * @author Aleksey Lazarev
 * @since 11.11.2018
 */
public class Counter {
    /**
     * Return max value method.
     * @param start Start of sequence.
     * @param finish End of sequence.
     * @return sum of even.
     */
    public int add(int start, int finish) {
        int sum = 0;
        while (start <= finish) {
            if (start % 2 == 0) {
                sum += start;
            }
            start++;
        }
        return sum;
    }
}