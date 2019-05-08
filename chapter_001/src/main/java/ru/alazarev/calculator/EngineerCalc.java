package ru.alazarev.calculator;

import java.util.function.Function;

/**
 * Class EngineerCalc решение задачи уровня 2 части 004.
 * Урок 2.1. На базе задания из занятия SRP расширить калькулятор [#851]
 *
 * @author Aleksey Lazarev
 * @since 08.05.2019
 */
public class EngineerCalc extends Calculator {
    /**
     * Method init EngineerCalc.
     *
     * @return this object.
     */
    public EngineerCalc init() {
        super.init();
        fillNewMethods();
        return this;
    }

    /**
     * Method count cos.
     *
     * @return Result cos.
     */
    private Function<String[], Double> cos() {
        return arr -> {
            return Math.cos(Double.parseDouble(arr[0]));
        };
    }

    /**
     * Method count sin.
     *
     * @return Result sin.
     */
    private Function<String[], Double> sin() {
        return arr -> {
            return Math.sin(Double.parseDouble(arr[0]));
        };
    }

    /**
     * Method count tg.
     *
     * @return Result tg.
     */
    private Function<String[], Double> tg() {
        return arr -> {
            return Math.tan(Double.parseDouble(arr[0]));
        };
    }

    /**
     * Method add new func in calculator.
     */
    private void fillNewMethods() {
        super.load("cos", cos());
        super.load("sin", sin());
        super.load("tg", tg());
    }
}
