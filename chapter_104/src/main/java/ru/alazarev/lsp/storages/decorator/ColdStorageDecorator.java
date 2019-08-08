package ru.alazarev.lsp.storages.decorator;

import ru.alazarev.lsp.foods.IFood;
import ru.alazarev.lsp.storages.IStorage;

import java.util.Date;


/**
 * Class ColdStorageDecorator решение задачи части 004. 3.2. Расширенное хранилище. [#853].
 *
 * @author Aleksey Lazarev
 * @since 19.06.2019
 */
public class ColdStorageDecorator extends StorageDecorator {
    private double temperature = 8.0;

    /**
     * Constructor.
     *
     * @param storageDecorator Storage value.
     */
    public ColdStorageDecorator(IStorage storageDecorator) {
        super(storageDecorator);
    }

    /**
     * Method get temperature storage variable.
     *
     * @return temperature storage variable.
     */
    public double getTemperature() {
        return this.temperature;
    }

    /**
     * Method set temperature storage variable.
     *
     * @param temperature temperature value.
     */
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    /**
     * Method return result add food.
     *
     * @param food Food value.
     * @param date Date value.
     * @return result add food.
     */
    @Override
    public boolean addTo(IFood food, Date date) {
        boolean result = false;
        if (quality(food, date)) {
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
        return food.coldStorageNeeded() && super.quality(food, date);
    }
}
