package ru.alazarev.seafight.interfaces;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;

/**
 * Interface IPlayer решение задачи части "Создание игры морской бой".
 *
 * @author Aleksey Lazarev
 * @since 18.09.2019
 */
public interface IPlayer {
    /**
     * Method of placing the ship on the field.
     *
     * @param ship       Ship for pacing.
     * @param way        Direction of placement.
     * @param startPlace Starting coordinate of the ship.
     * @return Result placing.
     */
    boolean placeShip(IShip ship, String way, int startPlace);

    /**
     * Method returns placed ships.
     *
     * @return Placed ships hashmap.
     */
    HashMap<Integer, IShip> getPlacedShip();

    /**
     * Method checks shot.
     *
     * @param cell Shot cell.
     * @return result check.
     */
    boolean checkShot(int cell);

    /**
     * Method get cell for shot.
     *
     * @return Cell for shot.
     */
    int getShot();

    /**
     * Method adds used cell.
     *
     * @param cell Used cell.
     */
    void addMiss(int cell);

    /**
     * Method return enemyPole.
     *
     * @return Enemy pole.
     */
    HashSet<Integer> getEnemyPole();

    /**
     * Method return pole size.
     *
     * @return Pole size.
     */
    int getSize();

    /**
     * Method get ships.
     *
     * @return Ships.
     */
    Queue<IShip> getShips();

    /**
     * Method return player name.
     *
     * @return Player name.
     */
    String getPlayerName();
}
