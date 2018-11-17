package ru.alazarev.pseudo;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test
 *
 * @author Aleksey Lazarev
 * @since 16.11.2018
 */
public class SquareTest {
    /**
     * Test draw method.
     */
    @Test
    public void whenDrawSquare() {
        Square square = new Square();
        StringBuilder match = new StringBuilder();
        match.append("*******" + System.lineSeparator());
        match.append("*     *" + System.lineSeparator());
        match.append("*     *" + System.lineSeparator());
        match.append("*******");
        assertThat(square.draw(), is(match.toString()));
    }
}
