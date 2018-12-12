package ru.alazarev.list;

import org.junit.Before;

import org.junit.Test;

import javax.xml.soap.Node;

import java.util.Iterator;

import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

/**
 * Class SimpleStackTest решение задачи части 001. Урок 5.3.3. Используя контейнер на базе связанного списка создать контейнер Stack [#71474].
 *
 * @author Aleksey Lazarev
 * @since 09.12.2018
 */
public class SimpleStackTest {
    private SimpleStack<Integer> simpleStack;
    private int size = 5;

    /**
     * Before all test method.
     */
    @Before
    public void setUp() {
        simpleStack = new SimpleStack<>();
        for (int indexPush = 1; indexPush < size + 1; indexPush++) {
            simpleStack.push(indexPush);
        }
    }

    /**
     * Method test pool.
     */
    @Test
    public void whenPollAfterPushThen() {
        for (int indexPoll = 0; indexPoll < size; indexPoll++) {
            assertThat(simpleStack.poll(), is(size - indexPoll));
        }
    }

    /**
     * Method test pool when stack is empty.
     */
    @Test
    public void whenStackIsEmptyThenPoll() {
        simpleStack = new SimpleStack<>();
        assertThat(simpleStack.poll(), is(nullValue()));

    }
}