package ru.alazarev.lsp;

import org.junit.Before;
import org.junit.Test;
import ru.alazarev.lsp.foods.Food;
import ru.alazarev.lsp.foods.Grape;
import ru.alazarev.lsp.foods.IFood;
import ru.alazarev.lsp.foods.decorator.ColdFoodDecorator;
import ru.alazarev.lsp.foods.decorator.ReproduceFoodDecorator;
import ru.alazarev.lsp.storages.Shop;
import ru.alazarev.lsp.storages.Trash;
import ru.alazarev.lsp.storages.Warehouse;
import ru.alazarev.lsp.storages.decorator.ColdStorageDecorator;
import ru.alazarev.lsp.storages.decorator.FixCapacityStorageDecorator;
import ru.alazarev.lsp.storages.decorator.ReproduceStorageDecorator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test Control Quality.
 */
public class ControlQualityTest {
    private FoodAssistant fa = new FoodAssistant(2019, 5, 15, 10000, 0);

    @Before
    public void addNewStorage() {
        this.fa.getCq().addStorage(new ColdStorageDecorator(new Warehouse()));
        this.fa.getCq().addStorage(new Warehouse());
        this.fa.getCq().addStorage(new FixCapacityStorageDecorator(new Warehouse(), 1));
        this.fa.getCq().addStorage(new ReproduceStorageDecorator(new Trash()));
        this.fa.getCq().addStorage(new Shop());
        this.fa.getCq().addStorage(new Trash());
    }

    @Test
    public void whenColdStorageThen() {
        this.fa.setupDates(30, 14);
        IFood f = new ColdFoodDecorator(new Grape("Cold food", this.fa.getDate1(), this.fa.getDate2(), this.fa.getStdPrice(), this.fa.getStdDisc()));
        assertThat(this.fa.getCq().distributor(f, this.fa.getNowInDate()) instanceof ColdStorageDecorator, is(true));
    }

    @Test
    public void whenMoreThanOneThenTrash() {
        assertThat(this.fa.checker("Trash food", 14, 1) instanceof Trash, is(true));
    }

    @Test
    public void whenMoreThanThreeQuartersThenShop() {
        assertThat(this.fa.checker("Shop food", 30, 1) instanceof Shop, is(true));
    }

    @Test
    public void whenMoreThanOneQuartersThenShopAndFoodDiscountAdd() {
        this.fa.setupDates(18, 1);
        Food f = this.fa.createMilk("Shop food");
        assertThat(this.fa.getCq().distributor(f, this.fa.getNowInDate()) instanceof Shop, is(true));
        assertThat(f.getDiscount(), is(0.2));
    }

    @Test
    public void whenMoreThanZeroThenWarehouse() {
        assertThat(this.fa.checker("Warehouse food", 30, 14) instanceof Warehouse, is(true));
    }

    @Test
    public void whenReproduceStorageThen() {
        this.fa.setupDates(14, 1);
        IFood f = new ReproduceFoodDecorator(new Grape("Reproduce food", this.fa.getDate1(), this.fa.getDate2(), this.fa.getStdPrice(), this.fa.getStdDisc()));
        assertThat(this.fa.getCq().distributor(f, this.fa.getNowInDate()) instanceof ReproduceStorageDecorator, is(true));
    }
}