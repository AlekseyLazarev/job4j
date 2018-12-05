package ru.alazarev.list;

import org.junit.Test;
import org.junit.Before;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

/**
 * Class SimpleArrayListTest решение задачи части 001. Урок 5.3.0 Создать метод delete для односвязного списка [#51424].
 *
 * @author Aleksey Lazarev
 * @since 05.12.2018
 */
public class SimpleArrayListTest {

    private SimpleArrayList<Integer> list;

    /**
     * Method before tests.
     */
    @Before
    public void beforeTest() {
        list = new SimpleArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
    }

    /**
     * Test add method.
     */
    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        assertThat(list.get(1), is(2));
    }

    /**
     * Test getSize method.
     */
    @Test
    public void whenAddThreeElementsThenUseGetSizeResultThree() {
        assertThat(list.getSize(), is(3));
    }

    /**
     * Test delete method.
     */
    @Test
    public void whenDeleteFirstThenFirstNull() {
        list.delete();
        assertThat(list.get(0), is(3));
        assertThat(list.get(1), is(2));
        assertThat(list.get(2), nullValue());
    }
}