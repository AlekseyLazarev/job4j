package ru.alazarev.converter;

/**
 *Class Converter решение задачи части 001. 3.2. Конвертер валюты. [#41583].
 *@author Aleksey Lazarev
 *@since 09.11.2018
 */
public class Converter {
    private static final int EURO = 76;
    private static final int DOLLAR = 67;
    /**
     * Convert rub into euro.
     * @param value In rub.
     * @return Euro.
     */
    public int rubleToEuro(int value) {
        return value / EURO;
    }
    /**
     * Convert rub into dollar.
     * @param value In rub.
     * @return Dollar.
     */
    public int rubleToDollar(int value) {
        return value / DOLLAR;
    }
    /**
     * Convert euro into rub.
     * @param value In euro.
     * @return Rub.
     */
    public int euroToRuble(int value) {
        return value * EURO;
    }
    /**
     * Convert dollar into rub.
     * @param value In dollar.
     * @return Rub.
     */
    public int dollarToRuble(int value) {
        return value * DOLLAR;
    }
}
