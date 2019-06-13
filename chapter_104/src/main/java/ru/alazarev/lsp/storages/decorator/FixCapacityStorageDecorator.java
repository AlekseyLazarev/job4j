package ru.alazarev.lsp.storages.decorator;

import ru.alazarev.lsp.foods.IFood;
import ru.alazarev.lsp.storages.IStorage;

import java.util.Date;

/**
 * Class FixCapacityWarehouse решение задачи части 004. 3.2. Расширенное хранилище. [#853].
 *
 * @author Aleksey Lazarev
 * @since 13.06.2019
 */
public class FixCapacityStorageDecorator extends StorageDecorator {
    private final int capacity;
    private int currentSize;

    /**
     * Constructor.
     *
     * @param storage  Storage value.
     * @param capacity Capacity value.
     */
    public FixCapacityStorageDecorator(IStorage storage, int capacity) {
        super(storage);
        this.capacity = capacity;
        this.currentSize = storage.getFoods().size();
    }

    /**
     * Method add food into storage.
     *
     * @param food Food value.
     * @param date Date value.
     * @return this object.
     */
    @Override
    public boolean addTo(IFood food, Date date) {
        boolean result = false;
        if (quality(food, date)) {
            this.currentSize++;
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
        return this.currentSize < this.capacity && super.quality(food, date);
    }
}
