package ru.alazarev.chess.figures.white;

import ru.alazarev.chess.exception.ImposibleMoveException;
import ru.alazarev.chess.figures.Cell;
import ru.alazarev.chess.figures.Figure;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class KnightWhite extends Figure {


    public KnightWhite(final Cell position) {
        super(position);
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        int deltaX = dest.x - source.x;
        int deltaY = dest.y - source.y;
        int stepX = dest.x - source.x >= 1 ? -1 : 1;
        int stepY = dest.y - source.y >= 1 ? -1 : 1;
        if (!((Math.abs(deltaX) == 2 && Math.abs(deltaY) == 1)
                || (Math.abs(deltaY) == 2 && Math.abs(deltaX) == 1))) {
            throw new ImposibleMoveException("Impossible move, Knight can'n move that");
        }
        int countSteps = Math.abs(deltaX) + Math.abs(deltaY);
        Cell[] steps = new Cell[countSteps];
        for (int index = 0; index < Math.abs(deltaX); index++) {
            int x = source.x - stepX * (index + 1);
            steps[index] = Cell.values()[x * 8 + source.y];
        }
        for (int index = 0; index < Math.abs(deltaY); index++) {
            int y = source.y - stepY * (index + 1);
            steps[index + Math.abs(deltaX)] = Cell.values()[steps[index + Math.abs(deltaX) - 1].x * 8 + y];
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new KnightWhite(dest);
    }
}
