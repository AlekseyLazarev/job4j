package ru.alazarev.lsp.storages;

import ru.alazarev.lsp.foods.IFood;

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

    /**
     * Constructor.
     */
    public Shop() {
        setAcceptQualityLower(25);
        setAcceptQualityUpper(100);
    }

    /**
     * Method set discount.
     *
     * @param discount Discount value.
     */
    public void setDiscount(double discount) {
        this.discount = discount;
    }

    /**
     * Method set quality for discount.
     *
     * @param qualityForDisc Quality value.
     */
    public void setQualityForDisc(int qualityForDisc) {
        this.qualityForDisc = qualityForDisc;
    }

    /**
     * Method return quality of food.
     *
     * @param food Food object for calculate.
     * @param date Date object for calculate.
     * @return return quality.
     */
    @Override
    public boolean quality(IFood food, Date date) {
        boolean result = false;
        int freshness = food.freshness(date);
        if (freshness >= this.acceptQualityLower && freshness < this.acceptQualityUpper) {
            if (freshness >= this.qualityForDisc) {
                food.setDiscount(this.discount);
            }
            result = true;
        }
        return result;
    }
}