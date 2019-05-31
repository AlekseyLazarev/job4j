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
    protected final List<Food> FOODS = new ArrayList<>();
    protected int acceptQualityUpper;
    protected int acceptQualityLower;

    public void setAcceptQualityUpper(int acceptQualityUpper) {
        this.acceptQualityUpper = acceptQualityUpper;
    }

    public void setAcceptQualityLower(int acceptQualityLower) {
        this.acceptQualityLower = acceptQualityLower;
    }
//TODO pravilnii ras4et svezhesti

    /**
     * Method add food into storage.
     *
     * @param food Food value.
     * @return this object.
     */
    public boolean addTo(Food food, Date date) {
        boolean result = false;
        if (quality(food, date)) {
            result = FOODS.add(food);
        }
        return result;
    }

    boolean quality(Food food, Date date) {
        int freshness = food.freshness(date);
        return freshness >= acceptQualityLower && freshness < acceptQualityUpper;
    }
}
