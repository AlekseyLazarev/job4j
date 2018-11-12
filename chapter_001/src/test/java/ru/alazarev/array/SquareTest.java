package ru.alazarev.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test.
 * @author Aleksey Lazarev
 * @version 0.1
 * @since 12.11.2018
 */
public class SquareTest {
    /**
     * Test calculate method.
     */
    @Test
    public void whenBound3Then149() {
        int bound = 3;
        Square square = new Square();
        int[] rst = square.calculate(bound);
        int[] expect = new int[]{1, 4, 9};
        assertThat(rst, is(expect));
    }
}