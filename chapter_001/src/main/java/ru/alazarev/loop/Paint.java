package ru.alazarev.loop;

import java.util.function.BiPredicate;

/**
 * Class Paint решение задачи части 001. Урок 5.5. Рефакторинг кода. [#33459].
 *
 * @author Aleksey Lazarev
 * @since 11.11.2018
 */
public class Paint {

    /**
     * Paint pseudographic right triangle.
     *
     * @param height Triangle height.
     * @return pseudographic right triangle.
     */
    public String rightTriangle(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= column
        );
    }

    /**
     * Paint pseudographic left triangle.
     *
     * @param height Triangle height.
     * @return pseudographic left triangle.
     */
    public String leftTriangle(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= height - column - 1
        );
    }

    /**
     * Paint pseudographic pyramid.
     *
     * @param height Pyramid height.
     * @return pseudographic pyramid.
     */
    public String pyramid(int height) {
        return this.loopBy(
                height,
                2 * height - 1,
                (row, column) -> row >= height - column - 1 && row + height - 1 >= column
        );
    }

    /**
     * Paint in pseudographic depending on the input.
     *
     * @param height  Figure height.
     * @param width   Figure width.
     * @param predict Figure depending.
     * @return pseudographic figure.
     */
    private String loopBy(int height, int width, BiPredicate<Integer, Integer> predict) {
        StringBuilder screen = new StringBuilder();
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != width; column++) {
                if (predict.test(row, column)) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }
}
