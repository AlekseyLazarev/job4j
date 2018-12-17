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

    /**
     * Method override equals.
     *
     * @param obj Object for equals.
     * @return Result of equals.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        User user = (User) obj;
        if (this.children != user.children) {
            return false;
        }
        if (this.name != null ? !this.name.equals(user.name) : user.name != null) {
            return false;
        }
        if (this.birthday != null ? !this.birthday.equals(user.birthday) : user.birthday != null) {
            return false;
        }
        return true;
    }
}
