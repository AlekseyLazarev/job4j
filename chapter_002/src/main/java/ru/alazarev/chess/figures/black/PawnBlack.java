package ru.alazarev.chess.figures.black;

import ru.alazarev.chess.figures.Cell;
import ru.alazarev.chess.figures.Figure;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class PawnBlack extends Figure {


    public PawnBlack(final Cell position) {
        super(position);
    }

    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps = new Cell[0];
        if (source.y == dest.y + 1 && source.x == dest.x) {
            steps = new Cell[]{dest};
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new PawnBlack(dest);
    }

}
