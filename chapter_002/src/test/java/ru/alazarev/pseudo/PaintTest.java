package ru.alazarev.pseudo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test
 *
 * @author Aleksey Lazarev
 * @since 16.11.2018
 */
public class PaintTest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    /**
     * Capture console output.
     */
    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    /**
     * Return console output.
     */
    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    /**
     * Test draw method with square.
     */
    @Test
    public void whenDrawSquare() {
        // выполняем действия пишушиее в консоль.
        new Paint().draw(new Square());
        // проверяем результат вычисления
        StringBuilder ex = new StringBuilder();
        ex.append("*******"+System.lineSeparator());
        ex.append("*     *"+System.lineSeparator());
        ex.append("*     *"+System.lineSeparator());
        ex.append("*******"+System.lineSeparator());
        String result = new String(out.toByteArray());
        assertThat(result, is(ex.toString()));
    }

    /**
     * Test draw method with triangle.
     */
    @Test
    public void whenDrawTriangle() {
        // выполняем действия пишушиее в консоль.
        new Paint().draw(new Triangle());
        // проверяем результат вычисления
        StringBuilder ex = new StringBuilder();
        ex.append("   *   "+System.lineSeparator());
        ex.append("  ***  "+System.lineSeparator());
        ex.append(" ***** "+System.lineSeparator());
        ex.append("*******"+System.lineSeparator());
        String result = new String(out.toByteArray());
        assertThat(result, is(ex.toString()));
    }
}