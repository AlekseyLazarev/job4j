package ru.alazarev.lsp.storages;

import ru.alazarev.lsp.foods.IFood;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Abstract Class Storage решение задачи части 004. 3.1. Хранилище продуктов [#852]
 *
 * @author Aleksey Lazarev
 * @since 27.05.2019
 */
public abstract class Storage implements IStorage {
    protected final List<IFood> foods = new ArrayList<>();
    protected int acceptQualityUpper;
    protected int acceptQualityLower;

    /**
     * Method return foods.
     *
     * @return Food list value.
     */
    public List<IFood> getFoods() {
        return foods;
    }

    /**
     * Method set upper quality.
     *
     * @param acceptQualityUpper upper quality value.
     */
    public void setAcceptQualityUpper(int acceptQualityUpper) {
        this.acceptQualityUpper = acceptQualityUpper;
    }

    /**
     * Method set lower quality.
     *
     * @param acceptQualityLower lower quality value.
     */
    public void setAcceptQualityLower(int acceptQualityLower) {
        this.acceptQualityLower = acceptQualityLower;
    }

    /**
     * Method add food into storage.
     *
     * @param food Food value.
     * @return this object.
     */
    @Override
    public boolean addTo(IFood food, Date date) {
        return quality(food, date) ? foods.add(food) : false;
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
        int freshness = food.freshness(date);
        return freshness >= acceptQualityLower && freshness < acceptQualityUpper;
    }

}
