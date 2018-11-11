package ru.alazarev.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Factorial test.
 *
 * @author Aleksey Lazarev
 * @version 0.1
 * @since 11.11.2018
 */
public class FactorialTest {
    /**
     * Test calc method.
     */
    @Test
    public void whenCalculateFactorialForFiveThenOneHundredTwenty() {
        Factorial factorial = new Factorial();
        int result = factorial.calc(5);
        assertThat(result, is(120));
    }

    /**
     * Test calc method if n is zero.
     */
    @Test
    public void whenCalculateFactorialForZerThenOne() {
        Factorial factorial = new Factorial();
        int result = factorial.calc(0);
        assertThat(result, is(1));
    }
}
