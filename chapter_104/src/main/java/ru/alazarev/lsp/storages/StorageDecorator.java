package ru.alazarev.lsp.storages;

import ru.alazarev.lsp.foods.Food;

import java.util.Date;

public abstract class StorageDecorator extends Storage {
    protected Storage storageDecorator;

    public StorageDecorator(Storage storageDecorator) {
        this.storageDecorator = storageDecorator;
    }

    @Override
    public boolean addTo(Food food, Date date) {
        return this.storageDecorator.addTo(food, date);
    }

    @Override
    boolean quality(Food food, Date date) {
        return this.storageDecorator.quality(food, date);
    }
}
