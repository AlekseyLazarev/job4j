package ru.alazarev.services;


import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class EvenIteratorArrayTest {
    private Iterator<Integer> it;

    @Before
    /**
     * Before test method.
     */
    public void setUp() {
        it = new EvenIteratorArray(new int[]{1, 3, 4, 1});
    }

    /**
     * Test method next.
     */
    @Test(expected = NoSuchElementException.class)
    public void testsThatNextMethodDoesntDependsOnPriorHasNextInvocation() {
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(new NoSuchElementException()));
    }

    /**
     * Test sequential work hasNext together to next methods.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenArrayHasEvenElementThenReturnTrueAndRunNextAfterHisIndex() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(false));
        assertThat(it.next(), is(new NoSuchElementException()));
    }
}