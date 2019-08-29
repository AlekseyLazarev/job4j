package ru.alazarev.tictactoe;

import com.google.common.collect.HashBiMap;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Class TicTacToeTest решение задачи части 004. 7. Крестики-нолики ООД [#793]
 *
 * @author Aleksey Lazarev
 * @since 28.08.2019
 */
public class TicTacToeTest {
    TicTacToe pole3win3 = new TicTacToe();
    TicTacToe pole5win5 = new TicTacToe();

    @Before
    public void setUp() {
        this.pole3win3.getOutputPseudographic().init(HashBiMap.create());
        this.pole5win5.getOutputPseudographic().init(HashBiMap.create());
        this.pole3win3.setPoleSize(3);
        this.pole5win5.setPoleSize(5);
    }

    @Test
    public void whenFivePoleHorizontalLineWinThenTrue() {
        this.pole5win5.setPole(new int[]
                {-1, -1, -1, -1, -1,
                        6, 7, 8, 9, 10,
                        11, 12, 13, 14, 15,
                        16, 17, 18, 19, 20,
                        21, 22, 23, 24, 25});
        assertThat(this.pole5win5.checkHorizontal(0), is(true));
        assertThat(this.pole5win5.checkHorizontal(1), is(true));
        assertThat(this.pole5win5.checkHorizontal(2), is(true));
        assertThat(this.pole5win5.checkHorizontal(3), is(true));
        assertThat(this.pole5win5.checkHorizontal(4), is(true));
    }

    @Test
    public void whenFivePoleButNotFiveInHorizontalLineWinThenFalse() {
        this.pole5win5.setPole(new int[]
                {-1, -1, -1, -1, 5,
                        6, 7, 8, 9, 10,
                        11, 12, 13, 14, 15,
                        16, 17, 18, 19, 20,
                        21, 22, 23, 24, 25});
        assertThat(this.pole5win5.checkHorizontal(3), is(false));
    }

    @Test
    public void whenFivePoleVerticalLineWinThenTrue() {
        this.pole5win5.setPole(new int[]
                {-1, 2, 3, 4, 5,
                        -1, 7, 8, 9, 10,
                        -1, 12, 13, 14, 15,
                        -1, 17, 18, 19, 20,
                        -1, 22, 23, 24, 25});
        assertThat(this.pole5win5.checkVertical(5), is(true));
    }

    @Test
    public void whenFivePoleButNotFiveInVerticalLineWinThenFalse() {
        this.pole5win5.setPole(new int[]
                {-1, 2, 3, 4, 5,
                        -1, 7, 8, 9, 10,
                        -1, 12, 13, 14, 15,
                        -1, 17, 18, 19, 20,
                        21, 22, 23, 24, 25});
        assertThat(this.pole5win5.checkVertical(5), is(false));
    }

    @Test
    public void whenFivePoleLeftToRightDiagonalLineWinThenTrue() {
        this.pole5win5.setPole(new int[]
                {-1, 2, 3, 4, 5,
                        6, -1, 8, 9, 10,
                        11, 12, -1, 14, 15,
                        16, 17, 18, -1, 20,
                        21, 22, 23, 24, -1});
        assertThat(this.pole5win5.checkLeftToRightDiagonal(6), is(true));
    }

    @Test
    public void whenFivePoleButNotFiveInLeftToRightDiagonalLineWinThenFalse() {
        this.pole5win5.setPole(new int[]
                {-1, 2, 3, 4, 5,
                        6, -1, 8, 9, 10,
                        11, 12, -1, 14, 15,
                        16, 17, 18, -1, 20,
                        21, 22, 23, 24, 25});
        assertThat(this.pole5win5.checkLeftToRightDiagonal(6), is(false));
    }

    @Test
    public void whenFivePoleRightToLeftDiagonalLineWinThenTrue() {
        this.pole5win5.setPole(new int[]
                {1, 2, 3, 4, -1,
                        6, 7, 8, -1, 10,
                        11, 12, -1, 14, 15,
                        16, -1, 18, 19, 20,
                        -1, 22, 23, 24, 25});
        assertThat(this.pole5win5.checkRightToLeftDiagonal(20), is(true));
    }

    @Test
    public void whenFivePoleButNotFiveInRightToLeftLineWinThenFalse() {
        this.pole5win5.setPole(new int[]
                {1, 2, 3, 4, -1,
                        6, 7, 8, -1, 10,
                        11, 12, -1, 14, 15,
                        16, -1, 18, 19, 20,
                        21, 22, 23, 24, 25});
        assertThat(this.pole5win5.checkRightToLeftDiagonal(20), is(false));
    }

    @Test
    public void whenHorizontalLineWinThenGameOver() {
        this.pole3win3.setPole(new int[]
                {-1, -1, -1,
                        4, 5, 6,
                        7, 8, 9});
        assertThat(this.pole3win3.checkHorizontal(0), is(true));
        assertThat(this.pole3win3.checkHorizontal(1), is(true));
        assertThat(this.pole3win3.checkHorizontal(2), is(true));
    }

    @Test
    public void whenVerticalLineWinThenGameOver() {
        this.pole3win3.setPole(new int[]
                {-2, 2, 3,
                        -2, 5, 6,
                        -2, 8, 9});
        assertThat(this.pole3win3.checkVertical(0), is(true));
        assertThat(this.pole3win3.checkVertical(3), is(true));
        assertThat(this.pole3win3.checkVertical(6), is(true));
    }

    @Test
    public void whenLeftToRightDiagonalLineWinThenGameOver() {
        this.pole3win3.setPole(new int[]
                {-1, 2, 3,
                        4, -1, 6,
                        7, 8, -1});
        assertThat(this.pole3win3.checkLeftToRightDiagonal(0), is(true));
        assertThat(this.pole3win3.checkLeftToRightDiagonal(4), is(true));
        assertThat(this.pole3win3.checkLeftToRightDiagonal(8), is(true));
    }

    @Test
    public void whenRightToLeftDiagonalLineWinThenGameOver() {
        this.pole3win3.setPole(new int[]
                {1, 2, -1,
                        4, -1, 6,
                        -1, 8, 9});
        assertThat(this.pole3win3.checkRightToLeftDiagonal(2), is(true));
        assertThat(this.pole3win3.checkRightToLeftDiagonal(4), is(true));
        assertThat(this.pole3win3.checkRightToLeftDiagonal(6), is(true));
    }

    @Test
    public void whenNoWinCondThenNotGameOver() {
        this.pole3win3.setPole(new int[]
                {1, 2, -1,
                        4, 5, 6,
                        -1, 8, 9});
        assertThat(this.pole3win3.isGameOver(2), is(false));
        assertThat(this.pole3win3.isGameOver(4), is(false));
        assertThat(this.pole3win3.isGameOver(6), is(false));
    }

}