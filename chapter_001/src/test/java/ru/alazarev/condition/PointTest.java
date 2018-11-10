package ru.alazarev.condition;

import org.junit.Test;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;
/**
 * Test.
 * @author Aleksey Lazarev
 * @version 0.1
 * @since 09.11.2018
 */
public class PointTest {
    /**
     * Test distanceTo method.
     */
    @Test
    public void whenOneXOneYDistaneToZeroXZeroYThenOnePointFour() {
        Point a = new Point(1, 1);
        Point b = new Point(0, 0);
        double result = a.distanceTo(b);
        assertThat(result, closeTo(1.4, 0.1));
    }
}

