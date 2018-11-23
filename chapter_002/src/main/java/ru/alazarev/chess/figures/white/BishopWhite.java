package ru.alazarev.chess.figures.white;

import ru.alazarev.chess.exception.ImposibleMoveException;
import ru.alazarev.chess.figures.Cell;
import ru.alazarev.chess.figures.Figure;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopWhite extends Figure {

    public BishopWhite(final Cell position) {
        super(position);
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (!isDiagonal(source, dest)) {
            throw new ImposibleMoveException("Impossible move, bishop can move only diagonal");
        }
        int deltaX = source.x - dest.x;
        int deltaY = source.y - dest.y;
        Cell[] steps = new Cell[Math.abs(deltaX)];
        int stepX = deltaX > 0 ? 1 : -1;
        int stepY = deltaY > 0 ? 1 : -1;
        for (int index = 0; index < steps.length; index++) {
            int x = source.x - stepX * (index + 1);
            int y = source.y - stepY * (index + 1);
            steps[index] = Cell.values()[x * 8 + y];
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopWhite(dest);
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return Math.abs(dest.x - source.x) == Math.abs(dest.y - source.y);
    }
}
