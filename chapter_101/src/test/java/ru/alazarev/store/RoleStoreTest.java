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
public class RoleStoreTest {
    private RoleStore store;
    private int sizeStore = 10;
    private Role r1, r2, r3, r4, r5;

    /**
     * Before tests method.
     */
    @Before
    public void setUp() {
        this.store = new RoleStore(this.sizeStore);
        r1 = new Role("ID 1");
        r2 = new Role("ID 2");
        r3 = new Role("ID 3");
        r4 = new Role("ID 4");
        r5 = new Role("ID 5");
        this.store.add(r1);
        this.store.add(r2);
        this.store.add(r3);
        this.store.add(r4);
        this.store.add(r5);
    }

    /**
     * Test add method.
     */
    @Test
    public void whenFiveRolesAddedThenGetItById() {
        assertThat(this.store.findById("ID 1"), is(r1));
        assertThat(this.store.findById("ID 2"), is(r2));
        assertThat(this.store.findById("ID 3"), is(r3));
        assertThat(this.store.findById("ID 4"), is(r4));
        assertThat(this.store.findById("ID 5"), is(r5));
    }

    /**
     * Test replace method.
     */
    @Test
    public void whenReplaceFirstRoleToSixThenSixGetItById() {
        Role u6 = new Role("ID 6");
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
        assertThat(this.store.findById("ID 1"), is(this.r1));
    }

    /**
     * Test findIndexById method.
     */
    @Test
    public void whenIndexOfElementFindById() {
        assertThat(this.store.findIndexById("ID 1"), is(0));
    }
}