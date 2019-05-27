package ru.alazarev.lsp;

import ru.alazarev.lsp.foods.Food;
import ru.alazarev.lsp.storages.Storage;

/**
 * Class Context решение задачи части 004. 3.1. Хранилище продуктов [#852]
 *
 * @author Aleksey Lazarev
 * @since 27.05.2019
 */
public class Context {
    private Storage storage;

    /**
     * Method set storage.
     *
     * @param storage Storage object.
     */
    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    /**
     * Method add food into storage.
     *
     * @param food Food value for add.
     * @return Storage object.
     */
    public Storage storageAdd(Food food) {
        return this.storage.addTo(food);
    }
}
