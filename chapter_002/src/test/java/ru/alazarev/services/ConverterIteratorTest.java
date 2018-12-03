package ru.alazarev.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Class ConverterIteratorTest test ConverterIterator.
 *
 * @author Aleksey Lazarev
 * @since 29.11.2018
 */
public class ConverterIteratorTest {
    Iterator<Integer> it;

    /**
     * Before test method.
     */
    @Before
    public void setUp() {
        Iterator<Integer> it1 = Arrays.asList(1, 2, 3).iterator();
        Iterator<Integer> it2 = Arrays.asList(4, 5, 6).iterator();
        Iterator<Integer> it3 = Arrays.asList(7, 8, 9).iterator();
        Iterator<Iterator<Integer>> its = Arrays.asList(it1, it2, it3).iterator();
        ConverterIterator iteratorOfIterators = new ConverterIterator();
        it = iteratorOfIterators.convert(its);
    }

    /**
     * Method test hasNext and next.
     */
    @Test
    public void hasNextNextSequentialInvocation() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(5));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(6));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(7));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(8));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(9));
        assertThat(it.hasNext(), is(false));
    }

    /**
     * Test each next methods.
     */
    @Test
    public void testsThatNextMethodDoesntDependsOnPriorHasNextInvocation() {
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(5));
        assertThat(it.next(), is(6));
        assertThat(it.next(), is(7));
        assertThat(it.next(), is(8));
        assertThat(it.next(), is(9));
    }

    /**
     * Test next after hasNext methods.
     */
    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(5));
        assertThat(it.next(), is(6));
        assertThat(it.next(), is(7));
        assertThat(it.next(), is(8));
        assertThat(it.next(), is(9));
    }

    /**
     * Test iterator of empty iterators.
     */
    @Test
    public void hasNextShouldReturnFalseInCaseOfEmptyIterators() {
        Iterator<Integer> it1 = (new ArrayList<Integer>()).iterator();
        Iterator<Integer> it2 = (new ArrayList<Integer>()).iterator();
        Iterator<Integer> it3 = (new ArrayList<Integer>()).iterator();
        Iterator<Iterator<Integer>> its = Arrays.asList(it1, it2, it3).iterator();
        ConverterIterator iteratorOfIterators = new ConverterIterator();
        it = iteratorOfIterators.convert(its);
        assertThat(it.hasNext(), is(false));
    }

    /**
     * Test throw no such element exception.
     */
    @Test(expected = NoSuchElementException.class)
    public void invocationOfNextMethodShouldThrowNoSuchElementException() {
        Iterator<Integer> it1 = Arrays.asList(1, 2, 3).iterator();
        Iterator<Iterator<Integer>> its = Arrays.asList(it1).iterator();
        ConverterIterator iteratorOfIterators = new ConverterIterator();
        it = iteratorOfIterators.convert(its);
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        it.next();
    }

    /**
     * Test hasNext method.
     */
    @Test
    public void hasNextShould() {
        Iterator<Integer> it1 = (new ArrayList<Integer>()).iterator();
        Iterator<Integer> it2 = (new ArrayList<Integer>()).iterator();
        Iterator<Integer> it3 = (Arrays.asList(1)).iterator();
        Iterator<Iterator<Integer>> its = Arrays.asList(it1, it2, it3).iterator();
        ConverterIterator iteratorOfIterators = new ConverterIterator();
        it = iteratorOfIterators.convert(its);
        assertThat(it.hasNext(), is(true));
    }

    /**
     * Test hasNext method before and after empty iterators.
     */
    @Test
    public void hasNextShouldTwice() {
        Iterator<Integer> it1 = (new ArrayList<Integer>()).iterator();
        Iterator<Integer> it2 = (Arrays.asList(9)).iterator();
        Iterator<Integer> it3 = (new ArrayList<Integer>()).iterator();
        Iterator<Integer> it4 = (new ArrayList<Integer>()).iterator();
        Iterator<Integer> it5 = (new ArrayList<Integer>()).iterator();
        Iterator<Integer> it6 = (new ArrayList<Integer>()).iterator();
        Iterator<Integer> it7 = (new ArrayList<Integer>()).iterator();
        Iterator<Integer> it8 = (Arrays.asList(1)).iterator();
        Iterator<Integer> it9 = (new ArrayList<Integer>()).iterator();
        Iterator<Iterator<Integer>> its = Arrays.asList(it1, it2, it3, it4, it5, it6, it7, it8, it9).iterator();
        ConverterIterator iteratorOfIterators = new ConverterIterator();
        it = iteratorOfIterators.convert(its);
        assertThat(it.hasNext(), is(true));
        it.next();
        assertThat(it.hasNext(), is(true));
        it.next();
        assertThat(it.hasNext(), is(false));
    }

    /**
     * Test if all iterators has no elements.
     */
    @Test
    public void whenEmptyIteratorThenHasNextReturnFalse() {
        Iterator<Integer> it1 = (new ArrayList<Integer>()).iterator();
        Iterator<Integer> it2 = (new ArrayList<Integer>()).iterator();
        Iterator<Integer> it3 = (new ArrayList<Integer>()).iterator();
        Iterator<Iterator<Integer>> its = Arrays.asList(it1, it2, it3).iterator();
        ConverterIterator iteratorOfIterators = new ConverterIterator();
        it = iteratorOfIterators.convert(its);
        assertThat(it.hasNext(), is(false));
    }

}