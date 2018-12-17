package ru.alazarev.map;

import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Class UserTest решение задачи части 001. Урок 4.2. Не перекрывать equals hashCode [#1005].
 *
 * @author Aleksey Lazarev
 * @since 17.12.2018
 */
public class UserTest {
    Calendar calendar;
    User user;
    User user2;

    /**
     * Before all test method.
     */
    @Before
    public void setUp() {
        this.calendar = Calendar.getInstance();
        this.user = new User("name", 1, this.calendar);
        this.user2 = new User("name", 1, this.calendar);
    }

    /**
     * Method test put in map.
     */
    @Test
    public void whenTwoUsersInMapThenPrintTwoValuesInMap() {
        Map<User, Object> map = new HashMap<>();
        map.put(this.user, new Object());
        map.put(this.user2, new Object());
        System.out.println(map);
        assertThat(this.user, is(this.user2));
    }
}