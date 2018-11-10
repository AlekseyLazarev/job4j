package ru.alazarev.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test.
 * @author Aleksey Lazarev
 * @version 0.1
 * @since 10.11.2018
 */
public class MaxTest {
    /**
     * Test max method where first > second.
     */
    @Test
    public void whenFirstLessSecond() {
        Max maxim = new Max();
        int result = maxim.max(1, 2);
        assertThat(result, is(2));
    }
    /**
     * Test max method where second > first.
     */
    @Test
    public void whenSecondLessFirst() {
        Max maxim = new Max();
        int result = maxim.max(6, 2);
        assertThat(result, is(6));
    }
}