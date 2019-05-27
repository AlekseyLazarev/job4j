package ru.alazarev.lsp.storages;

import ru.alazarev.lsp.foods.Food;

/**
 * Interface Storage решение задачи части 004. 3.1. Хранилище продуктов [#852]
 *
 * @author Aleksey Lazarev
 * @since 27.05.2019
 */
public interface Storage {
    /**
     * Method add food into storage.
     *
     * @param food Food value.
     * @return this object.
     */
    Storage addTo(Food food);
}
