package ru.alazarev.seafight;

import ru.alazarev.seafight.interfaces.IPlayer;
import ru.alazarev.seafight.interfaces.ISeaFight;
import ru.alazarev.seafight.interfaces.IShip;
import ru.alazarev.seafight.players.Computer;
import ru.alazarev.seafight.players.Player;
import ru.alazarev.seafight.ships.Battleship;
import ru.alazarev.seafight.ships.Boat;
import ru.alazarev.seafight.ships.Cruiser;
import ru.alazarev.seafight.ships.Destroyer;

import java.util.HashSet;

/**
 * Class SeaFight решение задачи части "Создание игры морской бой".
 *
 * @author Aleksey Lazarev
 * @since 19.09.2019
 */
public class SeaFight implements ISeaFight {
    private int size = 10;
    private HashSet<IShip> hashShip = new HashSet<>();
    private IPlayer p1;
    private IPlayer p2;

    /**
     * Method fill ship hashset.
     */
    private void fillHashShip() {
        this.hashShip.add(new Battleship());
        this.hashShip.add(new Cruiser());
        this.hashShip.add(new Destroyer());
        this.hashShip.add(new Boat());
    }


    /**
     * Initiate method.
     *
     * @return ISeaFight object.
     */
    @Override
    public SeaFight init() {
        fillHashShip();
        int[] pole = new int[this.size * this.size];
        for (int i = 0; i < this.size * this.size; i++) {
            pole[i] = i;
        }
//        this.p1 = new Human(new Player(this.size).init(this.hashShip), new Input()).init();
        this.p1 = new Computer(new Player(this.size, "First player").init(this.hashShip)).init();
        this.p2 = new Computer(new Player(this.size, "Second player").init(this.hashShip)).init();
        return this;
    }


    /**
     * Game method.
     */
    @Override
    public void game() {
        boolean endGame;
        int stage = 0;
        IPlayer current;
        IPlayer enemy;
        do {
            if (stage % 2 == 0) {
                current = this.p1;
                enemy = this.p2;
            } else {
                current = this.p2;
                enemy = this.p1;
            }
            int cell = current.getShot();
            current.addMiss(cell);
            enemy.checkShot(cell);
            endGame = enemy.getPlacedShip().isEmpty();
            stage++;
            if (endGame){
                System.out.println("Winner = " + current.getPlayerName());
            }
        } while (!endGame);
    }

    /**
     * Main method.
     *
     * @param args arguments.
     */
    public static void main(String[] args) {
        SeaFight seaFight = new SeaFight().init();
        seaFight.game();
    }
}
