package ru.alazarev.profession;

/**
 * Basic class Profession решение задачи части 002. Урок 1. Реализация профессий в коде [#6837].
 *
 * @author Aleksey Lazarev
 * @since 14.11.2018
 */

public class Profession {
    private String name;
    private String profession;

    /**
     * Method get name.
     *
     * @return name.
     */
    public String getName() {
        return name;
    }

    /**
     * Method get profession.
     *
     * @return profession.
     */
    public String getProfession() {
        return profession;
    }
    /**
     * Method set name.
     *
     * @param name Name of this professional.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method set profession.
     *
     * @param profession Profession of this professional.
     */
    public void setProfession(String profession) {
        this.profession = profession;
    }
}