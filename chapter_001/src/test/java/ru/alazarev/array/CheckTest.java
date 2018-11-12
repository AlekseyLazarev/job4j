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
public class CheckTest {
    /**
     * Test mono method.
     */
    @Test
    public void whenDataMonoByTrueThenTrue() {
        Check check = new Check();
        boolean[] input = new boolean[]{true, true, true};
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    /**
     * Test mono method.
     */
    @Test
    public void whenDataNotMonoByTrueThenFalse() {
        Check check = new Check();
        boolean[] input = new boolean[]{true, false, true};
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }

    /**
     * Test mono method.
     */
    @Test
    public void whenDataMonoByFalseThenTrue() {
        Check check = new Check();
        boolean[] input = new boolean[]{false, false, false, false};
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    /**
     * Test mono method.
     */
    @Test
    public void whenDataNotMonoByFalseThenFalse() {
        Check check = new Check();
        boolean[] input = new boolean[]{false, true, false, true};
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }
}