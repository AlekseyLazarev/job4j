package ru.alazarev.lsp.storages.decorator;

import ru.alazarev.lsp.foods.IFood;
import ru.alazarev.lsp.storages.Storage;

import java.util.Date;

/**
 * Class ReproduceStorageDecorator решение задачи части 004. 3.2. Расширенное хранилище. [#853]
 *
 * @author Aleksey Lazarev
 * @since 13.06.2019
 */
public class ReproduceStorageDecorator extends StorageDecorator {
    /**
     * Constructor.
     *
     * @param storageDecorator Storage value.
     */
    public ReproduceStorageDecorator(Storage storageDecorator) {
        super(storageDecorator);
    }

    /**
     * Method add food into storage
     *
     * @param food Food value.
     * @param date Date value.
     * @return result add.
     */
    @Override
    public boolean addTo(IFood food, Date date) {
        boolean result = false;
        if (food.canReproduce()) {
            result = super.addTo(food, date);
        }
        return result;
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
        return food.canReproduce() && super.quality(food, date);
    }
}
