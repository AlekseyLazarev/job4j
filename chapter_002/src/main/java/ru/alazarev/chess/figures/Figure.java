package ru.alazarev.chess.figures;

public abstract class Figure {
    /**
     * Place of figure.
     */
    public final Cell position;

    /**
     * Constructor.
     * @param position Class Cell object.
     */
    public Figure(Cell position) {
        this.position = position;
    }

    /**
     * Method move figure.
     * @param source From where move figure.
     * @param dest Where move.
     * @return
     */
    public abstract Cell[] way(Cell source, Cell dest);

    /**
     * Method create copy figure in destination.
     * @param dest Class Cell object as destination.
     * @return Class Figure object.
     */
    public abstract Figure copy(Cell dest);

    public String icon() {
        return String.format(
                "%s.png", this.getClass().getSimpleName()
        );
    }

}