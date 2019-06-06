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
    private Calendar now = new GregorianCalendar(2019, 5, 15);

    @Before
    public void setUp() {
        this.cq = new ControlQuality();
    }

    private Food createFood(String nameFood) {
        this.c1.set(this.year, this.month, this.date1);
        this.c2.set(this.year, this.month, this.date2);
        return new Milk(nameFood, this.c1.getTime(), this.c2.getTime(), this.stdPrice, this.stdDisc);
    }

    @Test
    public void whenMoreThanOneThenTrash() {
        this.date1 = 14;
        this.date2 = 1;
        Food f = createFood("Trash food");
        assertThat(this.cq.distributor(f, now.getTime()) instanceof Trash, is(true));
    }

    @Test
    public void whenMoreThanThreeQuartersThenShop() {
        this.date1 = 30;
        this.date2 = 1;
        Food f = createFood("Shop food");
        assertThat(this.cq.distributor(f, now.getTime()) instanceof Shop, is(true));
    }

    @Test
    public void whenMoreThanOneQuartersThenShopAndFoodDiscountAdd() {
        this.date1 = 18;
        this.date2 = 1;
        Food f = createFood("Shop food");
        assertThat(this.cq.distributor(f, now.getTime()) instanceof Shop, is(true));
        assertThat(f.getDiscount(), is(0.2));
    }

    @Test
    public void whenMoreThanZeroThenWarehouse() {
        this.date1 = 30;
        this.date2 = 14;
        Food f = createFood("Warehouse food");
        assertThat(this.cq.distributor(f, now.getTime()) instanceof Warehouse, is(true));
    }
}