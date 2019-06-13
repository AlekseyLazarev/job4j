package ru.alazarev.lsp.storages.decorator;

import org.junit.Test;
import ru.alazarev.lsp.FoodAssistant;
import ru.alazarev.lsp.foods.Grape;
import ru.alazarev.lsp.foods.IFood;
import ru.alazarev.lsp.foods.decorator.ReproduceFoodDecorator;
import ru.alazarev.lsp.storages.IStorage;
import ru.alazarev.lsp.storages.Trash;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class  решение задачи части
 *
 * @author Aleksey Lazarev
 * @since 14.06.2019
 */
public class ReproduceStorageDecoratorTest {
    private FoodAssistant fa = new FoodAssistant(2019, 5, 15,
            10000, 0);

    @Test
    public void whenReproduceStorageThen() {
        this.fa.setupDates(14, 1);
        IStorage rs = new ReproduceStorageDecorator(new Trash());
        IFood f = new ReproduceFoodDecorator(new Grape("name", this.fa.getDate1(),
                this.fa.getDate2(), this.fa.getStdPrice(), this.fa.getStdDisc()));
        assertThat(rs.addTo(f, this.fa.getNowInDate()), is(true));
    }

}