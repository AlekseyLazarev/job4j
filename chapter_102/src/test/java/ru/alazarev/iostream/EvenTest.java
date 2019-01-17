package ru.alazarev.iostream;

import org.junit.Test;
import ru.alazarev.iostream.Even;


import java.io.*;


import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Class EvenTest.
 *
 * @author Aleksey Lazarev
 * @since 17.01.2019
 */
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

    @Test()
    public void whenNotNumberThenFalse() {
        InputStream is = new ByteArrayInputStream("Not Number".getBytes());
        assertThat(this.even.isNumber(is), is(false));
    }
}