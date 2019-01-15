package ru.alazarev.iostream;

import org.junit.Test;
import ru.alazarev.iostream.Even;


import java.io.*;


import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class EvenTest {
    private Even even = new Even();

    @Test
    public void whenNumberEvenThenTrue() {
        InputStream is = new ByteArrayInputStream("122".getBytes());
        assertThat(this.even.isNumber(is), is(true));
    }

    @Test
    public void whenNumberOddThenFalse() {
        InputStream is = new ByteArrayInputStream("19".getBytes());
        assertThat(this.even.isNumber(is), is(false));
    }

    @Test(expected = RuntimeException.class)
    public void whenNotNumberThenException() {
        InputStream is = new ByteArrayInputStream("Not Number".getBytes());
        assertThat(this.even.isNumber(is), is(true));
    }
}