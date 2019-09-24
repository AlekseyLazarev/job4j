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
    private Player player;
    private HashSet<IShip> hashShip = new HashSet<>();
    private final String vertical = "v";
    private final String horizontal = "h";
    private final Boat b = new Boat();
    private final Destroyer d = new Destroyer();
    private final Cruiser c = new Cruiser();
    private final Battleship bs = new Battleship();

    @Before
    public void setUp() {
        this.player = new Player(this.size, "First player");
        this.hashShip.add(this.bs);
        this.hashShip.add(this.c);
        this.hashShip.add(this.d);
        this.hashShip.add(this.b);
    }

    @Test
    public void whenPlayerInitThenGenerateShips() {
        this.player.init(this.hashShip);
        int countShips = 0;
        for (IShip ship : this.hashShip) {
            countShips += ship.getCount();
        }
        assertTrue(this.player.getShips().size() == countShips);
    }

    @Test
    public void whenCheckVerticalShipThenTrue() {
        for (int i = 0; i < this.size * this.size; i++) {
            assertTrue(this.player.placeShip(this.b, vertical, i));
        }
    }

    @Test
    public void whenCheckVerticalShipThenFalse() {
        this.player.placeShip(this.c, vertical, 0);
        assertFalse(this.player.placeShip(this.d, vertical, 0));
    }

    @Test
    public void whenCheckHorizontalShipThenTrue() {
        for (int i = 0; i < this.size * this.size; i++) {
            assertTrue(this.player.placeShip(this.b, horizontal, i));
        }
    }

    @Test
    public void whenCheckHorizontalShipThenFalse() {
        this.player.placeShip(this.c, vertical, 10);
        assertFalse(this.player.placeShip(this.b, vertical, 10));
    }

    @Test
    public void whenShipPlaceThenCheckShotFalse() {
        this.player.placeShip(this.bs, horizontal, 0);
        assertFalse(this.player.checkShot(2));
    }

    @Test
    public void whenShipNoPlaceThenCheckShotTrue() {
        assertFalse(this.player.checkShot(0));
    }
}
