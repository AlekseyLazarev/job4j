package ru.alazarev.lsp.storages.decorator;

import ru.alazarev.lsp.foods.IFood;
import ru.alazarev.lsp.storages.IStorage;

import java.util.Date;
import java.util.List;

/**
 * Class StorageDecorator решение задачи части 004. 3.2. Расширенное хранилище. [#853].
 *
 * @author Aleksey Lazarev
 * @since 13.06.2019
 */
public class StorageDecorator implements IStorage {
    private IStorage storageDecorator;

    /**
     * Constructor.
     *
     * @param storageDecorator Storage value.
     */
    public StorageDecorator(IStorage storageDecorator) {
        this.storageDecorator = storageDecorator;
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
        return quality(food, date) ? this.storageDecorator.addTo(food, date) : false;
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
        return this.storageDecorator.quality(food, date);
    }

    /**
     * Method return foods.
     *
     * @return Food list value.
     */
    @Override
    public List<IFood> getFoods() {
        return this.storageDecorator.getFoods();
    }

    @Override
    public void clearFoods() {
        storageDecorator.clearFoods();
    }
}
