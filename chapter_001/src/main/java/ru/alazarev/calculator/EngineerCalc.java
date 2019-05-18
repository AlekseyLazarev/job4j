package ru.alazarev.calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * Class EngineerCalc решение задачи уровня 2 части 004.
 * Урок 2.1. На базе задания из занятия SRP расширить калькулятор [#851]
 *
 * @author Aleksey Lazarev
 * @since 08.05.2019
 */
public class EngineerCalc {
    /**
     * Method unites all new func in map.
     *
     * @return
     */
    public Map<String, Function<String[], Double>> resent() {
        Map<String, Function<String[], Double>> map = new HashMap<>();
        map.put("cos", cos());
        map.put("sin", sin());
        map.put("tg", tg());
        return map;
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
}
