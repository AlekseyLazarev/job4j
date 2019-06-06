package ru.alazarev.lsp.storages;

import ru.alazarev.lsp.foods.Food;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Interface Storage решение задачи части 004. 3.1. Хранилище продуктов [#852]
 *
 * @author Aleksey Lazarev
 * @since 27.05.2019
 */
public abstract class Storage {
    protected final List<Food> foods = new ArrayList<>();
    protected int acceptQualityUpper;
    protected int acceptQualityLower;

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
    public boolean addTo(Food food, Date date) {
        boolean result = false;
        if (quality(food, date)) {
            result = foods.add(food);
        }
        return result;
    }

    /**
     * Method calculate freshness.
     *
     * @param food Food object for calculate.
     * @param date Date object for calculate.
     * @return Freshness.
     */
    boolean quality(Food food, Date date) {
        int freshness = food.freshness(date);
        return freshness >= acceptQualityLower && freshness < acceptQualityUpper;
    }
}
