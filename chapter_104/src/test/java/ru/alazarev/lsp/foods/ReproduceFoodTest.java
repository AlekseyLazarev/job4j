package ru.alazarev.lsp.foods;

import org.junit.Test;

import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Class ReproduceFoodTest.
 *
 * @author Aleksey Lazarev
 * @since 14.06.2019
 */
public class ReproduceFoodTest {
    @Test
    public void whenFruitsFoodThenIsReproducibleThenTrue() {
        ReproduceFood rf = new ReproduceFood(new Grape("Grape", new Date(), new Date(), 10000, 0));
        assertThat(rf.isReproducible(), is(true));
    }

}