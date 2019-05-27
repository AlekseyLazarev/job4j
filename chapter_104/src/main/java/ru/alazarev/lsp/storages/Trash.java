package ru.alazarev.lsp.storages;

import ru.alazarev.lsp.foods.Food;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Trash решение задачи части 004. 3.1. Хранилище продуктов [#852]
 *
 * @author Aleksey Lazarev
 * @since 27.05.2019
 */
public class Trash implements Storage {
    private static final List<Food> FOODS = new ArrayList<>();

    /**
     * Method add food into storage.
     *
     * @param food Food value.
     * @return this object.
     */
    @Override
    public Storage addTo(Food food) {
        System.out.println(food.getName() + " Trash added");
        FOODS.add(food);
        return this;
    }
}
