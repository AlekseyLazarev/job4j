package ru.alazarev.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Aleksey Lazarev
 * @version 0.1
 * @since 12.11.2018
 */
public class FindLoopTest {
    /**
     * Test indexOf method.
     */
    @Test
    public void whenArrayHasElementFiveThenReturnIndexZero() {
        FindLoop find = new FindLoop();
        int[] input = new int[]{5, 10, 3};
        int value = 5;
        int result = find.indexOf(input, value);
        int expect = 0;
        assertThat(result, is(expect));
    }

    /**
     * Test indexOf method.
     */
    @Test
    public void whenArrayDoNotHasElementFourThenMinusOne() {
        FindLoop find = new FindLoop();
        int[] input = new int[]{2, 10, 3, 5, 8, 23};
        int value = 4;
        int result = find.indexOf(input, value);
        int expect = -1;
        assertThat(result, is(expect));
    }
}