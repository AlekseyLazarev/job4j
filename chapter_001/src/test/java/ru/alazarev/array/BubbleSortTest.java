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
public class BubbleSortTest {
    /**
     * Test sort method.
     */
    @Test
    public void whenStartWithPrefixThenTrue() {
        BubbleSort bs = new BubbleSort();
        int[] arr = new int[]{9, 7, 8, 5, 3, 4, 6};
        int[] result = bs.sort(arr);
        int[] expect = new int[]{3, 4, 5, 6, 7, 8, 9};
        assertThat(result, is(expect));
    }
}
