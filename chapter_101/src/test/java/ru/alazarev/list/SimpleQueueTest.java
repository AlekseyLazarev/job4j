package ru.alazarev.list;

import org.junit.Before;
import org.junit.Test;

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
    private SimpleQueue<Integer> queue = new SimpleQueue<>();
    private int size = 5;

    @Before
    public void setUp() {
        for (int indexPush = 1; indexPush < size + 1; indexPush++) {
            queue.push(indexPush);
        }
    }

    /**
     * Method test push and pool.
     */
    @Test
    public void whenPollAfterPushThen() {
        for (int indexPoll = 1; indexPoll < size + 1; indexPoll++) {
            assertThat(queue.poll(), is(indexPoll));
        }
    }

    /**
     * Method test pool with empty queue.
     */
    @Test
    public void whenPollWithEmptyThen() {
        queue = new SimpleQueue<>();
        assertThat(queue.poll(), is(nullValue()));
    }

    /**
     * Method test pool after push and pool again.
     */
    @Test
    public void whenPushAfterPollAndPollAgainThen() {
        for (int indexPoll = 1; indexPoll < size + 1; indexPoll++) {
            assertThat(queue.poll(), is(indexPoll));
        }
        for (int indexPush = size + 1; indexPush < 2 * size + 1; indexPush++) {
            queue.push(indexPush);
        }

        for (int indexPoll = size + 1; indexPoll < 2 * size + 1; indexPoll++) {
            assertThat(queue.poll(), is(indexPoll));
        }
    }

    /**
     * Method check teamwork push and poll.
     */
    @Test
    public void whenTwoPushOnePollOnePushTwoPollThen() {
        queue = new SimpleQueue<>();
        queue.push(1);
        queue.push(2);
        assertThat(queue.poll(), is(1));
        queue.push(3);
        assertThat(queue.poll(), is(2));
        assertThat(queue.poll(), is(3));
    }
}