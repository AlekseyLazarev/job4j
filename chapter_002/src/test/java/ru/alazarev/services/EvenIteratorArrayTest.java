package ru.alazarev.services;


import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class EvenIteratorArrayTest {
    private Iterator<Integer> it;

    @Before
    /**
     * Before test method.
     */
    public void setUp() {
        it = new EvenIteratorArray(new int[]{4, 2, 1, 1});
    }

    /**
     * Test method next.
     */
    @Test
    public void testsThatNextMethodDoesntDependsOnPriorHasNextInvocation() {
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is("odd"));
        assertThat(it.next(), is("odd"));
    }

    /**
     * Test separately work hasNext and next methods.
     */
    @Test
    public void whenTwoCallNextMethodHasNextReturnFalse() {
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(false));
    }

    /**
     * Test sequential work hasNext together to next methods.
     */
    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is("odd"));
        assertThat(it.next(), is("odd"));
    }
}