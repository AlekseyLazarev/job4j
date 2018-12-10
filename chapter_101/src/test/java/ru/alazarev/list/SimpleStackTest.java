package ru.alazarev.list;

import org.junit.Before;

import org.junit.Test;

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
    }

    /**
     * Method test push and pool.
     */
    @Test
    public void whenPushAToZThenPollZToA() {
        for (int indexPush = 1; indexPush < size + 1; indexPush++) {
            simpleStack.push(indexPush);
        }
        for (int indexPoll = 0; indexPoll < size; indexPoll++) {
            assertThat(simpleStack.poll(), is(size - indexPoll));
        }
    }

}