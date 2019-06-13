package ru.alazarev.lsp.foods.decorator;

import ru.alazarev.lsp.foods.IFood;

/**
 * Class ReproduceFoodDecorator решение задачи части 004. 3.2. Расширенное хранилище. [#853].
 *
 * @author Aleksey Lazarev
 * @since 13.06.2019
 */
public class ReproduceFoodDecorator extends FoodDecorator {
    /**
     * Constructor.
     *
     * @param food
     */
    public ReproduceFoodDecorator(IFood food) {
        super(food);
    }

    /**
     * Method return true reproduce flag.
     *
     * @return true reproduce flag.
     */
    @Override
    public boolean canReproduce() {
        return true;
    }
}
