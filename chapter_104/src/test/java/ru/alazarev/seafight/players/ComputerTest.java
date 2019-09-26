package ru.alazarev.seafight.players;

import org.junit.Test;
import ru.alazarev.seafight.interfaces.IShip;
import ru.alazarev.seafight.ships.Battleship;
import ru.alazarev.seafight.ships.Boat;
import ru.alazarev.seafight.ships.Cruiser;
import ru.alazarev.seafight.ships.Destroyer;

import java.util.HashSet;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ComputerTest {
    private int size = 10;
    private Player player = new Player(this.size, "First player");

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
        Computer c = new Computer(this.player.init(ships));
        c.init();
        int placedShipsSize = c.getPlacedShip().size();
        assertThat(placedShipsSize, is(countCells));
    }

    @Test
    public void whenInitWithoutShipsThenPlaceAllShips() {
        int countCells = 0;
        Computer c = new Computer(this.player);
        c.init();
        int placedShipsSize = c.getPlacedShip().size();
        assertThat(placedShipsSize, is(countCells));
    }

    @Test
    public void whenEnemyPoleIsFullWithoutOneAndShotThenGetShot() {
        Computer c = new Computer(this.player);
        int shot = 36;
        for (int i = 0; i < this.size * this.size; i++) {
            if (i != shot) {
                c.getEnemyPole().add(i);
            }
        }
        for (int i = 0; i < 10; i++) {
            int receivedShot = c.getShot();
            assertThat(receivedShot, is(shot));
        }
    }

}