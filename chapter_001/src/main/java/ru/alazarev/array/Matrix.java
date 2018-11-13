package ru.alazarev.array;

/**
 * Class Matrix решение задачи части 001. 6.6. Двухмерный массив. Таблица умножения. [#33491].
 *
 * @author Aleksey Lazarev
 * @since 13.11.2018
 */
public class Matrix {
    /**
     * Multiple row and column in matrix.
     *
     * @param size Size matrix.
     * @return matrix with multiple row and column.
     */
    public int[][] multiple(int size) {
        int[][] array = new int[size][size];
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                array[row][column] = (row + 1) * (column + 1);
            }
        }
        return array;
    }
}
