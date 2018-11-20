package ru.alazarev.chess.figures;

public interface FigureInterface {
    Cell position();

    Cell[] way(Cell source, Cell dest);

    default String icon() {
        return String.format(
                "%s.png", this.getClass().getSimpleName()
        );

    }

    FigureInterface copy(Cell dest);

}
