package ru.alazarev.chess.figures.black;

import ru.alazarev.chess.exception.ImposibleMoveException;
import ru.alazarev.chess.figures.Figure;
import ru.alazarev.chess.figures.Cell;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class KnightBlack extends Figure {

    public KnightBlack(final Cell position) {
        super(position);
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        int changeX = dest.x - source.x;
        int changeY = dest.y - source.y;
        int stepX = dest.x - source.x <= 1 ? -1 : 1;
        int stepY = dest.x - source.x <= 1 ? -1 : 1;
        if (!((Math.abs(changeX) == 2 && Math.abs(changeY) == 1) ||
                (Math.abs(changeY) == 2 && Math.abs(changeX) == 1))) {
            throw new ImposibleMoveException("Impossible move, Knight can'n move that");
        }
        int countSteps = Math.abs(dest.x - source.x) + Math.abs(dest.y - source.y);
        Cell[] steps = new Cell[countSteps];
        for (int index = 0; index < countSteps; index++) {
            //if (TODO)
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new KnightBlack(dest);
    }

}
