package ru.alazarev.lsp;

import org.junit.Before;
import org.junit.Test;
import ru.alazarev.lsp.foods.Food;
import ru.alazarev.lsp.foods.Milk;
import ru.alazarev.lsp.storages.Shop;
import ru.alazarev.lsp.storages.Trash;
import ru.alazarev.lsp.storages.Warehouse;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test Control Quality.
 */
public class ControlQualityTest {
    private Calendar c1 = new GregorianCalendar();
    private Calendar c2 = new GregorianCalendar();
    private ControlQuality cq;
    private int year = 2019;
    private int month = 5;
    private double stdPrice = 10000;
    private double stdDisc = 0;
    private int date1;
    private int date2;
    private double curDisc = 0.5;

    @Before
    public void setUp() {
        this.cq = new ControlQuality(this.year, this.month, 23);
        this.cq.setDiscount(0.5D);
    }

    private Food createFood(String nameFood) {
        this.c1.set(this.year, this.month, this.date1);
        this.c2.set(this.year, this.month, this.date2);
        return new Milk(nameFood, this.c1.getTime(), this.c2.getTime(), this.stdPrice, this.stdDisc);
    }

    @Test
    public void whenMoreThanOneThenTrash() {
        this.date1 = 21;
        this.date2 = 11;
        Food f = createFood("Trash food");
        assertThat(this.cq.distributor(f) instanceof Trash, is(true));
    }

    @Test
    public void whenMoreThanThreeQuartersThenShop() {
        this.date1 = 30;
        this.date2 = 15;
        Food f = createFood("Shop food");
        assertThat(this.cq.distributor(f) instanceof Shop, is(true));
    }

    @Test
    public void whenMoreThanOneQuartersThenShopAndFoodDiscountAdd() {
        this.date1 = 24;
        this.date2 = 19;
        Food f = createFood("Shop food");
        assertThat(this.cq.distributor(f) instanceof Shop, is(true));
        assertThat(f.getDiscount(), is(this.curDisc));
    }

    @Test
    public void whenMoreThanZeroThenWarehouse() {
        this.date1 = 30;
        this.date2 = 22;
        Food f = createFood("Warehouse food");
        assertThat(this.cq.distributor(f) instanceof Warehouse, is(true));
    }

}