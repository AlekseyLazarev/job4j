package ru.alazarev.calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * Class Calculator решение задачи части 001. Урок 3.1. Элементарный калькулятор. [#185].
 * и задачи уровня 2 части 004. Урок 1.1. Использую класса Calculator. Сделать класс InteractCalc. [#850].
 *
 * @author Aleksey Lazarev
 * @since 07.05.2019
 */
public class Calculator {
    private final Map<String, Function<String[], Double>> map = new HashMap<>();

    /**
     * Method initiate calculator.
     *
     * @return filled calculator.
     */
    public Calculator init() {
        EngineerCalc engineerCalc = new EngineerCalc();
        fill();
        this.map.putAll(engineerCalc.resent());
        return this;
    }

    /**
     * Method fill four actions.
     */
    private void fill() {
        load("+", add());
        load("-", sub());
        load("/", div());
        load("*", mul());
    }

    /**
     * Method load functions with their keys.
     *
     * @param type Type actions.
     * @param func Function.
     */
    public void load(String type, Function<String[], Double> func) {
        map.put(type, func);
    }

    /**
     * Method adds numbers.
     *
     * @return Result adds.
     */
    private Function<String[], Double> add() {
        return arr -> {
            return Double.parseDouble(arr[0]) + Double.parseDouble(arr[2]);
        };
    }

    /**
     * Method subtracts numbers.
     *
     * @return Result subtracts.
     */
    private Function<String[], Double> sub() {
        return arr -> {
            return Double.parseDouble(arr[0]) - Double.parseDouble(arr[2]);
        };
    }

    /**
     * Method divides numbers.
     *
     * @return Result divides.
     */
    private Function<String[], Double> div() {
        return arr -> {
            return Double.parseDouble(arr[0]) / Double.parseDouble(arr[2]);
        };
    }

    /**
     * Method multiplies numbers.
     *
     * @return Result multiplies.
     */
    private Function<String[], Double> mul() {
        return arr -> {
            return Double.parseDouble(arr[0]) * Double.parseDouble(arr[2]);
        };
    }

    /**
     * Method calls the function.
     *
     * @param expression Expression for call.
     * @return Result expression.
     */
    public double sent(String[] expression) {
        return this.map.get(expression[1]).apply(expression);
    }
}