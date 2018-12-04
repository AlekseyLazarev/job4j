package ru.alazarev.store;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

/**
 * Class RoleStoreTest.
 *
 * @author Aleksey Lazarev
 * @since 04.12.2018
 */
public class UserStoreTest {
    private UserStore store;
    private int sizeStore = 10;
    private User u1, u2, u3, u4, u5;

    /**
     * Before tests method.
     */
    @Before
    public void setUp() {
        this.store = new UserStore(this.sizeStore);
        u1 = new User("ID 1");
        u2 = new User("ID 2");
        u3 = new User("ID 3");
        u4 = new User("ID 4");
        u5 = new User("ID 5");
        this.store.add(u1);
        this.store.add(u2);
        this.store.add(u3);
        this.store.add(u4);
        this.store.add(u5);
    }

    /**
     * Test add method.
     */
    @Test
    public void whenFiveRolesAddedThenGetItById() {
        assertThat(this.store.findById("ID 1"), is(u1));
        assertThat(this.store.findById("ID 2"), is(u2));
        assertThat(this.store.findById("ID 3"), is(u3));
        assertThat(this.store.findById("ID 4"), is(u4));
        assertThat(this.store.findById("ID 5"), is(u5));
    }

    /**
     * Test replace method.
     */
    @Test
    public void whenReplaceFirstRoleToSixThenSixGetItById() {
        User u6 = new User("ID 6");
        this.store.replace("ID 1", u6);
        assertThat(this.store.findById("ID 6"), is(u6));
    }

    /**
     * Test delete method.
     */
    @Test
    public void whenDeleteUserAndGetItById() {
        this.store.delete("ID 1");
        assertThat(this.store.findById("ID 1"), nullValue());
    }

    /**
     * Test findById method.
     */
    @Test
    public void whenElementFindById() {
        assertThat(this.store.findById("ID 1"), is(this.u1));
    }

    /**
     * Test findIndexById method.
     */
    @Test
    public void whenIndexOfElementFindById() {
        assertThat(this.store.findIndexById("ID 1"), is(0));
    }
}