package ru.alazarev.lsp.storages;

import ru.alazarev.lsp.foods.IFood;

import java.util.Date;
import java.util.List;

/**
 * Class Warehouse решение задачи части 004. 3.1. Хранилище продуктов [#852]
 *
 * @author Aleksey Lazarev
 * @since 27.05.2019
 */
public class Warehouse implements IStorage {
    private final Storage storage;

    /**
     * Constructor.
     */
    public Warehouse() {
        this.storage = new Storage();
        this.storage.setAcceptQualityLower(0);
        this.storage.setAcceptQualityUpper(25);
    }

    /**
     * Method add food into storage.
     *
     * @param food Food value.
     * @return this object.
     */
    @Override
    public boolean addTo(IFood food, Date date) {
        return this.storage.addTo(food, date);
    }

    /**
     * Method calculate freshness.
     *
     * @param food Food object for calculate.
     * @param date Date object for calculate.
     * @return Freshness.
     */
    @Override
    public boolean quality(IFood food, Date date) {
        return this.storage.quality(food, date);
    }

    /**
     * Method return foods.
     *
     * @return Food list value.
     */
    @Override
    public List<IFood> getFoods() {
        return this.storage.getFoods();
    }

    /**
     * Method clear food list.
     */
    @Override
    public void clearFoods() {
        this.storage.clearFoods();
    }
}