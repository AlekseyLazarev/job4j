package ru.alazarev.list;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;

/**
 * Class NodeListTest решение задачи части 001. Урок 5.3.2. Создать контейнер на базе связанного списка  [#159].
 *
 * @author Aleksey Lazarev
 * @since 07.12.2018
 */
public class NodeListTest {
    private NodeList<Integer> nodeList;
    private int[] ex;
    private int size = 4;
    private Iterator iterator;

    /**
     * Method before tests.
     */
    @Before
    public void setUp() {
        nodeList = new NodeList<>();
        for (int index = 1; index < size + 1; index++) {
            nodeList.add(index);
        }
        ex = new int[size];
        for (int exIndex = size; exIndex > 0; exIndex--) {
            ex[size - exIndex] = exIndex;
        }
        iterator = nodeList.iterator();
    }

    /**
     * Test add method.
     */
    @Test
    public void whenAddedThen() {
        for (int index = 0; index < size; index++) {
            assertThat(nodeList.get(index), is(ex[index]));
        }
    }

    /**
     * Test get method.
     */
    @Test
    public void whenGetThen() {
        int[] a = new int[size];
        for (int index = 0; index < size; index++) {
            a[index] = nodeList.get(index);
        }
        assertThat(a, is(ex));
    }

    /**
     * Test get method with position > size.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetWithPositionOverSizeThen() {
        nodeList.get(1000);
    }

    /**
     * Test next iterator method.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenNextTenThenNoSuchElementException() {
        for (int index = 0; index < size; index++) {
            assertThat(iterator.next(), is(size - index));
        }
        assertThat(iterator.next(), is(nullValue()));
    }

    /**
     * Test next iterator method when list is empty.
     */
    @Test
    public void whenNextWithEmptyList() {
        nodeList = new NodeList<>();
        iterator = nodeList.iterator();
        assertThat(iterator.next(), is(nullValue()));
    }

    /**
     * Test hasNext iterator method.
     */
    @Test
    public void whenHasNext() {
        for (int index = 0; index < size; index++) {
            assertThat(iterator.hasNext(), is(true));
            iterator.next();
        }
        assertThat(iterator.hasNext(), is(false));
    }

    /**
     * Test exception after modified nodeList.
     */
    @Test(expected = ConcurrentModificationException.class)
    public void whenModifiedListThenConcurrentModificationException() {
        nodeList.add(99);
        iterator.next();
    }

    @Test
    public void whenDeleteThen() {
        assertThat(nodeList.delete(0), is(size));
    }
}