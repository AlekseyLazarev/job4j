package ru.alazarev.seafight.players;

import org.junit.Before;
import org.junit.Test;
import ru.alazarev.seafight.interfaces.IShip;
import ru.alazarev.seafight.ships.Battleship;
import ru.alazarev.seafight.ships.Boat;
import ru.alazarev.seafight.ships.Cruiser;
import ru.alazarev.seafight.ships.Destroyer;

import java.util.HashSet;

import static org.junit.Assert.*;

public class PlayerTest {
    private int size = 10;
    private HashSet<IShip> hashShip = new HashSet<>();
    private final String vertical = "v";
    private final String horizontal = "h";
    private final Boat boat = new Boat();
    private final Destroyer destroyer = new Destroyer();
    private final Cruiser cruiser = new Cruiser();
    private final Battleship battleship = new Battleship();

    @Before
    public void setUp() {
        this.hashShip.add(this.battleship);
        this.hashShip.add(this.cruiser);
        this.hashShip.add(this.destroyer);
        this.hashShip.add(this.boat);
    }

    @Test
    public void whenPlayerInitThenGenerateShips() {
        Player p = new Player(this.size, "Player");
        p.init(this.hashShip);
        int countShips = 0;
        for (IShip ship : this.hashShip) {
            countShips += ship.getCount();
        }
        int shipsCount = p.getShips().size();
        assertTrue(shipsCount == countShips);
    }

    @Test
    public void whenCheckVerticalShipThenTrue() {
        Player p = new Player(this.size, "Player");
        boolean resultPlaceShip;
        IShip ship = this.boat;
        int poleSize = this.size * this.size;
        for (int i = 0; i < poleSize; i++) {
            resultPlaceShip = p.placeShip(ship, vertical, i);
            assertTrue(resultPlaceShip);
        }
    }

    @Test
    public void whenCheckVerticalShipThenFalse() {
        int startShipPlace = 0;
        Player p = new Player(this.size, "Player");
        IShip firstShip = this.cruiser;
        IShip secondShip = this.destroyer;
        boolean firstShipPlaced = p.placeShip(firstShip, vertical, startShipPlace);
        boolean secondShipPlaced = p.placeShip(secondShip, vertical, startShipPlace);
        assertFalse(secondShipPlaced);
    }

    @Test
    public void whenCheckHorizontalShipThenTrue() {
        Player p = new Player(this.size, "Player");
        boolean resultPlaceShip;
        IShip ship = this.boat;
        int startShipPlace = 10;
        resultPlaceShip = p.placeShip(ship, horizontal, startShipPlace);
        assertTrue(resultPlaceShip);
    }

    @Test
    public void whenCheckHorizontalShipThenFalse() {
        Player p = new Player(this.size, "Player");
        int startShipPlace = 10;
        IShip firstShip = this.cruiser;
        IShip secondShip = this.boat;
        boolean firstShipPlaced = p.placeShip(firstShip, vertical, startShipPlace);
        boolean secondShipPlaced = p.placeShip(secondShip, vertical, startShipPlace);
        assertFalse(secondShipPlaced);
    }

    @Test
    public void whenShipPlaceThenCheckShotFalse() {
        Player p = new Player(this.size, "Player");
        int startShipPlace = 0;
        IShip ship = this.battleship;
        boolean shipPlaced = p.placeShip(ship, horizontal, startShipPlace);
        int cell = ship.getSize();
        boolean checkShotResult = p.checkShot(cell);
        assertFalse(checkShotResult);
    }

    @Test
    public void whenShipNoPlaceThenCheckShotFalse() {
        Player p = new Player(this.size, "Player");
        int cell = 0;
        boolean result = p.checkShot(cell);
        assertFalse(result);
    }
}
