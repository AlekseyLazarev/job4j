package ru.alazarev.seafight.players;

import ru.alazarev.seafight.interfaces.IPlayer;
import ru.alazarev.seafight.interfaces.IShip;

import java.util.*;

/**
 * Class Player решение задачи части "Создание игры морской бой".
 *
 * @author Aleksey Lazarev
 * @since 19.09.2019
 */
public class Player implements IPlayer {
    private final String vertical = "v";
    private final String horizontal = "h";
    private final String playerName;
    private final int size;
    private HashSet<Integer> enemyPole = new HashSet<>();
    private Queue<IShip> ships = new LinkedList<>();
    private HashMap<Integer, IShip> placedShip = new HashMap<>();

    /**
     * Constructor.
     *
     * @param poolSize Pole size value.
     */
    public Player(int poolSize, String playerName) {
        this.size = poolSize;
        this.playerName = playerName;
    }

    /**
     * Initiate method.
     *
     * @param shipsForPlace Ships set.
     * @return This object.
     */
    public Player init(HashSet<IShip> shipsForPlace) {
        generateShips(shipsForPlace);
        return this;
    }

    /**
     * Method generates the required amount from set.
     *
     * @param shipsForPlace Set of ships.
     */
    private void generateShips(HashSet<IShip> shipsForPlace) {
        try {
            for (IShip ship : shipsForPlace) {
                for (int i = 0; i < ship.getCount(); i++) {
                    this.ships.add(ship.getClass().newInstance());
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Method checks whether the ship can be placed vertically.
     *
     * @param startShip Start ship cell.
     * @param sizeShip  Size ship.
     * @return Result check.
     */
    private boolean checkVerShip(int startShip, int sizeShip) {
        boolean res = true;
        int endShip = startShip + (sizeShip - 1) * this.size;
        if (endShip < this.size * this.size) {
            do {
                if (this.placedShip.containsKey(startShip)) {
                    res = false;
                    break;
                }
                startShip += this.size;
            } while (res && startShip <= endShip);
        } else {
            res = false;
        }
        return res;
    }

    /**
     * Method places the ship vertically.
     *
     * @param ship      Ship for place.
     * @param startShip Start ship cell.
     * @return Array of ship cells.
     */
    private int[] placeVertical(IShip ship, int startShip) {
        int shipSize = ship.getSize();
        int[] result = null;
        if (checkVerShip(startShip, shipSize)) {
            result = new int[shipSize];
            for (int i = 0; i < shipSize; i++) {
                result[i] = startShip + i * this.size;
            }
        }
        return result;
    }

    /**
     * Method checks whether the ship can be placed horizontally.
     *
     * @param startShip Start ship cell.
     * @param sizeShip  Size ship.
     * @return Result check.
     */
    private boolean checkHorShip(int startShip, int sizeShip) {
        boolean res = true;
        int endShip = sizeShip == 1 ? startShip : startShip + sizeShip;
        int startLine = startShip - startShip % this.size;
        int endLine = startLine + this.size;
        if (startLine <= startShip && endShip < endLine) {
            do {
                if (this.placedShip.containsKey(startShip)) {
                    res = false;
                    break;
                }
                startShip++;
            } while (res && startShip < endShip);
        } else {
            res = false;
        }
        return res;
    }

    /**
     * Method places the ship horizontally.
     *
     * @param ship      Ship for place.
     * @param startShip Start ship cell.
     * @return Array of ship cells.
     */
    private int[] placeHorizontal(IShip ship, int startShip) {
        int[] result = null;
        int sizeShip = ship.getSize();
        if (checkHorShip(startShip, sizeShip)) {
            result = new int[sizeShip];
            for (int i = 0; i < sizeShip; i++) {
                result[i] = startShip + i;
            }
        }
        return result;
    }

    /**
     * Method get shot enemy pole.
     *
     * @return Enemy pole.
     */
    @Override
    public HashSet<Integer> getEnemyPole() {
        return this.enemyPole;
    }

    /**
     * Method get ships.
     *
     * @return Ships queue.
     */
    @Override
    public Queue<IShip> getShips() {
        return ships;
    }

    /**
     * Method return pole size.
     *
     * @return Pole size.
     */
    @Override
    public int getSize() {
        return size;
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
        boolean result = true;
        int[] cordPlace;
        switch (way) {
            case horizontal:
                cordPlace = placeHorizontal(ship, startPlace);
                break;
            case vertical:
                cordPlace = placeVertical(ship, startPlace);
                break;
            default:
                cordPlace = null;
                break;
        }
        if (cordPlace == null) {
            result = false;
        } else {
            for (int x : cordPlace) {
                this.placedShip.put(x, ship);
            }
        }
        return result;
    }

    /**
     * Method returns placed ships.
     *
     * @return Placed ships hashmap.
     */
    @Override
    public HashMap<Integer, IShip> getPlacedShip() {
        return this.placedShip;
    }

    /**
     * Method get cell for shot.
     *
     * @return Cell for shot.
     */
    @Override
    public int getShot() {
        return 0;
    }

    /**
     * Method checks shot.
     *
     * @param cell Shot cell.
     * @return result check.
     */
    @Override
    public boolean checkShot(int cell) {
        boolean result = false;
        if (this.placedShip.containsKey(cell)) {
            result = this.placedShip.get(cell).bang();
            this.placedShip.remove(cell);
        }
        return result;
    }

    /**
     * Method adds used cell.
     *
     * @param cell Used cell.
     */
    @Override
    public void addMiss(int cell) {
        this.enemyPole.add(cell);
    }

    /**
     * Method return player name.
     *
     * @return Player name.
     */
    @Override
    public String getPlayerName() {
        return this.playerName;
    }
}
