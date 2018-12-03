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
     * Test method next.
     */
    @Test
    public void testsThatNextMethodDoesntDependsOnPriorHasNextInvocation() {
        assertThat(simpleArray.next(), Matchers.is(0));
        assertThat(simpleArray.next(), Matchers.is(1));
        assertThat(simpleArray.next(), Matchers.is(2));
        assertThat(simpleArray.next(), Matchers.is(3));
        assertThat(simpleArray.next(), Matchers.is(4));
        simpleArray.add(null);
        simpleArray.add(6);
        assertThat(simpleArray.hasNext(), Matchers.is(true));
    }

    @Test
    public void whenAddFiveIndexElementBySixValueThenReturnSix() {
        simpleArray.add(6);
        assertThat(simpleArray.get(5), is(6));
    }

    @Test
    public void whenDeleteThreeIndexThenThreeIndexElementIsEmpty() {
        simpleArray.delete(3);
        assertThat(simpleArray.get(3), is(""));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenOverflowAdd() {
        SimpleArray<Integer> simpleArray = new SimpleArray<Integer>(10);
        for (int index = 0; index < size + 1; index++) {
            simpleArray.add(1);
        }
    }

    @Test
    public void whenSetTwoElementBySixValueThenTwoElementWasSixValue(){
        simpleArray.set(2, 16);
        assertThat(simpleArray.get(2), is(16));
    }
}