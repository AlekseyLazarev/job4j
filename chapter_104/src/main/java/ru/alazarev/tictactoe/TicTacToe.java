package ru.alazarev.tictactoe;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import ru.alazarev.tictactoe.interfaces.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class TicTacToe решение задачи части 004. 7. Крестики-нолики ООД [#793]
 *
 * @author Aleksey Lazarev
 * @since 26.08.2019
 */
public class TicTacToe implements ITicTacToe {
    private IOutputPseudographics output = new OutputPseudographics();
    private IInput input = new Input();
    private int[] pole;
    private int poleSize;
    private boolean pcFirst = false;
    private List<ILogic> ways = new ArrayList<>();
    private List<IGraphicElement> graphics = new ArrayList<>();

    /**
     * Method game logic.
     */
    @Override
    public void game() {
        boolean exit;
        int phase = 0;
        this.output.printSquare(this);
        if (!this.pcFirst) {
            Collections.reverse(this.ways);
        }
        this.ways.get(0).setElement(this.graphics.get(0));
        this.ways.get(1).setElement(this.graphics.get(1));
        do {
            int n;
            ILogic current;
            if (phase % 2 == 0) {
                current = this.ways.get(0);
            } else {
                current = this.ways.get(1);
            }
            do {
                n = current.step(this.pole);
            } while (!emptyCell(n));
            insertElement(n, current.getElement());
            exit = !isGameOver(n);
            this.output.printSquare(this);
            if (!exit) {
                System.out.println("GAME IS OVER! " + System.lineSeparator() + current.getElement().elementName() + " PLAYER WIN !");
            }
            phase++;
            if (phase == this.pole.length) {
                System.out.println("GAME OVER, NO ONE WIN");
                exit = false;
            }
        } while (exit);
    }

    /**
     * Method insert element by index.
     *
     * @param index   Insert index element.
     * @param element Insert element.
     */
    @Override
    public void insertElement(int index, IGraphicElement element) {
        this.pole[index] = element.poleSymbol();
    }

    /**
     * Method initiate start params.
     *
     * @param logic    List of logic.
     * @param elements List of elements.
     * @return
     */
    @Override
    public ITicTacToe init(List<ILogic> logic, List<IGraphicElement> elements) {
        this.ways = logic;
        this.graphics = elements;
        this.pcFirst = this.input.pcFirst();
        this.poleSize = this.input.getPoleSize();
        this.pole = new int[(int) Math.pow(poleSize, 2)];
        for (int i = 0; i < this.pole.length; i++) {
            this.pole[i] = i + 1;
        }
        BiMap<Integer, IGraphicElement> graphicMap = HashBiMap.create();
        for (IGraphicElement element : elements) {
            graphicMap.put(element.poleSymbol(), element);
        }
        this.output.init(graphicMap);
        String line = "";
        for (int j = 0; j < this.poleSize; j++) {
            line = line + String.format("%4s+%s", " ", " ").replace(" ", "-");
        }
        this.output.setLine(line);
        return this;
    }

    /**
     * Method return outputPseudographic variable.
     *
     * @return outputPseudographic variable.
     */
    @Override
    public IOutputPseudographics getOutputPseudographic() {
        return this.output;
    }

    /**
     * Method return Input variable.
     *
     * @return Input variable.
     */
    @Override
    public IInput getInput() {
        return this.input;
    }

    /**
     * Method return current pole state.
     *
     * @return current pole state.
     */
    @Override
    public int[] getPole() {
        return this.pole;
    }

    /**
     * Method return pole size.
     *
     * @return pole size.
     */
    @Override
    public int getPoleSize() {
        return this.poleSize;
    }

    /**
     * Return the result of checking the end of the game.
     *
     * @param n Current number for check.
     * @return result of checking.
     */
    @Override
    public boolean isGameOver(int n) {
        return checkHorizontal(n) || checkVertical(n) || checkLeftToRightDiagonal(n) || checkRightToLeftDiagonal(n);
    }

    /**
     * Method set pole size.
     *
     * @param poleSize pole size value.
     */
    public void setPoleSize(int poleSize) {
        this.poleSize = poleSize;
    }

    /**
     * Method set pole matrix.
     *
     * @param pole Pole matrix.
     */
    public void setPole(int[] pole) {
        this.pole = pole;
    }

    /**
     * Method check empty cell in matrix.
     *
     * @param n number cell.
     * @return check result.
     */
    public boolean emptyCell(int n) {
        boolean empty = true;
        for (ILogic logic : this.ways) {
            if (this.pole[n] == logic.getElement().poleSymbol()) {
                empty = false;
                break;
            }
        }
        return empty;
    }

    /**
     * Method checks horizontal matches.
     *
     * @param n cell for check.
     * @return Result check.
     */
    public boolean checkHorizontal(int n) {
        boolean result = false;
        int row = n - n % this.poleSize;
        for (int i = row + 1; i < this.poleSize; i++) {
            if (this.pole[row] != this.pole[i]) {
                result = false;
                break;
            } else {
                result = true;
            }
        }
        return result;
    }

    /**
     * Method checks vertical matches.
     *
     * @param n cell for check.
     * @return Result check.
     */
    public boolean checkVertical(int n) {
        boolean result = false;
        int col = n % this.poleSize;
        for (int i = 1; i < this.poleSize; i++) {
            if (this.pole[col] != this.pole[col + this.poleSize * i]) {
                result = false;
                break;
            } else {
                result = true;
            }
        }
        return result;
    }

    /**
     * Method checks left to right diagonal matches.
     *
     * @param n cell for check.
     * @return Result check.
     */
    public boolean checkLeftToRightDiagonal(int n) {
        boolean result = false;
        int leftToRight = this.poleSize + 1;
        if (n % leftToRight == 0) {
            for (int i = 1; i < this.poleSize; i++) {
                if (this.pole[0] != this.pole[0 + leftToRight * i]) {
                    result = false;
                    break;
                } else {
                    result = true;
                }
            }
        }
        return result;
    }

    /**
     * Method checks right to left diagonal matches.
     *
     * @param n cell for check.
     * @return Result check.
     */
    public boolean checkRightToLeftDiagonal(int n) {
        boolean result = false;
        int rightToLeft = this.poleSize - 1;
        if (n % rightToLeft == 0) {
            for (int i = 1; i < this.poleSize; i++) {
                if (this.pole[rightToLeft] != this.pole[this.poleSize - 1 + rightToLeft * i]) {
                    result = false;
                    break;
                } else {
                    result = true;
                }
            }
        }
        return result;
    }

    /**
     * Main method.
     *
     * @param args Arguments.
     */
    public static void main(String[] args) {
        List<ILogic> logic = new ArrayList<>();
        logic.add(new Computer());
        logic.add(new Computer());
        XGraphicElement x = new XGraphicElement();
        OGraphicElement o = new OGraphicElement();
        YGraphicElement y = new YGraphicElement();
        List<IGraphicElement> graphics = new ArrayList<>();
        graphics.add(x);
        graphics.add(y);
        ITicTacToe t = new TicTacToe().init(logic, graphics);
        t.game();
    }
}
