package ru.alazarev.seafight;

import org.junit.Before;
import ru.alazarev.seafight.interfaces.IShip;
import ru.alazarev.seafight.ships.Battleship;

/**
 * Class  решение задачи части
 *
 * @author Aleksey Lazarev
 * @since 13.09.2019
 */
public class SeaFightTest {
    SeaFight seaFight;
    int size = 100;
    IShip ship;
    int[] pole;

    @Before
    public void setUp() {
        this.seaFight = new SeaFight().init();
        this.ship = new Battleship();
        this.pole = new int[size];
        for (int i = 0; i < size; i++) {
            pole[i] = i;
        }
    }

//    @Test
//    public void whenPlaceHorizontalThenTrue() {
//        int startPlace = 6;
//        Assert.assertTrue(seaFight.placeHorizontal(ship, startPlace, pole));
//    }
//
//    @Test
//    public void whenPlaceVerticalThenTrue() {
//        int startPlace = 6;
//        Assert.assertTrue(seaFight.placeVertical(ship, startPlace, pole));
//    }
//
//    @Test
//    public void whenPlaceHorizontalThenFalse() {
//        int startPlace = 6;
//        this.pole[startPlace] = -2;
//        Assert.assertFalse(seaFight.placeHorizontal(ship, startPlace, pole));
//    }
//
//    @Test
//    public void whenPlaceVerticalThenFalse() {
//        int startPlace = 6;
//        this.pole[startPlace] = -3;
//        Assert.assertFalse(seaFight.placeVertical(ship, startPlace, pole));
//    }
}