package ru.alazarev.lsp.foods;

/**
 * Class FoodDecorator решение задачи части
 *
 * @author Aleksey Lazarev
 * @since 13.06.2019
 */
public abstract class FoodDecorator {
    Food food;

    /**
     * Constructor.
     */
    public FoodDecorator(Food food) {
        this.food = food;
    }
}
