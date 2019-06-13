package ru.alazarev.lsp.foods.decorator;

import org.junit.Test;
import ru.alazarev.lsp.foods.Grape;

import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class ReproduceFoodTest.
 *
 * @author Aleksey Lazarev
 * @since 14.06.2019
 */
public class ReproduceFoodTest {
    @Test
    public void whenReproduceFoodThenIsReproducibleThenTrue() {
        FoodDecorator rf = new ReproduceFoodDecorator(new Grape("Grape", new Date(), new Date(), 10000, 0));
        assertThat(rf.canReproduce(), is(true));
    }

}