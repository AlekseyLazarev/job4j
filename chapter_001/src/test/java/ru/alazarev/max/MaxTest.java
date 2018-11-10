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
     * Test max method where first less second.
     */
    @Test
    public void whenFirstLessSecond() {
        Max maxim = new Max();
        int result = maxim.max(1, 2);
        assertThat(result, is(2));
    }
    /**
     * Test max method where second less first.
     */
    @Test
    public void whenSecondLessFirst() {
        Max maxim = new Max();
        int result = maxim.max(6, 2);
        assertThat(result, is(6));
    }
    /**
     * Test max method where first is max.
     */
    @Test
    public void whenFirstMax() {
        Max maxim = new Max();
        int result = maxim.max(5, 4, 3);
        assertThat(result, is(5));
    }
    /**
     * Test max method where second is max.
     */
    @Test
    public void whenSecondMax() {
        Max maxim = new Max();
        int result = maxim.max(5, 6, 3);
        assertThat(result, is(6));
    }
    /**
     * Test max method where third is max.
     */
    @Test
    public void whenThirdMax() {
        Max maxim = new Max();
        int result = maxim.max(5, 4, 8);
        assertThat(result, is(8));
    }
    /**
     * Test max method where third is max.
     */
    @Test
    public void whenMethodInMethodAndThirdMax() {
        Max maxim = new Max();
        int result = maxim.max(maxim.max(5, 3), 8);
        assertThat(result, is(8));
    }

}