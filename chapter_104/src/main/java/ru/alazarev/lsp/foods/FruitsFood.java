package ru.alazarev.lsp.foods;

/**
 * Class  решение задачи части
 *
 * @author Aleksey Lazarev
 * @since 13.06.2019
 */
public class FruitsFood extends FoodDecorator {
    protected boolean reproducible = true;

    /**
     * Constructor.
     *
     * @param food
     */
    public FruitsFood(Food food) {
        super(food);
    }

    public FruitsFood(Food food, boolean reproducible) {
        super(food);
        this.reproducible = reproducible;
    }

    public boolean isReproducible() {
        return this.reproducible;
    }


}
