package ru.alazarev.seafight.players;

import org.junit.Before;
import org.junit.Test;
import ru.alazarev.seafight.interfaces.IShip;
import ru.alazarev.seafight.ships.Battleship;
import ru.alazarev.seafight.ships.Boat;
import ru.alazarev.seafight.ships.Cruiser;
import ru.alazarev.seafight.ships.Destroyer;

import java.util.HashSet;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ComputerTest {
    private Computer c;
    private int size = 10;

    @Before
    public void setUp() {
        this.c = new Computer(new Player(this.size, "First player"));
    }

    @Test
    public void whenInitWithShipsThenPlaceAllShips() {
        HashSet<IShip> ships = new HashSet<>();
        ships.add(new Battleship());
        ships.add(new Cruiser());
        ships.add(new Destroyer());
        ships.add(new Boat());
        int countCells = 0;
        for (IShip ship : ships) {
            countCells += ship.getCount() * ship.getSize();
        }
        this.c = new Computer(new Player(this.size, "Second player").init(ships));
        this.c.init();
        assertThat(this.c.getPlacedShip().size(), is(countCells));
    }

    @Test
    public void whenInitWithoutShipsThenPlaceAllShips() {
        int countCells = 0;
        this.c = new Computer(new Player(this.size, "Second player"));
        this.c.init();
        assertThat(this.c.getPlacedShip().size(), is(countCells));
    }

    @Test
    public void whenEnemyPoleIsFullWithoutOneAndShotThenGetShot() {
        int shot = 36;
        for (int i = 0; i < this.size * this.size; i++) {
            if (i != shot) {
                this.c.getEnemyPole().add(i);
            }
        }
        for (int i = 0; i < 10; i++) {
            assertThat(this.c.getShot(), is(shot));
        }
    }

}