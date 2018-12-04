package ru.alazarev.generic;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SimpleArrayTest {
    private final int size = 10;
    private SimpleArray<Integer> simpleArray = new SimpleArray<>(size);

    @Before
    /**
     * Before test method.
     */
    public void setUp() {
        for (int index = 0; index < size / 2; index++) {
            simpleArray.add(index);
        }
    }

    /**
     * Test method hasNext.
     */
    @Test
    public void whenHasNextAfterFiveNextThenReturnTrue() {
        assertThat(simpleArray.next(), Matchers.is(0));
        assertThat(simpleArray.next(), Matchers.is(1));
        assertThat(simpleArray.next(), Matchers.is(2));
        assertThat(simpleArray.next(), Matchers.is(3));
        assertThat(simpleArray.next(), Matchers.is(4));
        simpleArray.add(null);
        simpleArray.add(6);
        assertThat(simpleArray.hasNext(), Matchers.is(true));
    }

    /**
     * Test method add.
     */
    @Test
    public void whenAddFiveIndexElementBySixValueThenReturnSix() {
        simpleArray.add(6);
        assertThat(simpleArray.get(5), is(6));
    }

    /**
     * Test method delete.
     */
    @Test
    public void whenDeleteThreeIndexThenThreeIndexElementIsEmpty() {
        simpleArray.delete(3);
        assertThat(simpleArray.get(3), is(""));
    }

    /**
     * Test method checkOverflow.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenOverflowAdd() {
        SimpleArray<Integer> simpleArray = new SimpleArray<Integer>(10);
        for (int index = 0; index < size + 1; index++) {
            simpleArray.add(1);
        }
    }

    /**
     * Test method set.
     */
    @Test
    public void whenSetTwoElementBySixValueThenTwoElementWasSixValue() {
        simpleArray.set(2, 16);
        assertThat(simpleArray.get(2), is(16));
    }

    /**
     * Test method Next.
     */
    @Test
    public void whenNextReturnFirstElement() {
        assertThat(simpleArray.next(), is(0));
    }
}