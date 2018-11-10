package ru.alazarev.loop;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Counter test.
 * @author Aleksey Lazarev
 * @version 0.1
 * @since 11.11.2018
 */
public class CounterTest {
    /**
     * Test add method.
     */
    @Test
    public void whenStartOneFinishTenThenThirty() {
        Counter counter = new Counter();
        int result = counter.add(1, 10);
        assertThat(result, is(30));
    }


}
