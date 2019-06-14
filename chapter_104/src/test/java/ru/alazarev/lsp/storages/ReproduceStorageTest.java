package ru.alazarev.lsp.storages;

import org.junit.Test;
import ru.alazarev.lsp.foods.Food;
import ru.alazarev.lsp.foods.Grape;
import ru.alazarev.lsp.foods.ReproduceFood;

import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class  решение задачи части
 *
 * @author Aleksey Lazarev
 * @since 14.06.2019
 */
public class ReproduceStorageTest {
    @Test
    public void name() {
        ReproduceStorage rs = new ReproduceStorage();
        Food f = new ReproduceFood(new ReproduceFood(new Grape("Grape", new Date(), new Date(), 10000, 0)));
        assertThat(rs.addTo(f, new Date()), is(true));
    }

}