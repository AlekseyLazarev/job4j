package ru.alazarev.seafight;

import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class InputTest {
    private Input in;

    @Before
    public void setUp() {
        this.in = new Input();
    }

    @Test
    public void whenIntInputTenThenGetTen() {
        int cell = 10;
        InputStream is = new ByteArrayInputStream(String.valueOf(cell).getBytes());
        System.setIn(is);
        assertThat(this.in.intInput(), is(cell));
    }

    @Test
    public void whenStringInputHThenGetH() {
        String input = "h";
        InputStream is = new ByteArrayInputStream(input.getBytes());
        System.setIn(is);
        assertThat(this.in.stringInput(), is(input));
    }
}