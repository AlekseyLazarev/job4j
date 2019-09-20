package ru.alazarev.seafight.players;

import ru.alazarev.seafight.interfaces.IPlayer;
import ru.alazarev.seafight.interfaces.IShip;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;
import java.util.Random;

/**
 * Class Computer решение задачи части "Создание игры морской бой".
 *
 * @author Aleksey Lazarev
 * @since 19.09.2019
 */
public class Computer implements IPlayer {
    private IPlayer player;

    /**
     * Constructor.
     *
     * @param player Player value.
     */
    public Computer(IPlayer player) {
        this.player = player;
    }

    /**
     * Initiate method.
     *
     * @return This object.
     */
    public Computer init() {
        Queue<IShip> ships = getShips();
        while (!ships.isEmpty()) {
            IShip ship = ships.poll();
            String[] sq = new String[]{"v", "h"};
            int size = getSize();
            while (!placeShip(ship, sq[new Random().nextInt(sq.length)], new Random().nextInt(size * size))) ;
        }
        return this;
    }

    /**
     * Method of placing the ship on the field.
     *
     * @param ship       Ship for pacing.
     * @param way        Direction of placement.
     * @param startPlace Starting coordinate of the ship.
     * @return Result placing.
     */
    @Override
    public boolean placeShip(IShip ship, String way, int startPlace) {
        return this.player.placeShip(ship, way, startPlace);
    }

    /**
     * Method returns placed ships.
     *
     * @return Placed ships hashmap.
     */
    @Override
    public HashMap<Integer, IShip> getPlacedShip() {
        return this.player.getPlacedShip();
    }

    /**
     * Method checks shot.
     *
     * @param cell Shot cell.
     * @return result check.
     */
    @Override
    public boolean checkShot(int cell) {
        return this.player.checkShot(cell);
    }

    /**
     * Method get cell for shot.
     *
     * @return Cell for shot.
     */
    @Override
    public int getShot() {
        int shot;
        do {
            int size = getSize();
            shot = new Random().nextInt(size * size);
        } while (getEnemyPole().contains(shot));
        return shot;
    }

    /**
     * Method adds used cell.
     *
     * @param cell Used cell.
     */
    @Override
    public void addMiss(int cell) {
        this.player.addMiss(cell);
    }

    /**
     * Method return enemyPole.
     *
     * @return Enemy pole.
     */
    @Override
    public HashSet<Integer> getEnemyPole() {
        return this.player.getEnemyPole();
    }

    /**
     * Method return pole size.
     *
     * @return Pole size.
     */
    @Override
    public int getSize() {
        return this.player.getSize();
    }

    /**
     * Method get ships.
     *
     * @return Ships.
     */
    @Override
    public Queue<IShip> getShips() {
        return this.player.getShips();
    }

    /**
     * Method return player name.
     *
     * @return Player name.
     */
    @Override
    public String getPlayerName() {
        return this.player.getPlayerName();
    }
}
