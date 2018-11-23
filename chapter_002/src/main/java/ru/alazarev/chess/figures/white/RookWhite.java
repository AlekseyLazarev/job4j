package ru.alazarev.chess.figures.white;

import ru.alazarev.chess.exception.ImposibleMoveException;
import ru.alazarev.chess.figures.Cell;
import ru.alazarev.chess.figures.Figure;


/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class RookWhite extends Figure {

    public RookWhite(final Cell position) {
        super(position);
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        int deltaX = source.x - dest.x;
        int deltaY = source.y - dest.y;
        int stepX;
        int stepY;
        if (deltaX == 0) {
            stepX = 0;
        } else if (deltaX > 0) {
            stepX = 1;
        } else {
            stepX = -1;
        }
        if (deltaY == 0) {
            stepY = 0;
        } else if (deltaY > 0) {
            stepY = 1;
        } else {
            stepY = -1;
        }
        Cell[] steps = new Cell[Math.abs(deltaX) + Math.abs(deltaY)];
        if (!isLine(source, dest)) {
            throw new ImposibleMoveException("Impossible move for this rook");
        }
        for (int index = 0; index < steps.length; index++) {
            int x = source.x - stepX * (index + 1);
            int y = source.y - stepY * (index + 1);
            steps[index] = Cell.values()[x * 8 + y];
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new RookWhite(dest);
    }

    public boolean isLine(Cell source, Cell dest) {
        return source.x == dest.x || source.y == dest.y;
    }
}
