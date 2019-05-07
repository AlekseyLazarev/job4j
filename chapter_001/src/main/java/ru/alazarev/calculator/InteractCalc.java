package ru.alazarev.calculator;

import java.util.Scanner;

/**
 * Class InteractCalc решение задачи уровня 2 части 004. Урок 1.1. Использую класса Calculator.
 * Сделать класс InteractCalc. [#850].
 *
 * @author Aleksey Lazarev
 * @since 07.05.2019
 */

public class InteractCalc {
    private final Scanner in;
    private final Calculator calc;

    public InteractCalc(Scanner scanner, Calculator calc) {
        this.in = scanner;
        this.calc = calc;
    }

    /**
     * Method init loop.
     */
    public void init() {
        String current = this.in.nextLine();
        while (!"exit".equals(current)) {
            output(current, this.calc.sent(current.split(" ")));
            current = this.in.nextLine();
        }
    }

    /**
     * Method print string into console.
     *
     * @param expression Expression for print.
     * @param result     Result expression for print.
     */
    private void output(String expression, Double result) {
        System.out.format("Result of calculation %s = %f" + System.lineSeparator(), expression, result);
    }

    /**
     * Main method start app point.
     *
     * @param args
     */
    public static void main(String[] args) {
        InteractCalc interactCalc = new InteractCalc(new Scanner(System.in), new Calculator().init());
        interactCalc.init();
    }
}
