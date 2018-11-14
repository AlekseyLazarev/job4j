package ru.alazarev.loop;

/**
 * Class Board решение задачи части 001. Урок 5.3. Построить шахматную доску в псевдографике. [#13559].
 *
 * @author Aleksey Lazarev
 * @since 11.11.2018
 */
public class Board {
    /**
     * Paint pseudographic board.
     *
     * @param width  Board width.
     * @param height Board height.
     * @return pseudographic board.
     */
    public String paint(int width, int height) {
        StringBuilder board = new StringBuilder();
        String ln = System.lineSeparator();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ((i + j) % 2 == 0) {
                    board.append("X");
                } else {
                    board.append(" ");
                }
            }
            board.append(ln);
        }
        return board.toString();
    }
}
