package ru.alazarev.lsp.storages;

import ru.alazarev.lsp.foods.Food;

import java.util.Date;

/**
 * Class Shop решение задачи части 004. 3.1. Хранилище продуктов [#852]
 *
 * @author Aleksey Lazarev
 * @since 27.05.2019
 */
public class Shop extends Storage {
    private int qualityForDisc = 75;
    private double discount = 0.2;

    public Shop() {
        setAcceptQualityLower(25);
        setAcceptQualityUpper(100);
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setQualityForDisc(int qualityForDisc) {
        this.qualityForDisc = qualityForDisc;
    }

    /**
     * Method add food into storage.
     *
     * @param food Food value.
     * @return this object.
     */
    @Override
    public boolean addTo(Food food, Date date) {
        boolean result = false;
        int freshness = food.freshness(date);
        if (freshness >= this.acceptQualityLower && freshness < this.acceptQualityUpper) {
            if (freshness >= this.qualityForDisc) {
                food.setDiscount(this.discount);
            }
            result = FOODS.add(food);
        }
        return result;
    }
}
