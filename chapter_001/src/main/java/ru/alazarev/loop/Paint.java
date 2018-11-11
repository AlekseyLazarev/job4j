package ru.alazarev.loop;
/**
 * Class Paint решение задачи части 001. Урок 5.4. Построить пирамиду в псевдографике. [#4412].
 *
 * @author Aleksey Lazarev
 * @since 11.11.2018
 */
public class Paint {
    /**
     * Paint pseudographic right triangle.
     *
     * @param height Board height.
     * @return pseudographic right triangle.
     */
    public String rightTriangle(int height) {
        StringBuilder screen = new StringBuilder();
        for (int row = 0; row < height; row++) {
            for (int column = 0; column != height; column++) {
                if (row >= column) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }
    /**
     * Paint pseudographic left triangle.
     *
     * @param height Board height.
     * @return pseudographic left triangle.
     */
    public String leftTriangle(int height) {
        StringBuilder screen = new StringBuilder();
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != height; column++) {
                if (row >= height - column - 1) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }
    /**
     * Paint pseudographic pyramid.
     *
     * @param height Board height.
     * @return pseudographic pyramid.
     */
    public String pyramid(int height) {
        StringBuilder screen = new StringBuilder();
        int width = height * 2 - 1;
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != width; column++) {
                if (row >= height - column - 1 && row + height -1 >= column) {
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
