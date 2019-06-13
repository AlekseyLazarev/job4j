package ru.alazarev.lsp.storages;

import org.junit.Test;
import ru.alazarev.lsp.FoodAssistant;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * FixCapacityWarehouseTest.
 *
 * @author Aleksey Lazarev
 * @since 13.06.2019
 */
public class FixCapacityWarehouseTest {
    private FoodAssistant fa = new FoodAssistant(2019, 5, 15, 10000, 0);
    @Test
    public void whenTwoCapacityAndAddThenFalse() {
        this.fa.setupDates(14, 1);
        FixCapacityWarehouse fixCapacityWarehouse = new FixCapacityWarehouse(new Warehouse(), 2);
        fixCapacityWarehouse.addTo(this.fa.createMilk("milk1"), this.fa.getNowInDate());
        fixCapacityWarehouse.addTo(this.fa.createMilk("milk2"), this.fa.getNowInDate());
        assertThat(fixCapacityWarehouse.addTo(this.fa.createMilk("milk2"), this.fa.getNowInDate()), is(false));
    }

}