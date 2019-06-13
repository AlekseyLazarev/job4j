package ru.alazarev.lsp.foods.decorator;

import ru.alazarev.lsp.foods.IFood;

import java.util.Date;

/**
 * Class FoodDecorator решение задачи части 004. 3.2. Расширенное хранилище. [#853]
 *
 * @author Aleksey Lazarev
 * @since 13.06.2019
 */
public abstract class FoodDecorator implements IFood {
    protected IFood food;

    public FoodDecorator(IFood food) {
        this.food = food;
    }

    /**
     * Method return need for cold storage.
     *
     * @return need for cold storage.
     */
    @Override
    public boolean coldStorageNeeded() {
        return this.food.coldStorageNeeded();
    }

    /**
     * Method return recycling capacity.
     *
     * @return recycling capacity.
     */
    @Override
    public boolean canReproduce() {
        return this.food.canReproduce();
    }

    /**
     * Method return food price variable.
     *
     * @return food price variable.
     */
    @Override
    public double getPrice() {
        return this.food.getPrice();
    }

    /**
     * Method return food discount variable.
     *
     * @return food discount variable.
     */
    @Override
    public double getDiscount() {
        return this.getDiscount();
    }

    /**
     * Method set food discount variable.
     *
     * @param discount food discount value.
     */
    @Override
    public void setDiscount(double discount) {
        this.food.setDiscount(discount);
    }

    /**
     * Method return shelf life.
     *
     * @return shelf life.
     */
    @Override
    public int freshness(Date current) {
        return this.food.freshness(current);
    }
}
