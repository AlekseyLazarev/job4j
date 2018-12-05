package ru.alazarev.generic;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;

public class SimpleArrayTest {
    private final int size = 10;
    private SimpleArray<Integer> simpleArray = new SimpleArray<>(size);
    private Iterator simpleIterator;

    @Before
    /**
     * Before test method.
     */
    public void setUp() {
        for (int index = 0; index < size / 2; index++) {
            simpleArray.add(index);
        }
        simpleIterator = simpleArray.iterator();
    }

    /**
     * Test method hasNext.
     */
    @Test
    public void whenHasNextAfterFiveNextThenReturnTrue() {

        assertThat(this.simpleIterator.next(), Matchers.is(0));
        assertThat(this.simpleIterator.next(), Matchers.is(1));
        assertThat(this.simpleIterator.next(), Matchers.is(2));
        assertThat(this.simpleIterator.next(), Matchers.is(3));
        assertThat(this.simpleIterator.next(), Matchers.is(4));
        this.simpleArray.add(null);
        this.simpleArray.add(6);
        assertThat(this.simpleArray.iterator().hasNext(), Matchers.is(true));
    }

    /**
     * Test method add.
     */
    @Test
    public void whenAddFiveIndexElementBySixValueThenReturnSix() {
        this.simpleArray.add(6);
        assertThat(this.simpleArray.get(5), is(6));
    }

    /**
     * Test method delete.
     */
    @Test
    public void whenDeleteThreeIndexThenThreeIndexElementIsEmpty() {
        this.simpleArray.delete(3);
        assertThat(this.simpleArray.get(3), is(4));
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
        assertThat(simpleArray.iterator().next(), is(0));
    }
}