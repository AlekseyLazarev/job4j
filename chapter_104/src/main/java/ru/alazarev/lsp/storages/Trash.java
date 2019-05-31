package ru.alazarev.lsp.storages;

import ru.alazarev.lsp.foods.Food;

import java.util.Date;

/**
 * Class Trash решение задачи части 004. 3.1. Хранилище продуктов [#852]
 *
 * @author Aleksey Lazarev
 * @since 27.05.2019
 */
public class Trash extends Storage {

    public Trash() {
        setAcceptQualityLower(100);
    }

    @Override
    boolean quality(Food food, Date date) {
        return food.freshness(date) > acceptQualityLower;
    }
}
