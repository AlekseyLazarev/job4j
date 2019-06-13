package ru.alazarev.lsp.storages;

import ru.alazarev.lsp.foods.IFood;

import java.util.Date;

/**
 * Class Trash решение задачи части 004. 3.1. Хранилище продуктов [#852]
 *
 * @author Aleksey Lazarev
 * @since 27.05.2019
 */
public class Trash extends Storage {
    /**
     * Constructor.
     */
    public Trash() {
        setAcceptQualityLower(100);
    }

    /**
     * Method override calculate freshness.
     *
     * @param food Food object for calculate.
     * @param date Date object for calculate.
     * @return Freshness.
     */
    @Override
    public boolean quality(IFood food, Date date) {
        return food.freshness(date) > acceptQualityLower;
    }
}
