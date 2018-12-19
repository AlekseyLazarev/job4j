package ru.alazarev.list;

import org.junit.Assert;
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
    private int size = 5;
    private Iterator iterator;

    /**
     * Method before tests.
     */
    @Before
    public void setUp() {
        this.nodeList = new NodeList<>();
        for (int index = 1; index < this.size + 1; index++) {
            this.nodeList.add(index);
        }
        this.ex = new int[size];
        for (int exIndex = this.size; exIndex > 0; exIndex--) {
            this.ex[this.size - exIndex] = exIndex;
        }
        this.iterator = this.nodeList.iterator();
    }

    /**
     * Test add method.
     */
    @Test
    public void whenAddedThen() {
        for (int index = 0; index < this.size; index++) {
            assertThat(this.nodeList.get(index), is(this.ex[index]));
        }
    }

    /**
     * Test get method.
     */
    @Test
    public void whenGetThen() {
        int[] a = new int[this.size];
        for (int index = 0; index < this.size; index++) {
            a[index] = this.nodeList.get(index);
        }
        assertThat(a, is(this.ex));
    }

    /**
     * Test get method with position > size.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetWithPositionOverSizeThen() {
        this.nodeList.get(1000);
    }

    /**
     * Test next iterator method.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenNextTenThenNoSuchElementException() {
        for (int index = 0; index < this.size; index++) {
            assertThat(this.iterator.next(), is(this.size - index));
        }
        assertThat(this.iterator.next(), is(nullValue()));
    }

    /**
     * Test next iterator method when list is empty.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenNextWithEmptyList() {
        this.nodeList = new NodeList<>();
        this.iterator = this.nodeList.iterator();
        this.iterator.next();
    }

    /**
     * Test hasNext iterator method.
     */
    @Test
    public void whenHasNext() {
        for (int index = 0; index < this.size; index++) {
            assertThat(this.iterator.hasNext(), is(true));
            this.iterator.next();
        }
        assertThat(this.iterator.hasNext(), is(false));
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
        int pos = 0;
        assertThat(nodeList.delete(pos), is(this.size - pos));
    }

    @Test
    public void whenDeleteThreePosition() {
        NodeList<Integer> list = new NodeList<>();
        for (int index = 0; index < 5; index++) {
            list.add(index);
        }
        list.delete(4);
        Iterator iterator = list.iterator();
        Assert.assertThat(iterator.hasNext(), is(true));
    }
}