package ru.alazarev.lsp.storages.decorator;

import org.junit.Test;
import ru.alazarev.lsp.FoodAssistant;
import ru.alazarev.lsp.storages.Warehouse;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class FixCapacityWarehouseTest.
 *
 * @author Aleksey Lazarev
 * @since 13.06.2019
 */
public class FixCapacityStorageDecoratorTest {
    private FoodAssistant fa = new FoodAssistant(2019, 5, 15, 10000, 0);

    @Test
    public void whenTwoCapacityAndAddThenFalse() {
        this.fa.setupDates(14, 1);
        FixCapacityStorageDecorator fixCapacityStorageDecorator = new FixCapacityStorageDecorator(new Warehouse(), 2);
        fixCapacityStorageDecorator.addTo(this.fa.createMilk("milk1"), this.fa.getNowInDate());
        fixCapacityStorageDecorator.addTo(this.fa.createMilk("milk2"), this.fa.getNowInDate());
        assertThat(fixCapacityStorageDecorator.addTo(this.fa.createMilk("milk2"), this.fa.getNowInDate()), is(false));
    }

}