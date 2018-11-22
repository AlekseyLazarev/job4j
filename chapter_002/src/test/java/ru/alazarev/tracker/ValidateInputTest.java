package ru.alazarev.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Class ValidateInputTest решение задачи части 002. Урок 6.2. Рефакторинг - Шаблон Декоратор для валидатора. [#34117]
 *
 * @author Aleksey Lazarev
 * @since 18.11.2018
 */
public class ValidateInputTest {
    /**
     * Storage console output byte array.
     */
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();
    /**
     * Storage system out.
     */
    private final PrintStream out = System.out;

    /**
     * Setup system out in byte array.
     */
    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
    }

    /**
     * Setup system out default.
     */
    @After
    public void loadSys() {
        System.setOut(this.out);
    }

    /**
     * Test when input value is string.
     */
    @Test
    public void whenInvalidInput() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[]{"invalid", "1"})
        );
        input.ask("Enter", new int[]{1});
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Please input correct value" + System.lineSeparator())
                )
        );
    }

    /**
     * Test when input value out of menu range.
     */
    @Test
    public void whenOutOfMenuInput() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[]{"9", "1"})
        );
        input.ask("Enter", new int[]{1});
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Please select an item from the menu" + System.lineSeparator())
                )
        );
    }
}