package ru.alazarev.lsp.foods.decorator;

import ru.alazarev.lsp.foods.IFood;

/**
 * Class ColdFoodDecorator решение задачи части 004. 3.2. Расширенное хранилище. [#853].
 *
 * @author Aleksey Lazarev
 * @since 17.06.2019
 */
public class ColdFoodDecorator extends FoodDecorator {
    /**
     * Constructor.
     *
     * @param food
     */
    public ColdFoodDecorator(IFood food) {
        super(food);
    }

    /**
     * Method return need for cold storage.
     *
     * @return need for cold storage.
     */
    @Override
    public boolean coldStorageNeeded() {
        return true;
    }
}
