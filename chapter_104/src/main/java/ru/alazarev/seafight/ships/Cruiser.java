package ru.alazarev.seafight.ships;

import ru.alazarev.seafight.interfaces.IShip;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Class Cruiser решение задачи части "Создание игры морской бой".
 *
 * @author Aleksey Lazarev
 * @since 19.09.2019
 */
public class Cruiser implements IShip {
    private int shipSize = 3;
    private int stdCount = 2;
    private Queue decks = new PriorityQueue();

    /**
     * Constructor.
     */
    public Cruiser() {
        for (int i = 0; i < this.shipSize; i++) {
            this.decks.add(i);
        }
    }

    /**
     * Method checks a wounded ship or is killed.
     *
     * @return Result check.
     */
    @Override
    public boolean bang() {
        boolean result;
        if (this.decks.isEmpty()) {
            result = true;
        } else {
            this.decks.poll();
            result = this.decks.isEmpty();
        }
        return result;
    }

    /**
     * Method return standard ship count.
     *
     * @return Standard ship count.
     */
    @Override
    public int getCount() {
        return this.stdCount;
    }


    /**
     * Method return ship symbol.
     *
     * @return Ship symbol.
     */
    @Override
    public int getSymbol() {
        return this.shipSize * (-1);
    }

    /**
     * Method return ship name.
     *
     * @return Ship name.
     */
    @Override
    public String getShipName() {
        return "Cruiser";
    }

    /**
     * Method return ship size.
     *
     * @return Ship size.
     */
    @Override
    public int getSize() {
        return this.shipSize;
    }
}
