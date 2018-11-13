package ru.alazarev.array;
/**
 * Class MatrixCheck решение задачи части 001. 6.7. Квадратный массив заполнен true или false по диагоналям. [#53859].
 *
 * @author Aleksey Lazarev
 * @since 13.11.2018
 */
public class MatrixCheck {
    /**
     * Check diagonal.
     *
     * @param data Matrix with boolean values.
     * @return result of check diagonal boolean values.
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int row = 0; row < data.length - 1; row++) {
            for (int column = 0; column < data.length - 1; column++) {
                if ((row == column) && (data[row][column] !=data[row + 1][column + 1])) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }
}
