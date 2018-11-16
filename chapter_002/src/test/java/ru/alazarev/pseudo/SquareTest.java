package ru.alazarev.pseudo;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class SquareTest {
    @Test
    public void whenDrawSquare() {
        Square square = new Square();
        StringBuilder match = new StringBuilder();
        match.append("*******\n");
        match.append("*     *\n");
        match.append("*     *\n");
        match.append("*******\n");
        assertThat(square.draw(), is(match.toString()));
    }
}
