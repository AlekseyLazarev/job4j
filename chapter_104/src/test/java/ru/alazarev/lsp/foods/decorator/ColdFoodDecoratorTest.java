package ru.alazarev.lsp.foods.decorator;

import org.junit.Test;
import ru.alazarev.lsp.foods.Meat;

import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class ColdFoodDecoratorTest.
 *
 * @author Aleksey Lazarev
 * @since 19.06.2019
 */
public class ColdFoodDecoratorTest {
    @Test
    public void whenColdFoodThenColdStorageNeededIsTrue() {
        FoodDecorator cf = new ColdFoodDecorator(new Meat("Meat", new Date(),
                new Date(), 10000, 0));
        assertThat(cf.coldStorageNeeded(), is(true));
    }
}