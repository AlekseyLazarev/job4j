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
 * Class SimpleQueueTest решение задачи части 001. Урок 5.3.3.1 Очередь на двух стеках [#160].
 *
 * @author Aleksey Lazarev
 * @since 11.12.2018
 */
public class SimpleQueueTest {
    private SimpleQueue<Integer> simpleQueue = new SimpleQueue<>();
    private int size = 5;

    /**
     * Method test push and pool.
     */
    @Test
    public void whenPollAfterPushThen() {
        for (int indexPush = 1; indexPush < size; indexPush++) {
            simpleQueue.push(indexPush);
        }
        for (int indexPoll = 1; indexPoll < size; indexPoll++) {
            assertThat(simpleQueue.poll(), is(indexPoll));
        }
    }
}