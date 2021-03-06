package ru.alazarev.chess;

import org.junit.Before;
import org.junit.Test;
import ru.alazarev.chess.exception.FigureNotFoundException;
import ru.alazarev.chess.exception.ImposibleMoveException;
import ru.alazarev.chess.exception.OccupiedWayException;
import ru.alazarev.chess.figures.Cell;
import ru.alazarev.chess.figures.black.*;

public class BoardTest {
    private final Board board = new Board();

    @Before
    public void buildBlackTeam() {
        board.add(new PawnBlack(Cell.A7));
        board.add(new PawnBlack(Cell.B7));
        board.add(new PawnBlack(Cell.C7));
        board.add(new PawnBlack(Cell.D7));
        board.add(new PawnBlack(Cell.E7));
        board.add(new PawnBlack(Cell.F7));
        board.add(new PawnBlack(Cell.G7));
        board.add(new PawnBlack(Cell.H7));
        board.add(new RookBlack(Cell.A8));
        board.add(new KnightBlack(Cell.B8));
        board.add(new BishopBlack(Cell.C8));
        board.add(new QueenBlack(Cell.D8));
        board.add(new KingBlack(Cell.E8));
        board.add(new BishopBlack(Cell.F8));
        board.add(new KnightBlack(Cell.G8));
        board.add(new RookBlack(Cell.H8));
    }

    @Test(expected = ImposibleMoveException.class)
    public void whenBishopBlackMoveImpossible() {
        board.move(Cell.C8, Cell.C6);
        board.move(Cell.F8, Cell.A6);
    }

    @Test(expected = OccupiedWayException.class)
    public void whenBishopHasFigureOnWay() {
        board.move(Cell.C8, Cell.A6);
    }

    @Test(expected = FigureNotFoundException.class)
    public void whenFigureNotFound() {
        board.move(Cell.C2, Cell.C2);
    }

    @Test(expected = ImposibleMoveException.class)
    public void whenKingBlackMoveImpossible() {
        board.move(Cell.E7, Cell.E6);
        board.move(Cell.E6, Cell.E5);
        board.move(Cell.E8, Cell.E7);
        board.move(Cell.E7, Cell.A7);
    }

    @Test(expected = OccupiedWayException.class)
    public void whenKingBlackHasFigureOnWay() {
        board.move(Cell.E8, Cell.E7);
    }

    @Test(expected = ImposibleMoveException.class)
    public void whenKnightBlackMoveImpossible() {
        board.move(Cell.B8, Cell.D8);
    }

    @Test(expected = OccupiedWayException.class)
    public void whenKnightBlackHasFigureOnWay() {
        board.move(Cell.B8, Cell.D7);
    }

    @Test(expected = ImposibleMoveException.class)
    public void whenPawnBlackMoveImpossible() {
        board.move(Cell.B7, Cell.D6);
    }

    @Test(expected = OccupiedWayException.class)
    public void whenPawnBlackHasFigureOnWay() {
        board.move(Cell.B8, Cell.C6);
        board.move(Cell.C7, Cell.C6);
    }

    @Test(expected = ImposibleMoveException.class)
    public void whenQueenBlackMoveImpossible() {
        board.move(Cell.C7, Cell.C6);
        board.move(Cell.D8, Cell.A5);
        board.move(Cell.A5, Cell.C4);
    }

    @Test(expected = OccupiedWayException.class)
    public void whenQueenBlackHasFigureOnWay() {
        board.move(Cell.D8, Cell.B6);
    }

    @Test(expected = ImposibleMoveException.class)
    public void whenRookBlackMoveImpossible() {
        board.move(Cell.A7, Cell.A6);
        board.move(Cell.A6, Cell.A5);
        board.move(Cell.A8, Cell.A6);
        board.move(Cell.A6, Cell.B5);
    }

    @Test(expected = OccupiedWayException.class)
    public void whenRookBlackHasFigureOnWay() {
        board.move(Cell.A8, Cell.A6);
    }


}
