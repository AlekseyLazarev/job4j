package ru.alazarev.chess.figures.white;

import ru.alazarev.chess.figures.Cell;
import ru.alazarev.chess.figures.Figure;
import ru.alazarev.chess.figures.FigureInterface;

import java.lang.reflect.Field;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class KingWhite extends Figure {

    public KingWhite(final Cell position) {
        super(position);
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        return new Cell[]{dest};
    }

    @Override
    public Figure copy(Cell dest) {
        return new KingWhite(dest);
    }
}
