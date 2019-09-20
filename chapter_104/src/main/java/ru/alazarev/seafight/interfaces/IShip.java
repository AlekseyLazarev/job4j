package ru.alazarev.seafight.interfaces;

/**
 * Interface IShip решение задачи части "Создание игры морской бой".
 *
 * @author Aleksey Lazarev
 * @since 18.09.2019
 */
public interface IShip {
    /**
     * Method checks a wounded ship or is killed.
     *
     * @return Result check.
     */
    boolean bang();

    /**
     * Method return ship symbol.
     *
     * @return Ship symbol.
     */
    int getSymbol();

    /**
     * Method return standard ship count.
     *
     * @return Standard ship count.
     */
    int getCount();

    /**
     * Method return ship size.
     *
     * @return Ship size.
     */
    int getSize();

    /**
     * Method return ship name.
     *
     * @return Ship name.
     */
    String getShipName();

}
