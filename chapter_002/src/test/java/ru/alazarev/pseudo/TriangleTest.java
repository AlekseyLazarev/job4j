package ru.alazarev.pseudo;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TriangleTest {
    @Test
    public void whenDrawTriangle() {
        Triangle triangle = new Triangle();
        StringBuilder match = new StringBuilder();
        match.append("   *   \n");
        match.append("  ***  \n");
        match.append(" ***** \n");
        match.append("*******\n");
        assertThat(triangle.draw(), is(match.toString()));
    }
}
