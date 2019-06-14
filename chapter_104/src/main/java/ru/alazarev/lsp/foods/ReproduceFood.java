package ru.alazarev.lsp.foods;

/**
 * Class  решение задачи части
 *
 * @author Aleksey Lazarev
 * @since 13.06.2019
 */
public class ReproduceFood extends FoodDecorator {
    protected boolean reproducible = true;

    /**
     * Constructor.
     *
     * @param food
     */
    public ReproduceFood(Food food) {
        super(food);
    }

    public ReproduceFood(Food food, boolean reproducible) {
        super(food);
        this.reproducible = reproducible;
    }

    public boolean isReproducible() {
        return this.reproducible;
    }


}
