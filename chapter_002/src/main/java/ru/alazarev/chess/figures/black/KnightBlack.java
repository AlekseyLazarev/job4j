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
        int stepX = dest.x - source.x >= 1 ? -1 : 1;
        int stepY = dest.y - source.y >= 1 ? -1 : 1;
        if (!((Math.abs(changeX) == 2 && Math.abs(changeY) == 1) ||
                (Math.abs(changeY) == 2 && Math.abs(changeX) == 1))) {
            throw new ImposibleMoveException("Impossible move, Knight can'n move that");
        }
        int countSteps = Math.abs(changeX) + Math.abs(changeY);
        Cell[] steps = new Cell[countSteps];
        for (int index = 0; index < Math.abs(changeX); index++) {
            int x = source.x - stepX * (index + 1);
            steps[index] = Cell.values()[x * 8 + source.y];
        }
        for (int index = 0; index  < Math.abs(changeY); index++) {
            int y = source.y - stepY * (index + 1);
            steps[index+Math.abs(changeX)] = Cell.values()[steps[index+Math.abs(changeX)-1].x * 8 + y];
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new KnightBlack(dest);
    }

}
