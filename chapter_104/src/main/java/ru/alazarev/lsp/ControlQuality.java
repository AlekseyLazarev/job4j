package ru.alazarev.lsp;

import ru.alazarev.lsp.foods.IFood;
import ru.alazarev.lsp.storages.IStorage;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Class ControlQuality решение задачи части 004. 3.1. Хранилище продуктов [#852]
 *
 * @author Aleksey Lazarev
 * @since 27.05.2019
 */

/**
 * Класс должен перераспределять еду по хранилищам в зависимости от условиый.
 * 3.1. Если срок годности израсходован меньше чем на 25% направить в Warehouse.
 * 3.2 Если срок годности от 25% до 75% направить в Shop
 * 3.3. Если срок годности больше 75% то выставить скидку на продукт и отправить в Shop
 * 3.4. Если срок годности вышел. Отправить продукт в мусорку.
 */
public class ControlQuality {
    private final List<IStorage> storageList = new ArrayList<>();

    /**
     * Method add storage into list.
     *
     * @param storage Storage object.
     */
    public void addStorage(IStorage storage) {
        this.storageList.add(storage);
    }

    /**
     * Method distribute food to storage.
     *
     * @param food Food value.
     * @return Storage value.
     */
    public IStorage distributor(IFood food, Date date) {
        IStorage res = null;
        for (IStorage storage : this.storageList) {
            if (storage.addTo(food, date)) {
                res = storage;
                break;
            }
        }
        return res;
    }
}
