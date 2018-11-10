package ru.alazarev.loop;
/**
 * Class Factorial решение задачи части 001. Урок 5.2. Создать программу вычисляющую факториал. [#193].
 * @author Aleksey Lazarev
 * @since 11.11.2018
 */
public class Factorial {
    /**
     * Return max value method.
     * @param n value for factorial calculation.
     * @return factorial.
     */
    public int calc(int n) {
        int fact = 1;
        if (n == 0) {
            return fact;
        } else {
            for (int i = 1; i <= n; i++) {
                fact *= i;
            }
            return fact;
        }
    }
}
