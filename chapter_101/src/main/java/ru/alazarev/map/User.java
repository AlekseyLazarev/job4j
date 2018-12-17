package ru.alazarev.map;

import java.util.Calendar;

/**
 * Class User решение задачи части 001. Урок 5.1. Создать модель User [#999]
 *
 * @author Aleksey Lazarev
 * @since 17.12.2018
 */
public class User {
    private String name;
    private int children;
    private Calendar birthday;

    /**
     * Constructor.
     *
     * @param name     User name.
     * @param children Count children.
     * @param birthday User birthday.
     */
    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    /**
     * Override method generate hashCode.
     *
     * @return
     */
    @Override
    public int hashCode() {
        int nameHashCode = this.name != null ? this.name.hashCode() : 0;
        int birthdayHashCode = this.birthday != null ? this.birthday.hashCode() : 0;
        return 31 * nameHashCode * this.children * birthdayHashCode;
    }
}
