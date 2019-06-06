package ru.alazarev.lsp;

import ru.alazarev.lsp.foods.Food;
import ru.alazarev.lsp.storages.Shop;
import ru.alazarev.lsp.storages.Storage;
import ru.alazarev.lsp.storages.Trash;
import ru.alazarev.lsp.storages.Warehouse;

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
    private final List<Storage> storageList = new ArrayList<>();

    public ControlQuality() {
        this.storageList.add(new Shop());
        this.storageList.add(new Trash());
        this.storageList.add(new Warehouse());
    }

    /**
     * Method add storage into list.
     *
     * @param storage Storage object.
     */
    public void addStorage(Storage storage) {
        this.storageList.add(storage);
    }

    /**
     * Method distribute food to storage.
     *
     * @param food Food value.
     * @return Storage value.
     */
    public Storage distributor(Food food, Date date) {
        Storage res = null;
        for (Storage storage : this.storageList) {
            if (storage.addTo(food, date)) {
                res = storage;
                break;
            }
        }
        return res;
    }
}
