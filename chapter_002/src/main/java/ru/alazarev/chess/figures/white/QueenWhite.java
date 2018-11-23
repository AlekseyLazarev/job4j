package ru.alazarev.chess.figures.white;

import ru.alazarev.chess.exception.ImposibleMoveException;
import ru.alazarev.chess.figures.Cell;
import ru.alazarev.chess.figures.Figure;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class QueenWhite extends Figure {

    public QueenWhite(final Cell position) {
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
        Cell[] steps;
        if (deltaX == 0 || deltaY == 0) {
            if (!isLine(source, dest)) {
                throw new ImposibleMoveException("Impossible move for this queen");
            }
            steps = new Cell[Math.abs(deltaX) + Math.abs(deltaY)];
            for (int index = 0; index < steps.length; index++) {
                int x = source.x - stepX * (index + 1);
                int y = source.y - stepY * (index + 1);
                steps[index] = Cell.values()[x * 8 + y];
            }
        } else {
            if (!isDiagonal(source, dest)) {
                throw new ImposibleMoveException("Impossible move for this queen");
            }
            steps = new Cell[Math.abs(deltaX)];
            for (int index = 0; index < steps.length; index++) {
                int x = source.x - stepX * (index + 1);
                int y = source.y - stepY * (index + 1);
                steps[index] = Cell.values()[x * 8 + y];
            }
        }

        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new QueenWhite(dest);
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return Math.abs(dest.x - source.x) == Math.abs(dest.y - source.y);
    }

    public boolean isLine(Cell source, Cell dest) {
        return source.x == dest.x || source.y == dest.y;
    }
}
