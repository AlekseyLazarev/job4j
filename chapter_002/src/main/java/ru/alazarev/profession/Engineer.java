package ru.alazarev.profession;

/**
 * Class Engineer extends class Profession решение задачи части 002. Урок 1. Реализация профессий в коде [#6837].
 *
 * @author Aleksey Lazarev
 * @since 14.11.2018
 */
public class Engineer extends Profession {
    /**
     * Constructor class Engineer.
     *
     * @param name       Name of engineer.
     * @param profession Profession of specialist.
     */
    public Engineer(String name, String profession) {
        super(name, profession);
    }

    /**
     * Method for build house.
     *
     * @param house Object for building.
     */
    public void buildHouse(House house) {
    }
}