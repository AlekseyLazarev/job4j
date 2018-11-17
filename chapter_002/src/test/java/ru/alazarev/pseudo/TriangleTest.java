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
public class TriangleTest {
    /**
     * Test draw method.
     */
    @Test
    public void whenDrawTriangle() {
        Triangle triangle = new Triangle();
        StringBuilder match = new StringBuilder();
        match.append("   *   "+System.lineSeparator());
        match.append("  ***  "+System.lineSeparator());
        match.append(" ***** "+System.lineSeparator());
        match.append("*******");
        assertThat(triangle.draw(), is(match.toString()));
    }
}
