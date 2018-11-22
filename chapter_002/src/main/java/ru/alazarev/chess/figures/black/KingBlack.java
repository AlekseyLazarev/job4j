package ru.alazarev.chess.figures.black;

import ru.alazarev.chess.figures.Figure;
import ru.alazarev.chess.figures.Cell;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class KingBlack extends Figure {

    public KingBlack(final Cell position) {
        super(position);
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps = new Cell[0];
        if (Math.abs(dest.x - source.x) == 1 || Math.abs(dest.y - source.y) == 1) {
            steps = new Cell[] { dest };
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new KingBlack(dest);
    }

}
